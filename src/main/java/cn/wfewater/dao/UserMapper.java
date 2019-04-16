package cn.wfewater.dao;


import cn.wfewater.domain.User;

public interface UserMapper {
    int getUserCount();

    int add(User user);

    int existUsername(String username);

    User selectUserByName(String username);

    User getUserById(Integer uid);
}
