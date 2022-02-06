import org.junit.Assert;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    /**
     * Rohit Nair
     * Feb 5, 2022
     * T06
     */
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
        long d = x;
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
        assertFalse(TicTacToe.canPlay(testArray, x, y)); //since this spot is taken, canPlay should be falsee
    }

    @org.junit.jupiter.api.Test
    /**
     * Check to see if the play function plays a piece on the desired spot
     */
    void play_3x3() {
        int piece = 1;
        int x = 1;
        int y = 0;
        int[][] testArray = {{0,0,0}, {0,0,0},{0,0,0}};
        TicTacToe.play(testArray,x,y,piece);
        int[][] expectedArray = {{0,0,0}, {1,0,0},{0,0,0}}; //Since we want to play a one piece at row 2 and column 1, this is the array we would expect
        assertTrue(Arrays.deepEquals(testArray, expectedArray));
    }

    @org.junit.jupiter.api.Test
    /**
     * Check to see if the play function plays a piece on the desired spot
     */
    void play_4x4() {
        int piece = 2;
        int x = 2;
        int y = 2;
        int[][] testArray = {{1,2,0,2}, {1,1,0,1},{0,1,0,2}, {2,0,1,1}};
        TicTacToe.play(testArray,x,y,piece);
        int[][] expectedArray = {{1,2,0,2}, {1,1,0,1},{0,1,2,2}, {2,0,1,1}}; //Since we want to play a one piece at row 3 and column 3, this is the array we would expect
        assertTrue(Arrays.deepEquals(testArray, expectedArray));
    }

    @org.junit.jupiter.api.Test
    /**
     * Check to see if full function can accurately detect that this board is full
     */
    void full_3x3() {
        int[][] testArray = {{1,2,1}, {2,1,1},{1,2,2}};
        assertTrue(TicTacToe.full(testArray));
    }

    @org.junit.jupiter.api.Test
    /**
     * Check to see if full function can accurately detect that this board is NOT full
     */
    void not_full_3x3() {
        int[][] testArray = {{0,2,2}, {2,0,1},{1,2,1}};
        assertFalse(TicTacToe.full(testArray));
    }

    @org.junit.jupiter.api.Test
    /**
     * Check to see if full function can accurately detect that this board is NOT full
     */
    void not_full_5x4() {
        int[][] testArray = {{1,2,1,2},{2,1,1,2},{1,2,2,1},{2,1,2,0},{1,1,2,1}}; //row 4, column 4 is empty
        assertFalse(TicTacToe.full(testArray));
    }

    @org.junit.jupiter.api.Test
    /**
     * Check to see if full function can accurately detect that this board is full
     */
    void full_5x4() {
        int[][] testArray = {{1,2,1,2},{2,1,1,2},{1,2,2,1},{2,1,2,0},{1,1,2,1}}; //row 4, column 4 is empty
        assertFalse(TicTacToe.full(testArray));
    }

    @org.junit.jupiter.api.Test
    /**
     * Check to see if winInRow function will see that this is NOT a winning row
     */
    void no_winInRow_4x3() {
        int x = 0;
        int[][] testArray = {{2,1,2}, {1,2,1}, {1,1,1}, {2,1,2}};
        assertFalse(TicTacToe.winInRow(testArray,x,2)); //This statement should be false since we clearly see there is not 3 occurrences of '2' in row 1
    }

    @org.junit.jupiter.api.Test
    /**
     * Check to see if winInRow function will see that this is NOT a winning row
     */
    void no_winInRow_5x5() {
        int x = 2;
        int[][] testArray = {{2,1,2,1,1}, {1,2,1,2,2}, {1,1,2,2,1}, {2,1,2,1,1}, {1,2,2,1,1}};
        assertFalse(TicTacToe.winInRow(testArray,x,1)); //This statement should be false; although row 2 has 3 occurrences of 1, they are not consecutive
    }

    @org.junit.jupiter.api.Test
    /**
     * Check to see if winInRow function will see that this is a winning combination in the specified row
     */
    void winInRow_3x3() {
        int x = 2;
        int[][] testArray = {{2,1,0}, {1,2,1}, {1,1,1}};
        assertTrue(TicTacToe.winInRow(testArray,x,1)); //This statement should be true; row 3 has 3 consecutive of the same piece "1"
    }

    @org.junit.jupiter.api.Test
    /**
     * Check to see if winInRow function will see that this is a winning combination in the specified row
     */
    void winInRow_4x3() {
        int x = 3;
        int[][] testArray = {{2,1,2}, {1,2,1}, {1,2,0}, {2,2,2}};
        assertTrue(TicTacToe.winInRow(testArray,x,2)); //This statement should be true; row 4 has 3 consecutive of the same piece "2"
    }

    @org.junit.jupiter.api.Test
    /**
     * Check to see if winInRow function will see that this is a winning combination in the specified row
     */
    void winInRow_5x5() {
        int x = 1;
        int[][] testArray = {{0,1,2,1,1}, {0,2,2,2,1}, {1,1,2,2,1}, {2,0,2,1,1}, {1,2,0,0,1}};
        assertTrue(TicTacToe.winInRow(testArray,x,2)); //This statement should be true; row 2 has 3 consecutive of the same piece between the "1"s
    }

    /**
     * Check to see if the winInColumn function will check that there is NO winning combination in column 1
     */
    @org.junit.jupiter.api.Test
    void no_winInColumn_3x4() {
        int y = 0;
        int[][] testArray = {{2,1,2,2}, {1,2,1}, {1,1,1}, {2,1,2,2}};
        assertFalse(TicTacToe.winInColumn(testArray,y,1)); //Should return false since there is not three consecutive occurrences of "1" in column 1
    }

    /**
     * Check to see if the winInColumn function will check that there is NO winning combination in column 4
     */
    @org.junit.jupiter.api.Test
    void no_winInColumn_5x5() {
        int y = 3;
        int[][] testArray = {{2,1,2,1,1}, {1,2,2,2,1}, {1,1,2,2,1}, {2,1,2,1,1}, {1,2,2,1,1}};
        assertFalse(TicTacToe.winInColumn(testArray,y,2)); //Should return false since there is not three consecutive occurrences of "2" in column 4
    }

    /**
     * Check to see if the winInColumn function will check that there is a winning combination in column 2
     */
    @org.junit.jupiter.api.Test
    void winInColumn_3x3() {
        int y = 1;
        int[][] testArray = {{2,1,2}, {1,1,2}, {2,1,1}};
        assertTrue(TicTacToe.winInColumn(testArray,y,1)); //Should return true since there is  three consecutive occurrences of "1" in column 2
    }

    /**
     * Check to see if the winInColumn function will check that there is a winning combination in column 5
     */
    @org.junit.jupiter.api.Test
    void winInColumn_5x5() {
        int y = 0;
        int[][] testArray = {{2,0,2,1,2}, {1,2,2,2,1}, {1,0,0,2,1}, {1,1,0,1,0}, {2,0,2,1,0}};
        assertTrue(TicTacToe.winInColumn(testArray,y,1)); //Should return true since there is three consecutive occurrences of "1" in column 1
    }

    /**
     * Check to see if the winInColumn function will check that there is a winning combination in column 2
     */
    @org.junit.jupiter.api.Test
    void winInColumn_3x4() {
        int y = 1;
        int[][] testArray = {{2,1,2,1}, {1,1,2,2}, {1,1,2,1}};
        assertTrue(TicTacToe.winInColumn(testArray,y,1)); //Should return true since there is three consecutive occurrences of "1" in column 5
    }

    @org.junit.jupiter.api.Test
    /**
     * Checks to see that the function returns false since there is NO BS diagonal for the given piece in this array
     */
    void no_winInDiagonalBS_4x4() {
        int[][] testArray = {{0,1,2,1}, {1,1,2,0}, {1,1,2,1},{0,2,2,1}};
        assertFalse(TicTacToe.winInDiagonalBS(testArray,1)); //Since there is no possible backslash diagonal with "1" in this array, we expect false
    }

    @org.junit.jupiter.api.Test
    /**
     * Checks to see that the function returns true since there is a BS diagonal for the given piece in this array
     */
    void winInDiagonalBS_4x4() {
        int[][] testArray = {{1,0,2,2}, {2,1,0,2}, {0,2,1,0},{0,2,0,0}};
        assertTrue(TicTacToe.winInDiagonalBS(testArray,1)); //Starting from row 1, column 1, we see that a backslash diagonals of "1" is formed
    }

    @org.junit.jupiter.api.Test
    /**
     * Checks to see that the function returns true since there is a BS diagonal for the given piece in this array
     */
    void winInDiagonalBS_5x5() {
        int[][] testArray = {{0,1,0,1,0}, {0,2,0,0,0}, {0,0,2,1,0},{1,0,0,2,0}, {1,0,1,0,0}};
        assertTrue(TicTacToe.winInDiagonalBS(testArray,2)); //Starting from row 2, column 2, we see that a backslash diagonals of "2" is formed (this backslash diagonal is "floating")
    }

    @org.junit.jupiter.api.Test
    /**
     * Checks to see that the function returns true since there is a BS diagonal for the given piece in this array
     */
    void winInDiagonalBS_4x3() {
        int[][] testArray = {{0,1,2}, {1,2,0}, {1,1,2}, {0,0,1}};
        assertTrue(TicTacToe.winInDiagonalBS(testArray,1)); //Starting from row 2, column 1, we see that a backslash diagonals of "1" is formed (this backslash diagonal is "floating")
    }

    /**
     * Checks to see that the function returns false since there is a FS diagonal for the given piece in this array
     */
    @org.junit.jupiter.api.Test
    void no_winInDiagonalFS_4x4() {
        int[][] testArray = {{0,1,2,1}, {1,1,2,0}, {1,1,2,1},{0,2,2,1}};
        assertFalse(TicTacToe.winInDiagonalFS(testArray, 1)); //clearly, there is no FS diagonal for 1 in this array; we expect a false return
    }

    /**
     * Checks to see that the function returns true since there is a FS diagonal for the given piece in this array
     */
    @org.junit.jupiter.api.Test
    void winInDiagonalFS_4x4() {
        int[][] testArray = {{1,0,2,2}, {0,1,2,0}, {0,2,1,0},{0,2,0,0}};
        assertTrue(TicTacToe.winInDiagonalFS(testArray, 2)); //Starting from row 1, column 4, a backslash diagonal of "2" is formed
    }

    /**
     * Checks to see that the function returns true since there is a FS diagonal for the given piece in this array
     */
    @org.junit.jupiter.api.Test
    void winInDiagonalFS_5x5() {
        int[][] testArray = {{2,1,0,0,0}, {2,0,2,1,0}, {0,0,1,2,0},{0,1,0,0,0}, {0,1,1,0,2}};
        assertTrue(TicTacToe.winInDiagonalFS(testArray, 1)); //Starting from row 2, column 4, a floating backslash diagonal of "1" is formed
    }

    /**
     * Checks to see that the function returns true since there is a FS diagonal for the given piece in this array
     */
    @org.junit.jupiter.api.Test
    void winInDiagonalFS_4x3() {
        int[][] testArray = {{0,1,1}, {0,1,2}, {1,1,0}, {2,0,1}};
        assertTrue(TicTacToe.winInDiagonalFS(testArray,1)); //Starting from row 1, column 3, we see that a backslash diagonals of "1" is formed (this backslash diagonal is "floating")
    }

    /**
     * Checks to see that the function returns [-1][-1] as there is no spot where the player can win the game
     */
    @org.junit.jupiter.api.Test
    void no_hint() {
        int[] noHint = {-1,-1};
        int[][] testArray = {{0,1,0,0}, {0,0,0,0}, {2,0,0,0},{0,0,0,1}};
        Assert.assertArrayEquals(TicTacToe.hint(testArray,2), noHint);
    }

    /**
     * Checks to see that the function returns the winning spot
     */
    @org.junit.jupiter.api.Test
    void hint_4x4() {
        int[] hintSpot = {2,3};
        int[][] testArray = {{0,1,0,0}, {0,0,1,2}, {2,0,0,0},{0,0,0,1}};
        Assert.assertArrayEquals(TicTacToe.hint(testArray,1), hintSpot); //We see a winning spot at row 3, column 4 so that spot should be our return value (BS diagonal hint check)
    }
    /**
     * Checks to see that the function returns the spot the user must play to win
     */
    @org.junit.jupiter.api.Test
    void hint_3x5() {
        int[] hintSpot = {2,1};
        int[][] testArray = {{1,0,0,0,1}, {0,0,0,0,1}, {2,0,2,0,0}};
        Assert.assertArrayEquals(TicTacToe.hint(testArray,2), hintSpot); //We see that the player MUST place a piece at row 3, column 2 to win the game (column hint check)
    }

    /**
     * Checks to see that the function returns the spot the user must play to win
     */
    @org.junit.jupiter.api.Test
    void hint_3x3() {
        int[] hintSpot = {2,2};
        int[][] testArray = {{0,2,1}, {2,0,1}, {2,2,0}};
        Assert.assertArrayEquals(TicTacToe.hint(testArray,1), hintSpot); //We see that the player should play at row 3, column 3 to win the game (row win check)

}
    /**
     * Checks to see that the function returns the spot the user must play to avoid defeat
     */
    @org.junit.jupiter.api.Test
    void hint_3x4() {
        int[] hintSpot = {2,1};
        int[][] testArray = {{1,0,0,2}, {0,0,2,0}, {1,0,0,1}};
        Assert.assertArrayEquals(TicTacToe.hint(testArray,2), hintSpot); //We see a winning spot at row 3, column 2 so that spot should be our return value (FS diagonal hint check)
    }

    /**
     * Checks to see that 1 is returned when our n is 0
     */
    @org.junit.jupiter.api.Test
    void zero_factorial() {
        int n = 0;
        BigInteger expectedResult = BigInteger.valueOf(1);
        assertTrue(expectedResult.equals(TicTacToe.factorial(n)));
    }

    @org.junit.jupiter.api.Test
    /**
     * Check to see if the expected result of 5! is returned
     */
    void five_factorial() {
        int n = 5;
        BigInteger expectedResult = BigInteger.valueOf(5*4*3*2*1);
        assertTrue(expectedResult.equals(TicTacToe.factorial(n)));
    }

    @org.junit.jupiter.api.Test
    /**
     * Check to see if the expected result of 5! is returned
     */
    void ten_factorial() {
        int n = 10;
        BigInteger expectedResult = BigInteger.valueOf(10*9*8*7*6*5*4*3*2*1);
        assertTrue(expectedResult.equals(TicTacToe.factorial(n)));
    }
}