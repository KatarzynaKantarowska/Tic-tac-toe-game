package com.kodilla.tic_tac_toe;

import static com.kodilla.tic_tac_toe.GameStatusEnum.*;

public class Game {

    private final char[][] board = new char[3][3];
    private boolean isXTurn = true;
    private GameStatusEnum state = IN_PROGRESS;

    public void makeMove(int x, int y) {
        putChar(x, y);
        checkWin();
        isBoardFull();
        if (this.state == IN_PROGRESS) {
            changeTurn();
        }
    }

    private void changeTurn() {
        if (this.state == IN_PROGRESS) {
            this.isXTurn = !this.isXTurn;
        }
    }

    private void putChar(int x, int y) {
        if (this.board[x][y] == '\0') {
            this.board[x][y] = this.isXTurn ? 'X' : 'O';
        } else {
            throw new IllegalArgumentException("The field is not available !");
        }
    }

    public void print() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                System.out.print(this.board[x][y] == '\0' ? " " : this.board[x][y]);
            }
            System.out.println();
        }
    }

    private void checkWin() {
        GameStatusEnum playerTurn = this.isXTurn ? GameStatusEnum.X : GameStatusEnum.O;

        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '\0' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                this.state = playerTurn;
                return;
            }
            if (board[0][i] != '\0' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                this.state = playerTurn;
                return;
            }
        }
        if (board[0][0] != '\0' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            this.state = playerTurn;
            return;
        }
        if (board[0][2] != '\0' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            this.state = playerTurn;
            return;
        }

        boolean isDraw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    isDraw = false;
                    break;
                }
            }
        }
        this.state = isDraw ? GameStatusEnum.DRAW : IN_PROGRESS;
    }

    private void isBoardFull() {
        if (this.state == IN_PROGRESS) {
            boolean isFull = true;
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (board[x][y] == '\0') {
                        isFull = false;
                        break;
                    }
                }
            }
            this.state =  isFull ? DRAW : IN_PROGRESS;
        }
    }


    public char[][] getBoard() {
        return this.board;
    }

    public void setState(GameStatusEnum state) {
        this.state = state;
    }

    public boolean isXTurn() {
        return this.isXTurn;
    }

    public GameStatusEnum getState() {
        return this.state;
    }
}