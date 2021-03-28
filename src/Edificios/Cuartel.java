package Edificios;

import ControladorPack.ID;
import Jugador.Jugador;
import MapaPack.NodoMapa;
import Unidades.Infanteria;

import java.awt.*;

public class Cuartel extends Edificio {

    public Cuartel(NodoMapa posicion){
        super(posicion, ID.CUARTEL);
        setPosicion(posicion);
        posicion.setContenido(this);
        setVida(0);
        setImpuesto(0);
    }

    public Cuartel(NodoMapa posicion, Jugador jugador){
        super(posicion,ID.CUARTEL);
        setPosicion(posicion);
        getPosicion().setContenido(this);
        setDueño(jugador);
        getDueño().añadirEdificio(this);
        setVida(100);
        setImpuesto(0);
    }

    public void reclutar(NodoMapa posicion, int tipoUnidad){
        if(tipoUnidad == 0) new Infanteria(posicion,getDueño());

    }

    @Override
    public void reparar() {
        setVida(getVida()+20);
        if (getVida()>100)setVida(100);
    }

    @Override
    public void recibirDaño(int daño, Jugador jugador) {
        setVida(getVida()-daño);
        if (getVida()<=0) {
            setVida(daño);
            if (getDueño()!=null){
                getDueño().quitarEdificio(this);
            }
            setDueño(jugador);
            getDueño().añadirEdificio(this);
        }
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
