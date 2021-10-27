package clases;

import javax.swing.JOptionPane;

public class Persona {
    // Atributos que tendra la clase de tipo Persona
    private String documento;
    private String nombre;
    private String apellido;
    private String fechaNacimiento; 
    private String direccion;
    private String ciudadProcedencia;    


    public void imprimirDatosPersona(String datos){

        // StringBuffer es un objeto por lo tanto toca instanciarlo (Crearlo)
        StringBuffer sb = new StringBuffer();

        datos+= "Nombre: "+ this.nombre+"\n";
        datos+= "Apellidos: "+this.apellido+"\n";
        datos+= "Fecha de nacimiento: "+this.fechaNacimiento+"\n";
        datos+= "dirección: "+this.direccion+"\'n";
        datos+= "Ciudad de procedencia: "+this.ciudadProcedencia+"\n";
        
        // Se imprime los datos
        System.out.println(datos);
    }

    // Registrar los datos 
    public void registrarDatos(){
        this.documento = JOptionPane.showInputDialog(null, "Ingrese el numero de 'documento'");
        this.nombre = JOptionPane.showInputDialog(null, "Ingrese el 'nombre'");    
        this.apellido = JOptionPane.showInputDialog(null, "Ingrese el 'apellido'");
        this.fechaNacimiento = JOptionPane.showInputDialog(null, "Ingrese la fecha de nacimiento (DD/MM/AA)");
        this.direccion = JOptionPane.showInputDialog(null, "Ingrese la dirección");
        this.ciudadProcedencia = JOptionPane.showInputDialog(null, "Ingrese la ciudad de procedencia");
    }


    // Se crean los metodos de acceso
    public String getDocumento(){
        return this.documento;
    }

    public void setDocumento(String documento){
        this.documento = documento;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getFechaNacimiento(){
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion(){
        return this.direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getCiudadProcedencia(){
        return this.ciudadProcedencia;
    }

    public void setCiudadProcedencia(String ciudadProcedencia) {
        this.ciudadProcedencia = ciudadProcedencia;
    }
    
}

