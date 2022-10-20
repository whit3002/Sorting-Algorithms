/* Whitney Humecky
 * CS 3345.0U2
 * Project 2 driver class
 */

public class HumeckyProject2 {
    public static void main(String[] args) {

        Integer[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
        Integer[] array2 = { 1000, 2, 332, 4, 58, 600, 74, 8, 9, 0,
                19, 47, 22, 66, 900, 573, 673, 234, 543 };
        Integer[] array3 = { 10, 9, 8, 7, 6, 5, 1, 2, 3, 4, 12, 18, 16, 17 };
        Integer[] array4 = { 12, 9, 10 };
        Integer[] array5 = { 9, 1, 8, 2, 7, 3, 6, 4, 5, 9, 1, 8, 2, 7, 3, 6, 4, 5 };
        Integer[] array6 = { 100, 50, 90, 40, 80, 30, 70, 20, 10, 60 };

        System.out.println("Trial 1:");
        new SortClass(array1);

        System.out.println("\nTrial 2:");
        new SortClass(array2);

        System.out.println("\nTrial 3:");
        new SortClass(array3);

        System.out.println("\nTrial 4:");
        new SortClass(array4);

        System.out.println("\nTrial 5:");
        new SortClass(array5);

        System.out.println("\nTrial 6:");
        new SortClass(array6);
    }
}