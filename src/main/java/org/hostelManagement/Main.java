package org.hostelManagement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hostelManagement.entitiy.Student;
import org.hostelManagement.util.FactoryConfiguration;

public class Main {

    public static void main(String[] args) {
        Student student=new Student("S005","Deku","Matara","0772985802","2022-05-22","Male");

        /* Need to use try with resource --> firstly try session,
        Another time can't run the Session, after that close the session object */

        //start session --> Session is Interface (Therefore can't initialize with new keyword)
        try(Session session= FactoryConfiguration.getInstance().getSession();) {

            Transaction transaction = session.beginTransaction(); //begin transaction
            session.persist(student); //add data to table

            transaction.commit(); //commit that transaction

            session.close(); //close the session

        }


    }

}
