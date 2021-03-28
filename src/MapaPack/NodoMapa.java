package MapaPack;

import ControladorPack.GameObject;
import ControladorPack.ID;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NodoMapa extends GameObject {

    private ID tipo;
    private int defensa; //modificador para la unidad que ocupe la casilla
    private int dificultad; //coste de moverse a esta casilla
    private Mapa mapa;
    private int posX, posY;
    private GameObject contenido;

    public NodoMapa(ID tipo, Mapa mapa, int posX, int posY){
        super(posX,posY, tipo);
        this.posX = posX;
        this.posY = posY;
        this.tipo = tipo;
        this.mapa = mapa;
        if(tipo == ID.LLANURA){
            this.defensa = 0;
            this.dificultad = 1;
        }else if(tipo == ID.MONTAÑA){
            this.defensa = 3;
            this.dificultad = 2;
        }else if(tipo == ID.AGUA){
            this.defensa = 0;
            this.dificultad = 1;
        }else if(tipo == ID.BOSQUE){
            this.defensa = 2;
            this.dificultad = 1;
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getDificultad() {
        return dificultad;
    }

    public GameObject getContenido() {
        return contenido;
    }

    public void setContenido(GameObject contenido) {
        this.contenido = contenido;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        BufferedImage image = null;
        try{
            image = ImageIO.read(new File("src/Imagenes/llanura.png"));
            Image rescaledImage;
            rescaledImage = image.getScaledInstance(32,32, Image.SCALE_SMOOTH);
            g.drawImage(rescaledImage, posX*32, posY*32, null);
        } catch(IOException e){
            e.printStackTrace();
        }

    }
}
