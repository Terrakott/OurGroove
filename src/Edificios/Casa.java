package Edificios;

import Jugador.Jugador;
import Mapa.NodoMapa;


public class Casa extends Edificio {

    public Casa(NodoMapa posicion){
        setMyID(generarID());
        setPosocion(posicion);
        posicion.setContenido(this);
        setVida(0);
        setImpuesto(200);
    }

    public Casa(NodoMapa posicion, Jugador jugador){
        setMyID(generarID());
        setPosocion(posicion);
        getPosocion().setContenido(this);
        setDueño(jugador);
        getDueño().añadirEdificio(this);
        setVida(100);
        setImpuesto(200);
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
}
