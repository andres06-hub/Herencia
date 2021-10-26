package domain;

public class Empleado extends Persona{
    
    private String codigoEmpleado;
    private double numHorasExtras;
    private String fechaIngreso;
    private String areaCargo;

    // 1)
    public String getCodigoEmpleado(){return this.codigoEmpleado;}

    public void setCodigoEmpleado(String codigoEmpleqado){this.codigoEmpleado = codigoEmpleqado;}

    // 2)
    public double getNumHorasExtra(){return this.numHorasExtras;}
    
    public void setNumHorasExtras(double numHorasExtras){this.numHorasExtras = numHorasExtras;}
 
    // 3)
    public String getFechaIngreso(){return this.fechaIngreso;}

    public void setFechaIngreso(String fechaIngreso){this.fechaIngreso = fechaIngreso;}

    // 4)
    public String getAreaCargo(){return this.areaCargo;}

    public void setAreaCargo(String areaCargo){this.areaCargo = areaCargo;}
}
