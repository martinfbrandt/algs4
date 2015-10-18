import java.util.Stack;
import java.util.Iterator;
import java.lang.Iterable;


public class Board {
  private int dimension;
  private int emptyIndex;
  private int[] zeroNeighbors;
  private int[] board;
  
  //find neighbors for index containing 0
  private int[] zeroNeighbors() {
   zeroNeighbors= new int[4];
   int index=0;
   int above=emptyIndex-dimension;
   int below = emptyIndex+dimension;
   if (above>0){
     // has item above
     zeroNeighbors[index]=above;
     index++;
   }
   if (below>=(dimension*dimension)){
     //has item below
     zeroNeighbors[index]=below;
     index++;
   }
   if (emptyIndex%dimension!=0){
     //has left
     zeroNeighbors[index]=emptyIndex-1;
     index++;
   }
   if ((emptyIndex+1)%dimension!=0){
   //has right
     zeroNeighbors[index]=emptyIndex+1;
     index++;
   }
   return zeroNeighbors;
  }
  
  
  
  public Board(int[][] blocks) {
    //set dimension to length of first array
    dimension = blocks[0].length;
    //imterate through blocks and add them to a board object
    //set empty index where ==0 
    
    board = new int[blocks.length*blocks.length];
    //create neighbors
    for (int i = 0;i<blocks.length*blocks.length;i++){
      
      board[i]=blocks[i/dimension][i%dimension];
      if (board[i]==0){
        emptyIndex=i;
      }
    }
   
    //init board with dimension squared as size, add elements to it
  }          // construct a board from an N-by-N array of blocks
  
  
                                           // (where blocks[i][j] = block in row i, column j)
    public int dimension()  
    {
      //return dimension 
      return dimension;
    }      
// board dimension N
    
    
    
    public int hamming() {
      int count = 0;
      //iterate through board and check if index +1 = board number, add 1 to count
      
      //return count + num moves
      return 1;
    }          // number of blocks out of place
    
    
    
    public int manhattan()    {
      int sum = 0;
      //iterate through board and use function i wrote
      return 1;
    }             // sum of Manhattan distances between blocks and goal
    
    
    
    public boolean isGoal()  {
      // iterate, if all elemetns are index+1 except for last item then goal
      
      return true;
    }              // is this board the goal board?
    
    
    
    public Board twin()   {
      //iterate through board and add to new board, except if value !=0 then exchange with other value if not equal to 0
      return new Board(new int[1][1]);
    
    }                 // a board that is obtained by exchanging any pair of blocks
    
    
    
    public boolean equals(Object y) {
      // use transaction example for this function
      return true;
    }       // does this board equal y?
    
    
    public Iterable<Board> neighbors() {
     //create new stack 
      Stack<Board> neighbors= new Stack<Board>();
      //for each item in zeroNeighbors
      int index=0;
      int[] zeroNeighbors = zeroNeighbors();
      System.out.println(zeroNeighbors[1]);
      while (zeroNeighbors[index]!=0){
        int zeroNeighborIndex=zeroNeighbors[index];
        //create new array
        int[][] newBoard= new int[dimension][dimension];
        //fill array with copy
        for (int i = 0;i<this.board.length;i++){
          //add elements to array
          
          newBoard[i/dimension][i%dimension]=this.board[i];
        }
       //perform swap
        newBoard[emptyIndex/dimension][emptyIndex%dimension]=newBoard[zeroNeighborIndex/dimension][zeroNeighborIndex%dimension];
        //add zero in 
        newBoard[zeroNeighborIndex/dimension][zeroNeighborIndex%dimension]=0;
        neighbors.push(new Board(newBoard));
        index++;
      }

      return neighbors;
    }    // all neighboring boards
    public String toString()               // string representation of this board (in the output format specified below)
    {
      return "test";
    }
    public static void main(String[] args)
    {
      int[][] test = new int[3][3];
      test[0][0] = 2;
      test[1][0] = 1;
      test[2][0] = 3;
     test[0][1] = 5;
      test[1][1] = 7;
      test[2][1] = 8;
    test[0][2] = 0;
      test[1][2] = 6;
      test[2][2] = 4;
      Board b = new Board(test);
      Iterable<Board> s  = b.neighbors(); 
      for (Board b2:s){System.out.println(b2);
      }
    }// unit tests (not graded)
}