package univerisdadProgramacion;

import java.util.Scanner; /* Contiene la lógica del juego con ArrayList, océano, obstáculos y 
comida  y la libreria Scanner se usa para leer la entrada del usuario desde el teclado.*/

import java.util.ArrayList; /* ArrayList es una lista dinámica que puede crecer o reducirse automáticamente, 
a diferencia de los arreglos (arrays), que tienen un tamaño fijo.*/
import java.util.Timer;
import java.util.TimerTask;

public class JuegoPezGlobo { /*defino el tamaño del oceano */
    private static final int FILAS = 5; /*representacion del aceano con filas y columnas */
    private static final int COLUMNAS = 5;
    private ArrayList<ArrayList<Character>> oceano; /*representacion del oceano usando una lista de listas */
    private int pezFila, pezColumna; /*posiciones del pez globo dentro del oceano */
    private int comidaFila, comidaColumna;/*posiciones de la comida dentro del oceano */
    private ArrayList<int[]> obstaculos; /*Lista de obstáculos (coordenadas de las celdas donde hay obstáculos) */
    private Marcos miMarco=new Marcos();

    private static Timer miTimer;

    public static void music(){
        miTimer = new Timer();
        TimerTask task= new TimerTask() {
            @Override
            public void run() {
                ReproductorSonido.reproducir("/univerisdadProgramacion/sonidos/loop-air-bubbles-159283.wav");
            }
        };
        miTimer.schedule(task, 0, 6000);
    }

    public static void stopMusic() {
        if (miTimer != null) {
            miTimer.cancel(); // Cancela el Timer para detener la música
            miTimer = null;
        }
    }

    public JuegoPezGlobo() { /*Constructor del juego. Llama al método `inicializarMapa() para crear el océano con el pez, obstáculos y comida. */
    	inicializarMapa();
    } 
    /* Se Inicializa el mapa del océano con los siguientes elementos:
     Agua ('-') en todas las celdas.
     El pez globo ('P') en la posición inicial.
     Obstáculos ('X') en posiciones estratégicas.
     La comida ('C') en una posición fija. */
    
    private void inicializarMapa() {
        oceano = new ArrayList<>();

        /*Llenar el océano con agua representada por '-'*/

        for (int i = 0; i < FILAS; i++) {
            ArrayList<Character> fila = new ArrayList<>();
            for (int j = 0; j < COLUMNAS; j++) {
                fila.add('-');
            }
            oceano.add(fila);
        }

        /*Posición inicial del pez globo (P)*/
        pezFila = 0;
        pezColumna = 0;
        oceano.get(pezFila).set(pezColumna, 'P');

        /* Lista de obstáculos  en posiciones fijas (X)*/
        obstaculos = new ArrayList<>();
        agregarObstaculo(1, 2);
        agregarObstaculo(2, 2);
        agregarObstaculo(3, 1);
        agregarObstaculo(4, 3);

        /* Colocar la comida en una Posición especifica (C)*/
        comidaFila = 4;
        comidaColumna = 4;
        oceano.get(comidaFila).set(comidaColumna, 'C');
    }

    private void agregarObstaculo(int fila, int columna) { /* Se Agrega un obstáculo ('X') en una posición dada dentro del océano.
    param fila     Coordenada de fila donde se colocará el obstáculo, param columna  Coordenada de columna donde se colocará el obstáculo.
        */
        oceano.get(fila).set(columna, 'X');/*Coloca el obstáculo en la matriz */
        obstaculos.add(new int[]{fila, columna});/* Guarda la posición en la lista de obstáculos */
    }

    public void mostrarMapa() { /* Se Muestra en computador la representación actual del océano. */
        for (ArrayList<Character> fila : oceano) { /*Itera sobre cada fila del océano */
            for (Character celda : fila) { /*Itera sobre cada celda de la fila */
                System.out.print(celda + " ");/*Imprime la celda seguida de un espacio */
            }
            System.out.println();/*Salto de linea para la siguiente fila */
        }
    }

    public void iniciar() {
        music();
        /* Método principal del juego: permite al usuario mover el pez globo hasta encontrar la comida:Se muestra el océano en la consola.
     -El usuario ingresa un movimiento con W, A, S, D.
     -Se verifica si el movimiento es válido.
     -Si el pez llega a la comida ('C'), el juego termina. */
        Scanner scanner = new Scanner(System.in); /*Se crea un objeto Scanner para leer la entrada del usuario*/

        while (true) {/*Muestra el estado actual del océano */
            mostrarMapa();
            Textos.setTexto("Mueve el pez globo usando la consola de abajo con W (arriba), A (izquierda), S (abajo), D (derecha): \n(pez globo P, obstáculo X, comida C)"); 
            Imagenes.setImagen("src/univerisdadProgramacion/elLaberinto.jpg");
            miMarco.repaint();
            char movimiento = scanner.next().toUpperCase().charAt(0);/*Lee el movimiento del usuario*/

            System.out.println("\n\n\n\n\n\n\n\n"); //evita que se muestre la posicion anterior por consola
            if (moverPez(movimiento)) { /*Si el movimiento es valido */
                System.out.println("Movimiento exitoso!");
            } else {
                System.out.println("Movimiento inválido! Hay un obstáculo o estás fuera del mapa.");
            }

            /*Verificar si el pez ha llegado a la comida*/
            if (pezFila == comidaFila && pezColumna == comidaColumna) {
                mostrarMapa();
                System.out.println("¡Felicidades! El pez globo encontró la comida. ¡Ganaste!");
                miMarco.dispose();
                stopMusic();
                break;
            }
        }
    }

    private boolean moverPez(char direccion) {
        /* Mueve el pez globo en la dirección indicada por el usuario.param direccion Letra ingresada por el usuario (W, A, S, D), return `true` 
        si el movimiento fue exitoso, `false` si es inválido. */
        int nuevaFila = pezFila;
        int nuevaColumna = pezColumna;

        switch (direccion) { /*Determinar la nueva posición según la dirección ingresada */
            case 'W': nuevaFila--; break; /* Arriba*/
            case 'S': nuevaFila++; break; /* Abajo*/
            case 'A': nuevaColumna--; break; /* Izquierda*/
            case 'D': nuevaColumna++; break; /*Derecha*/
            default:
                System.out.println("Entrada inválida. Usa W, A, S o D.");
                return false;
        }

        /* Verificar límites y obstáculos*/
        if (esMovimientoValido(nuevaFila, nuevaColumna)) {
            oceano.get(pezFila).set(pezColumna, '-'); /*  Borrar la posición anterior del pez*/
            pezFila = nuevaFila;
            pezColumna = nuevaColumna;
            oceano.get(pezFila).set(pezColumna, 'P'); /*Actualiza a la Nueva posición del pez*/
            return true;
        }
        return false;/*movimiento invalido, aqui se verifica si el movimiento a una nueva posición es válido.
        @param fila     Nueva coordenada de fila.
        @param columna  Nueva coordenada de columna.
        return `true` si el movimiento es válido, `false` si hay un obstáculo o está fuera del mapa.
        */ 
    }

    private boolean esMovimientoValido(int fila, int columna) {
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            return false; /* Verifica si esta Fuera de los límites del oceano*/
        }
        for (int[] obstaculo : obstaculos) {/*Verificar si hay un obstáculo en la posición deseada */
            if (obstaculo[0] == fila && obstaculo[1] == columna) {
                return false; /*Choca con un obstáculo*/
            }
        }
        return true; /*movimiento valido */
    }
}