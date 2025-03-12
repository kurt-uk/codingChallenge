package com.example.demo;
/*
Problem Statement:
The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0).
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules:
•	Any live cell with fewer than two live neighbors dies as if caused by under-population.
•	Any live cell with two or three live neighbors lives on to the next generation.
•	Any live cell with more than three live neighbors dies, as if by over-population.
•	Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
•	The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.
Given the current state of the board, update the board to reflect its next state.
Example 1:
Before
    "11"
    "10"
After
    "11"
    "11"
Example 2:
Before
    "010"
    "001"
    "111"
    "000"
After
    "000"
    "101"
    "011"
    "010"

 */
public class Challenge {

    private final int LIVE = 1;
    private final int DEAD = 0;

    private final int DYING = 2;

    private final int BACK_TO_LIFE = 3;

    private int[][] DIRECTIONS = {{-1,-1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1,1}};

    public int[][] processBoard(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] newBoard = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int l = 0; l < n; l++) {
                int liveCells = countLiveCells(board, i, l, m, n);

                if (board[i][l] == LIVE && (liveCells < 2 || liveCells > 3)) {
                    newBoard[i][l] = DEAD;
                }

                if (board[i][l] == DEAD && liveCells == 3) {
                    newBoard[i][l] = LIVE;
                }
            }
        }

//        for (int i = 0; i < m; i++) {
//            for (int l = 0; l < n; n++) {
//                if (board[i][l] == DYING) {
//                    board[i][l] = DEAD;
//                }
//                if (board[i][l] == BACK_TO_LIFE) {
//                    board[i][l] = LIVE;
//                }
//            }
//            }

        return newBoard;

    }

    public int countLiveCells(int[][] board, int row, int column, int m, int n) {
        int counter = 0;
        for (int[] item : DIRECTIONS) {
            int newRow = row + item[0];
            int newColumn = column + item[1];

            if (newRow >= 0 && newColumn >=0 && newRow < m && newColumn < n) {
                if (board[newRow][newColumn] == LIVE) {
                    counter++;
                }
            }
        }

        return counter;
    }

}
