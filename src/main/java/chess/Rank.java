package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private static final int RANK_SIZE = 8;
    List<Piece> pieces = new ArrayList<>(RANK_SIZE);
    private void addPiece(Piece piece){
        pieces.add(piece);
    }
    public List<Piece> getPieces() {
        return pieces;
    }
    public static Rank initializeWhitePawns(){
        Rank rank = new Rank();
        for(int i = 0; i < RANK_SIZE; i++) {
            rank.addPiece(Piece.createWhitePawn());
        }
        return rank;
    }
    public static Rank initializeWhitePieces(){
        Rank rank = new Rank();
        rank.addPiece(Piece.createWhiteRook());
        rank.addPiece(Piece.createWhiteKnight());
        rank.addPiece(Piece.createWhiteBishop());
        rank.addPiece(Piece.createWhiteQueen());
        rank.addPiece(Piece.createWhiteKing());
        rank.addPiece(Piece.createWhiteBishop());
        rank.addPiece(Piece.createWhiteKnight());
        rank.addPiece(Piece.createWhiteRook());
        return rank;
    }
    public static Rank initializeBlackPawns(){
        Rank rank = new Rank();
        for(int i = 0; i < RANK_SIZE; i++) {
            rank.addPiece(Piece.createBlackPawn());
        }
        return rank;
    }
    public static Rank initializeBlackPieces(){
        Rank rank = new Rank();
        rank.addPiece(Piece.createBlackRook());
        rank.addPiece(Piece.createBlackKnight());
        rank.addPiece(Piece.createBlackBishop());
        rank.addPiece(Piece.createBlackQueen());
        rank.addPiece(Piece.createBlackKing());
        rank.addPiece(Piece.createBlackBishop());
        rank.addPiece(Piece.createBlackKnight());
        rank.addPiece(Piece.createBlackRook());
        return rank;
    }
    public static Rank initializeBlank(){
        Rank rank = new Rank();
        for(int i = 0; i < RANK_SIZE; i++) {
            rank.addPiece(Piece.createBlank());
        }
        return rank;
    }

}
