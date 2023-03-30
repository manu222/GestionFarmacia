
public class Receta {
	Producto Producto;
	String nombrePersona;
	int usos;
	
	
	public String getNombrePersona() {
		return nombrePersona;
	}
	
	public int getUsos() {
		return usos;
	}
	
	public boolean isValid() {
		if(usos < 1) {return false;}
		else {return true;}
	}
	
	public void decrement() {
		usos--;
	}
}
