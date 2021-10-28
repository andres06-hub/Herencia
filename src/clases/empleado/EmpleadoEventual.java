package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoEventual extends Empleado{
    
    private double honorariosPorHora;
    private String fechaTerminoContrato;

    // Se hereda un metodo y se sobreescribe 
    // para poder tener su propia implementación 
    @Override
    public void registrarDatos(){

        // Heredamos de la clse superior
        super.registrarDatos();
        boolean validacion = true;
        // se repite mientras el dato sea incorrecto
        do {          
            try {
                // Se trata de pedir el dato de tipo double
                this.honorariosPorHora = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario Mensual"));
                validacion = false;
            } catch (Exception e) {
                System.out.println("XXX Error: Dato no valido\nIngrese un dato de tipo number XXX");
                validacion = true;
            }
        } while (validacion);

        this.fechaTerminoContrato = JOptionPane.showInputDialog("Ingresa la fecha de nacimiento ( DD/MM/AA )");

    }

    // Se hereda el metodo y se sobreEscribe para poder implementar
    // Su comportamiento
    @Override
    public void imprimirDatosPersona(String datos){

        // Se implementa tambien el padre
        super.imprimirDatosPersona(datos);

        datos = "Honorarios por Hora "+this.honorariosPorHora+"\n";
        datos+= "Fecha Termino de contrato: "+this.fechaTerminoContrato+"\n";
        // Imprimimos la informacion

    }


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
