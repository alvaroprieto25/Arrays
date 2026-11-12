/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejerciciosclase;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author a.prietomartinbuit
 */
public class EjerciciosClase {

    public static void main(String[] args) {
        int[] numeros;

        numeros = rellenarAlAzar(10);
        System.out.println("-- Original --");
        mostrar(numeros);
        System.out.println(maximo(numeros));
        System.out.println(media(numeros));
        mostrar(invertir(numeros));
        System.out.println(buscar(numeros, 6) + "");
        System.out.println("-- Insertar --");
        mostrar(insertar(numeros, 3, 7));
        System.out.println("-- Quitar --");
        mostrar(quitar(numeros, 3));
        System.out.println("-- Rotar --");
        mostrar(rotar(numeros, 5));

        System.out.println();
        System.out.println();
        System.out.println();

        int[] tiradas = {3, 6, 1, 3, 3, 5, 2, 6, 6, 4, 1, 3, 5, 2, 6, 4, 4, 3, 1, 6};

        mostrar(frecuencias(tiradas));
        System.out.println("-- Histograma --");
        imprimirHistoriograma(frecuencias(tiradas));
        System.out.println("-- Mas frecuente --");
        System.out.println(masFrecuente(frecuencias(tiradas)));

        System.out.println();
        System.out.println();
        System.out.println();

        int[][] m = {
            {3, 8, 1},
            {4, 6, 9},
            {7, 2, 5}
        };

        int[][] m1 = {
            {3, 6, 2},
            {6, 2, 7},
            {9, 1, 5}
        };

        int[][] m2 = {
            {3, 6, 2},
            {6, 2, 7},
            {9, 1, 5}
        };

        char[][] t = {
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'O', ' ', 'X'}
        };

