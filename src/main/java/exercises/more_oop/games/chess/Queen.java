package exercises.more_oop.games.chess;

class Queen extends ChessPiece {
    public Queen(ChessPieceColor color) { this.color = color; }
    
    
    @Override public String toString() {
        return String.format("QUEEN: [%s, %s]",
                getX_ColumnLetter(), getY_RowNumber()
        );
    }
}
