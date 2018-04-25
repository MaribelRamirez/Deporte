/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deporte.service;

import com.deporte.dao.JugadorDao;
import com.deporte.dao.JugadorDaoImpl;
import com.deporte.domain.Jugador;
import java.util.List;

/**
 *
 * @author ELVIA
 */
public class JugadorServiceImpl implements JugadorService{
    
    private JugadorDao jugadorDao=new JugadorDaoImpl();
    
    @Override
    public void crearRegistro(Jugador jugador) {
        jugadorDao.crearRegistro(jugador);
    }

    @Override
    public List<Jugador> obtenerRegistros() {
        return jugadorDao.obtenerRegistros();
    }

    @Override
    public void actualizarRegistro(Jugador jugador) {
        jugadorDao.actualizarRegistro(jugador);
    }

    @Override
    public void eliminarRegistro(Jugador jugador) {
        jugadorDao.eliminarRegistro(jugador);
    }

    @Override
    public Jugador obtenerRegistro(Integer idJugador) {
        return jugadorDao.obtenerRegistro(idJugador);
    }
    
}
