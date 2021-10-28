package clases;

import javax.swing.JOptionPane;
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
    public ModeloDatos() {
        // Se crean los HasMap<>
        pacientesMap = new HashMap<String, Paciente>();
        empleadosPlantillaMap = new HashMap<String, EmpleadoPlantilla>();
        medicosMap = new HashMap<String, Medico>();
        empleadosEventualesMap = new HashMap<String, EmpleadoEventual>();
        citasList = new ArrayList<>();
    }

    // ###################################################################
    // METODOS PARA VERIFICAR SI LOS PACIENTES EXISTEN POR MEDIO DEL 'DOCUMENTO'
    public boolean existePaciente(String documento) {
        return pacientesMap.containsKey(documento);
    }

    public boolean existeEmpleadoEventula(String documento){
        return empleadosEventualesMap.containsKey(documento);
    }
    
    public boolean existeEmpeladoPlantilla(String documento) {
        return empleadosPlantillaMap.containsKey(documento);
    }
    
    public boolean existeMedico(String documento) {
        return medicosMap.containsKey(documento);
    }

    // ###################################################################
    // CONSULTAR PACIENTES MENDIANTE EL DOCUMENTO

    public void cosultarPacienteIndividula(String documento) {

        String mensaje = "EMPLEADO POR PLANILLA REGISTRADO\n";

        // Se valida
        if (empleadosPlantillaMap.containsKey(documento)) {

            empleadosPlantillaMap.get(documento).imprimirDatosPersona(mensaje);

            // Se pasa por cada elemento
            // for (String clave : empleadosPlantillaMap.keySet()) {

            // empleadosPlantillaMap.get(clave).imprimirDatosPersona();
            // }
        } else {
            System.out.println("El Paceinte no se encuentra registrado\ncon el Documento: " + documento);
            // String mensaje = "El Paceinte no se encuentra registrado\ncon el Documento:
            // "+documento;
            // JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    // ###################################################################
    // REGISTRAR USUARIOS
    public void registrarPersona(Paciente miPaciente) {
        pacientesMap.put(miPaciente.getDocumento(), miPaciente);
        System.out.println("\n_/ Se ha registrado el paciente '" + miPaciente.getNombre() + "' Satisfactoriamente");

    }

    public void registrarPersona(EmpleadoPlantilla miEmpPlantilla) {
        empleadosPlantillaMap.put(miEmpPlantilla.getDocumento(), miEmpPlantilla);
        System.out.println("\n_/ Se ha registrado el empleado por plantilla '" + miEmpPlantilla.getNombre()
                + "' Satisfactoriamente");
    }

    public void registrarPersona(EmpleadoEventual miEmpEventual) {
        empleadosEventualesMap.put(miEmpEventual.getDocumento(), miEmpEventual);
        System.out.println(
                "\n_/ Se ha registrado el empleado eventual '" + miEmpEventual.getNombre() + "' Satisfactoriamente");
    }

    public void registrarPersona(Medico miMedico) {
        medicosMap.put(miMedico.getDocumento(), miMedico);
        System.out.println("\n_/ Se ha registrado el medico '" + miMedico.getNombre() + "' Satisfactoriamente");
    }

    // Registrar citas medicas
    // Como parametros nos ingresa Un dato de tipo Citamedica (Objeto)
    public void registrarCitasMedicas(CitaMedica miCita) {
        // Lo agregamos al ArrayList<>
        citasList.add(miCita);
        // Mensajes que retorna
        System.out.println("Se ha registrado la cita exitosamente!");
        // Imprimimos la informacion de la cita ( La obtenemos )
        System.out.println(miCita.informacionCitaMedica());
    }

    // ############################################
    // IMPRIMIR DATOS

    // Funciones para imprimir informacion de los "pacientes"
    public void imprimirPacientes() {

        // Se crea un objeto de tipo StringBuffer
        StringBuffer menuPacientesListar = new StringBuffer();
        menuPacientesListar.append("LISTAR PACIENTES\n");
        menuPacientesListar.append("1) Pacientes registrados\n");
        menuPacientesListar.append("2) Paciente en específico\n");
        menuPacientesListar.append("Seleccione una opción\n");

        // Guardamos la opcion elegida por el usuario
        int opcionElegida = Integer.parseInt(JOptionPane.showInputDialog(null, menuPacientesListar));

        // Se hace un switch para asiganar la opcion
        switch (opcionElegida) {
        case 1:
            // Asignamos el mensjae a mostrar
            String mensajePacientes = "PACIENTES REGISTRADOS\n";

            System.out.println(mensajePacientes + "\n");

            // Se iterara en para el Map
            Iterator<String> iterador = pacientesMap.keySet().iterator();
            // Si la longitud del Map es mayor a 0
            // Es porque hay pacientes registrados
            if (pacientesMap.size() > 0) {
                // Mientras e cumpla continuara
                while (iterador.hasNext()) {
                    //
                    String clave = iterador.next();
                    // Obtenemos la clave (llave) y de esta imprimimos los datos
                    pacientesMap.get(clave).imprimirDatosPersona(mensajePacientes);
                }
            } else {
                System.out.println(" **** No se encontraron datos de 'pacientes' ****");
            }
            break;

        case 2:
            // Verificamos si hay datos en el Map
            if (pacientesMap.size() > 0) {

                // Asignamos el mensjae a mostrar
                String mensajePaciente = "PACIENTES REGISTRADOS\n";
                System.out.println(mensajePaciente + "\n");
                // Se piede el documento a buscar
                String documento = JOptionPane.showInputDialog("Ingrese el Documento del paciente a consultar");
                // Verificamos si el documento a solicitar existe
                if (pacientesMap.containsKey(documento)) {

                    System.out.println("Paciente con el documento : " + documento);

                    System.out.println("Paciente: \n" + pacientesMap.containsKey(documento));
                } else {
                    // Por el contrario
                    System.out.println("*** El paciente que busca no se encuentra Registrado ***");
                }
                // Si no hay datos guardados
            } else {
                System.out.println("*** No hay datos de pacientes Registrados ***");
            }
            break;

        default:
            break;
        }
    }

    // Imprimir a los empĺeados eventuales
    public void imprimirEmpleadosEventuales() {

        // Se crea un objeto de tipo StringBuffer
        StringBuffer menuEmpleEventualesListar = new StringBuffer();
        menuEmpleEventualesListar.append("LISTAR EMPLEADOS EVENTUALES\n");
        menuEmpleEventualesListar.append("1) TODOS Empleados Eventulaes\n");
        menuEmpleEventualesListar.append("2) ESPECIFICO Empleado Eventual\n");
        menuEmpleEventualesListar.append("Seleccione una opcion\n");

        // Se guarda la desicion del usuario
        int opcionUsu = Integer.parseInt(JOptionPane.showInputDialog(menuEmpleEventualesListar));
        switch (opcionUsu) {
            // 
        case 1:
                // asignamos el mensaje a mostrar
            String mensajeEmpleadosE = "EMPLEADOS EVENTUALES REGISTRADOS\n";

            System.out.println(mensajeEmpleadosE + "");

            // Se valida si en el Map hay datos
            if (empleadosEventualesMap.size() > 0) {
                // Se iterara con un FOREACH
                // pasamos por cada dato y obtenemos la clave con keySet()
                for (String clave : empleadosEventualesMap.keySet()) {
                    // Obtenemos la clave del HasMap e imprimimos los datos
                    empleadosEventualesMap.get(clave).imprimirDatosPersona(mensajeEmpleadosE);
                }
            } else {
                System.out.println(" **** No se encontraron datos de 'Empleados Eventuales' ****");
            }

            break;
        case 2:
            // Se valida si hay empleados registrados
            if(empleadosEventualesMap.size() > 0){
                String mensajeEmpleadoE = "EMPLEADO EVENTUAL\n"; 
                System.out.println(mensajeEmpleadoE);
                // Se pide el documento para buscar
                String documento = JOptionPane.showInputDialog("Ingrese el Documento");
                // Se valida si el documento esta registrado
                if(empleadosEventualesMap.containsKey(documento)){
                    System.out.println("Empleado eventual Documento : "+documento);

                    System.out.println("Empleado Eventual:\n"+empleadosEventualesMap.containsKey(documento));
                
                }else{ // Por lo contrario
                    System.out.println("--- El empleado no esta registrado ---");
                }
                // Si no hay registros
            }else{
                System.out.println("*** NO se encuentran Registro de 'Empleados Eventuales' ***");
            }
            break;

        default:
            break;
        }
    }

    // Imprimir los Empleados por planilla
    public void imprimimosEmpleadosPlantilla() {

        // Se crea un objeto de tipo StringBuffer
        StringBuffer menuEmplePlantListar = new StringBuffer();
        menuEmplePlantListar.append("LISTAR EMPLEADOS PLANILLA\n");
        menuEmplePlantListar.append("1) TODOS Empleados Planilla\n");
        menuEmplePlantListar.append("2) ESPECIFICO Empleado planilla\n");
        menuEmplePlantListar.append("Seleccione una opcion");

        // Se guarda la desicion del usuario
        int opcionUsu = Integer.parseInt(JOptionPane.showInputDialog(menuEmplePlantListar));

        switch (opcionUsu) {
            case 1:

                // Se crea el mensaje a mostrar
                String mensaje = "EMPLEADOS POR PLANILLA REGISTRADOS\n";

                System.out.println(mensaje + "\n");

                // Se valida si en el Map hay datos
                if (empleadosPlantillaMap.size() > 0) {
                    // Obtenemos el valor del dato, del Map
                    for (EmpleadoPlantilla empleadoPlantilla : empleadosPlantillaMap.values()) {
                        // imprimimos los datos
                        empleadoPlantilla.imprimirDatosPersona(mensaje);
                    }

                    System.out.println("- MEDICOS REGISTRADOS EMPLEADOS POR PLANILLA -\n");
                    // Tambien se imprime los medicos
                    // Validamos si el Map tiene datos
                    if (medicosMap.size() > 0) {
                        // Se itera por cada elemento (Medico)
                        for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {

                            // Obtenemos el elemento y lo imprimimos con sus datos
                            elemento.getValue().imprimirDatosPersona(mensaje);
                        }

                    } else {
                        System.out.println("**** NO se encontraron 'Medicos' registrados ****");
                    }
                } else {
                    System.out.println("**** NO se encontraron datos de 'Empleados Plantilla' ****");
                }
                
                break;
            case 2:
                // Se verifica si hay empleados registrados
                if (empleadosPlantillaMap.size() > 0) {
                    // MEnsaje
                    String mensajeEmpleP = "EMPLEADO PLANTILLA";
                    System.out.println(mensajeEmpleP);
                    // Pedimos le documento al usuario
                    String documento = JOptionPane.showInputDialog("Ingrese el Documento");

                    if (empleadosPlantillaMap.containsKey(documento)) {
                        System.out.println("Empleado Planilla Documento : "+documento);

                        // Se imprimelos datos del empleado planilla 
                        
                    }else{
                        System.out.println("--- El empleado no esta registrado ---");
                    }
                }else{
                    System.out.println("*** NO hay Empleados Plantilla Registrados ***");
                }
                break;
        
            default:
                break;
        }
    }

    //
    public void imprimirMedicos() {

        // Se crea un objeto de tipo StringBuffer
        StringBuffer menuMedicoListar = new StringBuffer();
        menuMedicoListar.append("LISTAR EMPLEADOS EVENTUALES\n");
        menuMedicoListar.append("1) TODOS Empleados Eventulaes\n");
        menuMedicoListar.append("2) ESPECIFICO Empleado Eventual\n");
        menuMedicoListar.append("Seleccione una opcion\n");

        // Se guarda la desicion del usuario
        int opcionUsu = Integer.parseInt(JOptionPane.showInputDialog(menuMedicoListar));

        switch (opcionUsu) {
            case 1:
                // Mensaje
                String mensajeMedicos = "MEDICOS REGISTRADOS\n";

                System.out.println(mensajeMedicos + "");
                // Validamos si hay registros de medicos
                if (medicosMap.size() > 0) {
                    // Se crea un FOREACH para poder padar por cada elemento
                    // TODO: PREGUNTAR QUE ES Map.Entry<K,V>

                    for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {

                        // Obtenemos el elemento y lo imprimimos con sus datos
                        elemento.getValue().imprimirDatosPersona(mensajeMedicos);
                    }
                } else {
                    System.out.println(" **** NO se encontraron datos de 'Medicos' ****");
                }
                break;

            case 2://Medico individual

                // Validamos si hay registros de medicos
                if (medicosMap.size() > 0) {
                    // Mensaje
                    String mensajeMedico = "MEDICO REGISTRADOS\n";
                    System.out.println(mensajeMedico + "");
                    // Se pide el documento al usuario que quiere consultar
                    String documento = JOptionPane.showInputDialog("Ingrese el Documento");
                    if (medicosMap.containsKey(documento)) {
                        System.out.println("Medico Documento : "+documento);

                        // se imprime los datos del medico
                    }else{
                        System.out.println("--- El MEDICO no esta registrado ---");
                    }
                    
                }else{
                    System.out.println(" **** NO se encontraron datos de 'Medicos' ****");
                }

                break;
            default:
                break;
        }
    }

    public void imprimirCitasMedicasProgramadas() {
        // Mensaje
        String mensaje = "CITAS MEDICAS PROGRAMADAS";
        // Se instancia la clase
        CitaMedica miCita = null;

        System.out.println(mensaje + "\n");

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
        } else {
            // POr lo contrario
            System.out.println("**** NO exiten citas programadas ****");
        }

    }

    // Se crea un metodo en la cual consulta el paciente por el documento
    // Llega como paametro el documento del paciente a consultar
    public Paciente consultarPacientePorDocumento(String documentoPaciente) {
        // Se instancia la clase Paciente()
        Paciente miPaciente = null;

        // Se verifica si el documento a consultar exita o esta en pacientesMap
        if (pacientesMap.containsKey(documentoPaciente)) {
            miPaciente = pacientesMap.get(documentoPaciente);
        }
        // Si el paciente existe lo retorno
        // Si no retornara un "null"
        return miPaciente;
    }

    // Se crea un metodo para la consulta del medico
    //
    public Medico consultarMedicoPorNombre(String nombreMedico) {

        // Se pasa pior cada elemento (medico) verificando que coinsida
        for (Medico medico : medicosMap.values()) {
            // Validamos
            if (medico.getNombre().equalsIgnoreCase(nombreMedico)) {
                // El medico es Found entonces lo retornamos
                return medico;
            }
        }
        // En caso en el que no encontremos el medico retornaremos 'null'
        return null;
    }
}