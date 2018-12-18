package hw2;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;
import edu.princeton.cs.introcs.StdOut;
import java.lang.Math;

public class PercolationStats {

    private int test_num;
    private int[] experiments_results;

    //perform T independent experiments
    public PercolationStats(int N, int T, PercolationFactory pf){
        if(N < 1 || T < 1) {
            throw new java.lang.IllegalArgumentException();
        }
        test_num = T;
        experiments_results = new int[test_num];
        for(int i = 0; i < T; i++){
            experiments_results[i] = experiment(pf.make(N));
        }
    }

    private int experiment(Percolation p){
        //PercolationVisualizer.draw(p, p.getSize());
        while(p.percolates() == false){
            int x = StdRandom.uniform(p.getSize()*p.getSize());
            int row = x / p.getSize();
            int col = x % p.getSize();
            while(p.isOpen(row, col)){
                x = StdRandom.uniform(p.getSize()*p.getSize());
                row = x / p.getSize();
                col = x % p.getSize();
            }
            p.open(row, col);
            //PercolationVisualizer.draw(p, p.getSize());
        }
        return p.numberOfOpenSites();
    }

    //sample mean of percolation shreshold
    public double mean(){
        return StdStats.mean(experiments_results);
    }
    //sample standard deviation
    public double stddev(){
        return StdStats.stddev(experiments_results);
    }

    public double confidenceLow(){
        return mean() - (1.96*stddev() / Math.sqrt(test_num));
    }

    public double confidenceHigh(){
        return mean() + (1.96*stddev() / Math.sqrt(test_num));
    }
}
