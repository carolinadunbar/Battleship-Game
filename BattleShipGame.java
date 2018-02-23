/** 
Battleship Game
*/

import java.util.Scanner;

public class BattleShipGame {

		int[][] board = new int[5][5];
        int[][] ships = new int[3][3];
        int[] shoot = new int[2];
        private int attempts=0,
            shotHit=0;

    
    public void initBoard(int[][] board){
        for(int row=0 ; row < 5 ; row++ )
            for(int column=0 ; column < 5 ; column++ )
                board[row][column]=-1;
    }
    
    public void showBoard(int[][] board){
        System.out.println("\t1 \t2 \t3 \t4 \t5");
        System.out.println();
        
        for(int row=0 ; row < 5 ; row++ ){
            System.out.print((row+1)+"");
            for(int column=0 ; column < 5 ; column++ ){
                if(board[row][column]==-1){
                    System.out.print("\t"+"~");
                }else if(board[row][column]==0){
                    System.out.print("\t"+"*");
                }else if(board[row][column]==1){
                    System.out.print("\t"+"X");
                }
                
            }
            System.out.println();
        }

    }

    public void initShips(int[][] ships){
		Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Input numbers between 1 and 5 with the row typed first then column");
		
        for(int ship=0 ; ship <3 ; ship++){
			System.out.println();
            ships[ship][0]=keyboard.nextInt()-1;
            ships[ship][1]=keyboard.nextInt()-1;
            
            for(int last=0 ; last < ship ; last++){
                if((ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1]))
                    do{
                        ships[ship][0]=keyboard.nextInt()-1;
                        ships[ship][1]=keyboard.nextInt()-1;
                    }while((ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1]));
            }
            
        }
    }

    public void shoot(int[] shoot){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Row: ");
        shoot[0] = input.nextInt();
        shoot[0]--;
        
        System.out.print("Column: ");
        shoot[1] = input.nextInt();
        shoot[1]--;
        
    }
    
    public boolean hit(int[] shoot, int[][] ships){
        // System.out.println("ships.length = " + ships.length);
        for(int ship=0 ; ship<ships.length ; ship++){
            if( shoot[0]==ships[ship][0] && shoot[1]==ships[ship][1]){
                System.out.printf("You hit a ship located in (%d,%d)\n",shoot[0]+1,shoot[1]+1);
                return true;
            }
		}
	  return false;
    }

    public void changeboard(int[] shoot, int[][] ships, int[][] board){
        if(hit(shoot,ships))
            board[shoot[0]][shoot[1]]=1;
        else
            board[shoot[0]][shoot[1]]=0;
    }
    
    public int attemptCounter(){
    return attempts++;
    }
    
    public int getAttempts(){
    	return attempts;
    }
}
