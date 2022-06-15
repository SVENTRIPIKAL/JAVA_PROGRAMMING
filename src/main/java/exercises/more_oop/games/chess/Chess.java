package exercises.more_oop.games.chess;

public interface Chess {
    static void play() {
        ChessBoard board = new ChessBoard();
        System.out.println(board);
    }
}
