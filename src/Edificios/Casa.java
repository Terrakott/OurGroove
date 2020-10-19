package Edificios;

import Jugador.Jugador;
import Mapa.NodoMapa;


public class Casa extends Edificio {

    public Casa(NodoMapa posicion){
        setMyID(generarID());
        setPosocion(posicion);
        setVida(0);
    }

    public Casa(NodoMapa posicion, Jugador jugador){
        setMyID(generarID());
        setPosocion(posicion);
        setDueño(jugador);
        setVida(100);
    }

    @Override
    public void reparar() {
        setVida(getVida()+20);
        if (getVida()>100)setVida(100);
    }

    @Override
    public void recibirDaño(int daño, Jugador jugador) {
        setVida(getVida()-daño);
        if (getVida()<=0) setVida(daño);
        setDueño(jugador);
    }
}
