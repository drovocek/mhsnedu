package edu.mhsn.education.repository;

import edu.mhsn.education.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserCrudRepository implements CrudRepository<User> {

    private final List<User> usersDataBase = new ArrayList<>();
    private int lastKey = 0;

    private final Map<Integer, User> usersMap = new HashMap<>();

    {
        User user_0 = new User(lastKey++, "Andrey", "andrey@gmail.ru", 38);
        User user_1 = new User(lastKey++, "Ivan", "ivan@gmail.ru", 28);
        User user_2 = new User(lastKey++, "Anna", "anna@gmail.ru", 18);

        usersDataBase.add(user_0);
        usersDataBase.add(user_1);
        usersDataBase.add(user_2);

        usersMap.put(user_0.getKey(), user_0);
        usersMap.put(user_1.getKey(), user_1);
        usersMap.put(user_2.getKey(), user_2);

        User user = usersMap.get(user_0.getKey()); //O(1)
    }

    @Override
    public void create(User created) {
        created.setKey(lastKey++);
        usersDataBase.add(created);
    }

    //Only User param!!!
    //Key not null!!!
    @Override
    public void update(User updated) {
        if (updated.isNew()) {
            throw new RuntimeException("key не может быть пустым");
        } else {
            User targetUser = findByKey(updated.getKey());

            targetUser.setAge(updated.getAge());
            targetUser.setFirstName(updated.getFirstName());
            targetUser.setEmail(updated.getEmail());
        }
    }

    //May be null return
    @Override
    public User findByKey(int key) {
        User target = null;

        for (User user : usersDataBase) {
            if (user.getKey() == key) {
                target = user;
                break;
            }
        }

        return target;
    }

    @Override
    public List<User> findAll() {
        return this.usersDataBase;
    }

    @Override
    public boolean delete(int key) {
        User target = findByKey(key);

        if (target != null) {
            usersDataBase.remove(target);
        }

        return target != null;
    }
}
