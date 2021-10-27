package main;

import javax.swing.JOptionPane;

import clases.ModeloDatos;
import clases.Paciente;
import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlantilla;
import clases.empleado.Medico;
import clases.*;

public class Procesos {

    // Iniciamos el contructor para instanciar la clase
    ModeloDatos miModeloDatos;

    // Se crea un constructor explicito para poder definir el comportamiento del objeto
    public Procesos(){

        // Se crea el objeto de ModeloDatos
        miModeloDatos = new ModeloDatos();
        // Llamamos la función de precentarMenuOpciones() 
        presentarMenuOpciones();
    }

    private void presentarMenuOpciones(){

        // Se crea un menu para poder saber cuales seran las opciones 
        // Que tendra el usuario
        String menu = "MENU HOSPITAL\n";
        menu+="1. Registrar pacientes\n";
        menu+="2. Registrar Empleado\n";
        menu+="3. Registrar Cita Medica\n";
        menu+="4. Imprimir Información";
        menu+="5. SALIR\n\n";
        menu+="Ingrese una opción\n";

        int opcion = 0;

        do {
            // Se crea una variablae para almacenar el dato que ingresa el usuario y asi capturarlo
            // A la ves mostrar el 'menu' 
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            // Se hace un switch para validar cual opcion eligio
            // Y asi ir a su función  
            switch (opcion) {
                case 1:
                // Sera la opcion 1 en el menu
                    // Registramos el paciente
                    registrarPacientes();
                    break;
                case 2:
                // Sera la opcion 2 en el menu
                    // Registramos empleado
                    registrarEmpleado();
                    break;
                case 3:
                // Sera la opcion 3 en el menu
                    registrarCitaMedica();

                    break;
                case 4:
                // Sera la opcion 4 en el menu
                    imprimirInformacion();
                    break;
                case 5:
                // Sera la opcion 5 en el menu

                    break;
                default:
                    break;
            }

        // SI el numero es diferente de 5 se repitara el ciclo
        } while (opcion!=5);
    }

    /**
     * ####################################
     * 1) Registrar Pacientes
     * 
     */

    private void registrarPacientes(){
        // Se instancia la clase Paciente
        // Y creamos un objeto de tipo Paciente
        Paciente miPaciente = new Paciente();
        // Registramos el pasiente llamando el metodo registrar y asi llenar los datos
        miPaciente.registrarDatos();

        // Utilizamos el objeto creado de ModeloDatos, en la linea 17 se creo
        miModeloDatos.registrarPersona(miPaciente);

    }
    /**
     * ######################################
     * 2) Registrar Empleados
     * 
     */

