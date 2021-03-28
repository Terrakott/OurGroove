package Partida;

import ControladorPack.Controlador;
import Ventanas.HUD;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Juego extends Canvas implements Runnable{

    public static final int WIDTH = 640, HEIGHT = WIDTH/12 *9;
    private Thread thread;
    private boolean running = false;

    private Partida game;

    private Controlador controlador;
    private HUD hud;

    public Juego(Partida game){
        this.game = game;

        this.controlador = new Controlador(game.getMapa());

        this.addMouseListener(new ControladorPack.MouseInput(this.controlador));

        new Ventanas.Window(WIDTH, HEIGHT, "OurGroove", this);

        hud = new HUD();

    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta --;
            }
            if (running)render();
            frames ++;

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames);
            }
        }
        stop();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0,0,WIDTH,HEIGHT);

        controlador.render(g);

        hud.render(g);

        g.dispose();
        bs.show();
    }

    private void tick(){
        controlador.tick();
        hud.tick();
    }

    public static void main(String args[]){



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
                    unis[x][y] = 0;
                }
            }
            unis[0][w] = 1;
            unidades[w] = unis;
        }

        int[][][] edificios = new int[3][5][5];
        for(int w = 0; w < 3; w++){
            int [][] edis = new int[5][5];
            for(int x=0; x<5; x++){
                for(int y =0; y<5; y++){
                    edis[x][y] = 0;
                }
            }
            edis[4][w] = 1;
            edificios[w] = edis;
        }

        Partida game = new Partida(2, nodos, unidades, edificios);
        new Juego(game);

    }
}
