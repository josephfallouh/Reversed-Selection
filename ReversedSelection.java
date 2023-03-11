// Joseph Fallouh - 2.1 Reversed Selection - CSC-280-350

// importing libraries
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;

public class ReversedSelection {
    public static void sort(Comparable[] a) { // sorting the array
        int N = a.length;
        for (int i = 0; i < N; i++) { 
            int min = i; // index of minimal entr.
            for (int j = i+1; j < N; j++)
                if (more(a[j], a[min])) //calls the more function which is described below
                    min = j;

            exch(a, i, min);
        }
    }

    private static boolean more(Comparable v, Comparable w) { // compares two variables to see which is higher
        return v.compareTo(w) > 0; 
    }

    private static void exch(Comparable[] a, int i, int j) { // exchanges the positions of the variables in the array
        Comparable t = a[i]; 
        a[i] = a[j]; 
        a[j] = t; 
    }

    private static void show(Comparable[] a) { // Print the array, on a single line.
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) { // Test whether the array entries are in order.
        for (int i = 1; i < a.length; i++)
            if (more(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String[] args) { // Read strings from standard input, sort them, and print.
        String[] a = In.readStrings(); 
        sort(a); 
        assert isSorted(a);
        show(a);
    } 
}