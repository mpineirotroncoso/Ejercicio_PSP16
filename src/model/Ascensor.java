package model;

public class Ascensor {
    int pisoActual = 0;
    int plantas = 20;
    boolean enMovimiento = false;

    public Ascensor(int pisoActual, int plantas) {
        this.pisoActual = pisoActual;
        this.plantas = plantas;
    }

    public void subir() {
        pisoActual++;
    }

    public void bajar() {
        pisoActual--;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    public int getPlantas() {
        return plantas;
    }

    public void setPlantas(int plantas) {
        this.plantas = plantas;
    }

    public boolean isEnMovimiento() {
        return enMovimiento;
    }

    public void setEnMovimiento(boolean enMovimiento) {
        this.enMovimiento = enMovimiento;
    }
}
