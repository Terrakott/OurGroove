package Partida;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        boolean salir = false;
        int [][] nodos = new int[5][5];
        for(int x=0; x<5; x++){
            for(int y =0; y<5; y++){
                nodos[x][y] = 1;
            }
        }

        int[][][] unidades = new int[2][5][5];
        for(int w = 0; w < 2; w++){
            int [][] unis = new int[5][5];
            for(int x=0; x<5; x++){
                for(int y =0; y<5; y++){
                    if(x==w)nodos[x][y] = 1;
                    else nodos[x][y] = 0;
                }
            }
            unidades[w] = unis;
        }

        int[][][] edificios = new int[3][5][5];
        for(int w = 0; w < 3; w++){
            int [][] edis = new int[5][5];
            for(int x=0; x<5; x++){
                for(int y =0; y<5; y++){
                    if(x==w)nodos[x+2][y] = 1;
                    else nodos[x][y] = 0;
                }
            }
            edificios[w] = edis;
        }

        Partida game = new Partida(3, nodos, unidades, edificios);
        while (!salir){
            System.out.print("Elige la X: ");
            String strX= sc.nextLine();
            System.out.print("Elige la X: ");
            String stry= sc.nextLine();

            if(strX == "salir" || stry == "salir") salir = true;
        }
    }
}

/*int [][] nodos = new int[4][4];
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
        //System.out.println(var);
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
        inf1.mover(mapa.getNodo(3,1));
        //inf2.mover(mapa.getNodo(3,3));
        //System.out.println(inf2.getPosicion().getPosX() + " " + inf2.getPosicion().getPosY());
        System.out.println("U________________________________________U");
        for(int x=0; x<4; x++){
            for(int y =0; y<4; y++){
                if(mapa.getNodo(x,y).getContenido() == inf1)System.out.print("I1  ");
                else if(mapa.getNodo(x,y).getContenido() == inf2)System.out.print("I2  ");
                else System.out.print("0   ");

            }
            System.out.print("\n");
        }*/