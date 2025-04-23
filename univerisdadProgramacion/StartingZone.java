package univerisdadProgramacion;


import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class StartingZone {
    private static Timer miTimer;

    public static void music(){
        miTimer = new Timer();
        TimerTask task= new TimerTask() {
            @Override
            public void run() {
                ReproductorSonido.reproducir("/univerisdadProgramacion/sonidos/birds-chirping-ambiance-26052.wav");
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
    public static void show() {
        music();
    	int choice=0;
    	Imagenes.setImagen("src/univerisdadProgramacion/npc1.png");
    	Textos.setTexto("");
    	Marcos miMarco=new Marcos();
  
    	do {
        System.out.println("Que vas a hacer? ");
        System.out.println("1. Hablar con el ser");
        System.out.println("2. Analizar tus alrededores");
        System.out.println("3. Irte a otra zona");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Bienvenido a este juego de mundo libre, explora todo lo que quieras");
                ReproductorSonido.reproducir("/univerisdadProgramacion/sonidos/ttsmaker-file-2025-4-21-22-15-47.wav");
                break;
            case 2:
                System.out.println("observaste enhorabuena");
                break;
            case 3:
                System.out.println("Estas son las diferentes zonas a las que puedes it:");
                System.out.println("1. Playa");
                System.out.println("2. Cueva");
                System.out.println("3. Océano");
              
                int choice2 = input.nextInt();
                switch (choice2) {
                    case 1:
                        stopMusic();
                    	miMarco.dispose();
                        Playa.show();
                        break;
                    case 2:
                        stopMusic();
                    	miMarco.dispose();
                        Cueva.show();
                        break;
                    case 3:
                        stopMusic();
                    	miMarco.dispose();
                        ParaintegrarYina.show();
                        break;
                 
                }
        }
        
        }while(choice==1 || choice==2 || choice==3);
    }

}