package projects.games.chess;

class Rook extends ChessPiece {
    public Rook(ChessPieceColor color) { this.color = color; }
    
    
    @Override public String toString() {
        return String.format("ROOK: [%s, %s]",
                getColumn(), getRow()
        );
    }
}
