package project1.level1;

import java.util.Scanner;

public class TicTacToe {
	Scanner scan=new Scanner(System.in);
	char player1='X';
	char player2='O';
	boolean continueGame=true;
	int count=0;
	
	//Initializing Board
	public void initializeArray(char[][] arr)
	{
		for(int i=0; i<3; i++) 
		{
			for(int j=0; j<3; j++)
			{
				arr[i][j]=' ';
			}
		}
	}

	//Displaying Board
	public void display(char[][] arr)
	{

		for(int i=0; i<3; i++) 
		{
			System.out.println("-------------");
			System.out.print("| ");
			for(int j=0; j<3; j++)
			{

				System.out.print(arr[i][j]+" | ");

			}
			System.out.println();
		}
		System.out.println("-------------");

	}

	//Play The Game
	public void play(char player, char[][] arr) 
	{
		System.out.println("Player "+player+" select the cell by giving row and column value separated by space");

		while (true)
		{
			int r=scan.nextInt();
			int c=scan.nextInt();
			if(!(0<=r && r<3) || !(0<=c && c<3))
			{
				System.out.println("Value is out of bound.. please select a valid empty cell");
			}
			else if(arr[r][c]==' ')
			{
				arr[r][c]=player;
				break;
			}
			else 
			{
				System.out.println("Value already exist in the selected cell. Please select a valid empty cell");
			}


		}
	}

	//Switch player
	public char switchPlayer()
	{


		char temp=player1;
		player1=player2;
		player2=temp;
		return player1;
	}

	//gameWin
	public void gameWin(char[][] arr, char player1)
	{

		for(int i=0; i<3; i++)
		{
			if(arr[i][0]==player1 && arr[i][0]==arr[i][1] && arr[i][1]==arr[i][2])

			{
				System.out.println("Player "+player1+" won the game...");
				count++;
				break;
			}
			else if(arr[0][i]==player1 && arr[0][i]==arr[1][i] && arr[1][i]==arr[2][i])
			{
				System.out.println("Player "+player1+" won the game...");
				count++;
				break;
			}
			else if(arr[0][0]==player1 && arr[1][1]==arr[0][0] && arr[2][2]==arr[1][1])
			{
				System.out.println("Player "+player1+" won the game...");
				count++;
				break;
			}
			else if(arr[0][2]==player1 && arr[1][1]==arr[0][2] && arr[2][0]==arr[1][1])
			{
				System.out.println("Player "+player1+" won the game...");
				count++;
				break;
			}

		}
		if(count!=0)
		{
			System.out.println("Do you want to play again..type 'true' or 'false'");
			continueGame=scan.nextBoolean();
			if(continueGame)
			{
				initializeArray(arr);
				display(arr);
			}
			count=0;
		}

	}

	//Board full
	public void boardFull(char[][] arr)
	{
		for(int i=0; i<3; i++) 
		{
			for(int j=0; j<3; j++)
			{
				if(arr[i][j]==' ')
				{
					count++;
				}
			}
		}
		if(count==0)
		{
			System.out.println("Board full --> Match Draw...");
			System.out.println("Do you want to play again..type 'true' or 'false'");
			continueGame=scan.nextBoolean();
			if(continueGame)
			{
				initializeArray(arr);
				display(arr);
			}
		}
		count=0;
	}



}
