package com.tictactoegame;
import java.util.Scanner;
public class TicTacToeGame {
    static char[] board = new char[10];                     //Char array of board
    static char player, computer;                           //To store the player and computer selection
    private static int boardLocation;
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
            System.out.println("Incorrect entry. Please select either X or O");
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
        boardLocation = scanner.nextInt();
        scanner.nextLine();
        if (boardLocation < 10 && boardLocation > 0 && isEmpty()) {
            board[boardLocation] = player;
            showBoard();
        } else {
            System.out.println("Invalid input. Please select location between 1-9 only");
            playerLocation();       //Calling the method once again
        }
    }
    public static boolean isEmpty() {                  //Checking for free space before making move (UC5)
        if (board[boardLocation] == ' ') {
            return true;
        } else {
            return false;
        }
    }
    public static void tossCheck() {                               //Checking who plays first (UC6)
        int tossResult = (int) ( Math.random() * 2 + 1);           //Using random to check toss win or lose
        System.out.print("\nChoose 1 or 2 : ");
        int flip = scanner.nextInt();
        if (flip == tossResult) {
            System.out.println("\nPlayer Won The Toss! Player Starts");
        } else {
            System.out.println("\nComputer Won The Toss! Computer Starts");
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe game");
        createBoard();                        //Calling the methods
        playerChoice();
        tossCheck();
        showBoard();
        playerLocation();
    }
}