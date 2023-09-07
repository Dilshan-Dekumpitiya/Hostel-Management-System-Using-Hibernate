package org.hostelManagement.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UnpaidStudentTM {

    private String student_id;
    private String name;
    private String address;
    private String contact;


}

