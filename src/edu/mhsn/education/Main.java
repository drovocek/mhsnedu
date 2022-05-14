package edu.mhsn.education;

import edu.mhsn.education.entity.Dog;
import edu.mhsn.education.entity.User;
import edu.mhsn.education.repository.UserCrudRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserCrudRepository userRepository = new UserCrudRepository();
        System.out.println(userRepository.findAll());
        System.out.println("--------------------");
        System.out.println(userRepository.findByKey(0));
        System.out.println("--------------------");
        userRepository.create(new User("Irina", "irina@gmail.com", 20));
        userRepository.update(new User(0, "Updated_Andrey", "andrey@gmail.com", 40));
        userRepository.delete(2);
        System.out.println(userRepository.findAll());
        System.out.println("--------------------");

//        userRepository.create(new Dog("Шарик"));

        User user = userRepository.findByKey(0);

        List<User> allUsers = userRepository.findAll();
     //   allUsers.add(new Dog("Шарик"));


        System.out.println(userRepository.findAll());
    }
}
