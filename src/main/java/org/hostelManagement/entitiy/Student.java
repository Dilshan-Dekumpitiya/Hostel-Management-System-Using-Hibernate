package org.hostelManagement.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "student")
public class Student {
    @Id
    private String studentID;

    private String studentName;

    private String studentAddress;

    private String studentContact;

    private String studentDOB;

    private String studentGender;

}
