package chess;

import pieces.Piece;
import pieces.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
        addRanks(Rank.initializeWhitePieces(0));
        addRanks(Rank.initializeWhitePawns(1));
        addRanks(Rank.initializeBlank(2));
        addRanks(Rank.initializeBlank(3));
        addRanks(Rank.initializeBlank(4));
        addRanks(Rank.initializeBlank(5));
        addRanks(Rank.initializeBlackPawns(6));
        addRanks(Rank.initializeBlackPieces(7));
    }
    public void initializeEmpty(){
        for (int i = 0;i<BOARD_HEIGHT;i++){
            addRanks(Rank.initializeBlank(i));
        }
    }
    public int totalSize(){
        return pieceCount;
    }
    private String getRankString(Rank rank) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank.getPieces()) {
            sb.append(piece.getRepresentation());
        }
        return appendNewLine(sb.toString());
    }
    public String showBoard(){
        StringBuilder sb = new StringBuilder();
        ListIterator<Rank> ranksItr = ranks.listIterator(ranks.size());
        while(ranksItr.hasPrevious()){
            sb.append(getRankString(ranksItr.previous()));
        }
        return sb.toString();
    }
    public Piece findPiece(String position) {
        Position target = new Position(position);
        return ranks.get(target.getY()).findPiece(target.getX());
    }
    public int countPiece(Piece.PieceColor pieceColor, Piece.PieceType pieceType){
        int count = 0;
        for(Rank rank : ranks){
            count += rank.countPiece(pieceColor,pieceType);
        }
        return count;
    }
}
