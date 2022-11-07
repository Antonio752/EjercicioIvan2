package ejercicio2.negocio;

import ejercicio2.Datos.AccesoDatosImpl;
import ejercicio2.Datos.IAccesoDatos;

public class SistemaImpl implements ISistema {

    private final IAccesoDatos datos;

    public SistemaImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void crearAlarma(String tipoAlarma, int valorReal, int valorUmbral) {
        datos.crearAlarma(tipoAlarma, valorReal, valorUmbral);
    }

    @Override
    public void guardarAlarma() {
        datos.guardarAlarma();
    }

    @Override
    public void listarAlarmas() {
        datos.listarAlarmas();
    }

    @Override
    public void borrarAlarma(int numeroAlarma) {
        datos.borrarAlarma(numeroAlarma);
    }

    @Override
    public void mostrarEstados() {
        datos.mostrarEstados();
    }

    @Override
    public void borrarSistema() {
        datos.borrarSistema();
    }

    @Override
    public void apagarAlarma() {
        datos.apagarAlarma();
    }

    @Override
    public void comprobarAnomalia() {
        datos.comprobarAnomalia();
    }

    @Override
    public int generaRandom() {
        return datos.generaRandom();
    }
}
