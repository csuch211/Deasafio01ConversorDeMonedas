import javax.swing.*;
import java.awt.*;

public class Formulario extends JFrame{

    Formulario(){

        this.setTitle("Conversor Desafio Alura G04");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(360,420);
        this.setVisible(true);

        ImageIcon image = new ImageIcon("./images/logo01.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(0x030929));
    
    }
}

