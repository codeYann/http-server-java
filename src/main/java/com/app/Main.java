package main.java.com.app;

import java.rmi.server.ExportException;
import java.util.*;
import java.util.stream.Collectors;

enum Role {
    MODERATOR,
    DEVELOPER,
    NONE,
}

class User {
    int id;
    public String name;
    public int age;
    public Role role;

    public User(int id, String name, int age, Role role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Role getRole() { return role; }

    public int getId() { return id; }

    @Override
    public String toString() {
        return "User: " + this.name;
    }
}

public class Main {
    public static void main(String[] args) {
        List<User> users = new LinkedList<>() {
            {
                add(new User(1, "Bob", 40, Role.NONE));
                add(new User(2, "Jane", 30, Role.NONE));
                add(new User(3,"John", 20, Role.DEVELOPER));
                add(new User(4,"Martin", 12, Role.DEVELOPER));
                add(new User(5,"Phillip", 56, Role.MODERATOR));
                add(new User(6, "Hilbert", 59, Role.MODERATOR));
            }
        };

        Map<Integer, List<User>> map = users
                .stream()
                .filter(user -> user.role == Role.MODERATOR)
                .collect(Collectors.groupingBy(User::getId));

        map.forEach((role, list) -> {
            System.out.println(role);
            System.out.println(list);
        });
    }
}
