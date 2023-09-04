package pieces;

import pieces.Pawn;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class PawnTest {
    @Test
    public void testCreate() {
        Pawn pawn = new Pawn();
        Assert.assertEquals("white", pawn.getColor());
        
        Pawn secondPawn = new Pawn("black");
        Assert.assertEquals("black", secondPawn.getColor());

        Pawn blankPawn = new Pawn();
        Assert.assertEquals("white", blankPawn.getColor());
    }
}
