package com.tictactoegame;
/*Creating an empty board*/
public class TicTacToeGame {
    static char[] board = new char[10];
    static void createBoard(){                       //Create a board of size 10 and ignoring 0th index
        for(int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
    }
    public static void main(String[] args) {
        createBoard();                        //Calling the method
    }
}