        imprimir(m);
        mostrar(sumaFilas(m));
        System.out.println(iguales(m1, m2));
        imprimir(tablaMultiplicar(6));
        System.out.println(hayGanador(t));

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(contarPalabras("Hola don pepito, hola don jose"));
        System.out.println((esPalindromo("ana")) ? "Sí es palíndromo" : "No es palíndromo");
        System.out.println(Arrays.toString(frecuenciaLetras("Sabes quien va ir al ignacio?")));
        System.out.println("LA letrica mas repetida es: " + letraMasFrecuente("Sabes quien va ir al ignacio?"));
    }

    public static int[] rellenarAlAzar(int tamano) {
        Random r = new Random();
        int[] nums = new int[tamano];

        for (int i = 0; i < tamano; i++) {
            nums[i] = r.nextInt(1, 10);
        }

        return nums;
    }

    public static void mostrar(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int maximo(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static double media(int[] nums) {
        double med = 0;
        for (int i = 0; i < nums.length; i++) {
            med = med + nums[i];

        }
        med = med / nums.length;
        return med;
    }

    public static int[] invertir(int[] nums) {
        int[] invertido = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            invertido[nums.length - 1 - i] = nums[i];
        }
        return invertido;
    }

    public static int contar(int[] v, int valor) {
        int manita = 0;
        for (int i = 0; i < v.length; i++) {
            if (valor == v[i]) {
                manita = manita + 1;
            }
        }
        return manita;
    }

    public static int buscar(int[] v, int valor) {
        int indice = -1;
        for (int i = 0; i < v.length; i++) {
            if (valor == v[i]) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    public static int[] insertar(int[] v, int pos, int valor) {
        int[] nuevo = new int[v.length + 1];
        for (int i = 0; i < nuevo.length; i++) {
            if (i == pos) {
                nuevo[i] = valor;
            } else if (i < pos) {
                nuevo[i] = v[i];
            } else {
                nuevo[i] = v[i - 1];
            }
        }
        return nuevo;
    }

    public static int[] quitar(int[] v, int pos) {
        int[] quitar = new int[v.length - 1];
        for (int i = 0; i < quitar.length; i++) {
            if (i < pos) {
                quitar[i] = v[i];
            } else if (i >= pos) {
                quitar[i] = v[i + 1];
            }
        }
        return quitar;
    }

    public static int[] rotar(int arr[], int k) {
        int rotado[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rotado[i] = arr[(i + k) % arr.length];
        }
        return rotado;
    }

    public static int[] frecuencias(int[] tiradas) {
        int[] pos = new int[6];
        for (int i = 0; i < pos.length; i++) {
            int contador = 0;
            for (int j = 0; j < tiradas.length; j++) {
                if (i + 1 == tiradas[j]) {
                    contador++;
                }
            }
            pos[i] = contador;
        }
        return pos;
    }

    public static void imprimirHistoriograma(int[] frec) {
        for (int i = 0; i < frec.length; i++) {
            System.out.print(i + 1 + ": ");
            for (int j = 0; j < frec[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static int masFrecuente(int[] frec) {
        int mayor = 0;
        int pos = 0;
        for (int i = 0; i < frec.length; i++) {
            if (frec[i] > mayor) {
                mayor = frec[i];
                pos = i;
            }
        }
        return pos + 1;
    }

    public static void imprimir(int[][] m) {
        for (int[] magdalena : m) {
            System.out.println(Arrays.toString(magdalena));
        }
    }

    public static int[] sumaFilas(int[][] m) {
        int[] sumas = new int[m.length];
        for (int i = 0; i < m.length; i++) {
            int sumaFila = 0;
            for (int j = 0; j < m[i].length; j++) {
                sumaFila = sumaFila + m[i][j];
            }
            sumas[i] = sumaFila;
        }
        return sumas;
    }

    public static int sumaDiagonal(int[][] m) {
        int suma = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i == j) {
                    suma += m[i][j];
                }
            }
        }
        return suma;
    }

    public static boolean iguales(int[][] m1, int[][] m2) {
        boolean sonIguales = true;
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                try {
                    if (m1[i][j] != m2[i][j]) {
                        sonIguales = false;
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    sonIguales = false;
                }
            }
        }
        return sonIguales;
    }

    public static int[][] tablaMultiplicar(int n) {
        int m[][] = new int[n][n];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (i + 1) * (j + 1);
            }
        }
        return m;
    }

    public static boolean hayGanador(char[][] m) {
        boolean ganador = false;
        if (m[0][0] == m[1][1] && m[0][0] == m[2][2]) {
            ganador = true;
        } else if (m[0][2] == m[1][1] && m[0][2] == m[2][0]) {
            ganador = true;
        }
        for (int i = 0; i < m.length - 1 && ganador == false; i++) {
            if (m[i][0] == m[i][1] && m[i][0] == m[i][2]) {
                ganador = true;
            } else if (m[0][i] == m[1][i] && m[0][i] == m[2][i]) {
                ganador = true;
            }
        }
        return ganador;
    }

    public static int contarPalabras(String frase) {
        String limpia = frase.trim();

        if (limpia.isEmpty()) {
            return 0;
        }

        return limpia.split("\\s+").length;
    }
    
    public static boolean esPalindromo(String cadena) { // Palabras capicúas
        
        String cadenaLimpia = cadena.trim(); // Quitamos los espacios
        
        String cadenaInversa = ""; // Creamos un String que almacene la palabra invertida
        
        
        for (int índice = (cadenaLimpia.length() - 1); índice >= 0 ; índice--) { // Recorremos String
            
            cadenaInversa += cadenaLimpia.charAt(índice);
            // Añadimos letras invertidas
        }
        
        return cadenaLimpia.equals(cadenaInversa);
    }
    
    public static int[] frecuenciaLetras(String frase) {
        String vocales = "abcdefghijklmnñopqrstuvwxyz";
        int[] numVoc = new int[vocales.length()];
        for(int i=0; i<frase.length(); i++){
            int aux = vocales.indexOf(frase.charAt(i));
            if(aux != -1){
                numVoc[aux] = numVoc[aux] + 1;
            }
        }
        return numVoc;
    }
    
    public static char letraMasFrecuente(String frase) {
        char[] letras = "abcdefghijklmnñopqrstuvwxyz".toCharArray();
        int maximo = 0;
        int[] veces = frecuenciaLetras(frase);
        for(int i = 0; i < veces.length; i++){
            if(veces[i] > veces[maximo]){
                maximo = i;
            }
        }
        return letras[maximo];
    }
}
