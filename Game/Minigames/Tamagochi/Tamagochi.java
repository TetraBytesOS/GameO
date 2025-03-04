package univerisdadProgramacion;

import javax.swing.JOptionPane;
import java.util.Timer;
import java.util.TimerTask;


public class Tamagochi {

	private String nombre;
	private int energia;
	private int comida;
	private int felicidad;
	private boolean vivo;
	private boolean completado;//juego completado
    
		
	public Tamagochi() {
		nombre=" ";
	    energia=100;
	    comida=100;
	    felicidad=100;
	    vivo=true;
	    completado=false;
	    RecargaStats();
	}
		
	
	public void TimerVida() { //Método para ejecutar el temporizador de la limpieza
	
		Timer timer1=new Timer(); //con esta clase creas el timer para una tarea
	
		TimerTask tarea1=new TimerTask() { //Con esta clase se establece la tarea que quieres ejecutar con el timer

	
			public void run() { //Método abstracto que crea la tarea
              
				felicidad-=6;
				energia-=4;
				comida-=10;
				
				
				if(completado==false) {
					if(felicidad<=0 || comida<=0 || energia<=0 ) {  //Si algúna propiedad del Tamagochi llega a 0, este muere y se para el timer
						vivo=false;
						System.out.println("\n💀 " + nombre + " se ha ido... (murió por hambre o agotamiento o depresión) 💀");
						System.out.println("comida: "+comida+", felicidad: "+ felicidad+", energía: "+energia);
						timer1.cancel();
					}
				}
				else timer1.cancel();
              }
				
		};
		
		 timer1.schedule(tarea1,2000,5000); //Param 1 la tarea, lo que tarda en ejecutarse por primera vez, param 3 el delay (param2 y 3 en millisecs)
	}
	
	
	
	
	
	
	
	public void TiempoJuego() { //El juego va a pedir que sobrevivas cierto tiempo para ser completado, este método determina el tiempo que llevas jugando (objetivo 2 mins)
		Timer timer2=new Timer(); //con esta clase creas el timer para una tarea
		
		TimerTask tarea2=new TimerTask() { //Con esta clase se establece la tarea que quieres ejecutar con el timer

	
			public void run() { //Método abstracto que crea la tarea
				
				completado=true;
				System.out.println("Tamagochi completado");
				timer2.cancel();
			}
		};
		timer2.schedule(tarea2,120000);//60 000 millisecs=1min-> 120 000 millisecs=2mins
	}
	
	
	
	
	
	
	
	public void RecargaStats() {  //Esta función va a recargar las estadisticas dependiendo de un valor introducido por el usuario

        nombre = JOptionPane.showInputDialog("Introduce nombre del tamagochi para empezar:");
        
        TiempoJuego();
        TimerVida();
 
        	while (vivo==true && completado==false) {
        		
        		System.out.print("Puedes realizar una acción: ");
        		System.out.println("\n🌈 ¿Qué quieres hacer con " + nombre + "?");
        		System.out.println("1. Alimentar 🍎");
        		System.out.println("2. Jugar 🎾");
        		System.out.println("3. Dormir 💤");
        		System.out.println("4. Ver estado 🧐");
        		System.out.println("5. Salir 🚪");

        		
        		String opcion = JOptionPane.showInputDialog("Introduce tu acción:");
        		if(opcion.equals("1")==false && opcion.equals("2")==false && opcion.equals("3")==false && opcion.equals("4")==false && opcion.equals("5")==false) {
        			opcion="4";     //Este if es para que si introduce una opción que no está contemplada, la va a transformar en un 4 (muestra las estadísticas del tamagochi)
        		}
        		int opcionInteger=Integer.parseInt(opcion); //Convierte la variable opcion a entero

        		switch (opcionInteger) {
                	case 1 : 
                		if(comida>=0 && comida<=70) {
                			comida+=30;
                			System.out.println("----------------------------------------------------------------------");
                			System.out.println("Alimentación completada, tienes que esperar para realizar otra acción");
                    		try {Thread.sleep(4000);}//Para que el usuario solo pueda meter una opción cada 2 seg, evitando spameo
            				catch (InterruptedException e) {e.printStackTrace();} 
                		}
                		else {
                			System.out.println("----------------------------------------------------------------------");
                			System.out.println("No puedes alimentar a "+nombre+" en este momento (comida<70)");
                		}
                		break;
                
                	case 2 : 
                		if(felicidad>=0 && felicidad<=60) {
                			energia-=10; 
                			comida-=5;
                			felicidad +=40; 
                			System.out.println("----------------------------------------------------------------------");
                			System.out.println(nombre+" ha jugado ,tienes que esperar para realizar otra acción");
                    		try {Thread.sleep(4000);}//Para que el usuario solo pueda meter una opción cada 2 seg, evitando spameo
            				catch (InterruptedException e) {e.printStackTrace();} 
                		}
                		else {
                			System.out.println("----------------------------------------------------------------------");
                			System.out.println("No puedes hacer feliz a "+nombre+" en este momento (felicidad<=60)");
                		}
                		break;
                
                	case 3 : 
                		if(energia>=0 && energia<=50) {
                			energia+=50;
                			comida-=10;
                			felicidad-=5;
                			System.out.println("----------------------------------------------------------------------");
                			System.out.println(nombre+" ha dormido,tienes que esperar para realizar otra acción");
                    		try {Thread.sleep(4000);}//Para que el usuario solo pueda meter una opción cada 2 seg, evitando spameo
            				catch (InterruptedException e) {e.printStackTrace();} 
                		}
                		else {
                			System.out.println("----------------------------------------------------------------------");
                			System.out.println(nombre+" no tiene sueño en este momento (energía<=50)");
                			}
                		break;
                
                	case 4 : 
                		System.out.println("----------------------------------------------------------------------");
                		System.out.println("Estado de: "+nombre+", comida: "+comida+", felicidad: "+ felicidad+", energía: "+energia);
                		break;
                
                	case 5: {
                		System.out.println("Saliendo del juego...");
                		vivo=false; //Para poder salir del bucle
                		return;
                	}
                	default: System.out.println("Opción no válida. Intenta de nuevo.");
                	break;
        		}//cierre switch
        	}//cierre while
       
		}//cierre método
	
	
	
	
	
}
