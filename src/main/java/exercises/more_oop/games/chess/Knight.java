package exercises.more_oop.games.chess;

class Knight extends ChessPiece {
    public Knight(ChessPieceColor color) { this.color = color; }
    
    
    @Override public String toString() {
        return String.format("KNIGHT: [%s, %s]",
                getX_ColumnLetter(), getY_RowNumber()
        );
    }
}
