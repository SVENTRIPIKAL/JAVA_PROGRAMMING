package exercises.more_oop.chess;

public class ChessBoard {
    private final ChessPiece[][] board = new ChessPiece[8][8];
    
    public ChessBoard() {   }
    
    //#8    SET CHESS-PIECE AT X/Y-COORDINATE
    public void setChessPiece(ChessPiece piece, String coordinate) {
        if (coordinate.toLowerCase().matches("[a-h][1-8]")) {
            int columnLetter = coordinate.toLowerCase().charAt(0) - 97;
            int rowNumber = 8 - Integer.parseInt(
                    coordinate.substring(1)
            );
            piece.setX_coordinate(columnLetter);    piece.setY_coordinate(rowNumber);
            board[rowNumber][columnLetter] = piece;
        } else System.out.printf("\"ONLY COORDINATES [a-h][1-8] ARE VALID!!!\"%n%n");
    }
    
    //#8    GET CHESS-PIECE AT X/Y-COORDINATE
    public ChessPiece getChessPiece(String coordinate) {
        if (coordinate.toLowerCase().matches("[a-h][1-8]")) {
            int columnLetter = coordinate.toLowerCase().charAt(0) - 97;
            int rowNumber = 8 - Integer.parseInt(
                    coordinate.substring(1)
            );  return board[rowNumber][columnLetter];
        } else { return null ;}
    }
    
    
    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        int position = 8;
        for (ChessPiece[] row : board) {
            sb.append(String.format("%s ", position));
            for (ChessPiece column : row) {
                if (column instanceof Pawn) { sb.append("[P]"); }
                else { sb.append("[_]"); }
            }
            sb.append(String.format(" %s\n", position));    position--;
        }
        return String.format("""
            %n   A  B  C  D  E  F  G  H
            %s   A  B  C  D  E  F  G  H
            """, sb
        );
    }
}