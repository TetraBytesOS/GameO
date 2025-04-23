package univerisdadProgramacion;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ParaintegrarYina  {
    private static Timer miTimer;

    public static void music(){
        miTimer = new Timer();
        TimerTask task= new TimerTask() {
            @Override
            public void run() {
                ReproductorSonido.reproducir("/univerisdadProgramacion/sonidos/seagulls-74748.wav");
            }
        };
        miTimer.schedule(task, 0, 5000);
    }

    public static void stopMusic() {
        if (miTimer != null) {
            miTimer.cancel(); // Cancela el Timer para detener la música
            miTimer = null;
        }
    }
    public static void show () {
        music();
    	int choice=0;
    	Imagenes.setImagen("src/univerisdadProgramacion/npc3.png");
    	Textos.setTexto("");
    	Marcos miMarcoNPC=new Marcos();
    	do {
        System.out.println(" Que vas a hacer?");
        System.out.println("1. Hablar con el ser ");
        System.out.println("2. Analizar tus alrededores ");
        System.out.println("3. Minijuego");
        System.out.println("4. Irte a otra zona ");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
       
        switch (choice) {
            case 1:
                System.out.println("se ha perdido mi pez globo por aquí ayudameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                ReproductorSonido.reproducir("/univerisdadProgramacion/sonidos/ttsmaker-file-2025-4-21-21-14-29.wav");
                break;
            case 2:
                System.out.println("observaste enhorabuena");
                break;
            case 3:
                stopMusic();
            	PezGlobo pez = new PezGlobo("TetraByte", 1, "Pez Globo");
    	        pez.mostrarInfo(); // Método heredado de Pez
    	        pez.nadar();       // De la interfaz Nadador
    	        pez.comer();       // De la interfaz Comedor

    	        JuegoPezGlobo juego = new JuegoPezGlobo(); // Esto sigue igual
    	        juego.iniciar();
                music();
            	break;
            case 4:
                System.out.println("Estas son las diferentes zonas a las que puedes it:");
                System.out.println("1. Base");
                System.out.println("2. Playa");
                System.out.println("3. Cueva");

                int choice2 = input.nextInt();
                switch (choice2) {
                    case 1:
                        stopMusic();
                    	miMarcoNPC.dispose();
                        StartingZone.show();
                        break;
                    case 2:
                        stopMusic();
                    	miMarcoNPC.dispose();
                        Playa.show();
                        break;
                    case 3:
                        stopMusic();
                    	miMarcoNPC.dispose();
                        Cueva.show();
                        break;
                  
                }

        }
      
        }while(choice==1 || choice==2 || choice==3);
    }

}
