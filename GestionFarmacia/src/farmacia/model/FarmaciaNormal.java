package farmacia.model;

import java.util.List;

public class FarmaciaNormal extends Farmacia {
    private String horario;

    public FarmaciaNormal(List<String> farmaceutico, List<String> productos, List<String> clientes, String direccion, int id, String horario) {
        super(farmaceutico, productos, clientes, direccion, id);
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void horario() {
        System.out.println("Horario de atención: " + this.horario);
    }
}