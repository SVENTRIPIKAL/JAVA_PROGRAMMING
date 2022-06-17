package exercises.more_oop.games.chess;

class Pawn extends ChessPiece {
    private boolean initialMovement = true;
    
    public Pawn(ChessPieceColor color) { this.color = color; }
    
    
    public boolean withinRange(int[] destination) {
        // IF BLACK PIECE -- MOVE UP ARRAYS:   Y++    (g8 == y0,x6) | (g7 == y1,x6)
        // IF WHITE PIECE -- MOVE DOWN ARRAYS: Y--    (g1 == y7,x6) | (g2 == y6,x6)
        if (isWithinLimitedRange(destination)) {
            return true;
        } else return (isWithinExtendedRange(destination));
    }
    
    
    private boolean isDiagonal(int[] destination) {
        return (((destination[1] == this.row - 1)   ||
                (destination[1] == this.row + 1))   &&
                (destination[0] == this.column + 1));
    }
    
    
    private boolean isWithinLimitedRange(int[] destination) {
        if ((!initialMovement) &&
            ((destination[1] == this.row - 1)   ||
            (destination[1] == this.row)        ||
            (destination[1] == this.row + 1)))  {
            
            if (this.color.equals(ChessPieceColor.BLACK)) {
                return (destination[0] == this.column + 1);
            }
            
            else if (this.color.equals(ChessPieceColor.WHITE)) {
                return (destination[0] == this.column - 1);
            }
        }
        return false;
    }
    
    
    private boolean isWithinExtendedRange(int[] destination) {
        if ((initialMovement) && (destination[1] == this.row)) {
            
            if (this.color.equals(ChessPieceColor.BLACK)) {
                return ((destination[0] == this.column + 1) ||
                        (destination[0] == this.column + 2));
            }
            
            else if (this.color.equals(ChessPieceColor.WHITE)) {
                return ((destination[0] == this.column - 1) ||
                        (destination[0] == this.column - 2));
            }
        }
        return false;
    }
    
    
    public void setInitialMovement(boolean initialMovement) {
        this.initialMovement = initialMovement;
    }
    
    
    @Override public String toString() {
        return String.format("PAWN: [%s, %s]",
            getColumn(), getRow()
        );
    }
}
