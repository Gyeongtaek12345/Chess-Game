package chess;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import pieces.Piece;
import pieces.Position;

import static org.junit.jupiter.api.Assertions.*;
import static utils.StringUtils.appendNewLine;

class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }
    @Test
    @DisplayName("피스들이 들어간 보드가 생성되었습니다.")
    void createBoard() throws Exception {
        board.initialize();
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.showBoard());
    }
    @Test
    @DisplayName("비어있는 보드가 생성되었습니다.")
    void createEmptyBoard() throws Exception {
        board.initializeEmpty();
        String blankRank = appendNewLine("........");
        assertEquals(
                blankRank + blankRank +
                        blankRank + blankRank +
                        blankRank + blankRank +
                        blankRank + blankRank,
                board.showBoard());
    }
    @Test
    @DisplayName("FindPiece로 찿은 피스와 표기 문자와 색이 같은지 체크합니다.")
    public void findPiece() throws Exception {
        board.initialize();
        assertEquals(Piece.createBlackRook(new Position("a8")), board.findPiece("a8"));
        assertEquals(Piece.createBlackRook(new Position("h8")), board.findPiece("h8"));
        assertEquals(Piece.createWhiteRook(new Position("a1")), board.findPiece("a1"));
        assertEquals(Piece.createWhiteRook(new Position("h1")), board.findPiece("h1"));
    }
}