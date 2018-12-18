package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.QuickFindUF;

public class Percolation {

    public int getSize() {
        return size;
    }

    int size;

    private QuickFindUF sets;
    private int open_num;
    private boolean[][] grid;
    private final int TOP;
    private final int BOTTOM;

    public final boolean OPEN = true;
    public final boolean BLOCKED = false;

    public Percolation(int N) throws IllegalArgumentException {
        if(N <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        size = N;
        grid = new boolean[N][N];
        open_num = 0;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                grid[i][j] = BLOCKED;
            }
        }

        sets = new QuickFindUF(N*N + 2);
        TOP = N*N + 1;
        BOTTOM = N*N;
        for(int i = 0; i < size; i++){
            sets.union(TOP, xy2index(0, i));
            sets.union(BOTTOM, xy2index(size-1, i));
        }
    }                // create N-by-N grid, with all sites initially blocked
    public void open(int row, int col) throws ArrayIndexOutOfBoundsException {
        if(row < 0 || row >= size || col < 0 || col >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(grid[row][col] == OPEN) {
            return;
        }
        grid[row][col] = OPEN;
        open_num += 1;
        if(col-1 >= 0 && grid[row][col-1] == OPEN){
            sets.union(xy2index(row, col), xy2index(row, col-1));
        }
        if(row-1 >= 0 && grid[row-1][col] == OPEN){
            sets.union(xy2index(row, col), xy2index(row-1, col));
        }
        if(col+1 < size && grid[row][col+1] == OPEN){
            sets.union(xy2index(row, col), xy2index(row, col+1));
        }
        if(row+1 < size && grid[row+1][col] == OPEN){
            sets.union(xy2index(row, col), xy2index(row+1, col));
        }
    }       // open the site (row, col) if it is not open already
    public boolean isOpen(int row, int col) throws ArrayIndexOutOfBoundsException{
        if(row < 0 || row >= size || col < 0 || col >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return grid[row][col] == OPEN;
    }  // is the site (row, col) open?
    public boolean isFull(int row, int col) throws ArrayIndexOutOfBoundsException{
        if(row < 0 || row >= size || col < 0 || col >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return isOpen(row, col) && sets.connected(TOP, xy2index(row, col));
    }  // is the site (row, col) full?
    public int numberOfOpenSites(){
        return open_num;
    }           // number of open sites
    public boolean percolates(){
        return sets.connected(TOP, BOTTOM);
    }              // does the system percolate?
    public static void main(String[] args){

    }   // use for unit testing (not required)

    private int xy2index(int r, int c){
        return getSize() * r + c;
    }
}
