package domain;

// import java.util.ArrayList;

public class Paciente  extends Persona{

    private String numHistoriaClinica;
    private char genero;
    private String rh;
    /**1) ¿Este atributo se coloca en arralist?
     * 2) ¿Como se colocario en los metodos de acceso si es un arraylist?
     */
    // private ArrayList<String> listaMedicamentosAlergico;


    // Creamos los metodos de acceso
    public String getNumHistoriaClinica(){
        return this.numHistoriaClinica;
    } 

    public void setNumHistoriaClinica(String numHistoriaClinica){
        this.numHistoriaClinica = numHistoriaClinica;
    }

    public char getGenero(){
        return this.genero;
    }

    public void setGenero(char genero){
        this.genero = genero;
    }

    public String getRh(){
        return this.rh;
    }

    public void setRh(String rh){
        this.rh = rh;
    }

}