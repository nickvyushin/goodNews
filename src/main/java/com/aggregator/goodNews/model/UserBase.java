package com.aggregator.goodNews.model;


import java.util.concurrent.ConcurrentHashMap;

public class UserBase {

    public static UserBase globalBase = new UserBase();

    private ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

    public boolean add(User user) {
        //проверка на уникальность логина
        if (!users.containsKey(user.getLogin())) {
            users.put(user.getLogin(), user);
        } else {
            return false;
        }
        return true;
    }

    public boolean check(String login, String password) {
        if (!users.containsKey(login)) {
            return false;
        } else {
            return users.get(login).getPassword().equals(password);
        }
    }

    public String findNameByLogin(String login) {
        return users.get(login).getFullName();
    }

    public Integer findAgeByLogin(String login) {
        return users.get(login).getAge();
    }
}
