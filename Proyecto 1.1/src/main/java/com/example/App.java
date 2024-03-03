package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Admin> listaDeAdmin = new ArrayList<Admin>();
    private static ArrayList<Estudiante> listaDeEstudiantes = new ArrayList<Estudiante>();
    private static ArrayList<Docente> listaDeDocentes = new ArrayList<Docente>();
    private static ArrayList<Asignatura> listaDeAsignaturas = new ArrayList<Asignatura>();
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        listaDeAdmin.add(new Admin("edd", "123"));
        opciones();

    }



    @SuppressWarnings("resource")
    /**
     * metodo incial que muestra las opciones de inicio de sesion (administrador o usuario)
     */
    public static void opciones() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, elige el método de inicio de sesión:");
        System.out.println("1. Administrador");
        System.out.println("2. Usuario");
        System.out.print("Opcion numero: ");

        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                System.out.println("Por favor, ingresa tu nombre de usuario:");
                String usuario = scanner.nextLine();
                System.out.print("Por favor, ingresa tu contraseña:");
                String contrasena = scanner.nextLine();
                verificar(usuario, contrasena);
                break;
            case "2":
                System.out.println("Has escogido Usuario");
                userPanel();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    /*
     * panel que muestra las opciones en caso de haber ingresado como administrador
     */
    public static void AdminPanel() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, elige alguna de las opciones:");
        System.out.println("1. Registrar Estudiante");
        System.out.println("2. Registrar Docente");
        System.out.println("3. Registrar Asignatura");
        System.out.println("4. Volver a iniciar sesion");
        System.out.println("5. Gestionar Asignatura");
        System.out.print("Opcion numero: ");

        String decision = scanner.nextLine();

        switch (decision) {
            case "1":
                System.out.print("Por favor ingrese el nombre del estudiante: ");
                String nombre = scanner.nextLine();

                System.out.print("Por favor ingrese el apellido del estudiante: ");
                String apellido = scanner.nextLine();

                System.out.print("Por favor ingrese el numero de identidad del estudiante: ");
                String numIdentidad = scanner.nextLine();

                System.out.print("Por favor ingrese la edad del estudiante: ");
                int edad = scanner.nextInt();
                scanner.nextLine();

                listaDeEstudiantes.add(new Estudiante(nombre, apellido, numIdentidad, edad));

                System.out.println("Estudiante ingresado correctamente, ¿desea volver?");
                System.out.println("1. Volver");
                System.out.println("2. Cerrar");

                String back = scanner.nextLine();

                switch (back) {
                    case "1":
                        AdminPanel();
                        break;
                    case "2":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }

            case "2":
                System.out.print("Por favor ingrese el nombre del docente: ");
                String nombreDocente = scanner.nextLine();

                System.out.print("Por favor ingrese el apellido del docente: ");
                String apellidoDocente = scanner.nextLine();

                System.out.print("Por favor ingrese el numero de identidad del docente: ");
                String numIdDocente = scanner.nextLine();

                listaDeDocentes.add(new Docente(nombreDocente, apellidoDocente, numIdDocente));

                System.out.println("Docente ingresado correctamente, ¿desea volver?");
                System.out.println("1. Volver");
                System.out.println("2. Cerrar");

                int volver = scanner.nextInt();

                switch (volver) {
                    case 1:
                        AdminPanel();
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }

            case "3":
                System.out.print("Por favor ingrese el nombre de la asignatura: ");
                String NombreAs = scanner.nextLine();

                System.out.print("Por favor ingrese el codigo de la asignatura: ");
                String CodigoAs = scanner.nextLine();

                System.out.print("Por favor ingrese la capacidad maxima de estudiantes de la asignatura: ");
                int CapacidadAs = scanner.nextInt();

                System.out.println("¿La asignatura esta actualmente abierta?");
                System.out.println("1. Si");
                System.out.println("2. No");
                int aperturaAs = scanner.nextInt();

                boolean AperturaAsBool = aperturaAs == 1;

                System.out.println("¿La asignatura es habilitable?");
                System.out.println("1. Si");
                System.out.println("2. No");
                int habilitableAs = scanner.nextInt();

                boolean HabilitableAsBool = habilitableAs == 1;

                System.out.print("Por favor ingrese el numero del docente quiere asignar a esta materia: ");
                for (int i = 0; i < listaDeDocentes.size(); i++) {
                    Docente docente = listaDeDocentes.get(i);
                    System.out.println((i + 1) + ". " + docente.getNombre());
                }

                int docenteIndex = scanner.nextInt();
                scanner.nextLine();

                Docente DocenteAs = listaDeDocentes.get(0);
                if (docenteIndex >= 1 && docenteIndex <= listaDeDocentes.size()) {
                    DocenteAs = listaDeDocentes.get(docenteIndex - 1);
                } else {
                    System.out.println("Número de docente no válido: " + docenteIndex);
                    return;
                }

                ArrayList<Integer> EstudiantesAs = new ArrayList<>();
                System.out.println("Lista de Estudiantes Disponibles:");
                for (int i = 0; i < listaDeEstudiantes.size(); i++) {
                    Estudiante estudiante = listaDeEstudiantes.get(i);
                    System.out
                            .println((i + 1) + ". " + estudiante.getNombre() + " " + estudiante.getApellido());
                }
                System.out.println(
                        "Ingrese los números de los estudiantes a registrar (separados por espacio): ");

                String estudiantesInput = scanner.nextLine();
                String[] estudiantesSeleccionados = estudiantesInput.split(" ");

                if (estudiantesSeleccionados.length < CapacidadAs) {
                    for (String numeroEstudiante : estudiantesSeleccionados) {
                        int indexEstudiante = Integer.parseInt(numeroEstudiante) - 1;

                        if (indexEstudiante >= 0 && indexEstudiante < listaDeEstudiantes.size()) {
                            EstudiantesAs.add(indexEstudiante);
                        } else {
                            System.out.println("Número de estudiante no válido: " + numeroEstudiante);
                        }
                    }
                } else {
                    System.out.println("Cantidad de estudiantes invalida");
                    System.exit(0);
                }

                ArrayList<ArrayList<Float>> listaDeNotas = new ArrayList<>();
                for (Estudiante estudiante : listaDeEstudiantes) {
                    ArrayList<Float> nota = new ArrayList<>();

                    System.out.println("Ingresar notas para " + estudiante.getNombre() + " " + estudiante.getApellido()
                            + "(recuerde separar las decimas con una coma)");

                    System.out.print("Nota 1: ");
                    Float nota1 = scanner.nextFloat();
                    nota.add(nota1);

                    System.out.print("Nota 2: ");
                    Float nota2 = scanner.nextFloat();
                    nota.add(nota2);

                    System.out.print("Nota 3: ");
                    Float nota3 = scanner.nextFloat();
                    nota.add(nota3);

                    System.out.print("Nota 4: ");
                    Float nota4 = scanner.nextFloat();
                    nota.add(nota4);

                    listaDeNotas.add(nota);
                }

                scanner.nextLine();

                listaDeAsignaturas.add(new Asignatura(NombreAs, CodigoAs, CapacidadAs, AperturaAsBool,
                        HabilitableAsBool, DocenteAs, listaDeNotas, EstudiantesAs));

                System.out.println("Asignatura registrada correctamente, ¿desea volver?");
                System.out.println("1. Volver");
                System.out.println("2. Cerrar");

                String volver1 = scanner.nextLine();

                switch (volver1) {
                    case "1":
                        AdminPanel();
                        break;
                    case "2":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            case "4":
                opciones();
                break;
            case "5":
                mostrarListaAsignaturas();
                break;
        }
    }

    /**
     * metodo utilizado para verificar los datos de inicio como administrador
     * @param usuario
     * @param contrasena
     */
    public static void verificar(String usuario, String contrasena) {
        boolean existe = false;
        for (Admin admin : listaDeAdmin) {
            if (admin.getNombre().equals(usuario) && admin.getContra().equals(contrasena)) {
                existe = true;
                break;
            }
        }

        if (existe) {
            System.out.println("Bienvenido");
            AdminPanel();
        } else {
            System.out.println("Acceso denegado");
        }
    }

    @SuppressWarnings("resource")
    /*
     * metodo que recopila las informacion del usuario (estudiante) al momento de ingresar el numero de identificacion registrado
     */
    public static void userPanel() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingresa tu número de identificación:");
        String numIdentidad = scanner.nextLine().trim();

        boolean estudianteEncontrado = false;
        Estudiante estudiante = null;

        for (Estudiante e : listaDeEstudiantes) {
            if (e.getNumIdentidad().equals(numIdentidad)) {
                estudiante = e;
                estudianteEncontrado = true;
                break;
            }
        }

        if (estudianteEncontrado) {
            System.out.println("Bienvenido, " + estudiante.getNombre() + " " + estudiante.getApellido());

            for (Asignatura asignatura : listaDeAsignaturas) {

                if( asignatura.isEstadoDeApertura() == true){
                    System.out.println("Asignatura: " + asignatura.getNombre());
                    System.out.println("Notas: ");

                    Float promedio = 0f;
                    for (ArrayList<Float> notas : asignatura.getListaDeNotas()) {
                        for (Float nota : notas) {
                            System.out.println(nota);
                            promedio = promedio + nota;
                        }
                    }

                System.out.println("promedio: " + promedio / 4);
                if (promedio / 4 < 2)
                    System.out.println("Lamentablemente has entrado a matricula condicional");
                if (promedio / 4 < 3)
                    System.out.println("Lamentablemente has entrado a un periodo de prueba");

                }else{
                    System.out.println("aun no puedes ver las notas de: " + asignatura.getNombre() + "ya que aun esta abierta");
                }
            }

            System.out.println("¿Deseas volver al menú principal?");
            System.out.println("1. Sí");
            System.out.println("2. Cerrar sesión");
            String volver = scanner.nextLine();

            switch (volver) {
                case "1":
                    opciones();
                    break;
                case "2":
                    System.out.println("Sesión cerrada. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Sesión cerrada.");
                    break;
            }

        } else {
            System.out.println("Estudiante no encontrado. Verifica tu número de identificación.");
        }
    }


    @SuppressWarnings("resource")
    /*
     * metodo utlizado para gestionar la apertura de las asignaturas
     */
    public static void mostrarListaAsignaturas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lista de Asignaturas:");
    
        for (Asignatura asignatura : listaDeAsignaturas) {
            System.out.println("Nombre: " + asignatura.getNombre());
            System.out.println("Código: " + asignatura.getCodigo());
            System.out.println("Estado: " + (asignatura.isEstadoDeApertura() ? "Cerrada" : "Abierta"));
            System.out.println("------------");
            System.out.println("¿Deseas abrir/cerrar la asignatura?: ");
            System.out.println("1. Si");
            System.out.println("2. No");
            
            int Estado = scanner.nextInt();
            if(Estado == 1){
               if(asignatura.isEstadoDeApertura() == true){
                asignatura.setEstadoDeApertura(false);
               }else{
                asignatura.setEstadoDeApertura(true);
               }
            }
            System.out.println("Cambio en apertura completado");

            
        }
        
    
    }

}
