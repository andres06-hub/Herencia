package clases.empleado;

public class EmpleadoPlantilla extends Empleado{

    private double salarioMensual;
    private double porcentajeAdiPorHoraExtra;

    // Se hereda el metodo del padre con su comportamiento y se le implementa su funcionalidad
    @Override
    public void imprimirDatosPersona(String datos){
        // Se hereda tambien la implementacion del padre
        super.imprimirDatosPersona(datos);

        // 
        datos = "Salario Mensual: "+this.salarioMensual+"\n";
        datos+= "Porcentaje adicional por hora EXTRA: "+this.porcentajeAdiPorHoraExtra+"\n";

        // Imprimimos los datos
        System.out.println(datos);
    }


// ###############################
// ENCAPSULACION
    // Creamos los metodos de acceso
    public double getSalarioMensual() {
        return this.salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual){
        this.salarioMensual = salarioMensual;
    }

    public double getProcentajeAdiPorHoraExtra() {
        return this.porcentajeAdiPorHoraExtra;
    }

    public void setProcentajeAdiHoraExtra(double porcentajeAdiPorHoraExtra){
        this.porcentajeAdiPorHoraExtra = porcentajeAdiPorHoraExtra;
    }
    
}
