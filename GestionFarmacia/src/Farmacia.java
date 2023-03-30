import java.io.*;
import java.util.LinkedList;

public class Farmacia implements Serializable{
    public LinkedList<Farmaceutico> farmaceutico;
    public LinkedList<Producto> producto;
    public LinkedList<Cliente>  clientes;
    public String Direccion;
    int IDfarmacia;

    /**
     * Instantiates a new Farmacia.
     *
     * @param farmaceutico the farmaceutico
     * @param producto    the productos
     * @param clientes     the clientes
     * @param direccion    the direccion
     * @param IDfarmacia   the dfarmacia
     */
    public Farmacia(LinkedList<Farmaceutico> farmaceutico, LinkedList<Producto> producto, LinkedList<Cliente> clientes, String direccion, int IDfarmacia) {
        this.farmaceutico = farmaceutico;
        this.producto = producto;
        this.clientes = clientes;
        this.Direccion = direccion;
        this.IDfarmacia = IDfarmacia;
    }


    /**
     * Gets farmaceutico.
     *
     * @return the farmaceutico
     */
    public LinkedList<Farmaceutico> getFarmaceutico() {
        return farmaceutico;
    }

    /**
     * Get productos producto [ ].
     *
     * @return the producto [ ]
     */


    /**
     * Get clientes cliente [ ].
     *
     * @return the cliente [ ]
     */
    public LinkedList<Cliente> getClientes(String pepe) {
        return clientes;
    }

    /**
     * Gets direccion.
     *
     * @return the direccion
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * Gets i dfarmacia.
     *
     * @return the i dfarmacia
     */
    public int getIDfarmacia() {
        return IDfarmacia;
    }

    public void escribirEnArchivo(String ruta) {
        try {
            FileWriter writer = new FileWriter(ruta, true);
            writer.write("Farmacia ID: " + IDfarmacia + "\n");
            writer.write("Dirección: " + Direccion + "\n");
            writer.write("Farmacéuticos: \n");
            for (Farmaceutico farmaceutico : farmaceutico) {
                writer.write("\t" + farmaceutico.toString() + "\n");
            }
            writer.write("Productos: \n");
            for (Producto producto : producto) {
                writer.write("\t" + producto.toString() + "\n");
            }
            writer.write("Clientes: \n");
            for (Cliente cliente : clientes) {
                writer.write("\t" + cliente.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en archivo: " + e.getMessage());
        }
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Farmacia ID: ").append(IDfarmacia).append("\n");
        sb.append("Dirección: ").append(Direccion).append("\n");
        sb.append("Farmacéuticos: \n");
        for (Farmaceutico f : farmaceutico) {
            sb.append("\t").append(f).append("\n");
        }
        sb.append("Productos: \n");
        for (Producto p : producto) {
            sb.append("\t").append(p).append("\n");
        }
        sb.append("Clientes: \n");
        for (Cliente c : clientes) {
            sb.append("\t").append(c).append("\n");
        }
        return sb.toString();
    }

    /**
     * Leer lista farmacias file.
     */
//funciones
    public static void leerListaFarmaciasFile() {
        System.out.println("Lista de Farmacias");

        // Verificar si el archivo existe
        File archivo = new File("farmacias.txt");

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                System.out.println("El archivo se ha creado exitosamente.");
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error al crear el archivo.");
                e.printStackTrace();
            }
        }

        // Leer archivo
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(archivo));
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

}
