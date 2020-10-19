package Partida;

import Mapa.Mapa;
import Unidades.Infanteria;

public class Main {
    public static void main(String args[]) {
        Mapa mapa = new Mapa();
        Infanteria inf1 = new Infanteria();
        Infanteria inf2 = new Infanteria();
        System.out.println("Inf1 :"+ inf1.getMyID());
        System.out.println("Inf2 :"+ inf2.getMyID());
        inf1.atacar(inf2);
        System.out.println("Inf2 :"+ inf2.getVida());
    }
}
