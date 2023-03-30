import java.io.Serializable;

public class Producto implements Serializable {
	String nombre;
	float precio;
	int ID;
	boolean necesitaReceta;
	
	
	
	public Producto(String nombre, float precio, int ID, boolean necesitaReceta) {
        this.nombre = nombre;
        this.precio = precio;
        this.ID = ID;
        this.necesitaReceta = necesitaReceta;
    }
	
	
	public String getNombre() {
		return nombre;
		
	}
	
	public float getPrecio() {
		return precio;
		
	}
	
	public int getID() {
		return ID;
		
	}
	
	public boolean getnecesitaReceta() {
		return necesitaReceta;
	
	}
	
	public void setNombre(String nombre) {
        this.nombre= nombre;
    }
	
	public void setPrecio(float precio) {
        this.precio= precio;
    }
	
	public void setID(int ID) {
        this.ID= ID;
    }
	
	public void setNecesitaReceta(boolean necesitaReceta) {
        this.necesitaReceta= necesitaReceta;
    }

	@Override
	public String toString() {
		return "Producto{" +
				"nombre='" + nombre + '\'' +
				", ID=" + ID +
				", precio=" + precio +
				", Necesita receta=" + necesitaReceta +
				'}';
	}
	
	
}
