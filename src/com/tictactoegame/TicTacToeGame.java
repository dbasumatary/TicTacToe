package com.tictactoegame;
import java.util.Scanner;
public class TicTacToeGame {
    static char[] board = new char[10];                     //Char array of board
    static char player, computer;                           //To store the player and computer selection
    public static Scanner scanner = new Scanner(System.in);
    static void createBoard(){                             //Create a board of size 10 and ignoring 0th index (UC1)
        for(int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
    }
    static void playerChoice() {                               //Allowing player to choose the letter X or O (UC2)
        System.out.print("Please select either X or O : ");
        player = Character.toUpperCase(scanner.next().charAt(0));
        if (player == 'X') {
            computer = 'O';
        } else if(player == 'O'){
            computer = 'X';
        }else {
            System.err.println("Incorrect entry. Please select either X or O");
        }
        System.out.println("You have selected : " +player);
        System.out.println("Computer's choice is : " +computer);
    }
    static void showBoard() {                        //To display the current board (UC3)
        System.out.println("  " + board[1] + "  |  " + board[2]  + "   | " + board[3] + "  ");
        System.out.println("------------------");
        System.out.println("  " + board[4] + "  |  " + board[5]  + "   | " + board[6] + "  ");
        System.out.println("------------------");
        System.out.println("  " + board[7] + "  |  " + board[8]  + "   | " + board[9] + "  ");
    }
    public static void playerLocation() {                               //Allowing the user to move to a location (UC4)
        System.out.print("Enter the location from 1-9 to make a move : ");
        int boardLocation = scanner.nextInt();
        if (boardLocation < 10 && boardLocation > 0) {
            board[boardLocation] = player;
            showBoard();
        } else {
            System.out.println("Invalid input. Please select location between 1-9 only");
            playerLocation();       //Calling the method once again
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe game");
        createBoard();                        //Calling the methods
        playerChoice();
        showBoard();
        playerLocation();
    }
}