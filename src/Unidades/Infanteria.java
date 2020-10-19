package Unidades;

import Edificios.Casa;
import Edificios.Edificio;
import Mapa.NodoMapa;

public class Infanteria extends Unidad{

    public Infanteria(){
        setMyID(super.generarID());
        setVida(100);
        setAtaque(20);
        setDefensa(0);
        setVelocidad(5);

    }

    public Infanteria(NodoMapa posicion){
        setMyID(super.generarID());

        setPosicion(posicion);
        setVida(100);
        setAtaque(20);
        setDefensa(0);
        setVelocidad(5);

    }

    @Override
    public void atacar( Unidad objetivo) {
        if (this.alcance(objetivo)){
            int daño = getAtaque() + getAtaque()*100/getVida();
            objetivo.recibirDaño(daño);
        }
    }

    @Override
    public void recibirDaño(int daño) {
        daño = daño - 10*getDefensa();
        setVida(getVida()-daño);
        if (getVida()<=0) morir();
    }

    @Override
    public void mover(NodoMapa posicion) {

    }

    @Override
    public void reforzar(Casa casa) {

    }

    @Override
    public void conquistar(Edificio edificio) {
        int daño = getAtaque() + getAtaque()*100/getVida();
        edificio.recibirDaño(daño, getDueño());
        if(edificio.getDueño() != getDueño()) recibirDaño(edificio.getVida()/2);
    }

    @Override
    public boolean alcance(Unidad objetivo) {
        return true;
    }

    @Override
    public void morir() {
    }

}
