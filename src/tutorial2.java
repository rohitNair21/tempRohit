import java.util.Arrays;
import java.util.Scanner;

public class tutorial2 {
    public static int[][] createBoard(int rows, int columns)
    {
        int[][] gameBoard = new int[rows][columns];
        return gameBoard;
    }

    public static int rowsIn(int[][] board) {
        return board.length;
    }

    //columnsIn
    public static int columnsIn(int[][] board) {
        return board[0].length;
    }
    public static boolean row(int[][] board, int row, int piece)
    {
        System.out.println(Arrays.toString(board[row]));
        System.out.println(board[row][3]);
        System.out.println(board[row].length);
        return true;
    }

    public static boolean winInRow(int[][] board, int row, int piece)
    {
        for(int x = 0; x < board[row].length-2; x++) //Since the size of the board can be up to 5x5, we have to iterate twice to check all possible row combinations
        {
            if(board[row][0+x] == piece && board[row][1+x] == piece && board[row][2+x] == piece)
            {
                return true;
            }
        }
        return false;
    }
    public static boolean winInColumn(int[][] board, int column, int piece) {
        int[] storage = new int[5];
        {
            for (int y = 0; y <= board.length - 1; y++) {
                storage[y] = board[y][column];
            }
            for (int x = 0; x < 4; x++) //Since the size of the board can be up to 5x5, we have to iterate twice to check all possible row combinations
            {
                if (storage[0 + x] == piece && storage[1 + x] == piece && storage[2 + x] == piece) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean winInDiagonalBS(int[][] board, int piece)
    {
        for(int x = 0; x <= board.length-3; x++)
        {
            for(int y = 0; y <= board[0].length-3; y++)
            {
                if(board[x][y] == piece && board[x+1][y+1] == piece && board[x+2][y+2] == piece)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean winInDiagonalFS(int[][] board, int piece)
    {
        for(int x = board.length-1; x >= board.length-2; x--)
        {
            for(int y = 0; y <= board[0].length-3; y++)
            {
                if(board[x][y] == piece && board[x-1][y+1] == piece && board[x-2][y+2] == piece)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean full(int[][] board) {
        for (int x = 0; x <= board.length - 1; x++) {
            for (int y = 0; y <= board[0].length - 1; y++) {
                if (board[x][y] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] board = {{1,0,0,1}, {0,0,1,0}, {0,1,0,0}};
        //System.out.println(Arrays.deepToString(createBoard(5,12)));
        //System.out.println(rowsIn(board));
        //System.out.println(columnsIn(board));
        //System.out.println(winInColumn(board, 4, 2));
        System.out.println(winInDiagonalFS(board, 2));
        System.out.println(full(board));p
    }
}
