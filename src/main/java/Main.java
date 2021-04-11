import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        int[] array1 = getFilledArray(10, input, ( ind, mode ) -> ind + mode);
        printArray(array1);

        int[] array2 = getFilledArray(10, input, ( ind, mode ) -> ind * mode);
        printArray(array2);

        int[] array3 = getFilledArray(10, input, ( ind, mode ) -> ind % 2 == 0 ? ind/2 + mode : ind * ind - mode);
        printArray(array3);

        // элемент = сумма квадратов индекса и модификатора
        int[] array4 = getFilledArray(10, input, ( ind, mode ) -> ind * ind + mode * mode);
        printArray(array4);

        // элемент = индекс делится на  3 -> 3*мод, индекс делится на 2 -> 2*мод, иначе 10*мод
        int[] array5 = getFilledArray(10, input, ( ind, mode ) -> ind % 3 == 0 ? 3*mode : ind % 2 == 0 ? 2*mode : 10*mode);
        printArray(array5);
    }

    private static int[] getFilledArray(int size, int mode, ArrayElementGenerator generator ) {
        int[] result = new int[size];
        for ( int i = 0; i < size; ++i )
            result[i] = generator.process( i, mode );

        return result;
    }

    private static void printArray( int[] array ) {
        for ( int i = 0; i < array.length; ++i )
            System.out.print( array[i] + ", " );
        System.out.print( '\n' );
    }
}
