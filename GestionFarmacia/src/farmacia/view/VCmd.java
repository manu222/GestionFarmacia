package farmacia.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import farmacia.model.Farmacia;
import farmacia.model.FarmaciaGuardia;
import farmacia.model.FarmaciaNormal;
import farmacia.model.RepoFileBinFarmacia;
import common.IRepo;

import static javafx.application.Application.launch;

public class VCmd {
    private IRepo<Farmacia> farmacias;
    private Scanner sc;
    public VCmd() {
        farmacias=new RepoFileBinFarmacia();
        sc=new Scanner(System.in);
    }
    public void menu() {
        boolean sigue = true;
        while (sigue) {
            System.out.println("--------------------");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("Other. Finish");
            String opciones = sc.next();
            System.out.println("--------------------");
            switch (opciones) {
                case "1":
                    menuCreate();
                    break;
                case "2":
                    menuRead();
                    break;
                case "3":
                    menuUpdate();
                    break;
                case "4":
                    menuDelete();
                    break;
                default:
                    sigue = false;
                    break;
            }
        }
    }
    public void menuCreate() {
        System.out.println("Normal(1) or Guardia(other):");
        String type = sc.next();
        System.out.println("Introduce el ID de la farmacia:");
        int id = sc.nextInt();
        Farmacia c;
        if(type.equals("1")) {
            System.out.println("Introduce la dirección de la farmacia:");
            String direccion = sc.next();
            System.out.println("Introduce el nombre del farmaceutico:");
            List<String> farmaceutico = new ArrayList<>();
            farmaceutico.add(sc.next());
            System.out.println("Introduce los productos de la farmacia:");
            List<String> productos = new ArrayList<>();
            productos.add(sc.next());
            System.out.println("Introduce los clientes de la farmacia:");
            List<String> clientes = new ArrayList<>();
            clientes.add(sc.next());
            System.out.println("Horario:");
            String horario = sc.next();
            c = new FarmaciaNormal(farmaceutico,productos, clientes, direccion, id, horario);
        } else {
            System.out.println("Introduce la dirección de la farmacia:");
            String direccion = sc.next();
            System.out.println("Introduce el nombre del farmaceutico:");
            List<String> farmaceutico = new ArrayList<>();
            farmaceutico.add(sc.next());
            System.out.println("Introduce los productos de la farmacia:");
            List<String> productos = new ArrayList<>();
            productos.add(sc.next());
            System.out.println("Introduce los clientes de la farmacia:");
            List<String> clientes = new ArrayList<>();
            clientes.add(sc.next());
            System.out.println("Guardia:");
            boolean isGuardia = sc.nextBoolean();
            c = new FarmaciaGuardia(farmaceutico, productos, clientes, direccion, id, isGuardia);
        }
        if (farmacias.create(c))
            System.out.println("Created");
        else
            System.out.println("Error");
    }

