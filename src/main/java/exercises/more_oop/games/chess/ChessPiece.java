package exercises.more_oop.games.chess;

import static exercises.more_oop.games.chess.ChessBoard.board;

abstract class ChessPiece {
    protected ChessPieceColor color;
    protected int row, column;
    
    protected boolean isOccupied(int[] destination) {
        return board[destination[0]][destination[1]] != null;
    }
    
    protected boolean isRival(int[] destination) {
        ChessPiece chessPiece = board[destination[0]][destination[1]];
        return !chessPiece.color.equals(this.color);
    }
    
    protected void move(String from, String to) {
        if (getChessPiece(from).withinRange(getCoordinates(to))) {
            ChessPiece piece = getChessPiece(from);
            clearPreviousLocation(from);
            setChessPiece(piece, to);
            if (piece instanceof Pawn) {
                ((Pawn) piece).setInitialMovement(false);
            }
        } else System.out.println("THAT PIECE CAN'T MOVE THERE");
    }
    
    
    //#8    GET CHESS-PIECE AT X/Y-COORDINATE
    protected ChessPiece getChessPiece(String coordinate) {
        if (coordinate.toLowerCase().matches("[a-h][1-8]")) {
            int columnLetter = coordinate.toLowerCase().charAt(0) - 97;
            int rowNumber = 8 - Integer.parseInt(
                    coordinate.substring(1)
            );
            return board[rowNumber][columnLetter];
        } else { return null ;}
    }
    
    //#8    SET CHESS-PIECE AT X/Y-COORDINATE
    protected void setChessPiece(ChessPiece piece, String coordinate) {
        if (coordinate.toLowerCase().matches("[a-h][1-8]")) {
            int columnLetter = coordinate.toLowerCase().charAt(0) - 97;
            int rowNumber = 8 - Integer.parseInt(
                    coordinate.substring(1)
            );
            piece.setRow(columnLetter);    piece.setColumn(rowNumber);
            board[rowNumber][columnLetter] = piece;
        } else System.out.printf("\"ONLY COORDINATES [a-h][1-8] ARE VALID!!!\"%n%n");
    }
    
    //  RETURNS ARRAY COORDINATES OF STRINGED LOCATION
    protected int[] getCoordinates(String coordinate) {
        if (coordinate.toLowerCase().matches("[a-h][1-8]")) {
            int columnLetter = coordinate.toLowerCase().charAt(0) - 97;
            int rowNumber = 8 - Integer.parseInt(
                    coordinate.substring(1)
            );
            int[] xY = new int[2];  xY[0] = rowNumber;  xY[1] = columnLetter;
            return xY;
        } else return null;
    }
    
    protected void setCoordinates(int x_coordinate, int y_coordinate) {
        this.row = y_coordinate;
        this.column = x_coordinate;
    }
    
    // SETS ANY OBJECT'S PREVIOUS LOCATION TO NULL
    protected void clearPreviousLocation(String previousLocation) {
        int[] previousCoordinates = getCoordinates(previousLocation);
        board[previousCoordinates[0]][previousCoordinates[1]] = null;
    }
    
    protected boolean withinRange(int[] destination) { return true; }
    
    protected int getColumn() { return column; }
    
    private void setColumn(int column) {
        this.column = column;
    }
    
    protected int getRow() { return row; }
    
    private void setRow(int row) {
        this.row = row;
    }
}
