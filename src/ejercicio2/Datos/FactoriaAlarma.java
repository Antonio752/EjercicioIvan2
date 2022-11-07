package ejercicio2;

public class FactoriaAlarma {
  
    private static Alarma alarma;
    public static Alarma crearAlarma(String tipoAlarma, int valorUmbral, int valorReal) {
        alarma = new Alarma(tipoAlarma, valorReal, valorUmbral);
        return alarma;
    }
}
