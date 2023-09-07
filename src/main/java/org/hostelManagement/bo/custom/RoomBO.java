package org.hostelManagement.bo.custom;

import org.hostelManagement.bo.SuperBO;

import java.util.List;

public interface RoomBO<T> extends SuperBO {
    public List<T> getAllRooms();

    public boolean addRoom(T entity);

    public boolean updateRoom(T entity);

    public String generateNewRoomID();

    public boolean deleteRoom(String id);

    public T searchRoom(String id);
}
