package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    @Transactional
    @SuppressWarnings({"unchecked"})
    public void update(User user) {
        userDao.update(user);
    }

    //   @Transactional(readOnly = true)
    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    // ========== from dao new ============//

    @Override
    @Transactional
    public Set<Role> getRoles(Long id) {
        return null;
    }

    @Override
    @Transactional
    public void setModified(User user, Date modified) {

    }

    @Override
    @Transactional
    public void setCreated(User user, Date created) {

    }

    @Override
    @Transactional
    public void setRoleByName(User user, String roleName) {

    }

    @Override
    @Transactional
    public void setRoles(User user, Set<Role> roles) {

    }
}
