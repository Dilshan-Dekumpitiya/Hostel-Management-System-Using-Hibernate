package org.hostelManagement.bo.custom.impl;

import org.hostelManagement.bo.custom.DashBoardBO;
import org.hostelManagement.dao.DAOFactory;
import org.hostelManagement.dao.custom.ReservationDAO;
import org.hostelManagement.dao.custom.RoomDAO;
import org.hostelManagement.dao.custom.StudentDAO;
import org.hostelManagement.entitiy.Room;

import java.util.List;

public class DashBoardBoImpl implements DashBoardBO {
    private ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESERVATION);
    private RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);
    private StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public int getAllReservationCount() throws Exception {
        return reservationDAO.getAll().size();
    }

    @Override
    public int getTotOfAvailableRoomsCount() throws Exception {
        List<Room> all = roomDAO.getAll();

        int totRoomsAvailable = 0;
        for (Room room : all) {
            totRoomsAvailable += room.getQty();
        }

        return totRoomsAvailable;
    }

    @Override
    public int getREGStuCount() throws Exception {
        return studentDAO.getAll().size();
    }

}
