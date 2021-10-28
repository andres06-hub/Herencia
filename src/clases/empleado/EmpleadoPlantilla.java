package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoPlantilla extends Empleado{

    private double salarioMensual;
    private double porcentajeAdiPorHoraExtra;

    // Se hereda el metodo del padre con su comportamiento y se le implementa su funcionalidad
    @Override
    public void registrarDatos(){

        // Heredar el metodo su implementacion y sobre escribirlo dandole 
        // Su propia implementacion
        super.registrarDatos();
        boolean validacion = true;
        do {
            // 
            try {
                // Se pide el salario mensual de tipo Double
                this.salarioMensual = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario mensula"));
                validacion = false;
            } catch (NumberFormatException e) {
                System.out.println("XXX Error: Dato Invalido\nTipo de dato 'NO' numerico XXX");
                validacion = true;
            }
        } while (validacion);
// -----------------------------------------------------------------------------------------------------------------
        // Se pide el siguiente dato 
        do {
            try {
                // Tramos de gacer esto : pedir el dato
                this.porcentajeAdiPorHoraExtra = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Porcentaje (%) por Hora Extra"));
                validacion = false;
            } catch (NumberFormatException e) {
                System.out.println("XXX Error: Dato Invalido\nTipo de dato 'NO' numerico XXX");
                validacion = true;
            }
        } while (validacion);
    }

    // 

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
