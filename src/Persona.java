public class Persona {
    String nombre;
    int edad;
    String type;


    public Persona(String nombre, int edad,String type ){
        this.nombre=nombre;
        this.edad=edad;
        this.type=type;
    }


    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", type=" + type +
                '}';
    }
}