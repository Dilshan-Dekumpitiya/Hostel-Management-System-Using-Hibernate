package org.hostelManagement.bo.custom.impl;

import org.hostelManagement.bo.custom.RoomBO;
import org.hostelManagement.dao.DAOFactory;
import org.hostelManagement.dao.custom.RoomDAO;
import org.hostelManagement.dto.RoomDTO;
import org.hostelManagement.entitiy.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomBOImpl implements RoomBO<RoomDTO> {

    RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public List<RoomDTO> getAllRooms() {

        List<Room> rooms = roomDAO.getAll();
        List<RoomDTO> roomDTOS = new ArrayList<>();

        for (Room room : rooms) {

            RoomDTO roomDTO = new RoomDTO();

            roomDTO.setRoom_id(room.getRoom_id());
            roomDTO.setType(room.getType());
            roomDTO.setKey_money(room.getKey_money());
            roomDTO.setQty(room.getQty());
            roomDTOS.add(roomDTO);
        }

        return roomDTOS;
    }

    @Override
    public boolean addRoom(RoomDTO entity) {
        Room room = new Room();
        room.setRoom_id(entity.getRoom_id());
        room.setType(entity.getType());
        room.setKey_money(entity.getKey_money());
        room.setQty(entity.getQty());
        return roomDAO.add(room);
    }

    @Override
    public boolean updateRoom(RoomDTO entity) {
        Room room = new Room();
        room.setRoom_id(entity.getRoom_id());
        room.setType(entity.getType());
        room.setKey_money(entity.getKey_money());
        room.setQty(entity.getQty());
        return roomDAO.update(room);
    }

    @Override
    public String generateNewRoomID() {
        return roomDAO.generateNewID();
    }

    @Override
    public boolean deleteRoom(String id) {
        return roomDAO.delete(id);
    }

    @Override
    public RoomDTO searchRoom(String id) {

        Room room = roomDAO.search(id);

        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoom_id(room.getRoom_id());
        roomDTO.setType(room.getType());
        roomDTO.setKey_money(room.getKey_money());
        roomDTO.setQty(room.getQty());

        return roomDTO;


    }
}
