/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deporte.dao;

import com.deporte.domain.Jugador;
import com.deporte.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author ELVIA
 */
public class JugadorDaoImpl implements JugadorDao{
    //Establecer la sesión con la base de datos
    Session session;

    @Override
    public List<Jugador> obtenerRegistros() {
        List<Jugador> listaJugador=new ArrayList<>();
        try {
            //Abrir sesion 
            session=HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("FROM Jugador").list();
            
        } catch (HibernateException e) {
            System.err.println("Error al obtener los regsitros: "+e.getMessage());
            return null;
        }
    }

    @Override
    public void crearRegistro(Jugador jugador) {
        try {
            //Abrir sesion 
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //insertar el objeto en la base de datos
            session.save(jugador);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.err.println("Error al crear el resgitro: "+e.getMessage());
        }
    }

    @Override
    public void actualizarRegistro(Jugador jugador) {
        try {
            //Abrir sesion 
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //insertar el objeto en la base de datos
            session.update(jugador);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.err.println("Error al crear el resgitro: "+e.getMessage());
        }
    }

    @Override
    public void eliminarRegistro(Integer idJugador) {
         try {
            //Abrir sesion 
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //insertar el objeto en la base de datos
            session.createQuery("DELETE FROM jugador WHERE IdJugador="+idJugador).executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.err.println("Error al crear el resgitro: "+e.getMessage());
        }
    }

    @Override
    public Jugador obtenerRegistro(Integer idJugador) {
       Jugador jugador=new Jugador();
        try {
            //Abrir sesion 
            session=HibernateUtil.getSessionFactory().openSession();
            jugador=(Jugador)session.createQuery("SELECT * FROM jugador WHERE idJugador="+idJugador).uniqueResult();
            session.close();
            return jugador;
        } catch (HibernateException e) {
            System.err.println("Error al crear el resgitro: "+e.getMessage());
            return null;
        }
    }
    
}
