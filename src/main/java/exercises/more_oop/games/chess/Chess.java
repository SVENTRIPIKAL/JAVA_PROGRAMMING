package exercises.more_oop.games.chess;

public interface Chess {
    static void play() {
        ChessBoard board = new ChessBoard();
        board.move("d2", "d4");
        System.out.println(board);
    }
}
