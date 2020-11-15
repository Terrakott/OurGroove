package Ventanas;
import javax.swing.*;
import java.awt.*;

public class Ventana_Inicial extends JFrame {
    public Ventana_Inicial(){
        iniciarComponentes();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setBackground(Color.blue);
        this.setTitle("OurWargroove");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void iniciarComponentes(){
        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        JLabel etiqueta1 = new JLabel();
        ImageIcon img = new ImageIcon("Blue-Wallpaper-For-Background-1.jpg");
        etiqueta1.setIcon(img);
        etiqueta1.setBounds(10,10,100,100);
        panel.add(etiqueta1);

    }
}
