package ru.job4j.springapp.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
