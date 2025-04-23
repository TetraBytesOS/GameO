package univerisdadProgramacion;

public class Pez {
	 protected String nombre;
	    protected int edad;
	    protected String especie;

	    public Pez(String nombre, int edad, String especie) {
	        this.nombre = nombre;
	        this.edad = edad;
	        this.especie = especie;
	    }

	    public void mostrarInfo() {
	        System.out.println("Nombre: " + nombre + ", Especie: " + especie + ", Edad: " + edad + " año");
	    }
}
