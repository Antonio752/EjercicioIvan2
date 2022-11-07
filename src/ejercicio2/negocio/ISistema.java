package ejercicio2.negocio;

public interface ISistema {
    
    public void crearAlarma(String tipoAlarma, int valorReal, int valorUmbral);
    public void guardarAlarma();
    public void listarAlarmas();
    public void borrarAlarma(int numeroAlarma);
    public void mostrarEstados();
    public void borrarSistema();
    public void apagarAlarma();
    public void comprobarAnomalia(); 
    public int generaRandom();
}
