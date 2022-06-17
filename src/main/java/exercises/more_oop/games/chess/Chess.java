package exercises.more_oop.games.chess;

public interface Chess {
    static void play() {
        ChessBoard board = new ChessBoard();
        board.move("c7", "c5");
        System.out.println(board);
    }
}
