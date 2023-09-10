package org.hostelManagement.bo.custom;


import org.hostelManagement.bo.SuperBO;
import org.hostelManagement.dto.UserDTO;

public interface DashBoardBO extends SuperBO {
    int getAllReservationCount() throws Exception;

    int getTotOfAvailableRoomsCount() throws Exception;

    int getREGStuCount()throws Exception;

  //  public UserDTO getUser(UserDTO dto) throws Exception;
  //  public boolean updateUser(UserDTO dto) throws Exception;
}
