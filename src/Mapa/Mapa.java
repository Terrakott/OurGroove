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

    public boolean encontarCamino(int distancia, NodoMapa origen, NodoMapa destino, Stack<NodoMapa> camino){
        boolean resultado = (origen == destino);
        System.out.println(origen.getPosX() + " " + origen.getPosY());
        if(origen.getContenido()==null || camino.isEmpty()){
            camino.push(origen);
            if(distancia>=0){
                int y = origen.getPosY()-1;
                if(y>=0) resultado = resultado || encontarCamino(distancia-origen.getDificultad(),nodos[origen.getPosX()][y], destino, camino);
                if(!resultado) camino.pop();
                y = origen.getPosY()+1;
                if(y<nodos[0].length) resultado = resultado || encontarCamino(distancia-origen.getDificultad(),nodos[origen.getPosX()][y], destino, camino);
                if(!resultado) camino.pop();
                int x = origen.getPosX()-1;
                if(x>=0) resultado = resultado || encontarCamino(distancia-origen.getDificultad(),nodos[x][origen.getPosY()], destino, camino);
                if(!resultado) camino.pop();
                x = origen.getPosX()+1;
                if(x<nodos.length)resultado = resultado || encontarCamino(distancia-origen.getDificultad(),nodos[x][origen.getPosY()], destino, camino);
                if(!resultado) camino.pop();
            }
        }
        System.out.print(" resultado: " + resultado + "\n");
        return resultado;
    }

    public NodoMapa getNodo(int x, int y){
        return nodos[x][y];
    }

}
