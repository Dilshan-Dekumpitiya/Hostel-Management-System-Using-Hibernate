package org.hostelManagement.dao.custom;

import org.hostelManagement.dao.CrudDAO;
import org.hostelManagement.entitiy.Student;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student> {
    List<Student> getUnpaidStudents();
}
