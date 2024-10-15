import java.util.Scanner;
public class mainClass {
    public static int lettertoNum(String x){
        switch (x) {
            case "a" -> {
                return 1;
            }
            case "b" -> {
                return 2;
            }
            case "c" -> {
                return 3;
            }
            case "d" -> {
                return 4;
            }
            case "e" -> {
                return 5;
            }
            case "f" -> {
                return 6;
            }
            case "g" -> {
                return 7;
            }
            case "h" -> {
                return 8;
            }
            default -> {
            }
        }
        return 0;
    }
    public static void main(String[] args) throws Exception {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Hello, who is player 1?");
            String player1 = scan.nextLine();
            System.out.println("Hello, who is player 2?");
            String player2 = scan.nextLine();
            System.out.println("Let's play! " + player1 + " vs " + player2 + ".");
            
            BoardClass board = new BoardClass();
            board.establishBoard();
            board.printBoard();
            String game = "";
            /*            System.out.println(board.getPieceVal(1,1)); */

           OUTER:
              while (!"quit".equals(game)) {
                System.out.println("What would you like to do?\n1. Move\n2. Quit \n3. Checkmate\n4. Stalemate\n5. Draw\n6. Illegal Move");
                game = scan.nextLine();
                switch (game) {
                    case "1" -> {
                        System.out.println("Please enter the position of the piece you would like to move");
                        String pos1 = scan.nextLine();
                        System.out.println("Please enter the position you would like to move to");
                        String pos2 = scan.nextLine();
                        //pos1
                        int pos1Col = lettertoNum(pos1.substring(0, 1));
                        int pos1Row = Integer.parseInt(pos1.substring(1, 2));
                        ChessBoardPositions pos1Pos = new ChessBoardPositions(pos1Row, pos1Col);
                        //pos2
                        int pos2Col = lettertoNum(pos1.substring(0, 1));
                        int pos2Row = Integer.parseInt(pos2.substring(1, 2));
                        ChessBoardPositions pos2Pos = new ChessBoardPositions(pos2Row, pos2Col);
                        for(int i = 0; i < board.positions.size(); i++){
                            if (board.positions.get(i).getColumn() == (pos1Col)) {
                                if (board.positions.get(i).getRow() == (pos1Row)) {
                                    pos1Pos = board.positions.get(i);
                                }
                            }
                            if (board.positions.get(i).getColumn() == (pos2Col)) {
                                if (board.positions.get(i).getRow() == (pos2Row)) {
                                    pos2Pos = board.positions.get(i);
                                }
                            }
                        }   board.movePiece(pos1Pos, pos2Pos);
                        board.printBoard();
                    }
                    case "2" -> {
                        System.out.println("Game aborted");
                        game = "quit";
                        break OUTER;
                    }
                    case "3" -> {
                        System.out.println("Checkmate!");
                        System.out.println("Who won?");
                        String winner = scan.nextLine();
                        System.out.println(winner + " won!");
                        game = "quit";
                        break OUTER;
                    }
                    case "4" -> {
                        System.out.println("Stalemate!");
                        game = "quit";
                        break OUTER;
                    }
                    case "5" -> {
                        System.out.println("Draw!");
                        game = "quit";
                        break OUTER;
                    }
                    case "6" -> {
                        System.out.println("Illegal Move!");
                        System.out.println("Who made the illegal move?");
                        String player = scan.nextLine();
                        System.out.println(player + " made an illegal move!");
                        if(player1.equals(player)){
                            System.out.println(player2 + " won!");
                            game = "quit";
                        } else {
                            System.out.println(player1 + " won!");
                            game = "quit";
                        }   break OUTER;
                    }
                    default -> {
                    }
                }
                System.out.println("");
            } 
        }
    }
}
