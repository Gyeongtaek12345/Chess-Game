package pieces;

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
    @MethodSource("whitePieceTypeProvider")
    void createWhitePieces(Piece piece, Piece.PieceType pieceType){
        verifyPiece(piece, WHITE, pieceType);
    }
    static Stream<Arguments> whitePieceTypeProvider() {
        return Stream.of(
                arguments(Piece.createWhitePawn(), PAWN),
                arguments(Piece.createWhiteRook(), ROOK),
                arguments(Piece.createWhiteKnight(), KNIGHT),
                arguments(Piece.createWhiteBishop(), BISHOP),
                arguments(Piece.createWhiteQueen(), QUEEN),
                arguments(Piece.createWhiteKing(), KING)
        );
    }
    @ParameterizedTest
    @MethodSource("blackPieceTypeProvider")
    void createBlackPieces(Piece piece,Piece.PieceType pieceType){
        verifyPiece(piece,BLACK, pieceType);
    }
    static Stream<Arguments> blackPieceTypeProvider() {
        return Stream.of(
                arguments(Piece.createBlackPawn(), PAWN),
                arguments(Piece.createBlackRook(), ROOK),
                arguments(Piece.createBlackKnight(), KNIGHT),
                arguments(Piece.createBlackBishop(), BISHOP),
                arguments(Piece.createBlackQueen(), QUEEN),
                arguments(Piece.createBlackKing(), KING)
        );
    }
    void verifyPiece(final Piece piece, final Piece.PieceColor color, final Piece.PieceType pieceType) {
        assertEquals(color, piece.getColor());
        if (piece.isWhite()){
            assertEquals(pieceType.getWhiteRepresentation(), piece.getRepresentation());
        }else{
            assertEquals(pieceType.getBlackRepresentation(), piece.getRepresentation());
        }
    }
}