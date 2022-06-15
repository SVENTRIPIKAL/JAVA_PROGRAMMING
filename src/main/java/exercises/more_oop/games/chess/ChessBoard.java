package exercises.more_oop.games.chess;

/**
 *  Simple Chess game inspired by:
 *  https://www.chess.com/learn-how-to-play-chess
 */

class ChessBoard {
    private final ChessPiece[][] board = new ChessPiece[8][8];
    
    public ChessBoard() {
        startNewGame();
    }
    
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
    
    //  SETUP BOARD
    private void startNewGame() {
        int i = 0;
        for (ChessPiece[] row : board) {
            Pawn blackPawn = new Pawn(ChessPieceColor.BLACK);
            Pawn whitePawn = new Pawn(ChessPieceColor.WHITE);
            board[1][i] = blackPawn;
            board[6][i] = whitePawn;
    
            Rook blackRook = new Rook(ChessPieceColor.BLACK);
            Rook whiteRook = new Rook(ChessPieceColor.WHITE);
            if (i == 0 || i == 7) {
                board[0][i] = blackRook;
                board[7][i] = whiteRook;
            }
    
            Knight blackKnight = new Knight(ChessPieceColor.BLACK);
            Knight whiteKnight = new Knight(ChessPieceColor.WHITE);
            if (i == 1 || i == 6) {
                board[0][i] = blackKnight;
                board[7][i] = whiteKnight;
            }
    
            Bishop blackBishop = new Bishop(ChessPieceColor.BLACK);
            Bishop whiteBishop = new Bishop(ChessPieceColor.WHITE);
            if (i == 2 || i == 5) {
                board[0][i] = blackBishop;
                board[7][i] = whiteBishop;
            }
    
            Queen blackQueen = new Queen(ChessPieceColor.BLACK);
            Queen whiteQueen = new Queen(ChessPieceColor.WHITE);
            if (i == 3) {
                board[0][i] = blackQueen;
                board[7][i] = whiteQueen;
            }
    
            King blackKing = new King(ChessPieceColor.BLACK);
            King whiteKing = new King(ChessPieceColor.WHITE);
            if (i == 4) {
                board[0][i] = blackKing;
                board[7][i] = whiteKing;
            }
            
            i++;
        }
    }
    
    
    // OUTPUT BOARD
    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        int position = 8;
        for (ChessPiece[] row : board) {
            sb.append(String.format("%s ", position));
            for (ChessPiece column : row) {
                if (column instanceof Pawn) {
                    String text = column.color == ChessPieceColor.WHITE ?
                            "[P]" : "[p]";   sb.append(text);
                }
                
                else if (column instanceof Rook) {
                    String text = column.color == ChessPieceColor.WHITE ?
                            "[R]" : "[r]";   sb.append(text);
                }
                
                else if (column instanceof Knight) {
                    String text = column.color == ChessPieceColor.WHITE ?
                            "[K]" : "[k]";   sb.append(text);
                }
                
                else if (column instanceof Bishop) {
                    String text = column.color == ChessPieceColor.WHITE ?
                            "[B]" : "[b]";   sb.append(text);
                }
                
                else if (column instanceof Queen) {
                    String text = column.color == ChessPieceColor.WHITE ?
                            "[Q]" : "[q]";   sb.append(text);
                }
                
                else if (column instanceof King) {
                    String text = column.color == ChessPieceColor.WHITE ?
                            "[*]" : "[+]";   sb.append(text);
                }
                
                else { sb.append("[_]"); }
            }
            sb.append(String.format(" %s\n", position));    position--;
        }
        return String.format("""
            %n   A  B  C  D  E  F  G  H         BLACK
            %s   a  b  c  d  e  f  g  h         WHITE""", sb
        );
    }
}