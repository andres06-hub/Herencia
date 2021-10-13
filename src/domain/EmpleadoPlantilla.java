package domain;

public class EmpleadoPlantilla extends Empleado{

    private double salarioMensual;
    private double porcentajeAdiHoraExtra;


    // Creamos los metodos de acceso
    public double getSalarioMensual() {
        return this.salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual){
        this.salarioMensual = salarioMensual;
    }

    public double getProcentajeAdiHoraExtra() {
        return this.porcentajeAdiHoraExtra;
    }

    public void setProcentajeAdiHoraExtra(double porcentajeAdiHoraExtra){
        this.porcentajeAdiHoraExtra = porcentajeAdiHoraExtra;
    }
    
}
