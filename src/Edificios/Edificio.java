package Edificios;

import ControladorPack.GameObject;
import ControladorPack.ID;
import Jugador.Jugador;
import MapaPack.NodoMapa;

public abstract class Edificio extends GameObject {

    private NodoMapa posicion;
    private int vida;
    private Jugador dueño;
    private int myID;
    private int impuesto;

    public Edificio(NodoMapa posicion, ID id) {
        super(posicion.getPosX(), posicion.getPosY(), id);
    }

    public abstract void reparar();
    public abstract void recibirDaño(int daño, Jugador jugador);


    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Jugador getDueño() {
        return dueño;
    }

    public void setDueño(Jugador dueño) {
        this.dueño = dueño;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public NodoMapa getPosicion() {
        return this.posicion;
    }

    public void setPosicion( NodoMapa posicion) {
        this.posicion = posicion;
    }
}
