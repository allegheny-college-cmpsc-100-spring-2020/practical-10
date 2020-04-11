package practicalten;

import java.util.ArrayList;
import java.util.Random;

/** Creates an n-by-n grid of random numbers.
 *
 * @author Solutions Repository
 */
public class Grid {

  private int size;
  private int[][] grid;
  private Random fill = new Random();
  private ArrayList<Integer> used = new ArrayList<Integer>();
  
  /** Constructor.
   *
   * @param size Size of square grid
   */
  public Grid(int size) {
    this.size = size;
    grid = new int[size][size];
    for (int r = 0; r < this.grid.length; r++) {
      for (int c = 0; c < this.grid[r].length; c++) {
        this.grid[r][c] = fillValue();
      }
    }
  }
  
  /** Creates random values to fill grid.
   *
   */
  private int fillValue() {
    int number;
    do {
      number = fill.nextInt(this.size * this.size) + 1;
    } 
    while (isUsed(number));
    this.used.add(number);
    return number;
  }
  
  /** Checks if a number has already been used.
   *
   * @param value Number to check
   */
  private boolean isUsed(int value) {
    return this.used.contains(value);
  }
  
  /** Returns a searchable grid object.
   *
   */
  public int[][] getGrid() {
    return this.grid;
  }

  /** Creates a String representation of the the Grid.
   *
   */
  public String toString() {
    String display = "\t";
    for (int i = 0; i < this.grid.length; i++) {
      display += "C" + (i + 1) + "\t";
    }
    display += "\n\n";
    for (int r = 0; r < this.grid.length; r++) {
      display += "R" + (r + 1) + "\t";
      for (int c = 0; c < this.grid[r].length; c++) {
        display += this.grid[r][c] + "\t";
      }
      display += "\n";
    }
    return display;
  }
}