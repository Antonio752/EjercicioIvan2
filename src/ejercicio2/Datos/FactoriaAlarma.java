package ejercicio2.Datos;

import ejercicio2.dominio.Alarma;

public class FactoriaAlarma {
  
    private static Alarma alarma;
    public static Alarma crearAlarma(String tipoAlarma, int valorUmbral, int valorReal) {
        alarma = new Alarma(tipoAlarma, valorReal, valorUmbral);
        return alarma;
    }
}
