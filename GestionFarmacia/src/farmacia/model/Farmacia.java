package farmacia.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The type Farmacia.
 */
public class Farmacia implements Serializable {
    private List<String> Farmaceutico;
    private List<String> Productos;
    private List<String> clientes;
    private String direccion;
    private int id;

    /**
     * Instantiates a new Farmacia.
     *
     * @param farmaceutico the farmaceutico
     * @param productos    the productos
     * @param clientes     the clientes
     * @param direccion    the direccion
     * @param id           the id
     */
    public Farmacia(List<String> farmaceutico, List<String> productos, List<String> clientes, String direccion, int id) {
        Farmaceutico = farmaceutico;
        Productos = productos;
        this.clientes = clientes;
        this.direccion = direccion;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Farmacia other = (Farmacia) obj;
        return id == other.id;
    }


    /**
     * Gets farmaceutico.
     *
     * @return the farmaceutico
     */
    public List<String> getFarmaceutico() {
        return Farmaceutico;
    }

    /**
     * Sets farmaceutico.
     *
     * @param farmaceutico the farmaceutico
     */
    public void setFarmaceutico(List<String> farmaceutico) {
        Farmaceutico = farmaceutico;
    }

    /**
     * Gets productos.
     *
     * @return the productos
     */
    public List<String> getProductos() {
        return Productos;
    }

    /**
     * Sets productos.
     *
     * @param productos the productos
     */
    public void setProductos(List<String> productos) {
        Productos = productos;
    }

    /**
     * Gets clientes.
     *
     * @return the clientes
     */
    public List<String> getClientes() {
        return clientes;
    }

    /**
     * Sets clientes.
     *
     * @param clientes the clientes
     */
    public void setClientes(List<String> clientes) {
        this.clientes = clientes;
    }

    /**
     * Gets direccion.
     *
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Sets direccion.
     *
     * @param direccion the direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Farmacia{" +
                "Farmaceutico=" + Farmaceutico +
                ", Productos=" + Productos +
                ", clientes=" + clientes +
                ", direccion='" + direccion + '\'' +
                ", id=" + id +
                '}';
    }

    public List<String> getFarmaceuticos() {
        return this.Farmaceutico;
    }

}
