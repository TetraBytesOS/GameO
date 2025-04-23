package univerisdadProgramacion;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Cueva  {
    private static Timer miTimer;

    public static void music(){
        miTimer = new Timer();
        TimerTask task= new TimerTask() {
            @Override
            public void run() {
                ReproductorSonido.reproducir("/univerisdadProgramacion/sonidos/dripping-water-in-cave-114694.wav");
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
    	Imagenes.setImagen("src/univerisdadProgramacion/npc4.png");
    	Textos.setTexto("");
    	Marcos miMarcoNPC=new Marcos();
    	do {
        System.out.println(" Que vas a hacer? ");
        System.out.println("1. Hablar con el ser");
        System.out.println("2. Analizar tus alrededores");
        System.out.println("3. Minijuego (Después del primer intento sales del programa completo, así que buena suerte) ");
        System.out.println("4. Irte a otra zona");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Este es el minijuego final,\nsi has acabado de explorar adelante,\nsolo tendrás una oportunidad para superarlo");
                ReproductorSonido.reproducir("/univerisdadProgramacion/sonidos/ttsmaker-file-2025-4-21-22-13-51.wav");
                break;
            case 2:
                System.out.println("observaste enhorabuena");
                break;
            case 3:
                stopMusic();
            	miMarcoNPC.dispose();
            	Imagenes.setImagen("src/univerisdadProgramacion/pezTama.jpg");
            	Marcos miMarco=new Marcos();
                Tamagochi elBicho=new Tamagochi(miMarco);
            	break;
            case 4:
                System.out.println("Estas son las diferentes zonas a las que puedes ir:");
                System.out.println("1. Base");
                System.out.println("2. Playa");
                System.out.println("3. Océano");

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
                        ParaintegrarYina.show();
                        break;
                 
                }

        }
        
        }while(choice==1 || choice==2 || choice==3);
    }

}


