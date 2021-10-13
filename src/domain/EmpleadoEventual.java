package domain;

public class EmpleadoEventual extends Empleado{
    
    private double honorariosPorHora;
    private String fechaTerminoContrato;

    // Se cran los metodos de acceso
    public double getHonorariosPorHora() {
        return this.honorariosPorHora;
    }

    public void setHonorariosPorHora(double honorariosPorHora){
        this.honorariosPorHora = honorariosPorHora;
    }

    public String getFechaTerminoContrato() {
        return this.fechaTerminoContrato;
    }

    public void setFechaTerminoContrato(String fechaTerminoContrato){
        this.fechaTerminoContrato = fechaTerminoContrato;
    }
}
