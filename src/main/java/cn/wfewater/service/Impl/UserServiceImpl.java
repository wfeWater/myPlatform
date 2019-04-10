package cn.wfewater.service.Impl;

import cn.wfewater.dao.UserMapper;
import cn.wfewater.domain.User;
import cn.wfewater.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    public UserMapper userDao;

    public int getUserCount() {
        return 0;
    }

    public int add(User user) {
        return userDao.add(user);
    }
}
