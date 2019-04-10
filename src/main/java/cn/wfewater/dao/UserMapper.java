package cn.wfewater.dao;


import cn.wfewater.domain.User;

public interface UserMapper {
    int getUserCount();

    int add(User user);
}
