package exercises.more_oop.games.chess;

class Bishop extends ChessPiece {
    public Bishop(ChessPieceColor color) { this.color = color; }
    
    
    @Override public String toString() {
        return String.format("BISHOP: [%s, %s]",
                getX_ColumnLetter(), getY_RowNumber()
        );
    }
}
