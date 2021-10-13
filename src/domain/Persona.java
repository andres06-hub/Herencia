package domain;

public class Persona {
    // Atributos que tendra la clase de tipo Persona
    private String documento;
    private String nombre;
    private String apellido;
    private String fechaNacimiento; 
    private String direccion;
    private String ciudadProcedencia;    


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

