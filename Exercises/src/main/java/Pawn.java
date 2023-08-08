public class Pawn {
    String color;
    static private final String WHITE = "white";
    static private final String BLACK = "black";

    public Pawn(String color){
        this.color = color;
    }

    public Pawn() {
        this.color = WHITE;
    }

    public String getColor() {
        return color;
    }
}
