package org.ejercicio4;
import java.util.Scanner;
import java.util.Random;
public class Main {
    

public class Ahorcado {
    private static final String[] PALABRAS = {"computadora", "programacion", "java", "openai", "ahorcado"};
    private static final int MAX_INTENTOS = 6;

    public static void main(String[] args) {
        try (Scanner Scanner = new Scanner(System.in)) {
            Random random = new Random();
            String palabraSecreta = PALABRAS[random.nextInt(PALABRAS.length)];
            char[] progreso = new char[palabraSecreta.length()];
            int intentos = 0;

            for (int i = 0; i < progreso.length; i++) {
                progreso[i] = '_';
            }

            System.out.println("Bienvenido al Juego del Ahorcado!");
            System.out.println("La palabra secreta tiene " + palabraSecreta.length() + " letras.");

            while (intentos < MAX_INTENTOS) {
                System.out.println("\nProgreso: " + String.valueOf(progreso));
                System.out.print("Ingresa una letra: ");
                char letra = Scanner.next().charAt(0);

                boolean acierto = false;
                for (int i = 0; i < palabraSecreta.length(); i++) {
                    if (palabraSecreta.charAt(i) == letra) {
                        progreso[i] = letra;
                        acierto = true;
                    }
                }

                if (!acierto) {
                    intentos++;
                    System.out.println("Incorrecto. Te quedan " + (MAX_INTENTOS - intentos) + " intentos.");
                }

                if (String.valueOf(progreso).equals(palabraSecreta)) {
                    System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
                    return;
                }
            }

            System.out.println("¡Oh no! Te has quedado sin intentos. La palabra era: " + palabraSecreta);
            
        }
    }
}
}