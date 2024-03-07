package pieces;

import static pieces.Piece.PieceColor.*;
import static pieces.Piece.PieceType.*;
public class Piece {
    public enum PieceColor {
        WHITE, BLACK, NO_COLOR;
    }
    public enum PieceType {
        PAWN('p'), KNIGHT('n'), ROOK('r'),
        BISHOP('b'), QUEEN('q'), KING('k'),
        NO_PIECE('.');
        private final char representation;
        PieceType(char representation) {
            this.representation = representation;
        }
        public char getWhiteRepresentation() {
            return this.representation;
        }
        public char getBlackRepresentation() {
            return Character.toUpperCase(this.representation);
        }
    }
    private final PieceColor teamColor;
    private final PieceType pieceType;
    private final Position position;
    private Piece(PieceColor color, PieceType pieceType, Position position){
        this.teamColor = color;
        this.pieceType = pieceType;
        this.position = position;
    }
    public PieceColor getColor(){
        return teamColor;
    }
    public PieceType getPieceType(){return pieceType;}
    public Position getPosition(){return position;}
    public boolean isWhite(){
        return teamColor.equals(WHITE);
    }
    public char getRepresentation(){
        if (isWhite() || teamColor.equals(NO_COLOR)){
            return pieceType.getWhiteRepresentation();
        }else {
            return pieceType.getBlackRepresentation();
        }
    }
    // 팩토리 메서드
    public static Piece createWhitePawn(Position position) {
        return new Piece(WHITE, PAWN,position);
    }
    public static Piece createBlackPawn(Position position) {
        return new Piece(BLACK, PAWN,position);
    }
    public static Piece createWhiteKnight(Position position) {
        return new Piece(WHITE, KNIGHT,position);
    }
    public static Piece createBlackKnight(Position position) {
        return new Piece(BLACK, KNIGHT,position);
    }
    public static Piece createWhiteRook(Position position) {
        return new Piece(WHITE, ROOK,position);
    }
    public static Piece createBlackRook(Position position) {
        return new Piece(BLACK, ROOK,position);
    }
    public static Piece createWhiteBishop(Position position) {
        return new Piece(WHITE, BISHOP,position);
    }
    public static Piece createBlackBishop(Position position) {
        return new Piece(BLACK, BISHOP,position);
    }
    public static Piece createWhiteQueen(Position position) {
        return new Piece(WHITE, QUEEN,position);
    }
    public static Piece createBlackQueen(Position position) {
        return new Piece(BLACK, QUEEN,position);
    }
    public static Piece createWhiteKing(Position position) {
        return new Piece(WHITE, KING,position);
    }
    public static Piece createBlackKing(Position position) {
        return new Piece(BLACK, KING,position);
    }
    public static Piece createBlank(Position position) {
        return new Piece(NO_COLOR, NO_PIECE,position);
    }
    @Override
    public String toString() {
        return this.pieceType.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Piece piece = (Piece) obj;
        return pieceType == piece.pieceType && teamColor == piece.teamColor;
    }
}

