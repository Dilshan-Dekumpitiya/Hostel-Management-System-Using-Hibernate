package org.hostelManagement.bo;

import org.hostelManagement.bo.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        USER, STUDENT, ROOM , RESERVATION,DASHBOARD

    }

    public SuperBO getBO(BOTypes boTypes) {

        switch (boTypes) {

            case USER:
                return new UserBOImpl();
            case STUDENT:
               return new StudentBOImpl();
            case ROOM:
                return new RoomBOImpl();
           case RESERVATION:
                return new ReservationBoImpl();
            case DASHBOARD:
                return new DashBoardBoImpl();
            default:
                return null;
        }


    }

}
