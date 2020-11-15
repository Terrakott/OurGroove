package Unidades;

import Edificios.Casa;
import Edificios.Edificio;
import Jugador.Jugador;
import Mapa.NodoMapa;

import java.util.Stack;

import static java.lang.Math.*;

public class Infanteria extends Unidad{

    public Infanteria(NodoMapa posicion){
        setMyID(super.generarID());
        //setDueño(dueño);
        setPosicion(posicion);
        posicion.setContenido(this);
        //System.out.print(posicion.getContenido());
        setAlcance(1);
        setVida(100);
        setAtaque(20);
        setDefensa(0);
        setVelocidad(5);
        setHaMovido(false);
        setVuela(false);

    }

    public Infanteria(NodoMapa posicion, Jugador dueño){
        setMyID(super.generarID());
        setDueño(dueño);
        setPosicion(posicion);
        posicion.setContenido(this);
        //System.out.print(posicion.getContenido());
        setAlcance(1);
        setVida(100);
        setAtaque(20);
        setDefensa(0);
        setVelocidad(4);
        setHaMovido(false);
        setVuela(false);

    }

    @Override
    public void atacar( Unidad objetivo) {
        if (this.alcance(objetivo)){
            int daño = getAtaque() + getAtaque()*(getVida()/100);
            objetivo.recibirDaño(daño);
        }
    }

    @Override
    public void recibirDaño(int daño) {
        daño = daño - 5*(getDefensa()+getPosicion().getDefensa());
        setVida(getVida()-daño);
        System.out.print("Vida: " + getVida());
        if (getVida()<=0) morir();
    }

    @Override
    public void mover(NodoMapa posicion) {
        Stack<NodoMapa> camino = new Stack<NodoMapa>();
        //System.out.println(getPosicion().getMapa().encontarCamino(getVelocidad(), getPosicion(), posicion, camino));
        if(getPosicion().getMapa().encontarCamino(getVelocidad(), getPosicion(), posicion, camino) && !getHaMovido()){
            getPosicion().setContenido(null);
            setPosicion(posicion);
            getPosicion().setContenido(this);
            setHaMovido(true);
        }
    }

    @Override
    public void reforzar(Casa casa) {
        if(getDueño().getOro()>300){
            getDueño().transaccion(-300);
            setVida(getVida()+casa.getVida()/2);
            if(getVida()>100)setVida(100);
        }
    }

    @Override
    public void conquistar(Edificio edificio) {
        int daño = getAtaque() + getAtaque()*100/getVida();
        edificio.recibirDaño(daño, getDueño());
        if(edificio.getDueño() != getDueño()) recibirDaño(edificio.getVida()/2);
    }

    @Override
    public boolean alcance(Unidad objetivo) {
        //System.out.print("Por aquí llego");
        return !objetivo.getVuela() && abs(getPosicion().getPosX()-objetivo.getPosicion().getPosX()) <= getAlcance() &&
                abs(getPosicion().getPosY()-objetivo.getPosicion().getPosY()) <= getAlcance();
    }

    @Override
    public void morir() {
        getPosicion().setContenido(null);
        getDueño().quitarUnidad(this);
        //quitar de la lista de unidades del jugador y de la celda
    }

}
