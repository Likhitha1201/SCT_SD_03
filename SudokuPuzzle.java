/*** 
    @Author: Likhitha S
    @Date: 06-01-2025 14:30
    @Last Modified by: Likhitha S
    @Last Modified time: 07-01-2025 12:30
    @Title: Create a program that solves sudoku puzzles automatically. The program should take an input grid representing an un solved sudoku puzzle and use an algorithm to fill in the missing numbers.

*/


class SudokuPuzzles{

    /***
     
            Description: 
                This methods are used to solve the sudoku game.
            Parameters: 
                here, 2D array will be acting as a parameter which has to be solved further. 
            return:
                It gives the solution for grid, if not possible then it prints regrate message.

     */


    static final int SIZE = 9;

    static boolean solveGrid(int[][] grid){
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] == 0) { 
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(grid, row, col, num)) {
                            grid[row][col] = num; // Place the number

                            if (solveGrid(grid)) {
                                return true;
                            }

                            grid[row][col] = 0; 
                        }
                    }
                    return false; 
                }
            }
        }
        return true; 
     }

    private static boolean isValid(int[][] grid, int row, int col, int num) {
     
        for (int x = 0; x < SIZE; x++) {
            if (grid[row][x] == num) {
                return false;
            }
        }

        for (int x = 0; x < SIZE; x++) {
            if (grid[x][col] == num) {
                return false;
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true; 
    }

    static void finalGrid(int[][] grid){
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
     }
  public static void main(String[] args){
    int[][] grid={
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    boolean fullyGrid=solveGrid(grid);
    if(fullyGrid){
        System.out.println("puzzle solved sucessfully..!!!\n");
        finalGrid(grid);
    }
    else{
        System.out.println("Solution not found..???");
    }
  }
}