package Jugador;

import Edificios.Edificio;
import Unidades.Unidad;

public interface IJugador {
    public abstract void añadirEdificio(Edificio edificio);
    public abstract void añadirUnidad(Unidad unidad);
    public abstract void quitarEdificio(Edificio edificio);
    public abstract void quitarUnidad( Unidad unidad);
}
