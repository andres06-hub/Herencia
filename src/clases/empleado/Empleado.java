// Se crea una clase de empleado (new Objeto)
/**
 * LA PALABRA extends ;
 * 
 * extends = Esta palabra es para obtener los atributos
 *           de de la clase que le asigne, en este caso seria Persona()
 *           Esto es HEREDAR los atributos de la otra clase 
 * 
 * SOLO Y SOLO se puede HEREDAR de una clase
 */

package clases.empleado;

import javax.swing.JOptionPane;

import clases.*;

public class Empleado extends Persona{
    
    private String codigoEmpleado;
    private double numHorasExtras;
    private String fechaIngreso;
    private String area;
    private String cargo;

    // HEredamos un metodo y lo sobre escribimos 
    @Override
    public void  registrarDatos(){

        // Se llama la el metodo super para heredar su implementacion
        super.registrarDatos();

        this.codigoEmpleado = JOptionPane.showInputDialog("Ingrese el codigo del empleado");
        
        boolean validacion = true;
        // Hacemos un ciclo por si el dato no se cumple
        do {
            // Tratamos de hacer esto, si el dato no es el que se pide ira al catch
            try {
                validacion = false;
                this.numHorasExtras = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero de horas extras"));
            } catch (NumberFormatException e) {
                System.out.println("### Dato incorrecto, ingrese Datos de tipo numerico ###");
                validacion = true;
            }
        } while (validacion);
        
        this.fechaIngreso = JOptionPane.showInputDialog("Ingrese la fecha de ingreso ( DD/MM/AA )");
        this.area = JOptionPane.showInputDialog("Ingrese el area");
        this.cargo = JOptionPane.showInputDialog("Ingrese el cargo");

    }

    // Se hereda un metodo para sobre escribirlo 
    // E imprimir los datos de la perosona + los del empleado
    @Override
    public void imprimirDatosPersona(String datos){
        // Se implementa tambien lo del metodo del padre
        super.imprimirDatosPersona(datos);

        // Y se le da tambien su propia implementación
        datos = "Codigo de Empleado: "+this.codigoEmpleado+"\n";
        datos+= "Numero de Horas Extras: "+this.numHorasExtras+"\n";
        datos+= "Fecha de ingreso: "+this.fechaIngreso+"\n";
        datos+= "Area: "+this.area+"\n";
        datos+= "Cargo: "+this.cargo+"\n";

        // Imprimimos loas datos obtenidos
        System.out.println(datos);

    }


    // Metodos de acceso
    // Se crean los metodos de acceso
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
    public String getArea(){return this.area;}

    public void setArea(String area){this.area = area;}

    // 5)
    public String getCargo(){return this.cargo;}

    public void setCargo(String cargo){this.cargo = cargo;}
    
}
