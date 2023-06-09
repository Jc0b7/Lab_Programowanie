package com.simulation.entities;

import com.simulation.Board;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Klasa dziedziczaca po klasie {@link Entity}. Odpowiada za graficzna reprezentacje gracza na planszy.
 * Razem z klasa {@link com.simulation.menu.Buttons} umozliwia poruszanie sie na planszy.
 * @author Jakub, Marek
 * @version 1.2.0
 */
public class Goblin extends Entity {

    private static final int amount = 10;
    private final int[][] goblinPosition = new int[amount][2];
    private final int[][] goblinOldPosition = new int[amount][2];
    private final static ImageIcon goblinIcon = new ImageIcon("src/main/java/res/goblin.png");

    /**
     * Konstruktor klasy {@link Goblin} odpowiedzialny za znalezienie pozycji wszystkich goblinow, oraz przypisanie ich do tablicy dwuwymiarowej.
     * @see Goblin#findGoblinPos()
     */
    public Goblin() {
        findGoblinPos();
    }

    /**
     * Metoda odpowiedzialna za losowanie ruchu dla kazdego goblina.
     * Losuje liczbe z przedziału od 0 do 3 (4 mozliwe ruchy), nastepnie zmienia pozycje goblina pod warunkiem, ze wylosowane pole jest polem wolnym.
     * Gdy wylosowane pole nie jest wolne, goblin nie zmienia pozycji.
     */
    public void moveGoblin() {
        Random random = new Random();
        int randomize;
        for (int i = 0; i < amount; i++) {

            // Losowanie jednego z czterech mozliwych ruchów
            randomize = random.nextInt(4);
            switch (randomize) {
                case 0 -> {
                    if (boardPosition[goblinPosition[i][1] + 1][goblinPosition[i][0]] == 0 || boardPosition[goblinPosition[i][1] + 1][goblinPosition[i][0]] == 2) {
                        // Zmiana pozycji
                        goblinOldPosition[i][1] = goblinPosition[i][1];
                        goblinOldPosition[i][0] = goblinPosition[i][0];
                        goblinPosition[i][1] += 1;
                    }
                }
                case 1 -> {
                    if (boardPosition[goblinPosition[i][1]][goblinPosition[i][0] + 1] == 0 || boardPosition[goblinPosition[i][1]][goblinPosition[i][0] + 1] == 2) {
                        // Zmiana pozycji
                        goblinOldPosition[i][1] = goblinPosition[i][1];
                        goblinOldPosition[i][0] = goblinPosition[i][0];
                        goblinPosition[i][0] += 1;
                    }
                }
                case 2 -> {
                    if (boardPosition[goblinPosition[i][1] - 1][goblinPosition[i][0]] == 0 || boardPosition[goblinPosition[i][1] - 1][goblinPosition[i][0]] == 2) {
                        // Zmiana pozycji
                        goblinOldPosition[i][1] = goblinPosition[i][1];
                        goblinOldPosition[i][0] = goblinPosition[i][0];
                        goblinPosition[i][1] -= 1;
                    }

                }
                case 3 -> {
                    if (boardPosition[goblinPosition[i][1]][goblinPosition[i][0] - 1] == 0 || boardPosition[goblinPosition[i][1]][goblinPosition[i][0] - 1] == 2) {
                        // Zmiana pozycji
                        goblinOldPosition[i][1] = goblinPosition[i][1];
                        goblinOldPosition[i][0] = goblinPosition[i][0];
                        goblinPosition[i][0] -= 1;
                    }
                }
            }
        }
    }

    /**
     * Metoda polega na zmianie pozycji goblina na sam rog mapy, gdzie nie jest mozliwe, aby sie poruszal (otoczony jest scianami).
     * @param i number goblina
     */
    public void goblinDies(int i) {
        // Usawienie pozycji goblina
        goblinPosition[i][0] = 18;
        goblinPosition[i][1] = 1;
        goblinOldPosition[i][0] = 18;
        goblinOldPosition[i][1] = 1;
    }

    ArrayList<Integer[]> positionsOfGoblins = new ArrayList<>();

    /**
     * Metoda odpowiedzialna za znalezienie pozycji goblinow na planszy.
     * Przeszukuje dwuwymiarowa tablice i przypisuje wartosci do nowej tablicy, zawierajacej same pozycje.
     */
    public void findGoblinPos() {
        if (Board.getCurrentLvL() == 2) {
            boardPosition = Board.getFieldStateArray2();
            positionsOfGoblins.clear();
        }
        if (Board.getCurrentLvL() == 3) {
            boardPosition = Board.getFieldStateArray3();
            positionsOfGoblins.clear();
        }
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (boardPosition[i][j] == 4) {
                    Integer[] temp = {j, i};
                    positionsOfGoblins.add(temp);
                }
            }
        }
        for (int i = 0; i < amount; i++) {
            goblinPosition[i][0] = positionsOfGoblins.get(i)[0];
            goblinPosition[i][1] = positionsOfGoblins.get(i)[1];
        }
    }

    /**
     * @return tablica pozycji goblinow
     */
    public int[][] getGoblinPosition() {
        return goblinPosition;
    }

    /**
     * @return tablica starych pozycji goblinow
     */
    public int[][] getGoblinOldPosition() {
        return goblinOldPosition;
    }

    /**
     * @return ikona goblina
     */
    public static ImageIcon getGoblinIcon() {
        return goblinIcon;
    }

    /**
     * @return liczba goblinow
     */
    public static int getAmount() {
        return amount;
    }
}
