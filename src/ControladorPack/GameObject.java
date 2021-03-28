package ControladorPack;

import java.awt.*;

public abstract class GameObject {
    protected int x,y;
    protected ID id;

    public  GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);


    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public ID getMyID() {
        return id;
    }

    public void setMyID(ID myID) {
        this.id = myID;
    }
}
