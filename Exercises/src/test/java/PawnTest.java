import org.junit.*;
import static org.junit.Assert.assertEquals;

public class PawnTest {
    @Test
    public void testCreate() {
        Pawn pawn = new Pawn();
        Assert.assertEquals("White", pawn.getColor());
        
        Pawn secondPawn = new Pawn();
        Assert.assertEquals("Black", secondPawn.getColor());

        Pawn blankPawn = new Pawn();
        Assert.assertEquals("White", blankPawn.getColor());
    }
}
