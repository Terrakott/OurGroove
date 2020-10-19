package Jugador;

import Edificios.Casa;
import Unidades.Unidad;

public interface IJugador {
    public abstract void añadirCasa(Casa casa);
    public abstract void añadirUnidad( Unidad unidad);
    public abstract void quitarCasa(Casa casa);
    public abstract void quitarUnidad( Unidad unidad);
}
