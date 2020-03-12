package Game;

//import Ships.Ship;

public class Board 
{	private Tile t=new Tile();
	private int[][] board1, board2;
	
	public Board() 
	{
	    int x=10;
	    board1 = new int[x][x];
	    board2 = new int[x][x];      
	}	
	
	public int[][] getBoard1() 
	{
		return board1;
	}
	
	public void setBoard1(int i,int j,int value) 
	{
		this.board1[i][j]=value;
	}
	
	public void setBoard2(int i,int j,int value) 
	{
		this.board2[i][j]=value;
	}
	
	public int[][] getBoard2() 
	{
		return board2;
	}
	
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
	
	public  boolean inBounds(Tile location) 
	{
		if( location.getX() >= 0 && location.getX() < 10 && location.getY() >= 0 && location.getY() < 10)
			return true;
	    else 
	    	return false;
	}
	
/* Legend: 
0 - empty location 
1 - Player's ship - print (@) 
2 - Computer's ship. 
3 - Sunk computer ship - print (!) 
4 - Sunk player's ship - print (x) 
5 - Player missed - print (-) 
8 - Computer missed 
9 - Both player and computer missed this spot - print (-) 
*/
	
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
					if (getBoard1()[i][j]==5)
						System.out.print(" "+"  ");
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
				if (getBoard2()[i][k]==5)
					System.out.print(" "+"  ");
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