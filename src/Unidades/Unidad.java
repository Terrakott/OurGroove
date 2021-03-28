package Unidades;

import ControladorPack.GameObject;
import ControladorPack.ID;
import Edificios.Casa;
import Edificios.Edificio;
import Jugador.Jugador;
import MapaPack.NodoMapa;

public abstract class Unidad extends GameObject {

    private NodoMapa posicion;
    private int vida, ataque, defensa, velocidad, alcance;
    private Jugador dueño;
    private boolean haMovido;
    private boolean vuela;

    public Unidad(NodoMapa posicion, ID id) {
        super(posicion.getPosX(), posicion.getPosY(), id);
    }

    public abstract void atacar(Unidad objetivo);
    public abstract void recibirDaño(int daño);
    public abstract void mover(NodoMapa posicion);
    public abstract void reforzar(Casa casa);
    public abstract void conquistar(Edificio edificio);
    public abstract boolean alcance(Unidad objetivo);
    public abstract void morir();

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

    public NodoMapa getPosicion() {
        return this.posicion;
    }

    public void setPosicion( NodoMapa posicion) {
        this.posicion = posicion;
    }
}
