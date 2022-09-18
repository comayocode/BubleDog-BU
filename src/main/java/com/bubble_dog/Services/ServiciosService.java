package com.bubble_dog.Services;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bubble_dog.Models.ServiciosModel;

public class ServiciosService {

    private SessionFactory factory;

    public ServiciosService() {
        factory = new Configuration().configure("cfg.xml")
                .addAnnotatedClass(ServiciosModel.class)
                .buildSessionFactory();
    }

    public Session openSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public List<ServiciosModel> getServicios(){
        List<ServiciosModel> servicios = new ArrayList<>();
        Session session = openSession();
        try {
            servicios = session.createQuery("from ServiciosModel", ServiciosModel.class).list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return servicios;
    }

    public ServiciosModel servicioXId(String id){
        ServiciosModel servicio = new ServiciosModel();
        Session session = openSession();
        try {
            servicio = session.find(ServiciosModel.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return servicio;
    }

    public String crearServicio(ServiciosModel servico){
        String resp = "";
        Session session = openSession();
        try {
            session.persist(servico);
            session.getTransaction().commit();
            resp = "Servicio creado con exito";
        } catch (Exception e) {
           e.printStackTrace();
        }
        session.close();
        return resp;
    }

    public String borrarServicios(String id){
        String resp = "";
        Session session = openSession();
        try {
            ServiciosModel servicio = servicioXId(id);
            session.remove(servicio);
            session.getTransaction().commit();
            resp = "Servicio eliminado con exito";
        } catch (Exception e) {
           e.printStackTrace();
        }
        session.close();
        return resp;
    }

    public String updateServicio( ServiciosModel servicio){
        String resp = "";
        Session session = openSession();
        try {
            session.merge(servicio);
            session.getTransaction().commit();
            resp = "Servicio actualizado con exito";
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return resp;
    }
}
