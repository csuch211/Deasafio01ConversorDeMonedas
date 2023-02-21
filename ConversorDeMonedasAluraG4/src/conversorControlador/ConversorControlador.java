package conversorControlador;
import java.awt.event.*;
import java.text.DecimalFormat;

import conversorVista.WindowsMain;
import conversorModelo.ConversorDivisas;


public class ConversorControlador implements ActionListener{

     // Propiedades
     private WindowsMain ventana;
     private ConversorDivisas modelo;
    
     // Constructor
     public ConversorControlador(WindowsMain v, ConversorDivisas m){
          this.ventana = v;
          this.modelo = m;
         
          ventana.setComboDivisas(modelo.obtenerCodigosDivisa());
     }

     public void actionPerformed(ActionEvent e) {
         
          // Obtengo los valores para operar
          Double importe = ventana.obtenerImporte();
          String codDivisaOrigen = ventana.obtenerDivisaOrigen();
          String codDivisaDestino = ventana.obtenerDivisaDestino();
         
          // Realizo la conversion
          Double resultado = modelo.convertir(codDivisaOrigen, codDivisaDestino, importe);
         
          // Muestro el resultado en la etiqueta Resultado
          DecimalFormat df = new DecimalFormat("#,###.##"); // Formateo salida a dos decimales
          ventana.actualizarResultado(df.format(resultado).toString());
     }
}