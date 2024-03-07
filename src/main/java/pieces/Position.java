package pieces;

public class Position {
    private int x;
    private int y;
    public Position(String piecePosition){
        this.x = piecePosition.charAt(0)-'a';
        this.y = piecePosition.charAt(1)-49;
    }
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
