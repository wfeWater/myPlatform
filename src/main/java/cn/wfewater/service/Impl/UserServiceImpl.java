package cn.wfewater.service.Impl;

import cn.wfewater.dao.UserMapper;
import cn.wfewater.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements IUserService {
    @Autowired
    public UserMapper userDao;

    public int getUserCount() {
        return 0;
    }
}
