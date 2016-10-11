package dao;

import domain.User;

/**
 * Created by codingBoy on 16/10/11.
 */
public interface UserDao
{
    public User findByUsername(String username);
    public void add(User user);
}
