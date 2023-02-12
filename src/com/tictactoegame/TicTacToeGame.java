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
    public static void main(String[] args) {
        createBoard();                        //Calling the method
        playerChoice();
    }
}