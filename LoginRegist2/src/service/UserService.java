package service;

import dao.DaoFactory;
import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;

/**
 * Created by codingBoy on 16/10/8.
 */
public class UserService
{
    UserDao userDao= DaoFactory.getUserDao();

    public void regist(User user) throws UserException
    {
        User _user=userDao.findByUsername(user.getUsername());
        if (_user!=null)
        {
            throw  new UserException("用户名"+user.getUsername()+"已被注册");
        }
        userDao.add(user);
    }

    public User login(User user) throws UserException
    {
        User _user=userDao.findByUsername(user.getUsername());
        if (_user==null)
        {
            throw new UserException("用户名不存在");
        }
        if (!user.getPassword().equals(_user.getPassword()))
        {
           throw new UserException("密码错误");
        }
        return _user;
    }
}
