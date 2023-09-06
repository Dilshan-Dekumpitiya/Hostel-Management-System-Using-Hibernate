package org.hostelManagement.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hostelManagement.entitiy.User;


public class FactoryConfiguration {
    //Used singleton design pattern
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration(){

        // Creating the Hibernate StandardServiceRegistryBuilder
        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();

        //load properties file
        standardServiceRegistryBuilder.loadProperties("hibernate.properties");

        // Creating MetadataSources to define metadata for the annotated classes
        MetadataSources metadataSources = new MetadataSources(standardServiceRegistryBuilder.build());

        // Adding annotated classes to the metadataSources
        metadataSources
                .addAnnotatedClass(User.class);
               /*addAnnotatedClass(Room.class).
                addAnnotatedClass(Reservation.class).
                addAnnotatedClass(User.class);*/

        // Building Metadata from the MetadataSources
        Metadata metadata = metadataSources.getMetadataBuilder().build();

        // Building the SessionFactory from the Metadata
        sessionFactory =  metadata.getSessionFactoryBuilder().build();
    }

    public static FactoryConfiguration getFactoryConfiguration(){ //get factory configuration instance
        return (factoryConfiguration==null)?
                factoryConfiguration=new FactoryConfiguration(): factoryConfiguration;
    }

    public Session getSession(){ //get one session
        return sessionFactory.openSession();
    }
}
