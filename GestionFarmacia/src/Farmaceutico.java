public class Farmaceutico extends Persona{
    double sueldo_bruto;
    public String contacto;
    final int horas;
    public double precioHoras ;
    int idFarmaceutico;

    public Farmaceutico(String nombre, int edad, String type, String contacto, double sueldo_bruto, int horas,double precioHoras,int idFarmaceutico) {
        super(nombre, edad, type);
        this.contacto = contacto;
        this.horas = horas;
        this.sueldo_bruto=sueldo_bruto;
        this.precioHoras=precioHoras;
        this.idFarmaceutico = idFarmaceutico;
    }



    public double Neto() {
        return sueldo_bruto-(0.25*sueldo_bruto);
    }
    public String contacto(String contacto) {
        return contacto;
    }
    @Override
    public String toString() {
        return "Farmaceutico{"+"nombre=" +getNombre()+",edad="+getEdad()+",Type="+getType()+",SueldoNeto="+Neto()+",Contacto="+getContacto()+",ID="+getIdFarmaceutico()+"}";
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo_bruto() {
        return sueldo_bruto;
    }

    public String getContacto() {
        return contacto;
    }

    public int getHoras() {
        return horas;
    }

    public double getPrecioHoras() {
        return precioHoras;
    }
    public double setPrecioHora(double precioHoras) {
        return precioHoras;
    }
    public int getEdad() {
        return edad;
    }
    public int setEdad(int edad) {
        return this.edad;
    }
    public int setHoras(double horas) {
        return this.horas;
    }
    public String getType() {
        return type;
    }
    public String setType(String type) {
        return type;
    }

    public void setSueldo_bruto(double sueldo_bruto) {
        this.sueldo_bruto = sueldo_bruto;
    }
    public void setNombre(String nombre) {
        this.nombre= nombre;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getIdFarmaceutico() {
        return idFarmaceutico;
    }

    public void setIdFarmaceutico(int idFarmaceutico) {
        this.idFarmaceutico = idFarmaceutico;
    }
}