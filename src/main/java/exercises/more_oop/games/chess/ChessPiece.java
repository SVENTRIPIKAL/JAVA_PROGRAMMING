package exercises.more_oop.games.chess;

abstract class ChessPiece {
    protected ChessPieceColor color;
    private int x_coordinate, y_coordinate;
    
    protected int getX_ColumnLetter() {
        return x_coordinate;
    }
    
    protected void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }
    
    protected int getY_RowNumber() {
        return y_coordinate;
    }
    
    protected void setY_coordinate(int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }
    
}
