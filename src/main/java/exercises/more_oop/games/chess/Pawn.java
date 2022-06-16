package exercises.more_oop.games.chess;

class Pawn extends ChessPiece {
    private boolean initialMovement = true;
    
    public Pawn(ChessPieceColor color) {
        this.color = color;
    }
    
    public void move(String from, String to) {
        if (getChessPiece(from).withinRange(getCoordinates(to))) {
            ChessPiece piece = getChessPiece(from);
            clearPreviousLocation(from);
            setChessPiece(piece, to); initialMovement = false;
        } else System.out.println("THAT PIECE CAN'T MOVE THERE");
    }
    
    public boolean withinRange(int[] destination) {
        // IF BLACK PIECE -- MOVE UP ARRAYS: Y++    (g8 == y0,x6) | (g7 == y1,x6)
        if (getColor().equals(ChessPieceColor.BLACK)) {
            if ((!initialMovement) &&
                (((destination[1] == this.row - 1)  ||
                (destination[1] == this.row)        ||
                (destination[1] == this.row + 1))   &&
                (destination[0] == this.column + 1))
            ) { return true; }
    
            else return (initialMovement) &&
                        ((destination[1] == this.row)   &&
                        ((destination[0] == this.column + 1)  ||
                        (destination[0] == this.column + 2)));
        }
        // CONTINUE MOVEMENT CHECKS
    
        // IF WHITE PIECE -- MOVE DOWN ARRAYS: Y--    (g1 == y7,x6) | (g2 == y6,x6)
        else if (getColor().equals(ChessPieceColor.WHITE)) {
            if ((!initialMovement) &&
                (((destination[1] == this.row - 1)  ||
                (destination[1] == this.row)        ||
                (destination[1] == this.row + 1))   &&
                (destination[0] == this.column - 1))
            ) { return true; }
    
            else return (initialMovement) &&
                        ((destination[1] == this.row)   &&
                        ((destination[0] == this.column - 1)  ||
                        (destination[0] == this.column - 2)));
        }
        else return false;
    }
    
    
    @Override public String toString() {
        return String.format("PAWN: [%s, %s]",
            getColumn(), getRow()
        );
    }
}
