package Jugador;

import Edificios.Edificio;
import Partida.Partida;
import Unidades.Unidad;

import java.util.LinkedList;

public class Jugador implements IJugador{
    private LinkedList<Edificio> edificios;
    private LinkedList<Unidad> unidades;
    private int oro;
    private int ID;
    private Partida partida;

    public Jugador(int ID, Partida p){
        edificios = new LinkedList<Edificio>();
        unidades = new LinkedList<Unidad>();
        oro = 500;
        this.ID = ID;
        setPartida(p);
    }

    @Override
    public void añadirUnidad(Unidad unidad){
        unidades.add(unidad);
    }

    @Override
    public void quitarUnidad(Unidad unidad) {
        unidades.remove(unidad);
    }

    @Override
    public void añadirEdificio( Edificio edificio){
        edificios.add(edificio);
    }

    @Override
    public void quitarEdificio(Edificio edificio) {
        edificios.remove(edificio);
    }

    public LinkedList<Unidad> getUnidades(){
        return unidades;
    }

    public LinkedList<Edificio> getEdificios(){
        return edificios;
    }

    public int getOro(){
        return this.oro;
    }

    public void recaudarDinero(){
        for(int edificio = 0; edificio<edificios.size();edificio++){
            this.oro = getOro()+edificios.get(edificio).getImpuesto();
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
}
