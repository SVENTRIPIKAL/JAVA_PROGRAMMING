package exercises.more_oop.games.chess;

class Pawn extends ChessPiece {
    public Pawn(ChessPieceColor color) { this.color = color; }
    
    
    @Override public String toString() {
        return String.format("PAWN: [%s, %s]",
            getX_ColumnLetter(), getY_RowNumber()
        );
    }
}
