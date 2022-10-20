
/* Whitney Humecky
 * CS 3345.0U2
 * Project 2 sorting class
 */
import java.math.*;

public class SortClass {
    SortClass() {
    }

    SortClass(Integer[] array) {
        int size = array.length;
        System.out.println("Size: " + size);

        // Copy array so sorts occur independently
        Integer[] arrayA = new Integer[size];
        for (int j = 0; j < size; j++)
            arrayA[j] = array[j];

        // Create empty array for merge sort use
        Integer[] array2 = new Integer[size];

        System.out.println("\nMergeSort: \nNumber of operations "
                + mergeSort(array, array2, 0, size - 1, 0));

        for (int k = 0; k < size; k++)
            System.out.print(array[k] + ", ");

        System.out.println();

        // Conduct quick sort with copy of original array

        System.out.println("\nQuickSort: \nNumber of operations "
                + quicksort(arrayA, 0, size - 1, 0));

        for (int i = 0; i < size; i++)
            System.out.print(arrayA[i] + ", ");

        System.out.println();

    }

    // Merge() compares the smallest element of 2 sub-arrays to determine the
    // correct order of insertion into a secondary array
    // Paramaters include original array, secondary array,
    // begining index of 2 subarrays (left and right), and the last
    // element of second subarray rightEnd

    void merge(Integer[] array, Integer[] array2, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int pos = left; // current index in array2
        int num = rightEnd - left + 1; // num of elements to be compared

        // compare smallest elements and insert to array

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left].compareTo(array[right]) < 0)
                array2[pos++] = array[left++];
            else
                array2[pos++] = array[right++];
        }

        // when 1 subarray has been completely copied to the second array
        // finish copying the rest of the elements from the other subarray

        while (left <= leftEnd)
            array2[pos++] = array[left++];

        while (right <= rightEnd)
            array2[pos++] = array[right++];

        // Copy second array back into original array

        for (int i = 0; i < num; i++, rightEnd--) {
            array[rightEnd] = array2[rightEnd];
        }
    }

    // mergeSort() recusrsively calls until subarrays are of length 1
    // calls merge() to compare and merge adjacent subarrays until
    // all subarrays have been sorted into the original, complete array
    // left and right begin as the first index of 2 adjacent subarrays
    // n counts how many sorting operations are needed to sort an
    // array (for time analysis)
    // Sorting operations are generally loops that reorganize elements
    // count the number of times a loop is initiall called -
    // not every iteration of the loop for a general comparison

    int mergeSort(Integer[] array, Integer[] array2,
            int left, int right, int n) {
        if (left < right) {
            int center = (left + right) / 2;
            n = 1 + mergeSort(array, array2, left, center, n);
            n = 1 + mergeSort(array, array2, center + 1, right, n);
            merge(array, array2, left, center + 1, right);
            n += 3;
        }
        return n;
    }

    // quickSort() uses median of three partitioning to determine a pivot
    // algorithm moves all elements greater than pivot to right of it, and
    // elements lesser than pivot to left of it. Array is split at pivot,
    // repeat process (recurssive calls) for less-than-pivot section and
    // greater-than
    // section. n counts the number of sort operations for time analysis

    int quicksort(Integer[] array, int left, int right, int n) {

        
        if (left + 15 < right) {
            Integer pivot = median(array, left, right, (left + right) / 2);
            n += 2;
            int temp;
            int i = left, j = right - 1;

            n++;
            for (;;) { // move all elements greater than pivot to r
                while (array[++i].compareTo((int) pivot) <= 0) {
                } // stops counting when an element is greater than pivot
                while (array[--j].compareTo((int) pivot) >= 0) {
                } // stops counting when an element is lesser than pivot

                if (i < j) {
                    // swap
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                } else {
                    break;
                }

            }

            // pivot is at array[i], exclude from subarrays

            n = 1 + quicksort(array, left, i - 1, n); // sort elements less than pivot
            n = 1 + quicksort(array, i + 1, right, n); // sort greater elements
        } else { // utilize an insertion sort for subarrays less than length 16
            insertionSort(array, left, right);
            n += 2;
        }

        return n;
    }

    // insertionSort() takes a subarray begining at index left, until index right
    // and performs an insertion sort, comparing each element to those before it
    // to determine its correct posiiton

    void insertionSort(Integer[] array, int left, int right) {
        int temp, i;

        for (; left <= right; left++) {
            i = left;
            while (i > 0 && array[i] < array[i - 1]) {
                temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
                i--;
            }
        }
    }

    // Method accepts the array, the begining index l of a subarray,
    // ending index r, and center index c to compare to identify
    // the median. Return median.

    Integer median(Integer[] array, int l, int r, int c) {
        Integer[] hold = { array[l], array[c], array[r] };

        insertionSort(hold, 0, 2);

        // set median (pivot, center c) to end of subarray - 1
        array[l] = hold[0];
        array[c] = array[r - 1];
        array[r - 1] = hold[1];
        array[r] = hold[2];

        return array[r - 1];
    }
}