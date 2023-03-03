
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;



public class Main {
    public static void reBuildLinkedList(LinkedList<Farmaceutico> lista, String ruta){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datosFarmaceutico = linea.split(",");
                Farmaceutico farmaceutico = new Farmaceutico(datosFarmaceutico[0], Integer.parseInt(datosFarmaceutico[1]), datosFarmaceutico[2], datosFarmaceutico[3], Double.parseDouble(datosFarmaceutico[4]), Integer.parseInt(datosFarmaceutico[5]), Double.parseDouble(datosFarmaceutico[6]), Integer.parseInt(datosFarmaceutico[7]));
                lista.add(farmaceutico);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Imprimir la LinkedList reconstruida
        for (Farmaceutico farmaceutico : lista) {
            System.out.println(farmaceutico);
        }*/
    }

    public static void escribirListaEnArchivo(LinkedList<Farmaceutico> lista, String nombreArchivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
            for (Farmaceutico elemento : lista) {
                writer.write(elemento.getNombre() + "," + elemento.getEdad() + "," + elemento.getType() + "," + elemento.getContacto() + ","+ elemento.getSueldo_bruto() + ","+ elemento.getHoras() + ","+ elemento.getPrecioHoras() + ","+ elemento.getIdFarmaceutico() );
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerListaFarmaceuticosFile() {
        System.out.println("Lista de farmaceuticos");
        //leer archivo
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("farmaceuticos.txt"));
            String linea = reader.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args)  {
        String ruta = "farmaceuticos.txt";

        LinkedList<Farmaceutico> farmaceutico = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("********** MENU **********");
            System.out.println("1. Leer");
            System.out.println("2. Crear");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {

                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(ruta));
                        if (reader.readLine() == null) {
                            System.out.println("El archivo está vacío.");
                        } else {
                            leerListaFarmaceuticosFile();
                            System.out.println();
                        }
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
                case 2 -> {
                    System.out.println("Seleccionaste Crear");
                    Scanner add = new Scanner(System.in);

                    System.out.println("Ingresa el nombre: ");
                    String nombreNew = add.nextLine();

                    System.out.println("Ingresa la edad: ");
                    int edadNew = add.nextInt();

                    System.out.println("Ingresa el tipo: ");
                    String tipoNew = add.next();

                    String contactoNew = nombreNew+"@farmacia.com";

                    System.out.println("Ingresa las horas: ");
                    int horasNew = add.nextInt();

                    System.out.println("Ingresa el precio por hora: ");
                    double precioHoraNew = add.nextDouble();

                    double sueldoBrutoNew = horasNew*precioHoraNew;

                    int newId = 0;

                    try {
                        BufferedReader br = new BufferedReader(new FileReader(ruta));
                        if (br.readLine() == null) {
                            newId = 1;
                        }else{
                            reBuildLinkedList(farmaceutico,ruta);
                            newId = farmaceutico.size()+1;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    Farmaceutico newElement = new Farmaceutico(nombreNew, edadNew, tipoNew,contactoNew, sueldoBrutoNew, horasNew,precioHoraNew,newId);
                    farmaceutico.add(newElement);
                    escribirListaEnArchivo(farmaceutico,ruta);
                    leerListaFarmaceuticosFile();
                }
                case 3 -> {
                    System.out.println("Seleccionaste Actualizar");

                    //Editar Valor

                    System.out.println("Que datos quieres cambiar??:");

                    Scanner changeAtributo = new Scanner(System.in);
                    String nombre, type, contacto;
                    int edad, horas;
                    double sueldoBruto, precioHora;
                    int atributo;

                    do {
                        System.out.println("********** MENU **********");
                        System.out.println("1. Nombre");
                        System.out.println("2. Edad");
                        System.out.println("3. Tipo");
                        System.out.println("4. Contacto");
                        System.out.println("5. Sueldo Bruto");
                        System.out.println("6. Salir");
                        System.out.print("Selecciona una opción: ");

                        atributo = changeAtributo.nextInt();

                        switch (atributo) {
                            case 1 -> {
                                reBuildLinkedList(farmaceutico,ruta);
                                System.out.println("Introduzca el ID del empleado para realizar cambios");
                                Scanner scId = new Scanner(System.in);
                                int id = scId.nextInt();

                                Scanner nwValue= new Scanner(System.in);

                                System.out.print("Ingresa el nombre: ");
                                nombre = nwValue.nextLine();

                                for (Farmaceutico elemento : farmaceutico) {
                                    if (elemento.getIdFarmaceutico()==id){
                                        elemento.setNombre(nombre);
                                    }
                                }
                                escribirListaEnArchivo(farmaceutico,ruta);


                            }
                            case 2 -> {
                                reBuildLinkedList(farmaceutico,ruta);
                                System.out.println("Introduzca el ID del empleado para realizar cambios");
                                Scanner scId = new Scanner(System.in);
                                int id = scId.nextInt();

                                Scanner nwValue= new Scanner(System.in);

                                System.out.print("Ingresa la edad: ");
                                edad = nwValue.nextInt();
                                for (Farmaceutico elemento : farmaceutico) {
                                    if (elemento.getIdFarmaceutico()==id){
                                        elemento.setEdad(edad);
                                    }
                                }
                                escribirListaEnArchivo(farmaceutico,ruta);
                            }
                            case 3 -> {
                                reBuildLinkedList(farmaceutico,ruta);
                                System.out.println("Introduzca el ID del empleado para realizar cambios");
                                Scanner scId = new Scanner(System.in);
                                int id = scId.nextInt();

                                Scanner nwValue= new Scanner(System.in);

                                System.out.print("Ingresa el Tipo: ");
                                type = nwValue.nextLine();
                                for (Farmaceutico elemento : farmaceutico) {
                                    if (elemento.getIdFarmaceutico()==id){
                                        elemento.setType(type);
                                    }
                                }
                                escribirListaEnArchivo(farmaceutico,ruta);
                            }
                            case 4 -> {
                                reBuildLinkedList(farmaceutico,ruta);
                                System.out.println("Introduzca el id del empleado para realizar cambios");
                                Scanner scId = new Scanner(System.in);
                                int id = scId.nextInt();

                                Scanner nwValue= new Scanner(System.in);

                                System.out.print("Ingresa el contacto: ");
                                contacto = nwValue.nextLine();
                                for (Farmaceutico elemento : farmaceutico) {
                                    if (elemento.getIdFarmaceutico()==id){
                                        elemento.setContacto(contacto);
                                    }
                                }
                                escribirListaEnArchivo(farmaceutico,ruta);
                            }
                            case 5 -> {
                                reBuildLinkedList(farmaceutico,ruta);
                                System.out.println("Introduzca el id del empleado para realizar cambios");
                                Scanner scId = new Scanner(System.in);
                                int id = scId.nextInt();

                                Scanner nwValue= new Scanner(System.in);

                                System.out.print("Ingresa las horas de trabajo: ");
                                horas = nwValue.nextInt();
                                System.out.print("Ingresa el precio por hora: ");
                                precioHora=nwValue.nextDouble();
                                sueldoBruto = horas*precioHora;
                                for (Farmaceutico elemento : farmaceutico) {
                                    if (elemento.getIdFarmaceutico()==id){
                                        elemento.setHoras(horas);
                                        elemento.setPrecioHora(precioHora);
                                        elemento.setSueldo_bruto(sueldoBruto);
                                    }
                                }
                                escribirListaEnArchivo(farmaceutico,ruta);
                            }
                            case 6 -> {
                                System.out.println("Saliendo del programa...");
                                opcion=6;
                            }
                            default -> System.out.println("Opción inválida, por favor intenta de nuevo");
                        }
                    } while (opcion != 6);

                }
                case 4 -> {
                    reBuildLinkedList(farmaceutico, ruta);
                    System.out.println("Seleccionaste Eliminar");
                    // Eliminar el empleado con nombre "X"
                    System.out.print("ID del Farmaceutico a eliminar:");
                    Scanner sc4 = new Scanner(System.in);
                    int borrar = sc4.nextInt();


                    farmaceutico.removeIf(elemento -> elemento.getIdFarmaceutico() == borrar);
                    //Escribir en el archivo de texto
                    escribirListaEnArchivo(farmaceutico, ruta);
                    //leer
                    leerListaFarmaceuticosFile();


                }
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida, por favor intenta de nuevo");
            }
        } while (opcion != 5);






    }


}
