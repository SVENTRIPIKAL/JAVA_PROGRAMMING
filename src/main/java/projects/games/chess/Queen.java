package projects.games.chess;

class Queen extends ChessPiece {
    public Queen(ChessPieceColor color) { this.color = color; }
    
    
    @Override public String toString() {
        return String.format("QUEEN: [%s, %s]",
                getColumn(), getRow()
        );
    }
}
