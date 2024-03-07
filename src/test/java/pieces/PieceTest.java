package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static pieces.Piece.PieceColor.*;
import static pieces.Piece.PieceType.*;

class PieceTest {
    @ParameterizedTest
    @DisplayName("흰색 피스들이 생성되었습니다.")
    @MethodSource("whitePieceTypeProvider")
    void createWhitePieces(Piece piece, Piece.PieceType pieceType){
        verifyPiece(piece, WHITE, pieceType);
    }
    static Stream<Arguments> whitePieceTypeProvider() {
        Position position = new Position("a1");
        return Stream.of(
                arguments(Piece.createWhitePawn(position), PAWN),
                arguments(Piece.createWhiteRook(position), ROOK),
                arguments(Piece.createWhiteKnight(position), KNIGHT),
                arguments(Piece.createWhiteBishop(position), BISHOP),
                arguments(Piece.createWhiteQueen(position), QUEEN),
                arguments(Piece.createWhiteKing(position), KING)
        );
    }
    @ParameterizedTest
    @DisplayName("검은색 피스들이 생성되었습니다.")
    @MethodSource("blackPieceTypeProvider")
    void createBlackPieces(Piece piece,Piece.PieceType pieceType){
        verifyPiece(piece,BLACK, pieceType);
    }
    static Stream<Arguments> blackPieceTypeProvider() {
        Position position = new Position("a1");
        return Stream.of(
                arguments(Piece.createBlackPawn(position), PAWN),
                arguments(Piece.createBlackRook(position), ROOK),
                arguments(Piece.createBlackKnight(position), KNIGHT),
                arguments(Piece.createBlackBishop(position), BISHOP),
                arguments(Piece.createBlackQueen(position), QUEEN),
                arguments(Piece.createBlackKing(position), KING)
        );
    }
    @Test
    @DisplayName("Empty 객체가 생성되었습니다.")
    void createBlank(){
        verifyPiece(Piece.createBlank(new Position("a1")),NO_COLOR, NO_PIECE);
    }
    void verifyPiece(final Piece piece, final Piece.PieceColor color, final Piece.PieceType pieceType) {
        assertEquals(color, piece.getColor());
        if (piece.isWhite() || piece.getColor().equals(NO_COLOR)){
            assertEquals(pieceType.getWhiteRepresentation(), piece.getRepresentation());
        }else{
            assertEquals(pieceType.getBlackRepresentation(), piece.getRepresentation());
        }
    }
}