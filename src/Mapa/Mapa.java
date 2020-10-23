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
        System.out.println(origen.getPosX() + " " + origen.getPosY() + " resultado: " + resultado);
        if( distancia >= 0 && ((!camino.isEmpty() && origen.getContenido() == null) || camino.isEmpty())){
            camino.push(origen);
            System.out.println("lo mete");
        }
        if(!resultado && (!camino.isEmpty() && origen.getContenido() != null)){
            if(origen.getPosY()>destino.getPosY()){
                resultado = encontarCamino(distancia-origen.getDificultad(),nodos[origen.getPosX()][origen.getPosY()-1], destino, camino);
                if(!resultado) camino.pop();
            }else if(!resultado){
                resultado = encontarCamino(distancia-origen.getDificultad(),nodos[origen.getPosX()][origen.getPosY()+1], destino, camino);
                if(!resultado) camino.pop();
            }
            if(origen.getPosX()>destino.getPosX() && !resultado){
                resultado = resultado || encontarCamino(distancia-origen.getDificultad(),nodos[origen.getPosX()-1][origen.getPosY()], destino, camino);
                if(!resultado) camino.pop();
            }else if(!resultado){
                resultado = resultado || encontarCamino(distancia-origen.getDificultad(),nodos[origen.getPosX()+1][origen.getPosY()], destino, camino);;
                if(!resultado) camino.pop();
            }
        }

        return resultado;
    }

    public NodoMapa getNodo(int x, int y){
        return nodos[x][y];
    }

}
