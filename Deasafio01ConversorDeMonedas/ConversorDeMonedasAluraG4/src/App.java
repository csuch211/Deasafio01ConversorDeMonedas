import conversorControlador.ConversorControlador;
import conversorModelo.ConversorDivisas;
import conversorVista.WindowsMain;

public class App {
    
    public static void main(String[] args) {
        // Propiedades
        WindowsMain vista = new WindowsMain();
        ConversorDivisas modelo = new ConversorDivisas();          
        ConversorControlador controlador = new ConversorControlador(vista, modelo);
        
         // Métodos
         vista.conectarControlador(controlador); // Conecto la vista al controlador
         vista.arrancar(); // Muestro la interfaz gráfica
    }
    
}
