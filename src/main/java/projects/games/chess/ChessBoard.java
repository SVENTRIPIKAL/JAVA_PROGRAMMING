package projects.games.chess;

/**
 *  Simple Chess game inspired by:
 *  https://www.chess.com/learn-how-to-play-chess
 */

class ChessBoard extends ChessPiece {
    static ChessPiece[][] board = new ChessPiece[8][8];
    
    public ChessBoard() {
        startNewGame();
    }
    
    
    //  SETUP BOARD
    private void startNewGame() {
        int i = 0;
        for (ChessPiece[] row : board) {
            Pawn blackPawn = new Pawn(ChessPieceColor.BLACK);
            Pawn whitePawn = new Pawn(ChessPieceColor.WHITE);
            board[1][i] = blackPawn;    blackPawn.setCoordinates(1, i);
            board[6][i] = whitePawn;    whitePawn.setCoordinates(6, i);
            
            Rook blackRook = new Rook(ChessPieceColor.BLACK);
            Rook whiteRook = new Rook(ChessPieceColor.WHITE);
            if (i == 0 || i == 7) {
                board[0][i] = blackRook;    blackRook.setCoordinates(0, i);
                board[7][i] = whiteRook;    whiteRook.setCoordinates(7, i);
            }
    
            Knight blackKnight = new Knight(ChessPieceColor.BLACK);
            Knight whiteKnight = new Knight(ChessPieceColor.WHITE);
            if (i == 1 || i == 6) {
                board[0][i] = blackKnight;  blackKnight.setCoordinates(0, i);
                board[7][i] = whiteKnight;  whiteKnight.setCoordinates(7, i);
            }
    
            Bishop blackBishop = new Bishop(ChessPieceColor.BLACK);
            Bishop whiteBishop = new Bishop(ChessPieceColor.WHITE);
            if (i == 2 || i == 5) {
                board[0][i] = blackBishop;  blackBishop.setCoordinates(0, i);
                board[7][i] = whiteBishop;  whiteBishop.setCoordinates(7, i);
            }
    
            Queen blackQueen = new Queen(ChessPieceColor.BLACK);
            Queen whiteQueen = new Queen(ChessPieceColor.WHITE);
            if (i == 3) {
                board[0][i] = blackQueen;   blackQueen.setCoordinates(0, i);
                board[7][i] = whiteQueen;   whiteQueen.setCoordinates(7, i);
            }
    
            King blackKing = new King(ChessPieceColor.BLACK);
            King whiteKing = new King(ChessPieceColor.WHITE);
            if (i == 4) {
                board[0][i] = blackKing;    blackKing.setCoordinates(0, i);
                board[7][i] = whiteKing;    whiteKing.setCoordinates(7, i);
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