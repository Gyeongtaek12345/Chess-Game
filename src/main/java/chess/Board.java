package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.*;

public class Board {
    private final int BOARD_WIDTH = 8;
    private final int BOARD_HEIGHT = 8;
    private int pieceCount = 0;
    private List<Rank> ranks = new ArrayList<>(BOARD_HEIGHT);
    public void addRanks(Rank rank) {
        ranks.add(rank);
    }
    public void initialize(){
        addRanks(Rank.initializeBlackPieces());
        addRanks(Rank.initializeBlackPawns());
        addRanks(Rank.initializeBlank());
        addRanks(Rank.initializeBlank());
        addRanks(Rank.initializeBlank());
        addRanks(Rank.initializeBlank());
        addRanks(Rank.initializeWhitePawns());
        addRanks(Rank.initializeWhitePieces());
    }
    public int totalSize(){
        return pieceCount;
    }
//    public Piece findWhitePawn(int index){
//        return whitePawns.get(index);
//    }
//    public Piece findBlackPawn(int index){
//        return blackPawns.get(index);
//    }
    private String getRankString(Rank rank) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank.getPieces()) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }
    public String showBoard(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<ranks.size()-1;i++){
            sb.append(appendNewLine(getRankString(ranks.get(i))));
        }
        sb.append(getRankString(ranks.get(7)));
        return sb.toString();
    }
}
