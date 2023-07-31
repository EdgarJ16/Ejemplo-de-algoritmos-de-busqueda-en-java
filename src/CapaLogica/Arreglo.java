/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import java.util.Random;

/**
 *
 * @author edgar
 */
public class Arreglo {

//ENCAPSULAMIENTO
    private double vector[] = new double[1000];

    private Random random = new Random();
//METODOS DE CLASE

    public void generaArreglo() {
        for (int i = 0; i < vector.length; i++) {
            double Double = (random.nextDouble()*10001);
            vector[i] = Double;

        }
    }
//SETTERS Y GETTERS
    //Getter arreglo 

    public double[] getArreglo() {
        return vector;
    }

//METODO PARA IMPRIMIR ARREGLO EN UN JTEXTAREA 
    public String getVectorValues() {

        StringBuilder values = new StringBuilder();
        double[] vector = getArreglo();

        if (vector != null) {
            for (double value : getArreglo()) {
                values.append(value).append(" | ");
            }
        }
        return values.toString();
    }

//METODO SHELLSORT
    //OBTENIDO DE ESTRUCTURAS DE DATOS JAVA 4ta EDICION Mark Allen Weiss
    public void shellSort(double vector[]) {

        for (int espacio = vector.length / 2; espacio > 0; espacio = espacio == 2 ? 1 : (int) (espacio / 2.2)) {
            for (int i = espacio; i < vector.length; i++) {
                Double temporal = vector[i];
                int j = i;
                for (; j >= espacio && temporal.compareTo(vector[j - espacio]) < 0; j -= espacio) {
                    vector[j] = vector[j - espacio];
                }
                vector[j] = temporal;

            }
        }
    }

    //METODO QUICK SORT 
    //ALGORITNMO OBTENIDO DE LA PAGINA  
    // "http://www.vogella.com/articles/JavaAlgorithmsQuicksort/article.html"
    // >http://www.vogella.com/articles/JavaAlgorithmsQuicksort/article.html<a>
    public void quickSort(double[] array, int izquierdo, int derecho) {
        int i = izquierdo, j = derecho; //PUNTEROS QUE COMPARAN ELVALOR CON EL PIVOTE
        // EN CUANTO AL PIVOTE (VALOR EL CUAL SE USA PARA COMPARAR LOS VALORES DE LOS PUNTEROS)
        //LO MAS RECOMENDABLE ES USAR UN VALOR MEDIO PARA EVITAR EL PEOR CASO (On2)
        double pivot = array[izquierdo + (derecho - izquierdo) / 2];

        //SE PARTE EL VECTOR EN 2
        double cambio;
        while (i <= j) {

            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                cambio = array[i];
                array[i] = array[j];
                array[j] = cambio;
                i++;
                j--;
            }
        }
        // SE APLICA RECURSIVIDAD PARA TRATAR LAS PARTICIONES CREADAS
        if (izquierdo < j) {
            quickSort(array, izquierdo, j);
        }
        if (i < derecho) {
            quickSort(array, i, derecho);
        }
    }
//  METODO DE ORDENAMIENTO BURBUJA
    
    public void bubbleSort(double vector[]) {
        double temp;
        
        for (int i = 0; i < vector.length; i++) {
            
            for (int j = 1; j < (vector.length - i); j++) {
                
                if (vector[j-1] > vector[j]) {
                    //SE REALIZA EL CAMBIO EN EL VECTOR
                    temp = vector[j - 1];
                    vector[j - 1] = vector[j];
                    vector[j] = temp;
                }
            }
        }

    }

}
