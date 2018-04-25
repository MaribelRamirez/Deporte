
package com.deporte.controller;

import com.deporte.domain.Jugador;
import com.deporte.service.JugadorService;
import com.deporte.service.JugadorServiceImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
//tarea facet_config.xml
@ViewScoped
@ManagedBean(name="jugadorController")
public class JugadorController implements Serializable{
    private List<Jugador> listaRegistro;
    private Jugador selectedJugador;
    private JugadorService jugadorService;
    //Inicializwar objetos
    @PostConstruct
    public void init(){
        this.jugadorService=new JugadorServiceImpl();
        inicializarListaJugador();
    }   
    //cargar la lista de registros del jugador 
    private  void inicializarListaJugador(){
        listaRegistro=new ArrayList<>();
        listaRegistro=jugadorService.obtenerRegistros();
    }
    //Métod para crear el registro
    public void crearRegistro(Jugador jugador){
        jugadorService.crearRegistro(jugador);
    }   
    
   
    //Métod para eliminar el registro
    public void eliminarRegistro(Jugador jugador){
        jugadorService.eliminarRegistro(jugador);
        inicializarListaJugador();
    }

    public Jugador getSelectedJugador() {
        return selectedJugador;
    }

    public void setSelectedJugador(Jugador selectedJugador) {
        this.selectedJugador = selectedJugador;
    }

    public List<Jugador> getListaRegistro() {
        return listaRegistro;
    }

    public void setListaRegistro(List<Jugador> listaRegistro) {
        this.listaRegistro = listaRegistro;
    }
    
    
    public void onRowSelect(SelectEvent event){
        FacesMessage mensaje=new FacesMessage("Jugador actualizado",((Jugador) event.getObject()).getIdJugador().toString());
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    public void onRowEdit(RowEditEvent event){
        jugadorService.actualizarRegistro(selectedJugador);
        //Jugador jugador=(Jugador) event.getObject();
        FacesMessage mensaje=new FacesMessage("Jugador actualizado",((Jugador) event.getObject()).getIdJugador().toString());
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    public void onRowCancel(RowEditEvent event){
         FacesMessage mensaje=new FacesMessage("Acción cancelado",((Jugador) event.getObject()).getIdJugador().toString());
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    }
