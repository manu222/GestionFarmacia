import java.io.Serializable;

public class Cliente implements Persona, Serializable {
    public String name;
    private int edad;

    public Cliente(String name,int edad) {
        this.name = name;
        this.edad = edad;
    }

    @Override
    public String getNombre(String name) {
        return this.name;
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
        this.edad=edad;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "name='" + name + '\'' +
                ", edad=" + edad +
                '}';
    }
}
