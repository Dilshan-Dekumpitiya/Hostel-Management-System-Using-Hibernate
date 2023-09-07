package org.hostelManagement.bo.custom;

import org.hostelManagement.bo.SuperBO;
import org.hostelManagement.dto.StudentDTO;
import org.hostelManagement.entitiy.Student;

import java.util.List;

public interface StudentBO<T> extends SuperBO {

    public List<T> getAllStudents();

    public boolean addStudent(T entity);

    public boolean updateStudent(T entity);

    public String generateNewStudentID();

    public boolean deleteStudent(String id);

    public T searchStudent(String id);

    List<T> getUnpaidStudents();

    List<T> searchStudentByText(String text);

}
