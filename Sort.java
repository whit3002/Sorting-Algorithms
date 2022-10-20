/* Whitney Humecky
 * CS 3345.0U2
 * Project 2 sorting class
 */

 import java.math.*;

public class Sort {
    sort() {
        
    }
    sort(int[] array){

    }

    //Implement mergesort algorithm.

    void mergesort(Integer[] array){

        int size1 = array.length;

        int[] arrayA = new int[size1];
        int temp, m, k, i;
        int countLeft = 0, countRight = size1 / 2;

        //compare 0, 1 | 2, 3 | ... | n - 1, n
        //compare 0, 1, 2, 3 | ... | n - 3, n - 2, n - 1, n
        while (i < Math.log(size1)){

            //compare singles
            for(int j = 0; j < size1; j++){
                if(array[j] > array[++j]){
                    temp = array[j - 1];
                    array[j] = temp;
                }
            }

            //compare pairs
            int count1 = (int) (0 + Math.pow(2, i)), count2 = (int) (3 + Math.pow(2, i));
            if(array[k] > array[m]){
                temp = array[k];
                array[k] = array[m];
                
            }
        }

        //compare pair A to pair B with counters
        //logN sets


        //Print sorted array
        for(i = 0; i < array.length; i++)
            System.out.print(array[i]);
    }

    //Implement quicksort with median-of-three partitioning and a cutoff of 15

    void quicksort(Integer[] array, int left, int right){
        int size = array.length;

        if (left + 15 <= right){ 
            Integer pivot = median(array[left], array[right], array[(left + right) / 2]);
            int i = left, j = right - 1;
            for(    ;   ;   ){
                while(array[++i].compareTo(pivot) < 0){}
                while(array[--j].compareTo(pivot) > 0){}
                if(i < j){ // swap
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                else
                    break;
            }

            // Correct pivot
            int temp = array[i];
            array[i] = array[right - 1];
            array[right - 1] = temp;

            quicksort(array, left, i - 1); // sort elements less than pivot
            quicksort(array, i + 1, right); // sort greater elements
        }
        else { // utilize an insertion sort
            insertionSort();
        }
        
        
        for(int i = 0; i < size; i++)
            System.out.print(array[i]);
    }

    void insertionSort(){

    }

    int median(int a, int b, int c){
        if(a < b && b < c || c < b && b < a){
            return b;
        }
        else if(a < c && c < b || b < c && c < a){
            return c;
        }
        else if (b < a && a < c || c < a && a < b){
            return a;
        }
    }
 }