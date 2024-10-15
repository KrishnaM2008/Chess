import java.util.ArrayList;

public class BoardClass {
    public ArrayList <ChessBoardPositions> positions = new ArrayList<>();
    public Integer[] ranks = {8, 7, 6, 5, 4, 3, 2, 1};
    public Integer[] numFiles = {1,2,3,4,5,6,7,8};

    public void establishBoard(){
        //establish positions
        for (int rank : ranks) {
            for (int file : numFiles) {
                positions.add(new ChessBoardPositions(rank, file));
            }
        }

        //establish pieces
            //pawns
            setPieceVal(7, 1, "P");
            setPieceVal(7, 2, "P");
            setPieceVal(7, 3, "P");
            setPieceVal(7, 4, "P");
            setPieceVal(7, 5, "P");
            setPieceVal(7, 6, "P");
            setPieceVal(7, 7, "P");
            setPieceVal(7, 8, "P");

            setPieceVal(2, 1, "P");
            setPieceVal(2, 2, "P");
            setPieceVal(2, 3, "P");
            setPieceVal(2, 4, "P");
            setPieceVal(2, 5, "P");
            setPieceVal(2, 6, "P");
            setPieceVal(2, 7, "P");
            setPieceVal(2, 8, "P");

            //kings
            setPieceVal(1,5,"K");
            setPieceVal(8,5,"K");
            //bishops
            setPieceVal(1,6,"B");
            setPieceVal(1,3,"B");
            setPieceVal(8,6,"B");
            setPieceVal(8,3,"B");

            //queens
            setPieceVal(1,4,"Q");
            setPieceVal(8,4,"Q");

            //rooks
            setPieceVal(8,8,"R");
            setPieceVal(8,1,"R");
            setPieceVal(1,8,"R");
            setPieceVal(1,1,"R");
            //knights
            setPieceVal(1,7,"K");
            setPieceVal(1,2,"K");
            setPieceVal(8,2,"K");
            setPieceVal(8,7,"K");

            
            //empty spaces
            for(int i = 0; i < 8; i++){
                setPieceVal(3, i+1, "-");
                setPieceVal(4, i+1, "-");
                setPieceVal(5, i+1, "-");
                setPieceVal(6, i+1, "-");
            }
    }

    public void printBoard(){
        System.out.println(" __________________________");
        System.out.println("|                          |");
        String x = "8 ";
        int counter = 0;
        int r = 7;
        for(int i = 0; i < positions.size(); i++){
            x = x + " " + positions.get(i).getPiece() + " ";
            counter++;
            if (counter % 8 == 0) {
                x = x + " | "+ "\n"+ r +" ";
                counter = 0;
                r--;
            }
        }
        int y = x.indexOf("0");
        x = x.substring(0, y) + x.substring(y+1);

        x = x.substring(0, x.length() - 1) +"|__a__b__c__d__e__f__g__h__|";
        System.out.println(x);
        System.out.println("");
    }

    public void pawn (ChessBoardPositions pos, int r1, int r2) {
        pos.setPiece("P");
    }
    public void King (ChessBoardPositions pos) {
        pos.setPiece("K");
    }
    public void Knight (ChessBoardPositions pos) {
        pos.setPiece("N");
    }
    public void Queen (ChessBoardPositions pos) {
        pos.setPiece("Q");
    }
    public void Rook (ChessBoardPositions pos) {
        pos.setPiece("R");
    }
    public void Bishop (ChessBoardPositions pos) {
        pos.setPiece("B");
    }


    public String numtoletter(int num){
        return switch (num) {
            case 1 -> "a";
            case 2 -> "b";
            case 3 -> "c";
            case 4 -> "d";
            case 5 -> "e";
            case 6 -> "f";
            case 7 -> "g";
            case 8 -> "h";
            default -> "n/a";
        };
    }
    public void movePiece(ChessBoardPositions pos1, ChessBoardPositions pos2){
        String piece = pos1.getPiece();
        pos1.setPiece("-");
        pos2.setPiece(piece);
    }

    public void setPieceVal(int row, int column, String piece){
        for(int i = 0; i < positions.size(); i++){
                if (positions.get(i).getRow() == row && positions.get(i).getColumn() == column) {
                    positions.get(i).setPiece(piece);
                }
        }
    }

}

