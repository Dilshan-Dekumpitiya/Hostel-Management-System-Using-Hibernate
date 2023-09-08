package org.hostelManagement.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hostelManagement.dao.custom.StudentDAO;
import org.hostelManagement.entitiy.Student;
import org.hostelManagement.util.FactoryConfiguration;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> getAll() {

        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM Student");
            nativeQuery.addEntity(Student.class);
            List<Student> students = nativeQuery.list();

            transaction.commit();

            return students;

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

    }

    @Override
    public boolean add(Student student) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(student);
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
    public boolean update(Student student) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(student);
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
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("SELECT student_id FROM Student ORDER BY student_id DESC");
            query.setMaxResults(1);
            List results = query.list();

            transaction.commit();

            return (results.size() == 0) ? null : (String) results.get(0);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return "0";
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Student student = new Student();
            student.setStudent_id(id);
            session.remove(student);
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
    public Student search(String id) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {

            return session.get(Student.class, id);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Student> getUnpaidStudents() {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {

            NativeQuery nativeQuery = session.createNativeQuery("SELECT DISTINCT * FROM student s JOIN reservation r on s.student_id = r.student_student_id WHERE r.status='un-paid'");
            nativeQuery.addEntity(Student.class);
            List<Student> students = nativeQuery.list();

            transaction.commit();

            return students;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Student> searchStudentByText(String text) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {

            Query query = session.createQuery("FROM Student WHERE name LIKE '%" + text + "%' OR address LIKE '%" + text + "%'" );
            List<Student> list = query.list();

            transaction.commit();

            return list;

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

    }
}
