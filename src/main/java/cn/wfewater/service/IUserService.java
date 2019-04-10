package cn.wfewater.service;

import cn.wfewater.domain.User;

public interface IUserService {
    int getUserCount();
    int add(User user);
}
