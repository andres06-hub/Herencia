package clases;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Paciente  extends Persona{

    private int numHistoriaClinica;
    private char genero;
    private String rh;
    private ArrayList<String> listaMedicamentosAlergico;

    // Se hace una sobre escritura de metodo 
    @Override
    public void registrarDatos(){

        /**
         * Llamamos al metodo registrar datos de la superClase
         * para continuar llanando los datos del paciente junto con los heredados
         */


        // llenamos los datos especificos del paciente 
        super.registrarDatos();

        this.listaMedicamentosAlergico  = new ArrayList<>();
        this.numHistoriaClinica = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la historia clinica"));
        // Se asigna el metodo  charAt(indice)
        // Este lo que hace es obtenerme el caracter en la indice '0'
        // EJEMPLO: char x = 'hola'; --> obtiene 'h'
            // Siempre tiene que ser con comillas simples
        this.genero = JOptionPane.showInputDialog("Ingrese el sexo").charAt(0);
        this.rh = JOptionPane.showInputDialog("Ingrese su grupo sanguineo");

        // pregunta
        String pregunta = JOptionPane.showInputDialog("¿Es alegico a algun medicamneto? si o no");

        if (pregunta.equalsIgnoreCase("si")) {

            String medicamento = "";
            String continuar = "";
            // Se crea un ciclo para el ingreso de medicamentos en losq ue es alergico
            do {
                
                medicamento = JOptionPane.showInputDialog("Nombre del medicamento al que es alergico");
                listaMedicamentosAlergico.add(medicamento);

                continuar = JOptionPane.showInputDialog("Ingrese 'si', si desea continuar");

            } while (continuar.equalsIgnoreCase("si"));
        }
    
    }

    // Sobre escribimos el metodo imprimirDatosPersona()
    @Override
    public void imprimirDatosPersona(String datos){

        // Llamamos a la super clase o se a el padre para tambie 
        // Tenga la impletemtacion de ella
        super.imprimirDatosPersona(datos);

        // Se le añade su propia implementacion
        datos = "Numero Historia Clinica:  "+this.numHistoriaClinica+"\n";
        datos+= "Genero: "+this.genero+"\n";
        datos+= "Grupo sanguineo : "+this.rh+"\n";

        if (listaMedicamentosAlergico.size() > 0) {
            // Es por que la persona es alergico a medicamentos
            datos+="Lista de medicamentos a los que es Alergico\n";
            // Se pasa por cada elemento Guardado(medicamento) para poder imprimirlo
            for (String medicamento : listaMedicamentosAlergico) {
                // Se agrega el medicamneto obtenido
                datos+="\t"+medicamento+"\n";
            }
        }else{
            // Si la lista su longitud es menor a 0 es porque no es alergico a ningun medicamento
            datos+="El paciente, no es alergico a ningún medicamento";
        }
        System.out.println(datos);
    }



    // Creamos los metodos de acceso
    public int getNumHistoriaClinica(){
        return this.numHistoriaClinica;
    } 

    public void setNumHistoriaClinica(int numHistoriaClinica){
        this.numHistoriaClinica = numHistoriaClinica;
    }

    public char getGenero(){
        return this.genero;
    }

    public void setGenero(char genero){
        this.genero = genero;
    }

    public String getRh(){return this.rh;}

    public void setRh(String rh){this.rh = rh;}

    public ArrayList<String> getListaMedicamentosAlergico(){
        return this.listaMedicamentosAlergico;
    }    

    public void setListaMedicamentosAlergico(ArrayList<String> listaMedicamentosAlergico){
        this.listaMedicamentosAlergico = listaMedicamentosAlergico;
    }
}