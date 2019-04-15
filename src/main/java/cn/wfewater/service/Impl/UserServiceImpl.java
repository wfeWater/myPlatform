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

    public int login(String username, String password) {
        boolean isExsited = existUsername(username);
        if (isExsited) {
            User resUser = userDao.selectUserByName(username);
            if (resUser.getPassword().equals(password)) {
                return 2;
            }
                return 1;
        }
            return 0;
    }

    public User getUserByName(String username) {
        return userDao.selectUserByName(username);
    }

    public boolean existUsername(String username) {
        return  userDao.existUsername(username)==1;
    }
}
