package org.hostelManagement.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hostelManagement.dao.custom.ReservationDAO;
import org.hostelManagement.entitiy.Reservation;
import org.hostelManagement.util.FactoryConfiguration;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public List<Reservation> getAll() {

        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM Reservation"); //Define from Entity Class Name
            nativeQuery.addEntity(Reservation.class);
            List<Reservation> reservations = nativeQuery.list();

            transaction.commit();

            return reservations;

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }


    }

    @Override
    public boolean add(Reservation entity) {

        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(entity);

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
    public boolean update(Reservation entity) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(entity);

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
            Query query = session.createQuery("SELECT res_id FROM Reservation ORDER BY res_id DESC");
            query.setMaxResults(1);
            List results = query.list();

            transaction.commit();

            return (results.size() == 0) ? null : (String) results.get(0);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return " ";
        } finally {
            session.close();
        }

    }

    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Reservation reservation = new Reservation();
            reservation.setRes_id(id);
            session.delete(reservation);

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
    public Reservation search(String id) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Reservation reservation = session.get(Reservation.class, id);

            transaction.commit();

            return reservation;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
