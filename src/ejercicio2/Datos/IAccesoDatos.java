package ejercicio2.Datos;

public interface IAccesoDatos{
    
    public void crearAlarma(String tipoAlarma, int valorReal, int valorUmbral);
    public void guardarAlarma();
    public void listarAlarmas();
    public void borrarAlarma(int numeroAlarma);
    public void mostrarEstados();
    public void borrarSistema();
    public void apagarAlarma();
    public void comprobarAnomalia();
    public int calcularValorMedio();
    public int generaRandom();   
}