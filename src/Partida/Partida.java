package Partida;

import Edificios.Casa;
import Jugador.Jugador;
import Mapa.Mapa;
import Unidades.Infanteria;
import Unidades.Unidad;

import java.util.ArrayList;
import java.util.LinkedList;

public class Partida {

    private ArrayList<Jugador> jugadores;
    private int turno;
    private Mapa mapa;

    public Partida(int numjugadores, int[][] esquemamapa, int[][][] esquemaunidades, int[][][] esquemaedificios){
        turno = -1;
        jugadores = new ArrayList<Jugador>();
        for(int i = 0; i<numjugadores; i++){
            jugadores.add(new Jugador(i, this));
        }
        mapa = new Mapa(esquemamapa);
        //se almacenan arrays con la informacion de las posiciones y tipos de unidades para cada jugador
        //Si valor = 0 (No hay edificio), si valor = 1 (Es una casa)
        for(int j = 0; j<esquemaunidades.length;j++){
            for(int x = 0; x< esquemaunidades[j].length; x++){
                for(int y = 0; y < esquemaunidades[j][x].length; y++){
                    if(esquemaunidades[j][x][y] == 1){
                        Infanteria unidad = new Infanteria(mapa.getNodo(x,y), jugadores.get(j));
                        jugadores.get(j).añadirUnidad(unidad);
                    }
                }
            }
        }
        //se almacenan arrays con la informacion de las posiciones y tipos de edificios para cada jugador, y al final otro con los
        //edificios que no tienen dueño. Si valor = 0 (No hay edificio), si valor = 1 (Es una casa)
        for(int j = 0; j<=esquemaedificios.length;j++){
            for(int x = 0; x<= esquemaedificios.length; x++){
                for(int y = 0; y <= esquemaedificios[x].length; y++){
                    if(esquemaedificios[j][x][y] == 1){
                        Casa casa;
                        if(j == esquemaedificios.length){
                            casa = new Casa(mapa.getNodo(x,y));
                        }else{
                            casa = new Casa(mapa.getNodo(x,y), jugadores.get(j));
                        }
                        jugadores.get(j).añadirEdificio(casa);
                    }
                }
            }
        }
    }

    public void pasarTurno(){
        this.turno ++;
        jugadores.get(turno%jugadores.size()).recaudarDinero();

        LinkedList<Unidad> unidades = jugadores.get(turno%jugadores.size()).getUnidades();
        for(int i = 0; i < unidades.size(); i++){
            unidades.get(i).setHaMovido(false);
        }

    }

    public void pierde(Jugador jugador){
        jugadores.remove(jugador);

    }

    public boolean gana(Jugador jugador){
        return jugadores.size() == 1;
    }

    public Jugador getJugador(int i){
        return  jugadores.get(i);
    }
}
