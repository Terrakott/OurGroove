package Partida;

import Mapa.Mapa;
import Unidades.Infanteria;

public class Main {
    public static void main(String args[]) {
        int [][] nodos = new int[4][4];
        for(int x=0; x<4; x++){
            for(int y =0; y<4; y++){
                nodos[x][y] = 1;
                System.out.print("1  ");
            }
            System.out.print("\n");
        }
        Mapa mapa = new Mapa(nodos);
        Infanteria inf1 = new Infanteria(mapa.getNodo(1,0));
        Infanteria inf2 = new Infanteria(mapa.getNodo(3,0));
        //System.out.println("Inf1 :"+ inf1.getMyID());
        //System.out.println("Inf2 :"+ inf2.getMyID());
        //inf1.atacar(inf2);
        //System.out.println("\nInf2 :"+ inf2.getVida());
        System.out.println("U________________________________________U");
        for(int x=0; x<4; x++){
            for(int y =0; y<4; y++){
                if(mapa.getNodo(x,y).getContenido() == inf1)System.out.print("I1  ");
                else if(mapa.getNodo(x,y).getContenido() == inf2)System.out.print("I2  ");
                else System.out.print("0   ");

            }
            System.out.print("\n");
        }
        //inf1.mover(mapa.getNodo(0,0));
        inf2.mover(mapa.getNodo(0,3));
        System.out.println("U________________________________________U");
        for(int x=0; x<4; x++){
            for(int y =0; y<4; y++){
                if(mapa.getNodo(x,y).getContenido() == inf1)System.out.print("I1  ");
                else if(mapa.getNodo(x,y).getContenido() == inf2)System.out.print("I2  ");
                else System.out.print("0   ");

            }
            System.out.print("\n");
        }
    }
}
