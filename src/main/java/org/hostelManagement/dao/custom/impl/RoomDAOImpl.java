package org.hostelManagement.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hostelManagement.dao.custom.RoomDAO;
import org.hostelManagement.entitiy.Room;
import org.hostelManagement.util.FactoryConfiguration;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public List<Room> getAll() {

        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM Room");
            nativeQuery.addEntity(Room.class);
            List<Room> rooms = nativeQuery.list();

            transaction.commit();

            return rooms;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean add(Room entity) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(entity);

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
    public boolean update(Room entity) {

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
            Query query = session.createQuery("SELECT room_id FROM Room ORDER BY room_id DESC");
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
            Room room = new Room();
            room.setRoom_id(id);
            session.remove(room);


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
    public Room search(String id) {

        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Room room = session.get(Room.class, id);

            transaction.commit();

            return room;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

    }
}