    public void menuRead() {
        List<Farmacia> tmp=farmacias.read();
        if(tmp.size()==0)
            System.out.println("Empty");
        for(int i = 0;i<tmp.size();i++) {
            System.out.println(tmp.get(i));
        }
    }
    public void menuUpdate() {
        List<Farmacia> tmp=farmacias.read();
        if(tmp.size()==0)
            System.out.println("Empty");
        for(int i = 0;i<tmp.size();i++) {
            System.out.println(tmp.get(i));
        }

        System.out.println("Introduce el ID de la farmacia que quieres actualizar:");
        int idFarmacia = sc.nextInt();
        // Buscar la farmacia correspondiente
        Farmacia farmaciaSeleccionada = null;
        for (Farmacia farmacia : tmp) {
            if (farmacia.getId() == idFarmacia) {
                farmaciaSeleccionada = farmacia;
                break;
            }
        }
        if (idFarmacia == -1) {
            System.out.println("La farmacia no existe");
        } else {
            Farmacia farmacia = farmaciaSeleccionada;
            System.out.println("Datos actuales de la farmacia:");
            System.out.println(farmacia.toString());
            System.out.println("¿Qué datos quieres modificar?");
            System.out.println("1. Dirección");
            System.out.println("2. ID");
            System.out.println("3. Farmacéuticos");
            System.out.println("4. Productos");
            System.out.println("5. Clientes");
            System.out.println("6. Horario (solo para farmacias normales)");
            int opcion = sc.nextInt();
            switch(opcion) {
                case 1:
                    System.out.println("Introduce la nueva dirección:");
                    String direccionUpdate = sc.next();
                    farmacia.setDireccion(direccionUpdate);
                    break;
                case 2:
                    System.out.println("Introduce el nuevo ID:");
                    int idUpdate = sc.nextInt();
                    farmacia.setId(idUpdate);
                    break;
                case 3:
                    List<String> farmaceuticos = farmacia.getFarmaceuticos();
                    System.out.println("Farmacéuticos actuales:");
                    for (int i = 0; i < farmaceuticos.size(); i++) {
                        System.out.println((i + 1) + ". " + farmaceuticos.get(i));
                    }
                    System.out.println("¿Qué acción deseas realizar?");
                    System.out.println("1. Agregar farmacéuticos");
                    System.out.println("2. Eliminar un farmacéutico");
                    int opcionFarmaceuticos = sc.nextInt();
                    if (opcionFarmaceuticos == 1) {
                        boolean seguirAgregando = true;
                        while (seguirAgregando) {
                            System.out.println("Introduce el nombre del nuevo farmacéutico o escribe '0' para terminar:");
                            String nuevoFarmaceutico = sc.next();
                            if (nuevoFarmaceutico.equals("0")) {
                                seguirAgregando = false;
                            } else {
                                farmaceuticos.add(nuevoFarmaceutico);
                            }
                        }
                    } else if (opcionFarmaceuticos == 2) {
                        boolean seguirQuitando = true;
                        while (seguirQuitando) {
                            System.out.println("Introduce el nombre del farmaceutico a eliminar '0' para terminar:");
                            String quitarFarmaceutico = sc.next();
                            if (quitarFarmaceutico.equals("0")) {
                                seguirQuitando = false;
                            } else {
                                farmaceuticos.remove(quitarFarmaceutico);
                            }
                        }
                    }
                    farmacia.setFarmaceutico(farmaceuticos);
                    break;
                case 4:
                    List<String> productos = farmacia.getProductos();
                    System.out.println("Productos actuales:");
                    for (int i = 0; i < productos.size(); i++) {
                        System.out.println((i + 1) + ". " + productos.get(i));
                    }
                    System.out.println("¿Qué acción deseas realizar?");
                    System.out.println("1. Agregar un producto");
                    System.out.println("2. Eliminar un producto");
                    int opcionProductos = sc.nextInt();
                    if (opcionProductos == 1) {
                        boolean seguirAgregando = true;
                        while (seguirAgregando) {
                            System.out.println("Introduce el nombre del nuevo producto o escribe '0' para terminar:");
                            String nuevoProducto = sc.next();
                            if (nuevoProducto.equals("0")) {
                                seguirAgregando = false;
                            } else {
                                productos.add(nuevoProducto);
                            }
                        }
                    } else if (opcionProductos == 2) {
                        boolean seguirQuitando = true;
                        while (seguirQuitando) {
                            System.out.println("Introduce el número del producto que quieres eliminar '0' para terminar:");
                            String productoEliminar = sc.next();
                            if (productoEliminar.equals("0")) {
                                seguirQuitando = false;
                            } else {
                                productos.remove(productoEliminar);
                            }
                        }
                    }
                    farmacia.setProductos(productos);
                    break;
                case 5:
                    List<String> clientes = farmacia.getClientes();
                    System.out.println("Clientes actuales:");
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println((i + 1) + ". " + clientes.get(i));
                    }
                    System.out.println("¿Qué acción deseas realizar?");
                    System.out.println("1. Agregar un cliente");
                    System.out.println("2. Eliminar un cliente");
                    int opcionClientes = sc.nextInt();
                    if (opcionClientes == 1) {
                        boolean seguirAgregando = true;
                        while (seguirAgregando) {
                            System.out.println("Introduce el nombre del nuevo cliente o escribe '0' para terminar:");
                            String nuevoCliente = sc.next();
                            if (nuevoCliente.equals("0")) {
                                seguirAgregando = false;
                            } else {
                                clientes.add(nuevoCliente);
                            }
                        }
                    } else if (opcionClientes == 2) {
                        boolean seguirQuitando = true;
                        while (seguirQuitando) {
                            System.out.println("Introduce el número del cliente que quieres eliminar '0' para terminar:");
                            String clienteEliminar = sc.next();
                            if (clienteEliminar.equals("0")) {
                                seguirQuitando = false;
                            } else {
                                clientes.remove(clienteEliminar);
                            }
                        }
                    }
                    farmacia.setClientes(clientes);
                    break;
                case 6:
                    if (farmacia instanceof FarmaciaNormal) {
                        FarmaciaNormal farmaciaNormal = (FarmaciaNormal) farmacia;
                        System.out.println("Horario actual: " + farmaciaNormal.getHorario());
                        System.out.println("Introduce el nuevo horario:");
                        String nuevoHorario = sc.next();
                        farmaciaNormal.setHorario(nuevoHorario);
                    } else {
                        System.out.println("La farmacia seleccionada no es una farmacia normal.");
                    }
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
            farmacias.update(idFarmacia, farmacia);
            System.out.println("La farmacia ha sido actualizada");
        }
    }
    //no elimina lo que tiene que eliminar
    public void menuDelete() {
        List<Farmacia> tmp = farmacias.read();
        if (tmp.size() == 0) {
            System.out.println("No hay farmacias disponibles");
            return;
        }

        // Imprimir farmacias disponibles
        System.out.println("Farmacias disponibles:");
        for (Farmacia farmacia : tmp) {
            System.out.println(farmacia.toString());
        }

        // Obtener la ID de la farmacia a eliminar
        System.out.println("Introduce el ID de la farmacia que quieres eliminar:");
        int idFarmacia = sc.nextInt();

        // Buscar la farmacia correspondiente
        boolean found = search(idFarmacia);

        if (!found) {
            System.out.println("La farmacia no existe");
        }

        // Imprimir lista actualizada de farmacias
        tmp = farmacias.read();
        if (tmp.size() == 0) {
            System.out.println("No hay farmacias disponibles");
        } else {
            System.out.println("Farmacias disponibles:");
            for (Farmacia farmacia : tmp) {
                System.out.println(farmacia.toString());
            }
        }
    }

    private boolean search(int idFarmacia) {
        List<Farmacia> tmp = farmacias.read();
        boolean found = false;
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i).getId() == idFarmacia) {
                farmacias.delete(i);
                System.out.println("La farmacia ha sido eliminada");
                found = true;
                break;
            }
        }
        return found;
    }

    public static void main(String[] args) {

        //Ejecutando la siguiente linea se llama a FarmaciaGUI y se ejecuta la interfaz grafica
        FarmaciaGUI.launch(FarmaciaGUI.class,args);
        //si descomentamos estas dos lineas y comentamos la anterior, la interfaz que usaremos sera la de consola
        //VCmd view = new VCmd();
        // view.menu();
    }

}
