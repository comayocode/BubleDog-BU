package com.bubble_dog.Services;

//import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bubble_dog.Models.ClienteModel;

public class ClienteService {
    
    /*ATRIBUTOS */
    private SessionFactory factory;

    //Contructores
    public ClienteService() {
        factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(ClienteModel.class)
        .buildSessionFactory();
    }
    public Session openSession() {
        Session session = factory.openSession();
        session.beginTransaction();

        return session;
    }

    //Agregar clientes
    public String create(ClienteModel cliente){

        String message = "";
        Session session = openSession();

        try {
            session.persist(cliente);
            session.getTransaction().commit();

            message = "Cliente creado con exito";
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
        }

        session.close();
        return message;

    }

    //Obtener o mostrar cliente X cedula

    public ClienteModel getClienteByCedula(int cedula) {
        ClienteModel cliente = new ClienteModel();
        Session session = openSession();
        try {
            cliente = session.find(ClienteModel.class, cedula);
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        session.close();
        return cliente;
    }
}
