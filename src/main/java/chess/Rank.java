package chess;

import pieces.Piece;
import pieces.Position;

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
    public Piece findPiece(int xIndex){
        return pieces.get(xIndex);
    }
    public static Rank initializeWhitePawns(int rankIndex){
        Rank rank = new Rank();
        for(int i = 0; i < RANK_SIZE; i++) {
            rank.addPiece(Piece.createWhitePawn(new Position(i,rankIndex)));
        }
        return rank;
    }
    public static Rank initializeWhitePieces(int rankIndex){
        Rank rank = new Rank();
        rank.addPiece(Piece.createWhiteRook(new Position(0,rankIndex)));
        rank.addPiece(Piece.createWhiteKnight(new Position(1,rankIndex)));
        rank.addPiece(Piece.createWhiteBishop(new Position(2,rankIndex)));
        rank.addPiece(Piece.createWhiteQueen(new Position(3,rankIndex)));
        rank.addPiece(Piece.createWhiteKing(new Position(4,rankIndex)));
        rank.addPiece(Piece.createWhiteBishop(new Position(5,rankIndex)));
        rank.addPiece(Piece.createWhiteKnight(new Position(6,rankIndex)));
        rank.addPiece(Piece.createWhiteRook(new Position(7,rankIndex)));
        return rank;
    }
    public static Rank initializeBlackPawns(int rankIndex){
        Rank rank = new Rank();
        for(int i = 0; i < RANK_SIZE; i++) {
            rank.addPiece(Piece.createBlackPawn(new Position(i,rankIndex)));
        }
        return rank;
    }
    public static Rank initializeBlackPieces(int rankIndex){
        Rank rank = new Rank();
        rank.addPiece(Piece.createBlackRook(new Position(0,rankIndex)));
        rank.addPiece(Piece.createBlackKnight(new Position(1,rankIndex)));
        rank.addPiece(Piece.createBlackBishop(new Position(2,rankIndex)));
        rank.addPiece(Piece.createBlackQueen(new Position(3,rankIndex)));
        rank.addPiece(Piece.createBlackKing(new Position(4,rankIndex)));
        rank.addPiece(Piece.createBlackBishop(new Position(5,rankIndex)));
        rank.addPiece(Piece.createBlackKnight(new Position(6,rankIndex)));
        rank.addPiece(Piece.createBlackRook(new Position(7,rankIndex)));
        return rank;
    }
    public static Rank initializeBlank(int rankIndex){
        Rank rank = new Rank();
        for(int i = 0; i < RANK_SIZE; i++) {
            rank.addPiece(Piece.createBlank(new Position(i,rankIndex)));
        }
        return rank;
    }
}