    private void registrarEmpleado(){

        // Se crea un objeto de StringBuffer
        StringBuffer menuTipoEmpleado = new StringBuffer();
        menuTipoEmpleado.append("Registro Empleado\n");
        menuTipoEmpleado.append("1) Empleado Eventual\n");
        menuTipoEmpleado.append("2) Empleado por plantilla\n");
        menuTipoEmpleado.append("Seleccione el tipo de empleado a registrar\n");

        // Guardamos en variable el dato que nos da el usuario
        // La opcion elegida del menuTipoEmpleado
        int tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));

        switch (tipoEmpleado) {
            case 1://Registro de empleado Eventual 
                // Se Instancia la clase de tipo EmpleadoEvenetual 
                // Y se crea un objeto
                EmpleadoEventual miEmpleadoEventual = new EmpleadoEventual();
                // Registramos los datos para el objeto creado
                miEmpleadoEventual.registrarDatos();
                // Guardamos el objeto creado(miEmpleadoEventula)
                // En una estructura de datos
                miModeloDatos.registrarPersona(miEmpleadoEventual);
                break;
            case 2:
                //Preguntamos al usuario si es un tipo de empleadoPlamilla
                String datoObtenidoResp = JOptionPane.showInputDialog("Ingrese 'SI', si es un médico, de lo contrario es otro tipo de empleado");
                if (datoObtenidoResp.equalsIgnoreCase("si")) {
                    // Registro Medico
                    // Creamos el objeto de tipo Medico()
                    Medico miMedico = new Medico();
                    // Registramos los datos del medico
                    // llamando la funcion registrar datos
                    miMedico.registrarDatos();
                    // Guardamos esta informacion de registro en una estructura de datos (HashMap)
                    miModeloDatos.registrarPersona(miMedico);
                }else{
                    // Si la repsuesta es 'NO' registramos al ususario como EmpleadoPlantilla 
                    EmpleadoPlantilla miEmpPlantilla = new EmpleadoPlantilla();
                    // Registramos los datos del empleado plantilla
                    miEmpPlantilla.registrarDatos();
                    // Guardamos los datos en una estructura de datos
                    miModeloDatos.registrarPersona(miEmpPlantilla);
                }

                break;
            default: 
                System.out.println("El tipo de empleado no es valido, intentelo nuevamente");
                break;
        }
    }

    /**
     * 3) Registrar Cita Medica
     */

    public void registrarCitaMedica(){
        // Se pide el Documento al paciente
        String documentoPaciente = JOptionPane.showInputDialog("Ingrese el documento del 'Paciente' ");
        // Se manda el documento para consulta si el paciente esta recistrado
        Paciente pacienteFound = miModeloDatos.consultarPacientePorDocumento(documentoPaciente);

        // Validamos
        if(pacienteFound != null){
            // Es porque fue encontrado (Found)
            // Obtenemos el nombre del medico a consultar
            String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del medico");
            // Consultamos el medico con el nombre que nos asignaron
            Medico medicoFound = miModeloDatos.consultarMedicoPorNombre(nombreMedico);

            // Validamos
            if(medicoFound != null){
                // Es porque el medico solicitado se encontro

                // Se pide el servico
                String servicio = JOptionPane.showInputDialog("Ingrese el servico o motivo de la Consulta");
                // Se pide la hora de la consulta
                String fechaConsulta = JOptionPane.showInputDialog("Ingrese la fecha de la Consulta");
                // Se pide la hora de la consulta
                String horaConsulta = JOptionPane.showInputDialog("Ingrese la hora de la Consulta");

                // Se asiga el lugar de la cita, el consultorio
                String lugar = "LA cita sera en el consultoruo: "+medicoFound.getNumConsultorio();
                
                // Se instancia la clase creando un objeto de tipo CitaMedica() 
                // Se les pasa los parametros que pide
                CitaMedica miCita = new CitaMedica(pacienteFound, medicoFound, servicio, fechaConsulta, horaConsulta, lugar);
                // Registramos la cita medica y guardamos (Registramos) en la estructura de datos
                miModeloDatos.registrarCitasMedicas(miCita);
            }else{
                System.out.println("El medico no se encuentra registrado en el sistema");
            }
        }else{
            System.out.println("El paciente no se encuentra registrado en el sistema");
        }
    }



    /**
     * 4)Imprimir informacion
     */

    public void imprimirInformacion(){

        // Se crea un objeto de tipo StringBuffer
        StringBuffer menuImprimir = new StringBuffer();
        // Se crea las opciones del menu
        menuImprimir.append("MENU IMPRESIONES DE INFORMACIÓN\n");
        menuImprimir.append("1) Listar Pacientes\n");
        menuImprimir.append("2) Listar Empleados Eventual\n");
        menuImprimir.append("3) Listar Empleados por Plantilla\n");
        menuImprimir.append("4) Listar medicos\n");
        menuImprimir.append("5) Listar citas programadas\n");
        menuImprimir.append("Ingese una opcion\n");

        // Separador 
        System.out.println("-------------------------------------------------------------");
        // Variable que guarda la opcion del usuario de acuerdo al menu
        int opcionUsuario = Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));

        switch (opcionUsuario) {
            case 1:
                // Imprimir 
                miModeloDatos.imprimirPacientes();
                break;
            case 2:
                // 
                miModeloDatos.imprimirEmpleadosEventuales();
                break;
            case 3:
                // 
                miModeloDatos.imprimimosEmpleadosPlantilla();
                break;
            case 4:
                // 
                miModeloDatos.imprimirMedicos();
                break;
            case 5:
                // 
                miModeloDatos.imprimirCitasMedicasProgramadas();
                break;
            default:
                break;
        }


    }
}
