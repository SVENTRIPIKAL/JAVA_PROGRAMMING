package exercises.more_oop.games.chess;

public interface Chess {
    static void play() {
        ChessBoard board = new ChessBoard();
        board.move("c2", "c4");
        board.move("c4", "c5");
        board.move("c5", "c6");
        System.out.println(board);
    }
}
