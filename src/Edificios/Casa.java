package Edificios;

import ControladorPack.ID;
import Jugador.Jugador;
import MapaPack.NodoMapa;

import java.awt.*;


public class Casa extends Edificio {

    public Casa(NodoMapa posicion){
        super(posicion, ID.CASA);
        setPosicion(posicion);
        posicion.setContenido(this);
        setVida(0);
        setImpuesto(200);
    }

    public Casa(NodoMapa posicion, Jugador jugador){
        super(posicion, ID.CASA);
        setPosicion(posicion);
        getPosicion().setContenido(this);
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

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        if(getDueño() == null){
            g.setColor(Color.GRAY);
        }else if(getDueño().getID() == 0){
            g.setColor(Color.RED);
        }else if(getDueño().getID() == 1) {
            g.setColor(Color.BLUE);
        }
        g.drawString("Casa", (getPosicion().getPosX())*32, (getPosicion().getPosY()+1)*32);
    }
}
