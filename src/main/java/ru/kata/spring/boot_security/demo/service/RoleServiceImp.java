package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImp implements RoleService {
    private RoleDao roleDao;

    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    @Transactional
    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    public List<Role> getRolesWithCheck(User user) {
        return roleDao.getRolesWithCheck(user);
    }

    @Override
    public Set<Role> getRolesByIdList(List<Long> id) {
        return roleDao.getRolesByIdList(id);
    }

    @Override
    @Transactional
    public void deleteRole(Long id) {
        roleDao.deleteRole(id);
    }

    @Override
    @Transactional
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }
}