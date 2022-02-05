import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    /**
     * Manually create a 2D array of 3x3 size and compare it to the one our function returns
     */
    void create_3x3_createBoard() {
        int x = 3;
        int y = 3;
        int[][] testArray = new int[3][3];
        assertTrue(Arrays.deepEquals(testArray, TicTacToe.createBoard(x,y)));
    }

    @org.junit.jupiter.api.Test
    /**
     * Manually create a 2D array of 5x5 size and compare it to the one our function returns; bigger square board than the traditional 3x3
     */
    void create_5x5_createBoard() {
        int x = 5;
        int y = 5;
        int[][] testArray = new int[5][5];
        assertTrue(Arrays.deepEquals(testArray, TicTacToe.createBoard(x,y)));
    }

    @org.junit.jupiter.api.Test
    /**
     * Manually create a 2D array of 3x5 size and compare it to the one our function returns; non-square board with more columns than rows
     */
    void create_3x5_createBoard() {
        int x = 3;
        int y = 5;
        int[][] testArray = new int[3][5];
        assertTrue(Arrays.deepEquals(testArray, TicTacToe.createBoard(x,y)));
    }

    @org.junit.jupiter.api.Test
    /**
     * Manually create a 2D array of 5x3 size and compare it to the one our function returns; non-square board with more rows than columns
     */
    void create_5x3_createBoard() {
        int x = 5;
        int y = 3;
        int[][] testArray = new int[5][3];
        assertTrue(Arrays.deepEquals(testArray, TicTacToe.createBoard(x,y)));
    }

    @org.junit.jupiter.api.Test
    /**
     * Compare the number of rows detected by rowsIn function to the expected result; non-square to differentiate between row and column return
     */
    void rowsIn_3x4() {
        int x = 3;
        int y = 4;
        int[][] testArray = new int[x][y];
        assertTrue(TicTacToe.rowsIn(testArray) == 3);
    }

    @org.junit.jupiter.api.Test
    /**
     * Compare the number of rows detected by rowsIn function to the expected result; non-square to differentiate between row and column return
     */
    void rowsIn_4x3() {
        int x = 4;
        int y = 3;
        int[][] testArray = new int[x][y];
        assertTrue(TicTacToe.rowsIn(testArray) == 4);
    }

    @org.junit.jupiter.api.Test
    /**
     * Compare the number of rows detected by rowsIn function to the expected result; non-square to differentiate between row and column return
     */
    void rowsIn_5x4() {
        int x = 5;
        int y = 4;
        int[][] testArray = new int[x][y];
        assertTrue(TicTacToe.rowsIn(testArray) == 5);
    }

    @org.junit.jupiter.api.Test
    /**
     * Compare the number of columns detected by rowsIn function to the expected result; non-square to differentiate between row and column return
     */
    void columnsIn_3x4() {
        int x = 3;
        int y = 4;
        int[][] testArray = new int[x][y];
        assertTrue(TicTacToe.columnsIn(testArray) == 4);
    }

    @org.junit.jupiter.api.Test
    /**
     * Compare the number of columns detected by rowsIn function to the expected result; non-square to differentiate between row and column return
     */
    void columnsIn_4x3() {
        int x = 4;
        int y = 3;
        int[][] testArray = new int[x][y];
        assertTrue(TicTacToe.columnsIn(testArray) == 3);
    }

    @org.junit.jupiter.api.Test
    /**
     * Compare the number of columns detected by rowsIn function to the expected result; non-square to differentiate between row and column return
     */
    void columnsIn_4x5() {
        int x = 4;
        int y = 5;
        int[][] testArray = new int[x][y];
        assertTrue(TicTacToe.columnsIn(testArray) == 5);
    }

    @org.junit.jupiter.api.Test
    /**
     * See if the canPlay function returns the expected result when the user plays on an empty spot (standard 3x3 board)
     */
    void canPlay_emptySpot() {
        int x = 0;
        int y = 2; //these x,y correspond to row 1, column 3 on the below board; this spot is empty
        int[][] testArray = {{1,0,0}, {2,1,0},{0,1,2}};
        assertTrue(TicTacToe.canPlay(testArray, x, y));
    }

    @org.junit.jupiter.api.Test
    /**
     * See if the canPlay function returns the expected result when the user plays on an occupied spot (standard 3x3 board)
     */
    void canPlay_occupiedSpot() {
        int x = 2;
        int y = 2; //these x,y correspond to row 3, column 3 on the below board; this spot is occupied
        int[][] testArray = {{1,0,0}, {2,1,0},{0,1,2}};
        assertFalse(TicTacToe.canPlay(testArray, x, y)); //since this spot is taken, canPlay should be false
    }

    @org.junit.jupiter.api.Test
    void play() {
    }

    @org.junit.jupiter.api.Test
    void full() {
    }

    @org.junit.jupiter.api.Test
    void winInRow() {
    }

    @org.junit.jupiter.api.Test
    void winInColumn() {
    }

    @org.junit.jupiter.api.Test
    void winInDiagonalBS() {
    }

    @org.junit.jupiter.api.Test
    void winInDiagonalFS() {
    }

    @org.junit.jupiter.api.Test
    void hint() {
    }
}