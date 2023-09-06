package org.hostelManagement.dao.custom;


import org.hostelManagement.dao.CrudDAO;
import org.hostelManagement.entitiy.User;

public interface UserDAO extends CrudDAO<User> {

    boolean valid(User user);
}
