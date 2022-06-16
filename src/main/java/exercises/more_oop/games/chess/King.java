package exercises.more_oop.games.chess;

class King extends ChessPiece {
    public King(ChessPieceColor color) { this.color = color; }
    
    
    @Override public String toString() {
        return String.format("KING: [%s, %s]",
                getColumn(), getRow()
        );
    }
}
