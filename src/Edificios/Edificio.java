package Edificios;

import Jugador.Jugador;
import Mapa.NodoMapa;

public abstract class Edificio {

    private static int ID = 0;

    private int vida;
    private NodoMapa posocion;
    private Jugador dueño;
    private int myID;
    private int impuesto;

    public abstract void reparar();
    public abstract void recibirDaño(int daño, Jugador jugador);

    public int generarID(){
        this.ID ++;
        return this.ID;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public NodoMapa getPosocion() {
        return posocion;
    }

    public void setPosocion(NodoMapa posocion) {
        this.posocion = posocion;
    }

    public Jugador getDueño() {
        return dueño;
    }

    public void setDueño(Jugador dueño) {
        this.dueño = dueño;
    }


    public int getMyID() {
        return myID;
    }

    public void setMyID(int myID) {
        this.myID = myID;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }
}
