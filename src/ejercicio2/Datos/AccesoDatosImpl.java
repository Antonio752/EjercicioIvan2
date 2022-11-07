package ejercicio2.Datos;

import ejercicio2.dominio.Alarma;
import java.util.*;

public class AccesoDatosImpl implements IAccesoDatos{
    
    private static List<Alarma> sistema = new ArrayList<>();
    private static Alarma alarma;
    
    @Override
    public void crearAlarma(String tipoAlarma, int valorReal, int valorUmbral) {

        alarma = FactoriaAlarma.crearAlarma(tipoAlarma, valorUmbral, valorReal);
        guardarAlarma();
    }

    @Override
    public void guardarAlarma() {
        sistema.add(alarma);
    }

    @Override
    public void listarAlarmas() {
        for (Alarma alarma : sistema) {
            System.out.println(alarma.toString());
        }
        
        if(sistema.isEmpty()){
            System.out.println("No hay Alarmas en el sistema");
        }
    }

    @Override
    public void borrarAlarma(int numeroAlarma) {
        sistema.remove(numeroAlarma);
        System.out.println("Se ha eliminado la alarma seleccionada");
    }

    @Override
    public void mostrarEstados() {
        for (Alarma alarma : sistema) {
            if(alarma.isEstado()== false){
               System.out.println("Desactivada"); 
            }else{
                System.out.println("Activada"); 
            }
        }
    }

    @Override
    public void borrarSistema() {
        sistema.clear();
        System.out.println("Se han eliminado todas las alarmas del sistema");
    }

    @Override
    public void apagarAlarma() {
        for (Alarma alarma : sistema) {
            if (alarma.isEstado() == true) {
                alarma.setEstado(false);
            }
        }
        System.out.println("Se han apagado la alarma");
    }

    @Override
    public void comprobarAnomalia() {
        for (Alarma alarma : sistema) {

            if (alarma.getValorReal() >= alarma.getValorUmbral()) {
                alarma.setEstado(true);
                System.out.println("Se ha activado la alarma " + sistema.indexOf(alarma) + 1);
                if (alarma.getValorUmbral() <= calcularValorMedio()) {
                    System.out.println("PIIIIIIIIIIIIIII hay un incendio");
                } else {
                    System.out.println("Falsa Alarma");
                }
            }else{
                System.out.println("Todo esta tranquilo");
            }
        }
    }

    @Override
    public int calcularValorMedio() {

        int sumaValor = 0;
        int mediaSistema = 0;
        for (Alarma alarma : sistema) {
            sumaValor = alarma.getValorReal();
        }
        mediaSistema = sumaValor / sistema.size();
        return mediaSistema;
    }

    @Override
    public int generaRandom() {
        double random = (Math.random() * 50) + 1;
        int aleatorio = (int) random;
        return aleatorio;
    }   
}