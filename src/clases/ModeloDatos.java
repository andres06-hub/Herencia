package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlantilla;
import clases.empleado.Medico;

public class ModeloDatos {

    // Se crea Map para llevar un manejo de datos y poder guardarlos 
    HashMap<String, Paciente> pacientesMap;
    HashMap<String, EmpleadoPlantilla> empleadosPlantillaMap;
    HashMap<String, EmpleadoEventual> empleadosEventualesMap;
    HashMap<String, Medico> medicosMap;
    // Para almacenar las citas medicas
    ArrayList<CitaMedica> citasList;


    // Se crea un contructor explicito sin parametros
    public ModeloDatos(){
        // Se crean los HasMap<>
        pacientesMap = new HashMap<String, Paciente>();
        empleadosPlantillaMap = new HashMap<String, EmpleadoPlantilla>();
        medicosMap = new HashMap<String, Medico>();
        empleadosEventualesMap = new HashMap<String, EmpleadoEventual>();
        citasList = new ArrayList<>();
    }

    public void registrarPersona(Paciente miPaciente){
        pacientesMap.put(miPaciente.getDocumento(), miPaciente);
        System.out.println("Se ha registrado el paciente "+miPaciente.getNombre()+" Satisfactoriamente");

    }

    public void registrarPersona(EmpleadoPlantilla miEmpPlantilla){
        empleadosPlantillaMap.put(miEmpPlantilla.getDocumento(), miEmpPlantilla);
        System.out.println("Se ha registrado el empleado por plantilla "+miEmpPlantilla.getNombre()+" Satisfactoriamente");
    }

    public void registrarPersona(EmpleadoEventual miEmpEventual){
        empleadosEventualesMap.put(miEmpEventual.getDocumento(), miEmpEventual);
        System.out.println("Se ha registrado el empleado eventual "+miEmpEventual.getNombre()+" Satisfactoriamente");
    }

    public void registrarPersona(Medico miMedico){
        medicosMap.put(miMedico.getDocumento(), miMedico);
        System.out.println("Se ha regisytrado el medico "+miMedico.getNombre()+" Satisfactoriamente");
    }

    // Registrar citas medicas 
    // Como parametros nos ingresa Un dato de tipo Citamedica (Objeto)
    public void registrarCitasMedicas(CitaMedica miCita){
        // Lo agregamos al ArrayList<>
        citasList.add(miCita);
        // Mensajes que retorna
        System.out.println("Se ha registrado la cita exitosamente!");
        // Imprimimos la informacion de la cita ( La obtenemos )
        System.out.println(miCita.informacionCitaMedica());
    }


    // Funciones para imprimir informacion de los "pacientes"
    public void imprimirPacientes(){
        // Asignamos el mensjae a mostrar
        String mensaje = "PACIENTES REGISTROSDOS\n";
        // Se iterara en para el Map 
        Iterator<String> iterador =pacientesMap.keySet().iterator();
        // Mientras e cumpla continuara 
        while (iterador.hasNext()) {
            // 
            String clave = iterador.next();
            // Obtenemos la clave (llave) y de esta imprimimos los datos 
            pacientesMap.get(clave).imprimirDatosPersona(mensaje);
        }
    }
    // Imprimir a los empĺeados eventuales
    public void imprimirEmpleadosEventuales(){
        // asignamos el mensaje a mostrar
        String mensaje = "EMPLEADOS EVENTUALES REGISTRADOS\n";
        // Se iterara con un FOREACH
        // pasamos por cada dato y obtenemos la clave con keySet()
        for (String clave : empleadosEventualesMap.keySet()) {
            // Obtenemos la clave del HasMap e imprimimos los datos
            empleadosEventualesMap.get(clave).imprimirDatosPersona(mensaje);
        }
    }

    // Imprimir los Empleados por planilla
    public void imprimimosEmpleadosPlantilla(){
        // Se crea el mensaje a mostrar 
        String mensaje = "EMPLEADOS POR PLANILLA REGISTRADOS\n";

        // Obtenemos el valor del dato, del Map
        for (EmpleadoPlantilla empleadoPlantilla : empleadosPlantillaMap.values()) {
            // imprimimos los datos 
            empleadoPlantilla.imprimirDatosPersona(mensaje);
        }
    }

    // 
    public void imprimirMedicos(){
        // MEnsaje
        String mensaje = "MEDICOS REGISTRADOS\n";

        // Se crea un FOREACH para poder padar por cada elemento
        // TODO: PREGUNTAR QUE ES Map.Entry<K,V>

        for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {


            // Obtenemos el elemento y lo imprimimos con sus datos
            elemento.getValue().imprimirDatosPersona(mensaje);
        }
    }

    public void imprimirCitasMedicasProgramadas(){
        // Mensaje
        String mensaje = "CITAS MEDICAS PROGRAMADAS";
        // Se instancia la clase
        CitaMedica miCita = null;

        System.out.println(mensaje+"\n");

        // Validar
        if (citasList.size() > 0) {
            // Hay citas medicas
            // Pasamos por cada una obteniendola
            for (int i = 0; i < citasList.size(); i++) {
                // Obtenemos cada cita
                miCita = citasList.get(i);
                // Se imprime la cita con su informacion
                System.out.println(miCita.informacionCitaMedica());
            }
        }else{
            // POr lo contrario
            System.out.println("NO exiten citas programadas");
        }

    }

    // Se crea un metodo en la cual consulta el paciente por el documento
    // Llega como paametro el documento del paciente a consultar
    public Paciente consultarPacientePorDocumento(String documentoPaciente){
        // Se instancia la clase Paciente()
        Paciente miPaciente = null;

        // Se verifica si el documento a consultar exita o esta en pacientesMap
        if(pacientesMap.containsKey(documentoPaciente)){
            miPaciente = pacientesMap.get(documentoPaciente);
        }
        // Si el paciente existe lo retorno
        // Si no retornara un "null"
        return miPaciente;
    }

    // Se crea un metodo para la consulta del medico
    // 
    public Medico consultarMedicoPorNombre(String nombreMedico){

        // Se pasa pior cada elemento (medico) verificando que coinsida
        for (Medico medico : medicosMap.values()) {
            // Validamos
            if(medico.getNombre().equalsIgnoreCase(nombreMedico)){
                // El medico es Found entonces lo retornamos
                return medico;
            }
        }
        // En caso en el que no encontremos el medico retornaremos 'null'
        return null;
    }

}
