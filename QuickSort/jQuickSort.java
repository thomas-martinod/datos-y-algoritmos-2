import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;

public class jQuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the array of integers in the format [a,b,c,d,...,z]: ");
        String input = scanner.nextLine();

        // Regular expressions for extracting numbers
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(input);

        ArrayList<Integer> A_array = new ArrayList<>();

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            A_array.add(number);
        }

        int[] A = new int[A_array.size()];
        for (int i = 0; i < A_array.size(); i++) {
            A[i] = A_array.get(i);
        }

        QuickSort(A, 0, A.length - 1);

        System.out.println("\nThe ordered list of integers is: " + Arrays.toString(A));

        scanner.close();
    }

    public static void QuickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = Partition(A, p, r);
            QuickSort(A, p, q - 1);
            QuickSort(A, q + 1, r);
        }
    }

    public static int Partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        int temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;

        return i + 1;
    }
}
