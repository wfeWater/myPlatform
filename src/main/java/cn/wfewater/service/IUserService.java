package cn.wfewater.service;

import cn.wfewater.domain.User;

public interface IUserService {
    int getUserCount();
    int add(User user);
    int login(String username, String password);

    User getUserByName(String username);
    boolean existUsername(String username);

    User getUserById(Integer uid);
}
