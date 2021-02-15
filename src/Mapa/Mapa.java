package Mapa;


import java.util.Stack;

public class Mapa {

    private NodoMapa[][] nodos;

    public Mapa(int[][] setTipoNodos){
        this.nodos = new NodoMapa[setTipoNodos.length][setTipoNodos[0].length];
        generarNodos(setTipoNodos);
    }

    private void generarNodos(int[][] setTipoNodos){
        for (int x = 0; x<setTipoNodos.length; x++){
            for (int y = 0; y<setTipoNodos[0].length; y++){
                this.nodos[x][y] = new NodoMapa(setTipoNodos[x][y], this, x, y);
            }
        }
    }

    public Stack encontrarCamino(NodoMapa posicionActual,NodoMapa posicionObjetivo,int movimientos){
        Stack solucion = new Stack();
        if(posicionActual.getPosX()==posicionObjetivo.getPosX() && posicionActual.getPosY() == posicionObjetivo.getPosY()){
            solucion.push(posicionActual);
            return solucion;

        }
        else return encontrarCaminoAux(posicionActual,posicionObjetivo,movimientos,solucion);

    }
    public Stack encontrarCaminoAux(NodoMapa posicionActual,NodoMapa posicionObjetivo,int Movimientos,Stack camino){
        if(posicionActual.getPosX()==posicionObjetivo.getPosX() && posicionActual.getPosY() == posicionObjetivo.getPosY()){//Caso base 1:Hemos llegado a la casilla objetivo
            camino.push(posicionActual);
            return camino;
        }
        if (Movimientos==0){ //Caso base 2: No quedan movimientos por tanto no llega
            return camino;
        }
        if ((posicionActual.getPosX()+1<nodos.length) && Movimientos - this.getNodo(posicionActual.getPosX()+1,posicionActual.getPosY()).getDificultad() > 0 ) //Preguntamos si se puede subir
        encontrarCaminoAux(this.getNodo(posicionActual.getPosX()+1,posicionActual.getPosY()))


    }


    public NodoMapa getNodo(int x, int y){
        return nodos[x][y];
    }

}
