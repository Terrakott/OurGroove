package Unidades;

import Edificios.Casa;
import Edificios.Edificio;
import Jugador.Jugador;
import Mapa.NodoMapa;

public abstract class Unidad {

    private static int ID = 0;

    private NodoMapa posicion;
    private int vida, ataque, defensa, velocidad, alcance;
    private Jugador dueño;
    private int myID;
    private boolean haMovido;
    private boolean vuela;

    public abstract void atacar(Unidad objetivo);
    public abstract void recibirDaño(int daño);
    public abstract void mover(NodoMapa posicion);
    public abstract void reforzar(Casa casa);
    public abstract void conquistar(Edificio edificio);
    public abstract boolean alcance(Unidad objetivo);
    public abstract void morir();

    public int generarID(){
        this.ID ++;
        return this.ID;
    }

    public NodoMapa getPosicion() {
        return posicion;
    }

    public void setPosicion(NodoMapa posicion) {
        this.posicion = posicion;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAlcance() { return alcance; }

    public void setAlcance(int alcance) { this.alcance = alcance; }

    public Jugador getDueño() { return dueño; }

    public void setDueño(Jugador dueño) { this.dueño = dueño; }

    public int getMyID() { return myID; }

    public void setMyID(int myID) { this.myID = myID; }

    public boolean getHaMovido() {
        return haMovido;
    }

    public void setHaMovido(boolean haMovido) {
        this.haMovido = haMovido;
    }

    public boolean getVuela() {
        return vuela;
    }

    public void setVuela(boolean vuela) {
        this.vuela = vuela;
    }
}
