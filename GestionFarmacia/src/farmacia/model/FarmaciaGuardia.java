package farmacia.model;

import java.util.List;

public class FarmaciaGuardia extends Farmacia {
    private boolean guardia;

    public FarmaciaGuardia(List<String> farmaceutico, List<String> productos, List<String> clientes, String direccion, int id, Boolean guardia) {
        super(farmaceutico, productos, clientes, direccion, id);
        this.guardia = guardia;
    }

    public boolean isGuardia() {
        return guardia;
    }

    public void setGuardia(boolean guardia) {
        this.guardia = guardia;
    }

    public void guardia() {
        System.out.println("Estado: " + this.guardia);
    }
}