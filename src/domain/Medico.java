package domain;

public class Medico extends EmpleadoPlantilla{
    
    private String especialidad;
    private String numConsultorio;



    // Creamos los metodos de acceso

    public String getEspecialidad(){
        return this.especialidad;
    }

    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }

    public String getNumConsultorio(){
        return this.numConsultorio;
    }

    public void setNumConsultorio(String numConsultorio){
        this.numConsultorio = numConsultorio;
    }


}
