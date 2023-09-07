package org.hostelManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class StudentDTO {

    private String student_id;
    private String name;
    private String address;
    private String contact;
    private String gender;
    private Date dob;
    @ToString.Exclude
    private List<ReservationDTO> reservationList = new ArrayList<>();

}
