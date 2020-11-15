package Mapa;

public class NodoMapa {

    private int tipo; //1 llanura, 2 montaña, 3 agua, 4 bosque
    private int defensa; //modificador para la unidad que ocupe la casilla
    private int dificultad; //coste de moverse a esta casilla
    private Mapa mapa;
    private int posX, posY;
    private Object contenido;

    public NodoMapa(int tipo, Mapa mapa, int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        this.tipo = tipo;
        this.mapa = mapa;
        if(tipo == 1){
            this.defensa = 0;
            this.dificultad = 1;
        }else if(tipo == 2){
            this.defensa = 3;
            this.dificultad = 2;
        }else if(tipo == 3){
            this.defensa = 0;
            this.dificultad = 1;
        }else if(tipo == 4){
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

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }
}
