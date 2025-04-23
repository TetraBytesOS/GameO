package univerisdadProgramacion;


public class PezGlobo extends Pez implements Nadador, Comedor{
		public PezGlobo(String nombre, int edad, String especie) {
	        super(nombre, edad, especie); // Llama al constructor de la clase padre
	    }

	    @Override
	    public void nadar() {
	        System.out.println(nombre + " está nadando por el océano.");
	    }

	    @Override
	    public void comer() {
	        System.out.println(nombre + " ha comido su comida.");
	    }
	}
