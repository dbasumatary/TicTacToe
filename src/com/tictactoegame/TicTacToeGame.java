package com.tictactoegame;
import java.util.Scanner;
import java.util.Random;
public class TicTacToeGame {
    static char[] board = new char[10];                     //Char array of board
    static char player, computer;                           //To store the player and computer selection
    private static int boardLocation;                       //Location of the selected number in board
    private static boolean playerWinLossToss;
    private static boolean isWinner = false;
    public static Scanner scanner = new Scanner(System.in);
    public static final Random random = new Random();       //Using random class to generate random numbers
    private static int userInput;
    static void createBoard(){                             //Create a board of size 10 and ignoring 0th index (UC1)
        for(int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
        isWinner = false;
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
        System.out.println("You have selected : " + player);
        System.out.println("Computer's choice is : " + computer);
    }
    static void showBoard() {                        //To display the current board (UC3)
        System.out.println("  " + board[1] + "  |  " + board[2]  + "   | " + board[3] + "  ");
        System.out.println("------------------");
        System.out.println("  " + board[4] + "  |  " + board[5]  + "   | " + board[6] + "  ");
        System.out.println("------------------");
        System.out.println("  " + board[7] + "  |  " + board[8]  + "   | " + board[9] + "  ");
    }
    public static void playerLocation() {                               //Allowing the user to move to a location (UC4)
        System.out.println("Player is currently playing");
        System.out.print("Enter the location from 1-9 to make a move : ");
        while (true){
            boardLocation = scanner.nextInt();
            scanner.nextLine();
            if (boardLocation < 10 && boardLocation > 0 && isEmpty(boardLocation)) {
                board[boardLocation] = player;
                showBoard();
                break;
            } else {
                System.out.println("Invalid input. Please select location between 1-9 only");
            }
        }
    }
    public static void computerLocation() {                       //Determining the computer location using random (UC7)
        System.out.println("\nComputer Is Playing");
        do {                              //call the methods
            takeCorner();
            if (takeCenter()){}                 //boolean methods
            if (takeOtherPosition()){}
            if (predictWin()){}
        } while (!isEmpty(boardLocation));
        board[boardLocation] = computer;
        System.out.println("The computer played the location " + boardLocation);
        showBoard();
    }
    public static void takeCorner(){                  //take corner if possible
        int[] cornerPosition = {1, 3, 7, 9};
        int corner =  random.nextInt(3);          //four possible corners
        boardLocation = cornerPosition[corner];
    }
    public static boolean takeCenter(){                      //take center if possible
        if (board[1] != ' ' && board[3] != ' ' && board[7] != ' ' && board[9] != ' ') {      //if corners are not empty
            if (isEmpty(5)) {
                boardLocation = 5;                     //if center is empty then occupy it
                return true;
            }
        }
        return false;
    }
    public static boolean takeOtherPosition(){
        //if corners and center are not empty then occupy other remaining positions
        if (board[1] != ' ' && board[3] != ' ' && board[7] != ' ' && board[9] != ' ' && board[5] != ' ') {
            int[] otherPositionLocation = { 2, 4, 6, 8 };
            int notCenterOrCorner = random.nextInt(3);
            if (isEmpty(otherPositionLocation[notCenterOrCorner])) {          //check if corners and center are not empty
                boardLocation = otherPositionLocation[notCenterOrCorner];     //occupy other remaining positions
                return true;
            }
        }
        return false;
    }
    public static boolean predictWin() {                     //Predicting the various win scenarios for computer and player
        if ((board[1] == computer && board[2] == computer && board[3] == ' ') || (board[1] == player && board[2] == player && board[3] == ' ')) {
            boardLocation = 3;
            return true;
        }
        if ((board[1] == computer && board[3] == computer && board[2] == ' ') || (board[1] == player && board[3] == player && board[2] == ' ')) {
            boardLocation = 2;
            return true;
        }
        if ((board[3] == computer && board[2] == computer && board[1] == ' ') || (board[3] == player && board[2] == player && board[1] == ' ')){
            boardLocation = 1;
            return true;
        }
        if ((board[4] == computer && board[5] == computer && board[6] == ' ') || (board[4] == player && board[5] == player && board[6] == ' ')){
            boardLocation = 6;
            return true;
        }
        if ((board[4] == computer && board[6] == computer && board[5] == ' ') || (board[4] == player && board[6] == player && board[5] == ' ')){
            boardLocation = 5;
            return true;
        }
        if ((board[6] == computer && board[5] == computer && board[4] == ' ') || (board[6] == player && board[5] == player && board[4] == ' ')){
            boardLocation = 4;
            return true;
        }
        if ((board[7] == computer && board[8] == computer && board[9] == ' ') || (board[7] == player && board[8] == player && board[9] == ' ')){
            boardLocation = 9;
            return true;
        }
        if ((board[7] == computer && board[9] == computer && board[8] == ' ') || (board[7] == player && board[9] == player && board[8] == ' ')){
            boardLocation = 8;
            return true;
        }
        if ((board[9] == computer && board[8] == computer && board[7] == ' ') || (board[9] == player && board[8] == player && board[7] == ' ')){
            boardLocation = 7;
            return true;
        }
        if ((board[1] == computer && board[4] == computer && board[7] == ' ') || (board[1] == player && board[4] == player && board[7] == ' ')){
            boardLocation = 7;
            return true;
        }
        if ((board[1] == computer && board[7] == computer && board[4] == ' ') || (board[1] == player && board[7] == player && board[4] == ' ')){
            boardLocation = 4;
            return true;
        }
        if ((board[7] == computer && board[4] == computer && board[1] == ' ') || (board[7] == player && board[4] == player && board[1] == ' ')){
            boardLocation = 1;
            return true;
        }
        if ((board[2] == computer && board[5] == computer && board[8] == ' ') || (board[2] == player && board[5] == player && board[8] == ' ')){
            boardLocation = 8;
            return true;
        }
        if ((board[2] == computer && board[8] == computer && board[5] == ' ') || (board[2] == player && board[8] == player && board[5] == ' ')){
            boardLocation = 5;
            return true;
        }
        if ((board[8] == computer && board[5] == computer && board[2] == ' ') || (board[8] == player && board[5] == player && board[2] == ' ')){
            boardLocation = 2;
            return true;
        }
        if ((board[3] == computer && board[6] == computer && board[9] == ' ') || (board[3] == player && board[6] == player && board[9] == ' ')){
            boardLocation = 9;
            return true;
        }
        if ((board[3] == computer && board[9] == computer && board[6] == ' ') || (board[3] == player && board[9] == player && board[6] == ' ')){
            boardLocation = 6;
            return true;
        }
        if ((board[9] == computer && board[6] == computer && board[3] == ' ') || (board[9] == player && board[6] == player && board[3] == ' ')){
            boardLocation = 3;
            return true;
        }
        if ((board[1] == computer && board[5] == computer && board[9] == ' ') || (board[1] == player && board[5] == player && board[9] == ' ')){
            boardLocation = 9;
            return true;
        }
        if ((board[1] == computer && board[9] == computer && board[5] == ' ') || (board[1] == player && board[9] == player && board[5] == ' ')){
            boardLocation = 5;
            return true;
        }
        if ((board[9] == computer && board[5] == computer && board[1] == ' ') || (board[9] == player && board[5] == player && board[1] == ' ')){
            boardLocation = 1;
            return true;
        }
        if ((board[3] == computer && board[5] == computer && board[7] == ' ') || (board[3] == player && board[5] == player && board[7] == ' ')){
            boardLocation = 7;
            return true;
        }
        if ((board[3] == computer && board[7] == computer && board[5] == ' ') || (board[3] == player && board[7] == player && board[5] == ' ')){
            boardLocation = 5;
            return true;
        }
        if ((board[7] == computer && board[5] == computer && board[3] == ' ') || (board[7] == player && board[5] == player && board[3] == ' ')){
            boardLocation = 3;
            return true;
        } else
            return false;
    }
    public static boolean isEmpty(int location) {                  //Changing back to empty location (UC5)
        return board[location] == ' ';
    }
    public static void tossCheck() {                               //Checking who plays first (UC6)
        int tossResult = (int) ( Math.random() * 2 + 1);           //Using random to check player toss win or lose
        System.out.print("\nChoose 1 or 2 for determining who wins the toss: ");
        int flip = scanner.nextInt();
        if (flip == tossResult) {
            System.out.println("\nPlayer Won The Toss! Player Starts");
            playerWinLossToss = true;
        } else {
            playerWinLossToss = false;
            System.out.println("\nComputer Won The Toss! Computer Starts");
        }
    }
    public static boolean checkBoardIsFull() {                //Checking if the current board is full
        if ((board[1] != ' ') && (board[2] != ' ') && (board[3] != ' ') && (board[4] != ' ') && (board[5] != ' ')
                && (board[6] != ' ') && (board[7] != ' ') && (board[8] != ' ') && (board[9] != ' ')) {
            return true;
        }
        return false;
    }

    public static boolean checkWinner() {                      //Checking winner for player and computer
        if (isWinner)                                          //Initially the boolean statement is false
            return true;
        else if ((board[1] == player && board[2] == player && board[3] == player)
                || (board[4] == player && board[5] == player && board[6] == player)
                || (board[7] == player && board[8] == player && board[9] == player)
                || (board[1] == player && board[4] == player && board[7] == player)
                || (board[2] == player && board[5] == player && board[8] == player)
                || (board[3] == player && board[6] == player && board[9] == player)
                || (board[1] == player && board[5] == player && board[9] == player)
                || (board[3] == player && board[5] == player && board[7] == player)) {
            System.out.println("Player is the WINNER!!");
            isWinner = true;
            return true;
        }
        else if ((board[1] == computer && board[2] == computer && board[3] == computer)
                || (board[4] == computer && board[5] == computer && board[6] == computer)
                || (board[7] == computer && board[8] == computer && board[9] == computer)
                || (board[1] == computer && board[4] == computer && board[7] == computer)
                || (board[2] == computer && board[5] == computer && board[8] == computer)
                || (board[3] == computer && board[6] == computer && board[9] == computer)
                || (board[1] == computer && board[5] == computer && board[9] == computer)
                || (board[3] == computer && board[5] == computer && board[7] == computer)) {
            System.out.println("Computer is the WINNER");
            isWinner = true;
            return true;
        }
        return false;
    }
    public static void startGame() {                              //Method to start the game
        do {
            if (playerWinLossToss) {
                playerLocation();
                if (!checkBoardIsFull())                          //Checking if the board is filled
                    computerLocation();
            } else if (!playerWinLossToss){
                computerLocation();
                if (!checkBoardIsFull())                          //Checking if the board is filled
                    playerLocation();
            }
        } while (!checkWinner() && !checkBoardIsFull());
        if (checkBoardIsFull() && !checkWinner())
            System.out.println("The game is a tie.");
    }
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe game");
        boolean play = true;
        while (play){                             //it will always be true unless we have an option to exit
            createBoard();                        //Calling the methods
            playerChoice();
            showBoard();
            tossCheck();
            startGame();
            System.out.println();
            System.out.println("Press 1 to continue playing");
            System.out.println("Press 2 to exit the game");
            userInput = scanner.nextInt();
            if (userInput == 2){
                System.out.println("Thank You!");
                System.exit(0);                       //exit the game
            }
        }
    }
}
