package conversorVista;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import conversorControlador.ConversorControlador;

public class WindowsMain extends JFrame {

     private static final long serialVersionUID = 1L;
     // Propiedades
     private JPanel contentPane;
     private JTextField txtImporte;
     private JButton btnConvertir;
     private JComboBox<String> comboDivD;
     private JComboBox<String> comboDivO;
     private JLabel lblResultado;
     private JLabel lblImporte;
     private JLabel lblConvertir;

     // Constructor
     public WindowsMain() {

          setTitle("Conversor Desafio Alura G04");
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setResizable(false);
          setSize(360, 420);
          setVisible(true);

          ImageIcon image = new ImageIcon("./images/logo01.png");
          setIconImage(image.getImage());
          getContentPane().setBackground(new Color(0x030929));

          setBounds(100, 100, 309, 237);
          contentPane = new JPanel();
          contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
          setContentPane(contentPane);
          contentPane.setLayout(null);

          lblImporte = new JLabel("Introduce importe: ");
          lblImporte.setFont(new Font("MV Boli", Font.BOLD, 12));
          lblImporte.setBounds(10, 11, 131, 14);
          contentPane.add(lblImporte);

          lblConvertir = new JLabel("Convertir a:");
          lblConvertir.setFont(new Font("MV Boli", Font.BOLD, 12));
          lblConvertir.setBounds(10, 74, 91, 14);
          contentPane.add(lblConvertir);

          lblResultado = new JLabel("Resultado: ");
          lblResultado.setFont(new Font("MV Boli", Font.BOLD, 18));
          lblResultado.setBounds(10, 165, 267, 27);
          contentPane.add(lblResultado);

          txtImporte = new JTextField();
          txtImporte.setBounds(10, 36, 131, 20);
          contentPane.add(txtImporte);
          txtImporte.setColumns(10);

          btnConvertir = new JButton("Convertir");
          btnConvertir.setFont(new Font("MV Boli", Font.BOLD, 12));
          btnConvertir.setBounds(175, 104, 102, 23);
          contentPane.add(btnConvertir);

          comboDivO = new JComboBox<String>();
          comboDivO.setBounds(175, 36, 102, 20);
          contentPane.add(comboDivO);

          comboDivD = new JComboBox<String>();
          comboDivD.setBounds(10, 105, 102, 20);
          contentPane.add(comboDivD);

          JSeparator separator = new JSeparator();
          separator.setBounds(10, 152, 273, 2);
          contentPane.add(separator);
     }

     // Metodos
     public void arrancar() {
          EventQueue.invokeLater(new Runnable() {
               public void run() {
                    try {
                         setVisible(true);
                         setLocationRelativeTo(null);
                    } catch (Exception e) {
                         e.printStackTrace();
                    }
               }
          });
     }

     public Double obtenerImporte() {
          try {
               return Double.valueOf(txtImporte.getText());
          } catch (NumberFormatException e) {
               return 0.0D;
          }
     }

     public String obtenerDivisaOrigen() {
          return comboDivO.getSelectedItem().toString();
     }

     public String obtenerDivisaDestino() {
          return comboDivD.getSelectedItem().toString();
     }

     public void actualizarResultado(String importe) {
          lblResultado.setText("Resultado: " + importe + " " + obtenerDivisaDestino());
     }

     public void setComboDivisas(Enumeration<String> codigosDivisas) {

          String elemento;
          while (codigosDivisas.hasMoreElements()) { // Mientras tenga más elementos
               elemento = codigosDivisas.nextElement(); // Almacenar elemento en variable
               // Añadimos elemento a ambos comboBox
               comboDivD.addItem(elemento);
               comboDivO.addItem(elemento);
          }
     }

     // El que escucha la acción no es la ventana, es el controlador
     public void conectarControlador(ConversorControlador controlador) {
          btnConvertir.addActionListener(controlador);
     }
}
