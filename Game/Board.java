package Game;


public class Board 
{	// Board 1 == Human Board, Board 2 == Computer Board
	private int[][] board1, board2;
	/*Constructor
	Creates 10x10 boards for human and computer
	
	*/
	public Board() 
	{
	    int x=10;
	    board1 = new int[x][x];
	    board2 = new int[x][x];      
	}	
	//Getters for Board1 and Board2
	public int[][] getBoard1() 
	{
		return board1;
	}
	public int[][] getBoard2() 
	{
		return board2;
	}
	
	//Setters for individual locations on Board1 and Board2
	public void setBoard1(int i,int j,int value) 
	{
		this.board1[i][j]=value;
	}
	
	public void setBoard2(int i,int j,int value) 
	{
		this.board2[i][j]=value;
	}
	
	
	/*Setter for Computer Board
	Takes start and end tiles for ships and places the ships
	Populates the area around the ships as empty sea
	*/
	
	public void setBoardComputer(Tile t1,Tile t2) 
	{

    	{if (t1.getX()==t2.getX())
    		for (int i=t1.getY();i<t2.getY();i++)
    			setBoard2(t1.getX(),i,2);
   
    	else if (t1.getY()==t2.getY())
    		for (int i=t1.getX();i<t2.getX();i++)
    			setBoard2(i,t1.getY(),2);}

	
    for (int i=0;i<10;i++)
    	for(int j=0;j<10;j++)
    		
    		if(getBoard2()[i][j]!=1 && getBoard2()[i][j]!=2)
    				setBoard2(i,j,0);	
	}
	/*Setter for Human Board
	Takes start and end tiles for ships and places the ships
	Populates the area around the ships as empty sea
	*/
	public void setBoardHuman(Tile t1,Tile t2)
	{ 
	    if (t1.getX()==t2.getX())
	    {
	    	if (t1.getY()<t2.getY())
	   	  		for (int i=t1.getY();i<t2.getY();i++)
	   	  			setBoard1(t1.getX(),i,1);
	    	else if (t1.getY()>t2.getY())
	    		for (int i=t2.getY();i<t1.getY();i++)
	   	  			setBoard1(t1.getX(),i,1);}

	   if (t1.getY()==t2.getY())
	   {
		   if (t1.getX()<t2.getX())
		   	  	for (int i=t1.getX();i<t2.getX();i++)
		   	  		setBoard1(i,t1.getY(),1);
		   else if  (t1.getX()>t2.getX())
		   	  	for (int i=t2.getX();i<t1.getX();i++)
		   	  		setBoard1(i,t1.getY(),1);
	    }
		
	    for (int i=0;i<10;i++)
	    	for(int j=0;j<10;j++)
	    	{
	    		if(getBoard1()[i][j]!=1 && getBoard1()[i][j]!=2)
	    			setBoard1(i,j,0);
	    	}	
	}
	//Checks whether the given coordinates are within bounds
	public  boolean inBounds(Tile location) 
	{
		if( location.getX() >= 0 && location.getX() < 10 && location.getY() >= 0 && location.getY() < 10)
			return true;
	    else 
	    	return false;
	}
	
/* Legend: 
0 - empty location 
1 - Player's ship - print (#) 
2 - Computer's ship(@). 
3 - Sunk ship - print (!) 
4 - Miss - print (~) 
 
*/
	
	//Print the board
	
	public void printBoard() 
	{
		System.out.println("     0  1  2  3  4  5  6  7  8  9 \t\t     0  1  2  3  4  5  6  7  8  9  ");
		System.out.println("     -----------------------------\t\t     -----------------------------");
			for (int i=0;i<10;i++)
			{
				System.out.print(i+ " |  ");
				for(int j=0;j<10;j++)
				{
					if(getBoard1()[i][j]==0)
						System.out.print(" "+"  ");
					if (getBoard1()[i][j]==1)
						System.out.print("#"+"  ");
					if (getBoard1()[i][j]==3)
						System.out.print("!"+"  ");
					if (getBoard1()[i][j]==4)
						System.out.print("~"+"  ");
					if (j==9)
						System.out.print( " | "+i);
				}
			System.out.print("\t \t");
			System.out.print(i+ " |  ");
			for(int k=0;k<10;k++)
			{
				if(getBoard2()[i][k]==0)
					System.out.print(" "+"  ");
				if (getBoard2()[i][k]==2)
					System.out.print("@"+"  ");
				if (getBoard2()[i][k]==3)
					System.out.print("!"+"  ");
				if (getBoard2()[i][k]==4)
					System.out.print("~"+"  ");
				if (k==9)
					System.out.print( " | "+i);}
				System.out.println();
			}
			System.out.println("     -----------------------------\t\t     -----------------------------");
			System.out.println("     0  1  2  3  4  5  6  7  8  9 \t\t     0  1  2  3  4  5  6  7  8  9  ");
			System.out.println("             Human Board          \t\t             Computer Board ");
	}

	public void printBoard(int z) 
	{
		System.out.println("     0  1  2  3  4  5  6  7  8  9 \t\t     0  1  2  3  4  5  6  7  8  9  ");
		System.out.println("     -----------------------------\t\t     -----------------------------");
			for (int i=0;i<10;i++)
			{
				System.out.print(i+ " |  ");
				for(int j=0;j<10;j++)
				{
					System.out.print(getBoard1()[i][j]+"  ");
				if (j==9)
					System.out.print( "| "+i);
				}
				System.out.print("\t \t");
				System.out.print(i+ " |  ");
				for(int k=0;k<10;k++)
				{
					System.out.print(getBoard2()[i][k]+"  ");
				if (k==9)
					System.out.print( "| "+i);
				}
				System.out.println();
			}
			System.out.println("     -----------------------------\t\t     -----------------------------");
			System.out.println("     0  1  2  3  4  5  6  7  8  9 \t\t     0  1  2  3  4  5  6  7  8  9  ");
			System.out.println("             Human Board          \t\t             Computer Board ");
	}
	
	/*
	public static void main(String args[])
	{ 
		Board b=new Board();
		Tile t1= new Tile(2,3);
		Tile t2=new Tile(4,3);
		Tile t3= new Tile(7,4);
		Tile t4=new Tile(4,4);
	/*  b.setBoard(t1, t2, "Human");
	  b.setBoard(t3, t4, "Human");
	  b.printBoard();
	}
	*/
}
