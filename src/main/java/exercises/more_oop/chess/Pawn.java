package exercises.more_oop.chess;

public class Pawn extends ChessPiece {
    public Pawn() { }
    
    
    @Override public String toString() {
        return String.format("PAWN: [%s, %s]",
            getX_ColumnLetter(), getY_RowNumber()
        );
    }
}
