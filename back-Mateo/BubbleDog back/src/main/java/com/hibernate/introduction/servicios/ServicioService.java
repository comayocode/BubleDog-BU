package com.hibernate.introduction.servicios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.hibernate.introduction.modelo.Servicio;

public class ServicioService {
        //atributos
        private SessionFactory factory;

        //metodos 
        public ServicioService() {
            // Crear objeto que permita fabricar sesiones
            factory = new Configuration().configure("cfg.xml").addAnnotatedClass(Servicio.class).buildSessionFactory();
        }
    
        public Session openSession() {
            Session session = factory.openSession();
            session.beginTransaction();
            return session;
        }
    //consultar servicios
    public List<Servicio> getServicios() {
        List<Servicio> servicio = new ArrayList<>();
        Session session = openSession();
        try {
            servicio = session.createQuery("from Servicio", Servicio.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return servicio;
    }
    
    //consultar servicio x nombre 
    public List<Servicio> getServiciosXNombre(String nombre_servicio) {
        List<Servicio> servicio = new ArrayList<>();
        Session session = openSession();
        try {
            servicio = session.createQuery("from Servicio where nombre_servicio = :parametro_nombre_servicio", Servicio.class).setParameter("parametro_nombre_servicio", nombre_servicio).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return servicio;
    }

        //actualizar registro

        public String updateServicios(Servicio servicios) {
            String message = "";
            Session session = openSession();
            try {
                session.merge(servicios);
                session.getTransaction().commit();
                message = "servicios actualizado con exito";
            } catch (Exception e) {
                e.printStackTrace();
                message = e.getMessage();
            }
            session.close();
            return message;
        }

        //eliminar registro

        public Servicio getServiciosXId(int id_servicio) {
            Servicio servicio = new Servicio();
            Session session = openSession();
            try {
                servicio = session.find(Servicio.class, id_servicio);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return servicio;
        }

        public String deleteServicios(int id) {
            String message = "";
            Session session = openSession();
            try {
                Servicio servicio = getServiciosXId(id);
                session.remove(servicio);
                session.getTransaction().commit();
                message = "Servicio eliminado con éxito";
            } catch (Exception e) {
                e.printStackTrace();
                message = e.getMessage();
            }
            session.close();
            return message;
        }
}
