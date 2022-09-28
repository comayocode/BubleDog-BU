package com.hibernate.introduction.servicios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.hibernate.introduction.modelo.detalles_servicio;

public class Detalles_servicioService {
    //atributos
    private SessionFactory factory;

    //metodos
    public Detalles_servicioService(){
        // Crear objeto que permita fabricar sesiones
        factory = new Configuration().configure("cfg.xml").addAnnotatedClass(detalles_servicio.class).buildSessionFactory();
    }

    public Session openSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

        //crear nuevo registro

    
    public String create(detalles_servicio registro) {
        
        
        String resp = "";
        Session session = openSession();
        try {
            session.persist(registro);
            session.getTransaction().commit();
            resp = "Registro creado con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            resp = e.getMessage();
        }
        session.close();
        return resp;
    }

    //consultar todos los registros
    public List<detalles_servicio> getDetalles_servicio() {
        List<detalles_servicio> registro = new ArrayList<>();
        Session session = openSession();
        try {
            registro = session.createQuery("from detalles_servicio", detalles_servicio.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return registro;
    }
    
    //consultar registros x cedula
    public List<detalles_servicio> getDetallesXCedula(String cedula) {
        List<detalles_servicio> registro = new ArrayList<>();
        Session session = openSession();
        try {
            registro = session.createQuery("from detalles_servicio where cedula = :parametro_cedula ", detalles_servicio.class).setParameter("parametro_cedula",cedula).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registro;
    }

        //actualizar registro

        public String updateDetalles(detalles_servicio registro) {
            String message = "";
            Session session = openSession();
            try {
                session.merge(registro);
                session.getTransaction().commit();
                message = "registro actualizado con exito";
            } catch (Exception e) {
                e.printStackTrace();
                message = e.getMessage();
            }
            session.close();
            return message;
        }

        //eliminar registro

        public detalles_servicio getDetallesXId(int id_detalles_servicio) {
            detalles_servicio registro = new detalles_servicio();
            Session session = openSession();
            try {
                registro = session.find(detalles_servicio.class, id_detalles_servicio);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return registro;
        }

        public String deleteDetalles(int id) {
            String message = "";
            Session session = openSession();
            try {
                detalles_servicio resitro = getDetallesXId(id);
                session.remove(resitro);
                session.getTransaction().commit();
                message = "resitro eliminado con éxito";
            } catch (Exception e) {
                e.printStackTrace();
                message = e.getMessage();
            }
            session.close();
            return message;
        }
}
