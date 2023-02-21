package conversorModelo;
import java.util.*;

public class ConversorDivisas {
    
     // Propiedades
     private Hashtable<String, Double> tablaConversion = new Hashtable<String, Double>();// Codigo de divisa e importe en euros
    
     // Constructor
     public ConversorDivisas(){
          insertarDivisa("EUR", 1.0); // Euro
          insertarDivisa("USD", 1.180); // Dolar estadounidense
          insertarDivisa("JPY", 134.86); // Yen japonés
          insertarDivisa("BGN", 1.958); // Lev búlgaro
     }

     private void insertarDivisa(String codigo, Double tipoCambio) {
          tablaConversion.put(codigo, tipoCambio);
     }
    
     private double obtenerDivisa(String codigoDivisa){
          return tablaConversion.get(codigoDivisa);
     }
    
     public Double convertir(String codDivOrigen, String codDivDestino, Double importe){
          Double euros = importe / obtenerDivisa(codDivOrigen); // Primero convierto a euros
          return euros * obtenerDivisa(codDivDestino); // Luego a la unidad de destino
     }
    
     public Enumeration<String> obtenerCodigosDivisa(){
          return tablaConversion.keys();
     }
}
