package clases;

import clases.empleado.*;

public class CitaMedica {

    // Se crean los atributos que tendra esta clase
    private Paciente paciente;
    private Medico medico;
    private String servicio;
    private String fechaConsulta;
    private String horaConsulta;
    private String lugar;

    // Se crea el constructor "EXPLICITO"
    public CitaMedica(Paciente paciente, Medico medico, String servicio, String fechaConsulta, String horaConsulta, String lugar){

        this.paciente = paciente;
        this.medico = medico;
        this.servicio = servicio;
        this.fechaConsulta = fechaConsulta;
        this.horaConsulta = horaConsulta;
        this.lugar = lugar;

    }
    
    // Se crea el metodo para dar la informacion de la cita medica
    // Como un toString()
    public String informacionCitaMedica(){
        // 
        String datosCitas = "<< INFORMACIÓN CITA MEDICA >>\n";
        // Se optiene el nombre del paciente
        datosCitas+= "Paciente: "+paciente.getNombre()+"\n";
        datosCitas+= "Medico: "+medico.getNombre()+"\n";
        datosCitas+= "Motivo consulta: "+this.servicio+"\n";
        datosCitas+= "Fecha Consulta: "+this.fechaConsulta+" - Hora: "+this.horaConsulta+"\n";
        datosCitas+= "Lugar: "+this.lugar+"\n";

        // Se retorna los datos
        return datosCitas;
    }

    // Se crean los metodos de acceso
    // Encapsulacion
    public Paciente getPaciente(){
        return this.paciente;
    }

    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }
    // 
    public Medico getMedico(){
        return this.medico;
    }

    public void setMedico(Medico medico){
        this.medico = medico;
    }
    // 
    public String getServicio(){
        return this.servicio;
    }

    public void setServicio(String servicio){
        this.servicio = servicio;
    }
    // 
    public String getFechaConsulta(){
        return this.fechaConsulta;
    }

    public void setFechaConsulta(String fechaConsulta){
        this.fechaConsulta = fechaConsulta;
    }
    // 
    public String getHoraConsulta(){
        return this.horaConsulta;
    }

    public void setHoraConsulta(String horaConsulta){
        this.horaConsulta = horaConsulta;
    }
    // 
    public String getLugar(){
        return this.lugar;
    }

    public void setLugar(String lugar){
        this.lugar = lugar;
    }
    
}
