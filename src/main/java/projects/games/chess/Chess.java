package projects.games.chess;

public interface Chess {
    static void play() {
        ChessBoard board = new ChessBoard();
        board.move("c2", "c4");
        System.out.println(board);
    }
}
