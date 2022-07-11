package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Override
    @SuppressWarnings("Unchecked")
    public List<Role> getRoles() {
        return entityManager.createQuery("SELECT r FROM Role r").getResultList();
    }

    @Override
    public List<Role> getRolesWithCheck(User user) {
        return null;
    }

    @Override
    public Set<Role> getRolesByIdList(List<Long> id) {
        return null;
    }

    @Override
    public void deleteRole(Long id) {
        entityManager.remove(entityManager.find(Role.class, id));
//        Query qry = entityManager.createNativeQuery("DELETE FROM user_role WHERE Role_id = :id");
//        qry.setParameter("id", id);
//        qry.executeUpdate();
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }
}
