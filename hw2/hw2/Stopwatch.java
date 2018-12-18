package hw2;
import edu.princeton.cs.introcs.StdOut;

/******************************************************************************
 *  Compilation:  javac Stopwatch.java
 *  Execution:    java Stopwatch n
 *  Dependencies: none
 *
 *  A utility class to measure the running time (wall clock) of a program.
 *
 *  % java8 Stopwatch 100000000
 *  6.666667e+11  0.5820 seconds
 *  6.666667e+11  8.4530 seconds
 *
 ******************************************************************************/

/**
 *  The {@code Stopwatch} data type is for measuring
 *  the time that elapses between the start and end of a
 *  programming task (wall-clock time).
 *
 *  See  for a version that measures CPU time.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */


public class Stopwatch {

    private final long start;

    /**
     * Initializes a new stopwatch.
     */
    public Stopwatch() {
        start = System.currentTimeMillis();
    }


    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }


    /**
     * Unit tests the {@code Stopwatch} data type.
     * Takes a command-line argument {@code n} and computes the
     * sum of the square roots of the first {@code n} positive integers,
     * first using {@code Math.sqrt()}, then using {@code Math.pow()}.
     * It prints to standard output the sum and the amount of time to
     * compute the sum. Note that the discrete sum can be approximated by
     * an integral - the sum should be approximately 2/3 * (n^(3/2) - 1).
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // sum of square roots of integers from 1 to n using Math.sqrt(x).
        Stopwatch timer1 = new Stopwatch();
        double sum1 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum1 += Math.sqrt(i);
        }
        double time1 = timer1.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum1, time1);

        // sum of square roots of integers from 1 to n using Math.pow(x, 0.5).
        Stopwatch timer2 = new Stopwatch();
        double sum2 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum2 += Math.pow(i, 0.5);
        }
        double time2 = timer2.elapsedTime();
        // PercolationStats test = new PercolationStats(5, 1, new PercolationFactory());
        StdOut.printf("%e (%.2f seconds)\n", sum2, time2);


        double low, high;

        Stopwatch timer3 = new Stopwatch();
        PercolationStats ps = new PercolationStats(30, 10000, new PercolationFactory());
        low = ps.confidenceLow();
        high = ps.confidenceHigh();
        double time3 = timer3.elapsedTime();
        StdOut.printf("[%e %e] (%.2f seconds)\n",  low, high, time3);
        Stopwatch timer4 = new Stopwatch();
        ps = new PercolationStats(30, 20000, new PercolationFactory());
        low = ps.confidenceLow();
        high = ps.confidenceHigh();
        double time4 = timer4.elapsedTime();
        StdOut.printf("[%e %e] (%.2f seconds)\n",  low, high, time4);
    }
}

/*
QuickFindUF N=30 T=10000
[5.317087e+02 5.330199e+02] (2.19 seconds)
QuickFindUF N=60 T=10000
[2.131272e+03 2.134554e+03] (20.30 seconds)

WeightedQuickFindUF N=30 T=10000
[5.321220e+02 5.334394e+02] (0.61 seconds)
WeightedQuickFindUF N=60 T=10000
[2.131721e+03 2.135020e+03] (1.60 seconds)

================================================
QuickFindUF N=30 T=10000
[5.322554e+02 5.335698e+02] (2.20 seconds)
QuickFindUF N=30 T=20000
[5.322103e+02 5.331325e+02] (3.55 seconds)

WeightedQuickFindUF N=30 T=10000
[5.319078e+02 5.332366e+02] (0.66 seconds)
WeightedQuickFindUF N=30 T=20000
[5.322737e+02 5.332033e+02] (0.90 seconds)
 */