import java.util.Arrays;
import java.util.Date;

public class Compra {
    private Cliente cliente;
    private Farmaceutico farmaceutico;
    private float precioTotal;
    private Producto[] productos;
    private Date fecha;
    private int ID;
    //constructor

    public Compra(Cliente cliente, Farmaceutico farmaceutico, float precioTotal, Producto[] productos, Date fecha, int ID) {
        this.cliente = cliente;
        this.farmaceutico = farmaceutico;
        this.precioTotal = precioTotal;
        this.productos = productos;
        this.fecha = new Date(System.currentTimeMillis());
        this.ID = ID;
    }
    //getters

    public Cliente getCliente() {
        return cliente;
    }

    public Farmaceutico getFarmaceutico() {
        return farmaceutico;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "cliente=" + cliente +
                ", farmaceutico=" + farmaceutico +
                ", precioTotal=" + precioTotal +
                ", productos=" + Arrays.toString(productos) +
                ", fecha=" + fecha +
                ", ID=" + ID +
                '}';
    }
}
