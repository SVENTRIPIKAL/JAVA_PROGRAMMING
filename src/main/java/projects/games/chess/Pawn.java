package projects.games.chess;

class Pawn extends ChessPiece {
    private boolean initialMovement = true;
    
    public Pawn(ChessPieceColor color) { this.color = color; }
    
    
    public boolean withinRange(int[] destination) {
        // IF BLACK PIECE -- MOVE UP ARRAYS:   Y++    (g8 == y0,x6) | (g7 == y1,x6)
        // IF WHITE PIECE -- MOVE DOWN ARRAYS: Y--    (g1 == y7,x6) | (g2 == y6,x6)
        if (isWithinLimitedRange(destination)) {
            return true;
        }
        
        else return (isWithinExtendedRange(destination));
    }
    
    
    private boolean isDiagonal(int[] destination) {
        return (((destination[1] == this.row - 1)   ||
                (destination[1] == this.row + 1))   &&
                (destination[0] == this.column + 1));
    }
    
    private boolean inFront(int[] destination) {
        return (destination[1] == this.row - 1) ||
                (destination[1] == this.row)    ||
                (destination[1] == this.row + 1);
    }
    
    private boolean inFrontPlus(int[] destination, int number) {
        return (destination[0] == this.column + number);
    }
    
    private boolean inFrontMinus(int[] destination, int number) {
        return (destination[0] == this.column - number);
    }
    
    private boolean pieceIsBlack() {
        return this.color.equals(ChessPieceColor.BLACK);
    }
    
    private boolean pieceIsWhite() {
        return this.color.equals(ChessPieceColor.WHITE);
    }
    
    private boolean isAhead(int[] destination) {
        return (destination[1] == this.row);
    }
    
    
    private boolean isWithinLimitedRange(int[] destination) {
        // subsequent moves forward
        if ((!initialMovement) && inFront(destination)) {
            //the 3 squares in front row of black pawn
            if (pieceIsBlack() && inFrontPlus(destination, 1)) {
                if (isDiagonal(destination)) {
                    return isOccupied(destination) && isRival(destination);
                }
                else return !isOccupied(destination);
            }
            
            //FIX WHITE PAWN MOVEMENTS
            
            //the 3 squares in front row of white pawn
            else if (pieceIsWhite() && inFrontMinus(destination, 1)) {
                if (isDiagonal(destination)) {
                    return isOccupied(destination) && isRival(destination);
                }
                else return !isOccupied(destination);
            }
        } return false;
    }
    
    
    private boolean isWithinExtendedRange(int[] destination) {
        // first move forward
        if ((initialMovement) && isAhead(destination)) {
            //squares aligned with black pawns
            if (pieceIsBlack()) { // 1-2 spaces ahead
                return (inFrontPlus(destination, 1) ||
                        inFrontPlus(destination, 2));
            }
            //squares aligned with white pawns
            else if (pieceIsWhite()) { // 1-2 spaces ahead
                return (inFrontMinus(destination, 1) ||
                        inFrontMinus(destination, 2));
            }
        } return false;
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
