package nl.han.testtttt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import nl.han.tictactoe.*;
import nl.han.tictactoe.TicTacToe.State;

@SuppressWarnings("javadoc")
public class TestTTT {
    TicTacToe ttt;

    @Before
    public void init() {
        ttt = new TicTacToe();
    }

    @Test
    public void startBoard() {
        assertEquals(ttt.getBoard(), 0L);
    }

    @Test
    public void placeCenter() {
        assertTrue(ttt.place(1, 1));
    }

    @Test
    public void checkBoardValue() {
        ttt.place(1, 1);
        assertEquals(ttt.getBoard(), 256L); // Checks if the only token is a X in the center.
    }

    @Test
    public void checkPlayers() {
        assertEquals(ttt.getCurrentPlayer(), State.X);
        ttt.place(1, 1);
        assertEquals(ttt.getCurrentPlayer(), State.O);
    }

    @Test
    public void clearBoard() {
        ttt.place(1, 1);
        ttt.resetBoard();
        assertEquals(ttt.getBoard(), 0L);
    }

    @Test
    public void checkOverlap() {
        assertTrue(ttt.place(1, 1));
        assertFalse(ttt.place(1, 1));
    }

    @Test
    public void winGameHorizontal() {
        // X X X
        // O _ _
        // O _ _
        ttt.place(0, 0);
        ttt.place(1, 0);
        ttt.place(0, 1);
        ttt.place(2, 0);
        ttt.place(0, 2);

        assertNotEquals(ttt.getWinner(), State.BLANK);
    }

    @Test
    public void winGameVertical() {
        // X O O
        // X _ _
        // X _ _
        ttt.place(0, 0);
        ttt.place(0, 1);
        ttt.place(1, 0);
        ttt.place(0, 2);
        ttt.place(2, 0);

        assertNotEquals(ttt.getWinner(), State.BLANK);
    }

    @Test
    public void winGameDiagonal() {
        // X _ _
        // O X _
        // O _ X
        ttt.place(0, 0);
        ttt.place(1, 0);
        ttt.place(1, 1);
        ttt.place(2, 0);
        ttt.place(2, 2);

        assertNotEquals(ttt.getWinner(), State.BLANK);
    }

    @Test
    public void winGameCross() {
        // X _ _
        // O X _
        // O _ X
        ttt.place(0, 0);
        ttt.place(1, 0);
        ttt.place(1, 1);
        ttt.place(2, 0);
        ttt.place(2, 2);

        assertEquals(ttt.getWinner(), State.X);
    }

    @Test
    public void winGameCircle() {
        // X X _
        // O O O
        // X _ _
        ttt.place(0, 0);
        ttt.place(1, 0);
        ttt.place(2, 0);
        ttt.place(1, 1);
        ttt.place(0, 1);
        ttt.place(1, 2);

        assertEquals(ttt.getWinner(), State.O);
    }

    @Test
    public void drawGame() {
        // X O X
        // O X X
        // O X O
        ttt.place(0, 0);
        ttt.place(0, 1);
        ttt.place(0, 2);
        ttt.place(1, 0);
        ttt.place(1, 1);
        ttt.place(2, 0);
        ttt.place(1, 2);
        ttt.place(2, 2);
        ttt.place(2, 1);

        assertEquals(ttt.getWinner(), State.DRAW);
    }
}