
public class Farmaceutico extends Persona{
    double sueldo_bruto;
    private String contacto;
    private int horas;
    private double precioHoras;

    public Farmaceutico(String nombre, int edad, String type, double sueldo_bruto, String contacto, int horas, double precioHoras) {
        super(nombre, edad, type);
        this.sueldo_bruto = sueldo_bruto;
        this.contacto = contacto;
        this.horas = horas;
        this.precioHoras = precioHoras;
    }

    public double Neto() {
        return sueldo_bruto-(0.25*sueldo_bruto);
    }
    @Override
    public String toString() {
        return "Empleado{"+ "nombre= " + nombre + ", edad= "+ edad +", Sueldo neto= "+ Neto() + '}';
    }
}