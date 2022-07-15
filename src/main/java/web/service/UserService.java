package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> listUsers();

    public void addUser(User user);

    public User deleteUser(long id);

    public User changeUser(User user);

    public User getUserById(long id);

}
