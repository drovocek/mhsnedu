package edu.mhsn.education.repository;

import edu.mhsn.education.entity.Task;
import edu.mhsn.education.utils.DaoConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskCrudRepository implements CrudRepository<Task> {

    private final static TaskCrudRepository INSTANCE = new TaskCrudRepository();
    private final static String CREATE_SQL = "INSERT INTO task(question, answer) VALUES (?,?)";

    private final List<Task> taskDataBase = new ArrayList<>();
    private int lastId = 0;

    private TaskCrudRepository() {
    }

    public static TaskCrudRepository getInstance() {
        return INSTANCE;
    }

    {
        create(new Task("Что такое java?", "Язык программирования"));
        create(new Task("Какая версия java последняя", "17-я"));
        create(new Task("В каком году появилась java", "1996 год"));
    }

    @Override
    public void create(Task created) {
        created.setId(lastId++);
        taskDataBase.add(created);

        try (Connection connection = DaoConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_SQL)) {
            statement.setObject(1, created.getQuestion());
            statement.setObject(2, created.getAnswer());
            statement.executeUpdate();
        } catch (SQLException sql) {
            throw new RuntimeException(sql);
        }
    }

    @Override
    public void update(Task updated) {
        if (updated.isNew()) {
            throw new RuntimeException("id не может быть пустым");
        } else {
            Task targetTask = findByKey(updated.getId());

            targetTask.setQuestion(updated.getQuestion());
            targetTask.setAnswer(updated.getAnswer());
        }
    }

    @Override
    public Task findByKey(int key) {
        Task target = null;

        for (Task task : taskDataBase) {
            if (task.getId() == key) {
                target = task;
                break;
            }
        }

        return target;
    }

    @Override
    public List<Task> findAll() {
        return this.taskDataBase;
    }

    @Override
    public boolean delete(int key) {
        Task target = findByKey(key);

        if (target != null) {
            this.taskDataBase.remove(target);
        }

        return target != null;
    }
}
