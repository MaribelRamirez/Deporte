
package com.deporte.controller;

import com.deporte.domain.Jugador;
import com.deporte.service.JugadorService;
import com.deporte.service.JugadorServiceImpl;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import org.primefaces.event.RowEditEvent;
//tarea facet_config.xml
@ViewScoped
@ManagedBean(name="jugadorController")
public class JugadorController implements Serializable{
    private Jugador jugador;
    private Jugador selectedJugador;
    private JugadorService jugadorService;
    //Inicializwar objetos
    @PostConstruct
    public void init(){
    this.jugadorService=new JugadorServiceImpl();
    this.jugador=new Jugador();
    }   
    //Métod para crear el registro
    public void crearRegistro(Jugador jugador){
        jugadorService.crearRegistro(jugador);
    }   
    
     public List<Jugador> obtenerRegistros(){
        return jugadorService.obtenerRegistros();
     }
     
     
     public void actualizarRegistro(Jugador jugador){
         jugadorService.actualizarRegistro(jugador);
     }
     
     public void eliminarRegistro(Integer idJugador){
         jugadorService.eliminarRegistro(idJugador);
     }
     public Jugador obtenerRegistro(Integer idJugador){
         return jugadorService.obtenerRegistro(idJugador);
     }       
    //Métod para eliminar el registro
    public void eliminarRegistro(Jugador jugador){
        jugadorService.crearRegistro(jugador);
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getSelectedJugador() {
        return selectedJugador;
    }

    public void setSelectedJugador(Jugador selectedJugador) {
        this.selectedJugador = selectedJugador;
    }

    public JugadorService getJugadorService() {
        return jugadorService;
    }

    public void setJugadorService(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }
    
    public void onRowSelect(RowEditEvent event){
        FacesMessage mensaje=new FacesMessage("Jugador actualizado",((Jugador) event.getObject()).getIdJugador().toString());
    }
    public void onRowEdit(RowEditEvent event){
        FacesMessage mensaje=new FacesMessage("Jugador actualizado",((Jugador) event.getObject()).getIdJugador().toString());
    }
    public void onRowCancel(RowEditEvent event){
    }
    }
