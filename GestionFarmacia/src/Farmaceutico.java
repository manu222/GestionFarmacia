import java.io.Serializable;

public class Farmaceutico implements Persona , Serializable {

    private String nombre;
    public Farmaceutico(String nombre) {
    this.nombre=nombre;
    }

    @Override
    public String getNombre(String name) {
        return null;
    }

    @Override
    public String getNombre() {
        return null;
    }

    @Override
    public int getEdad() {
        return 0;
    }

    @Override
    public void setNombre(String nombre) {

    }

    @Override
    public void setEdad(int edad) {

    }

    @Override
    public String toString() {
        return "Farmaceutico{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}