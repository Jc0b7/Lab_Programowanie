package com.simulation;

import javax.swing.*;
import java.util.Objects;

public class Player extends Entity {

    private int[] playerPosition = new int[2];
    private int[] oldPostion = new int[2];
    private ImageIcon playerIcon;
    private int playerMoves;

    public Player() {
        findPlayerPos();
    }

    public void movePlayer(int n, String dir) {
        if (Objects.equals(dir, "x")) {
            // Zmiana pozycji x'owej gracza jezeli pole ma wartosc 0
            if (boardPosition[playerPosition[0]][playerPosition[1] + n] == 0) {
                // Przypisanie starej pozycji
                oldPostion[0] = playerPosition[0];
                oldPostion[1] = playerPosition[1];
                // Ustawienie nowej pozycji
                playerPosition[1] += n;

            }
            else if (boardPosition[playerPosition[0]][playerPosition[1] + n] == 3) {
                // Przypisanie starej pozycji
                oldPostion[0] = playerPosition[0];
                oldPostion[1] = playerPosition[1];
                // Ustawienie nowej pozycji
                playerPosition[1] += n;
                Stats.increaseHealth();
            }

        } else if (Objects.equals(dir, "y")) {
            // Zmiana pozycji y'owej gracza jezeli pole ma wartosc 0
            if (boardPosition[playerPosition[0] + n][playerPosition[1]] == 0) {
                // Przypisanie starej pozycji
                oldPostion[0] = playerPosition[0];
                oldPostion[1] = playerPosition[1];
                // Ustawienie nowej pozycji
                playerPosition[0] += n;
            }
            else if (boardPosition[playerPosition[0] + n][playerPosition[1]] == 3) {
                // Przypisanie starej pozycji
                oldPostion[0] = playerPosition[0];
                oldPostion[1] = playerPosition[1];
                // Ustawienie nowej pozycji
                playerPosition[0] += n;
                Stats.increaseHealth();
            }

        }

    }

    public void findPlayerPos() {
        // Szukanie pozycji gracza (2) na planszy i przypisanie do zmiennej
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (boardPosition[i][j] == 2) {
                    playerPosition[1] = i;
                    playerPosition[0] = j;
                }
            }
        }
    }

    public int[] getPlayerPosition() {
        return playerPosition;
    }

    public int[] getOldPostion() {
        return oldPostion;
    }

    public void setPlayerPosition(int[] playerPosition) {
        this.playerPosition = playerPosition;
    }
}
