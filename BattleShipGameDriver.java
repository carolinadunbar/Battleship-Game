/**
Driver for Game
*/
import java.util.Scanner;

public class BattleShipGameDriver {


		public static void main(String[] args) {
		 
		int[][] board = new int[5][5];
        int[][] ships = new int[3][3];
        int[] shoot = new int[2];
        int attempts=0,
            shotHit=0;
		System.out.println("\nPlayer 1 will place their ships first and Player 2 will attack first \n");
		System.out.println(" A '~' is the water \n An '*' is a shot and miss \n An X is a hit.");
    {
		 
       	BattleShipGame p1 = new BattleShipGame();
       	
       	System.out.println("\n \nPlayer 1 where would you like your 3 ships to be?");
       
        
        p1.initBoard(board);
        p1.initShips(ships);
        
        for(int n=0 ; n < 50 ; n++ ){
            System.out.println();
        }
        
        
        
        
        System.out.println("Player 2 begin playing!");
        
        System.out.println();
        
        do{
            p1.showBoard(board);
            p1.shoot(shoot);
            p1.attemptCounter();
            
            if(p1.hit(shoot,ships)){
                shotHit++;
                p1.changeboard(shoot,ships,board);
            }                
            else
            p1.changeboard(shoot,ships,board);
            

        }while(shotHit!=3);
        
        
        System.out.println("\n\n\nBattleship Java game finished! Player 2 hit 3 ships in "+ p1.getAttempts()+" attempts");
        p1.showBoard(board);
    
        
        BattleShipGame p2 = new BattleShipGame();
        
    	System.out.println();
    	System.out.println();
        System.out.println("Player 2 where would you like your 3 ships to be?");
        System.out.println();
        
        p2.initBoard(board);
        p2.initShips(ships);
        shotHit=0;
        
        for(int n=0 ; n < 50 ; n++ ){
            System.out.println();
        }
        
        
        	
        
        
        System.out.println("Player 1 begin playing!");
        System.out.println();
        
        do{
            p2.showBoard(board);
            p2.shoot(shoot);
            p2.attemptCounter();
            
            if(p2.hit(shoot,ships)){
                shotHit++;
                p2.changeboard(shoot,ships,board);
            }                
           else
            p2.changeboard(shoot,ships,board);
            

        }while(shotHit != 3);
        
        System.out.println("\n\n\nPlayer 1 hit 3 ships in "+ p2.getAttempts()+" attempts");
        p2.showBoard(board);
    
    	if (p1.getAttempts() < p2.getAttempts()){
    	System.out.println("Player 2 wins!");
    	}
    	if(p2.getAttempts() < p1.getAttempts()){
    	System.out.println("Player 1 wins!");
		}
		if (p1.getAttempts() == p2.getAttempts()){
			System.out.println("Tie!!");
		}
    
    }
}
}
