package org.hostelManagement.dao.custom.impl;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hostelManagement.dao.custom.UserDAO;
import org.hostelManagement.entitiy.User;
import org.hostelManagement.util.FactoryConfiguration;


import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAll() {

        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM User");
            nativeQuery.addEntity(User.class);
            List<User> users = nativeQuery.list();

            transaction.commit();

            return users;

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean add(User user) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(user);

            transaction.commit();

            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(User user) {

        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(user);

            transaction.commit();

            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }


    }

    @Override
    public String generateNewID() {
        return null;
    }

    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            User user = session.get(User.class, id);
            session.remove(user);

            transaction.commit();

            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public User search(String id) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            User user = session.get(User.class, id);

            transaction.commit();

            return user;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean valid(User user) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            User current_user = session.get(User.class, user.getId());
            if (current_user.getPassword().equals(user.getPassword())) {
                return true;
            }

            transaction.commit();

            return false;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}
