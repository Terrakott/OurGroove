package Ventanas;

import javax.swing.*;

public class Window extends  JFrame {

    public Window(){
        setTitle("OurGroove");
        //setSize(WIDTH,HEIGHT);
        //UNA PERRA Skjbvrkjdsbvkhhb
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        //setUndecorated(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Window();
    }

}
