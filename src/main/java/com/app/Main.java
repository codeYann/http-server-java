package main.java.com.app;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class User {
    public String name;
    public int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User: " + this.name;
    }
}

public class Main {
    public static void main(String[] args) {
        List<User> users = new LinkedList<>() {
            {
                add(new User("Bob", 40));
                add(new User("Jane", 30));
                add(new User("John", 20));
                add(new User("Martin", 12));
                add(new User("Phillip", 56));
                add(new User("Hilbert", 59));
            }
        };

        var v = users
                .stream()
                .filter(u -> u.getAge() > 50)
                .collect(Collectors.toUnmodifiableList());

        v.forEach(System.out::println);

    }
}
