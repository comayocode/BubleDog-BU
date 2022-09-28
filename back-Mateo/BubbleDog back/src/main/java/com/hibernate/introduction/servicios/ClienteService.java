package com.hibernate.introduction.servicios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.introduction.modelo.Cliente;

public class ClienteService {
    //atributos
    private SessionFactory factory;

    //metodos 
    public ClienteService() {
        // Crear objeto que permita fabricar sesiones
        factory = new Configuration().configure("cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
    }

    public Session openSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    //crear cliente
    public String create(Cliente cliente) {
        String resp = "";
        Session session = openSession();
        try {
            session.persist(cliente);
            session.getTransaction().commit();
            resp = "Cliente creado con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            resp = e.getMessage();
        }
        session.close();
        return resp;
    }

    //consultar cliente
    public List<Cliente> getClientes() {
        List<Cliente> cliente = new ArrayList<>();
        Session session = openSession();
        try {
            cliente = session.createQuery("from Cliente", Cliente.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return cliente;
    }
    
    //consultar cliente x cedula
    public Cliente getClienteXCedula(String cedula) {
        Cliente cliente = new Cliente();
        Session session = openSession();
        try {
            cliente = session.find(Cliente.class, cedula);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    //actualizar cliente 

    public String updateCliente(Cliente cliente) {
        String message = "";
        Session session = openSession();
        try {
            session.merge(cliente);
            session.getTransaction().commit();
            message = "cliente actualizado con exito";
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
        }
        session.close();
        return message;
    }

    //eliminar cliente
    public String deleteCliente(String cedula) {
        String message = "";
        Session session = openSession();
        try {
            Cliente cliente = getClienteXCedula(cedula);
            session.remove(cliente);
            session.getTransaction().commit();
            message = "cliente eliminado con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
        }
        session.close();
        return message;
    }
}
