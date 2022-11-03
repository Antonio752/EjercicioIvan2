package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private static List<Alarma> sistema = new ArrayList<>();
    private static Alarma alarma;

    public static void main(String args[]) {
        Scanner entrada = new Scanner(System.in);
        String tipoAlarma, cadena;
        int valorUmbral = 0;
        int valorReal = 0;
        int indice = 0;
        int opcion = 0;
        do {
            System.out.println();
            System.out.println("Elige una opcion: \n 1. Crear Dispositivo \n 2. Borrar Alarma "
                    + "\n 3. Borrar Sistema \n 4. Listar Alarmas \n  5. Mostrar estados de las alarmas "
                    + "\n 6. comprobarAnomalia \n 7. Apagar alarmar \n 0. Salir");
            cadena = entrada.nextLine();
            if (isNumeric(cadena) == true) {
                opcion = Integer.parseInt(cadena);
                switch (opcion) {
                    case 1:
                        System.out.println("Introduce un tipo de alarma");
                        tipoAlarma = entrada.nextLine();
                        System.out.println("Introduce un numero de Umbral");
                        cadena = entrada.nextLine();
                        valorUmbral = Integer.parseInt(cadena);
                        valorReal = generaRandom();
                        crearAlarma(tipoAlarma, valorReal, valorUmbral);
                        break;
                    case 2:
                        System.out.println("Introduce un numero de alarma");
                        cadena = entrada.nextLine();
                        if (isNumeric(cadena) == true) {
                            indice = Integer.parseInt(cadena);
                            borrarAlarma(indice);
                        } else {
                            System.out.println("No es un numero");
                        }

                        break;
                    case 3:
                        borrarSistema();
                        break;
                    case 4:
                        listarAlarmas();
                        break;
                    case 5:
                        mostrarEstados();
                        break;
                    case 6:
                        comprobarAnomalia();
                        break;
                    case 7:
                        apagarAlarma();
                        break;
                }

            } else {
                System.out.println("No es un numero");
            }

        } while (opcion != 0);
    }

    public static void crearAlarma(String tipoAlarma, int valorReal, int valorUmbral) {

        alarma = FactoriaAlarma.crearAlarma(tipoAlarma, valorUmbral, valorReal);
        guardarAlarma();
    }

    public static void guardarAlarma() {
        sistema.add(alarma);
    }

    public static void listarAlarmas() {
        for (Alarma alarma : sistema) {
            System.out.println(alarma.toString());
        }
        
        if(sistema.size()== 0){
            System.out.println("No hay Alarmas en el sistema");
        }
    }

    public static void borrarAlarma(int numeroAlarma) {
        sistema.remove(numeroAlarma);
        System.out.println("Se ha eliminado la alarma seleccionada");
    }

    public static void mostrarEstados() {
        for (Alarma alarma : sistema) {
            if(alarma.isEstado()== false){
               System.out.println("Desactivada"); 
            }else{
                System.out.println("Activada"); 
            }
        }
    }

    public static void borrarSistema() {
        sistema.clear();
        System.out.println("Se han eliminado todas las alarmas del sistema");
    }

    public static void apagarAlarma() {
        for (Alarma alarma : sistema) {
            if (alarma.isEstado() == true) {
                alarma.setEstado(false);
            }
        }
        System.out.println("Se han apagado la alarma");
    }

    public static void comprobarAnomalia() {
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

    public static int calcularValorMedio() {

        int sumaValor = 0;
        int mediaSistema = 0;
        for (Alarma alarma : sistema) {
            sumaValor = alarma.getValorReal();
        }
        mediaSistema = sumaValor / sistema.size();
        return mediaSistema;
    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }

    public static int generaRandom() {
        double random = (Math.random() * 50) + 1;
        int aleatorio = (int) random;
        return aleatorio;
    }
}