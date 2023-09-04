package chess;

import pieces.Pawn;

import java.util.*;
public class Board {
    private final ArrayList<String> listOfPieces = new ArrayList<>();
    private int pieces;
    private final int size;

    public Board(int width, int length) {
        this.pieces = 0;
        this.size = width * length;
    }

    public int getBoardSize() {
        return size;
    }

    public int getNumberOfPieces() {
        return pieces;
    }

    public void addPieces(int numPieces) {
        pieces = pieces + numPieces;
    }

    public void addPawn(Pawn pawn, Board board) {
        board.addPieces(1);
        listOfPieces.add(pawn.getColor());
    }

    public void getPieces() {
        for (String listOfPiece : listOfPieces) {
            System.out.println(listOfPiece);
        }

    }

}