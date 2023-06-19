package com.simulation.menu;

import com.simulation.Board;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa tworząca panel menu na której znajdują dwa inne panele: panel przycisków oraz statystyk.
 * @author Jakub, Marek
 * @version 1.2.0
 * @see Buttons
 * @see Stats
 */
public class Menu {
    private final int menuHeight;
    private final int menuWidth;
    private JPanel menu;
    private final Stats stats;
    private final Board board;

    /**
     * Konstruktor klasy Menu. Ustawia wartości atrybutów oraz wywołuje metodę tworzącą panel - {@link Menu#display()}.
     * @param heigth wysokość panelu
     * @param width szerokość panelu
     * @param board obiekt klasy Board
     * @param stats obiekt klasy Stats
     */
    public Menu(int heigth, int width, Board board, Stats stats) {
        menuHeight = heigth;
        menuWidth = width;
        this.board = board;
        this.stats = stats;
        // Wyswietlenie panelu
        display();
    }

    /**
     * Tworzy panel menu oraz dodaje do niego panele: przcisków oraz statystyk.
     * @see Buttons#add(JPanel)
     * @see Stats#getStatsPanel()
     */
    public void display() {
        // Stworzenie panelu glownego
        menu = new JPanel();
        menu.setPreferredSize(new Dimension(menuWidth, menuHeight));
        // Stworzenie panelu dla przyciskow
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(menuWidth, menuHeight/2));
        stats.setSize(menuHeight,menuWidth/2);
        // Stworzenie przyciskow
        Buttons buttons = new Buttons(menuHeight / 2, menuWidth, board);
        buttons.add(buttonPanel);

        menu.setLayout(new GridLayout(2,1));

        // Dodanie paneli do panelu glownego
        menu.add(stats.getStatsPanel());
        menu.add(buttonPanel);

        menu.setVisible(true);
    }

    /**
     * Dodaje panel menu do okna głównego progamu (z klasy MainFrame).
     * @param mainFrame okno główne programu
     * @see com.simulation.MainFrame
     */
    public void add(JFrame mainFrame) {
        mainFrame.add(menu);
    }

}
