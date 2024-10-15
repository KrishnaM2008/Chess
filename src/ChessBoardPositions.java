public class ChessBoardPositions {
    public int row;
    public int  column;
    public String piece;

    public ChessBoardPositions(int rowString, int columnString){
        row = rowString;
        column = columnString;
        piece = " - ";
    }

    public String getPosition()
    { 
        return "(" + column + "," + row + ")";
    }

    public String getPiece(){
        return piece;
    }

    public int getRow(){
        return row;
    }

    public int  getColumn(){
        return column;
    }

    public void setPiece(String pieceString){
        piece = pieceString;
    }

    public void pieceValue(){
        
    }
}