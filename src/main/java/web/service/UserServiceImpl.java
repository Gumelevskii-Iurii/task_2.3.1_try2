package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userdao;

    @Autowired
    public UserServiceImpl(UserDao userdao) {
        this.userdao = userdao;
    }

    @Override
    public List<User> listUsers() {
        return userdao.listUsers();
    }

    @Override
    public void addUser(User user) {
        userdao.addUser(user);
    }

    @Override
    public User deleteUser(long id) {
        return userdao.deleteUser(id);
    }

    @Override
    public User changeUser(User user) {
        return userdao.changeUser(user);
    }

    @Override
    public User getUserById(long id) {
        return userdao.getUserById(id);
    }
}
