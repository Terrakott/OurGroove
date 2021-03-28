package ControladorPack;

import MapaPack.Mapa;
import MapaPack.NodoMapa;

import java.awt.*;
import java.util.LinkedList;

public class Controlador {
    //LinkedList<Unidad> unidades = new LinkedList<Unidad>();
    //LinkedList<Edificio> edificios = new LinkedList<Edificio>();
    Mapa mapa;
    LinkedList<NodoMapa> posibleMovimiento;
    LinkedList<GameObject> menusTemporales;

    public Controlador(Mapa mapa){
        this.mapa = mapa;
        posibleMovimiento = new LinkedList<NodoMapa>();
        menusTemporales = new LinkedList<GameObject>();
    }

    public void tick(){
        /*for (int i = 0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);

            tempObject.tick();
        }*/
    }

    public void render(Graphics g){
        //dibuja el mapa
        for (int x = 0; x < mapa.getNodos().length; x++){
            for (int y = 0; y < mapa.getNodos()[x].length; y++){
                NodoMapa tempObject = mapa.getNodo(x,y);
                tempObject.render(g);
                if(tempObject.getContenido() != null){
                    tempObject.getContenido().render(g);
                }

            }
        }
        for (int x = 0; x < posibleMovimiento.size(); x++){
            NodoMapa tempObject = posibleMovimiento.get(x);
            g.drawRect(tempObject.getPosX(), tempObject.getPosY(), 32, 32); //Aqui se dibuja el cuadrado verde como que puede moverse
            //tempObject.render(g);
        }
        //dibuja las unidades
        /*for (int i = 0; i<unidades.size(); i++){
            Unidad tempUnidad = unidades.get(i);
            tempUnidad.render(g);
        }
        //dibuja los edificios
        for (int i = 0; i<edificios.size(); i++){
            Edificio tempEdificio = edificios.get(i);
            tempEdificio.render(g);
        }*/
    }

    /*public void addUnidad(Unidad object){
        this.unidades.add(object);
    }

    public void removeUnidad(Unidad object){
        this.unidades.remove(object);
    }

    public void addEdificio(Edificio object){
        this.edificios.add(object);
    }

    public void removeEdificio(Edificio object){
        this.edificios.remove(object);
    }*/

    public Mapa getMapa() {
        return this.mapa;
    }

    public void setMapa(final Mapa mapa) {
        this.mapa = mapa;
    }
}
