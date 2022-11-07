package ejercicio2;

import java.util.Objects;

public class Alarma {
    
    private String tipoAlarma;
    private int valorReal;
    private int valorUmbral;
    private boolean estado = false;
       
    public Alarma() {
    }

    public Alarma(String tipoAlarma, int valorReal, int valorUmbral) {
        this.tipoAlarma = tipoAlarma;
        this.valorReal = valorReal;
        this.valorUmbral = valorUmbral;
    }

    public String getTipoAlarma() {
        return tipoAlarma;
    }

    public void setTipoAlarma(String tipoAlarma) {
        this.tipoAlarma = tipoAlarma;
    }

    public int getValorReal() {
        return valorReal;
    }

    public void setValorReal(int valorReal) {
        this.valorReal = valorReal;
    }

    public int getValorUmbral() {
        return valorUmbral;
    }

    public void setValorUmbral(int valorUmbral) {
        this.valorUmbral = valorUmbral;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Alarma{" + "tipoAlarma=" + tipoAlarma + ", valorReal=" + valorReal + ", valorUmbral=" + valorUmbral + ", estado=" + estado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.tipoAlarma);
        hash = 97 * hash + this.valorReal;
        hash = 97 * hash + this.valorUmbral;
        hash = 97 * hash + (this.estado ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alarma other = (Alarma) obj;
        if (this.valorReal != other.valorReal) {
            return false;
        }
        if (this.valorUmbral != other.valorUmbral) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        return Objects.equals(this.tipoAlarma, other.tipoAlarma);
    }  
}