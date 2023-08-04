import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PawnTest {
    @Test
    public void testCreate() {
        final String pawnColor = "White";
        Pawn firstPawn = new Pawn(pawnColor);
        assertEquals(pawnColor, firstPawn.getColor());

        final String secondPawnColor = "Black";
        Pawn secondPawn = new Pawn(secondPawnColor);
        assertEquals(secondPawnColor, secondPawn.getColor());
    }
}
