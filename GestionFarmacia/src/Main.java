
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {
 /*   public static void reBuildLinkedList(LinkedList<Farmaceutico> lista, String ruta){
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

        *//* Imprimir la LinkedList reconstruida
        for (Farmaceutico farmaceutico : lista) {
            System.out.println(farmaceutico);
        }*//*
    }*/

    /**
     * Escribir lista en archivo.
     *
     * @param lista         the lista
     * @param nombreArchivo the nombre archivo
     */
    /*public static void escribirListaEnArchivo(LinkedList<Farmacia> lista, String nombreArchivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
            for (Farmacia elemento : lista) {
                writer.write(elemento.getIDfarmacia()+ "," + elemento.getDireccion()+"," + elemento.getClientes("pepe") + ","+ elemento.getProductos("paracetamol") + ","+ elemento.getFarmaceutico(1) );
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/



   /* public static void leerListaFarmaceuticosFile() {
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
*/

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)  {
        String ruta = "farmacias.txt";

        LinkedList<Farmaceutico> farmaceuticos = new LinkedList<>();
        LinkedList<Farmacia> listaFarmacias= new LinkedList<>();
        LinkedList<Producto> almacen1= new LinkedList<>();
        LinkedList<Cliente> listaClientes = new LinkedList<>();

        LinkedList<Farmaceutico> farmaceuticos2 = new LinkedList<>();
        LinkedList<Farmacia> listaFarmacias2= new LinkedList<>();
        LinkedList<Producto> almacen2= new LinkedList<>();
        LinkedList<Cliente> listaClientes2 = new LinkedList<>();

        Farmaceutico farmaceutico1 = new Farmaceutico("pepito");
        Farmaceutico farmaceutico2 = new Farmaceutico("manolito");

        Cliente cliente1 = new Cliente("juanito",21);
        Cliente cliente2 = new Cliente("Federico",43);

        Producto paracetamol = new Producto("paracetamol",5,1,true);
        Producto ibuprofeno = new Producto("ibuprofeno",5,2,true);

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);

        farmaceuticos.add(farmaceutico1);
        farmaceuticos.add(farmaceutico2);

        farmaceuticos2.add(farmaceutico2);

        almacen1.add(paracetamol);
        almacen1.add(ibuprofeno);

        listaClientes2.add(cliente1);
        farmaceuticos.add(farmaceutico2);
        almacen2.add(ibuprofeno);

        Farmacia farmacia1 = new Farmacia(farmaceuticos,almacen1,listaClientes,"Calle tajo",1);
        Farmacia farmacia2 = new Farmacia(farmaceuticos2,almacen2,listaClientes2,"Calle miño",2);

        listaFarmacias.add(farmacia1);
        listaFarmacias.add(farmacia2);


        System.out.println(listaFarmacias);
        

        farmacia1.escribirEnArchivo("farmaciasTotal.txt");

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
                    Farmacia.leerListaFarmaciasFile();
                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {


                }
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida, por favor intenta de nuevo");
            }
        } while (opcion != 5);






    }


}
