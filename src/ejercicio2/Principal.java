package ejercicio2;

import ejercicio2.negocio.ISistema;
import ejercicio2.negocio.SistemaImpl;
import java.util.*;

public class Principal {

    public static void main(String args[]) {
        Scanner entrada = new Scanner(System.in);
        ISistema sistema = new SistemaImpl();
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
                        valorReal = sistema.generaRandom();
                        sistema.crearAlarma(tipoAlarma, valorReal, valorUmbral);
                        break;
                    case 2:
                        System.out.println("Introduce un numero de alarma");
                        cadena = entrada.nextLine();
                        if (isNumeric(cadena) == true) {
                            indice = Integer.parseInt(cadena);
                            sistema.borrarAlarma(indice);
                        } else {
                            System.out.println("No es un numero");
                        }

                        break;
                    case 3:
                        sistema.borrarSistema();
                        break;
                    case 4:
                        sistema.listarAlarmas();
                        break;
                    case 5:
                        sistema.mostrarEstados();
                        break;
                    case 6:
                        sistema.comprobarAnomalia();
                        break;
                    case 7:
                        sistema.apagarAlarma();
                        break;
                }

            } else {
                System.out.println("No es un numero");
            }

        } while (opcion != 0);
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
}