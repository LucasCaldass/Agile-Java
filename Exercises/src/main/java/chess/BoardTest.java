package chess;

import org.junit.*;
import pieces.Pawn;

public class BoardTest {
    @Test
    public void testCreate() {
        Board board = new Board(8, 8);
        Assert.assertEquals(64, board.getBoardSize());

        Pawn blackPawn = new Pawn("black");
        Pawn whitePawn = new Pawn();
        board.addPawn(blackPawn, board);
        board.addPawn(whitePawn, board);

        Assert.assertEquals(2, board.getNumberOfPieces());
        //board.getPieces();

        /*
        int n = 7;
        board.addPawn(7, board);
        board.getPieces();
        */


    }
}
