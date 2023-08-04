// MergeSort, Cormen

public class jMS_algorithm {
    
    public static void MergeSort(int[] A, int p, int r) {
        if (p >= r) {
            return;
        }
        else {
            int q = (p+r)/2;

            MergeSort(A, p, q);
            MergeSort(A, q+1, r);
            Merge(A, p, q, r);
        }
    }

    public static void Merge (int[] A, int p, int q, int r) {
        int nL = q - p + 1;
        int nR = r - q;

        int[] L = new int[nL];
        int[] R = new int[nR];

        for (int i=0; i<nL; i++) {
            L[i] = A[p+i];
        }
        for (int j=0; j<nR; j++) {
            R[j] = A[q+j+1];
        }

        int i = 0;
        int j = 0;
        int k = p;

        while ((i < nL) && (j < nR)) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            }
            else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < nL) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < nR) {
            A[k] = R[j];
            j++;
            k++;
        }
    } 
    
    public static void swap(int [] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        int[] A = { 64, 34, 25, 12, 22, 11, 90, 30 };
        int n = A.length;

        System.out.println("Unsorted array:");
        printArray(A);

        MergeSort(A, 0, n - 1);

        System.out.println("\nSorted array:");
        printArray(A);
    }
            
}
