package univerisdadProgramacion;

import java.util.Scanner;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class JuegoSubmarino {
	private static Timer miTimer;

	public static void music(){
		miTimer = new Timer();
		TimerTask task= new TimerTask() {
			@Override
			public void run() {
				ReproductorSonido.reproducir("/univerisdadProgramacion/sonidos/sonar-ping-95840.wav");
			}
		};
		miTimer.schedule(task, 0, 3000);
	}

	public static void stopMusic() {
		if (miTimer != null) {
			miTimer.cancel(); // Cancela el Timer para detener la música
			miTimer = null;
		}
	}
	    public void Jugar() {
			music();
	        Scanner sc = new Scanner(System.in);
	        Random rand = new Random();
	        Textos.setTexto("Mueve el submarino (S) con 'a' (izquierda) o 'd' (derecha).");
	        Imagenes.setImagen("src/univerisdadProgramacion/submarino.jpg");
	        Marcos miMarco=new Marcos();
	        

	        boolean jugarDeNuevo = true;

	        while (jugarDeNuevo) {
	            int pos = 5; // posición inicial del submarino
	            int puntaje = 0;

	            System.out.println("Atrapa los tesoros (T) y evita los peces globo (P)!\n");

	            while (true) {
	                char[] linea = new char[10];
	                for (int i = 0; i < 10; i++) linea[i] = '.';

	                int obj = rand.nextInt(10);
	                boolean esTesoro = rand.nextBoolean();
	                linea[obj] = esTesoro ? 'T' : 'P';
	                linea[pos] = 'S';

	                System.out.println(new String(linea));
	                System.out.print("Mover (a/d): ");
	                String mov = sc.nextLine();

	                if (mov.equals("a") && pos > 0) pos--;
	                if (mov.equals("d") && pos < 9) pos++;

	                if (pos == obj) {
	                    if (esTesoro) {
	                        puntaje++;
	                        System.out.println("🎉 ¡Tesoro atrapado! Puntaje: " + puntaje);
	                    } else {
	                        System.out.println("💥 ¡Tocaste un pez globo! Fin del juego.");
	                        break;
	                    }
	                }
	            }

	            System.out.println("Puntaje final: " + puntaje);
	            System.out.print("¿Quieres jugar otra vez? (s/n): ");
	            String respuesta = sc.nextLine().trim().toLowerCase();
	            jugarDeNuevo = respuesta.equals("s");
	            miMarco.dispose();
				stopMusic();
	            }

	    }
	}


