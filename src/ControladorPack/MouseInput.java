package ControladorPack;

import MapaPack.Mapa;
import MapaPack.NodoMapa;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    private NodoMapa selected;
    private Controlador controlador;
    private Mapa mapa;

    public MouseInput(Controlador controlador){
        this.selected = null;
        this.controlador = controlador;
        this.mapa = controlador.mapa;
    }

    @Override
    public void mouseClicked(final MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        int mapCordX = mouseX/32;//traduce los pixeles a cordenadas en el mapa
        int mapCordY = mouseY/32;//traduce los pxeles a cordenadas en el mapa
        if(SwingUtilities.isLeftMouseButton(e)){//click izquierdo
            if(mapCordX < controlador.getMapa().getNodos().length && mapCordY < controlador.getMapa().getNodos()[0].length ) {//si clica dentro del mapa
                if ((selected != null) && mapa.getNodo(selected.getPosX(), selected.getPosY()).getContenido() != null) { //si ya ha seleccionado algo previamente que no sea una casilla vacia

                } else {
                    selected = mapa.getNodo(mapCordX, mapCordY);
                }
            }else{
                this.selected = null;
            }
        }else{//click derecho

        }

        //System.out.println("Has clicado en " + mouseX + ", " + mouseY);
    }
}
