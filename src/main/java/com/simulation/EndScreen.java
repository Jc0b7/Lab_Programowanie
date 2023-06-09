package com.simulation;

import com.simulation.menu.Buttons;
import com.simulation.menu.Stats;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EndScreen {

    private long secondsDisplay;
    private long elapsedMinutes;


    public void displayWin() {
        JFrame endScreen = new JFrame();
        endScreen.setSize(new Dimension(420, 420));
        endScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        endScreen.setResizable(false);


        JLabel winLabel = new JLabel("Wygrales! \n");
        JPanel winPanel = new JPanel();

        winPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 15));


        JLabel bodyCount = new JLabel("Pokonani wrogowie: " + Stats.getBodyCount().toString());
        JLabel nameLabel = new JLabel("Nazwa gracza: " + Stats.getName());
        JLabel movesLabel = new JLabel("Wykonane ruchy: " + Buttons.getMoveCounter());
        timer();
        JLabel timer;
        if (secondsDisplay <= 9 ) {
            timer = new JLabel("Czas gry: " + elapsedMinutes + ":0" + secondsDisplay);
        } else {
            timer = new JLabel("Czas gry: " + elapsedMinutes + ":" + secondsDisplay);
        }


        winLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
        bodyCount.setFont(new Font("Calibri", Font.PLAIN, 22));
        nameLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
        movesLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
        timer.setFont(new Font("Calibri", Font.PLAIN, 22));

        winPanel.add(winLabel);
        winPanel.add(nameLabel);
        winPanel.add(timer);
        winPanel.add(bodyCount);
        winPanel.add(movesLabel);

        endScreen.add(winPanel);

        MainFrame.dispose();

        endScreen.setLocationRelativeTo(null);
        endScreen.setVisible(true);

        Path path = Paths.get("src/main/java/saves/" + Stats.getName() + ".txt");
        String data;
        if (secondsDisplay <= 9) {
            data = "Wygrana\n" + "Nazwa gracza: " + Stats.getName() + "\n" + "Czas gry: " + elapsedMinutes + ":0" + secondsDisplay
                    + "\n" + "Pokonani wrogowie: " + Stats.getBodyCount().toString() + "\n" + "Wykonane ruchy: " + Buttons.getMoveCounter();
        } else {
            data = "Wygrana\n" + "Nazwa gracza: " + Stats.getName() + "\n" + "Czas gry: " + elapsedMinutes + ":" + secondsDisplay
                    + "\n" + "Pokonani wrogowie: " + Stats.getBodyCount().toString() + "\n" + "Wykonane ruchy: " + Buttons.getMoveCounter();
        }


        try {
            Files.writeString(path, data,
                    StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.print("Invalid Path");
        }
    }

    public void displayLose() {
        JFrame endScreen = new JFrame();
        endScreen.setSize(new Dimension(420, 420));
        endScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        endScreen.setResizable(false);


        JLabel winLabel = new JLabel("Przegrales! \n");
        JPanel winPanel = new JPanel();

        winPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 15));


        JLabel bodyCount = new JLabel("Pokonani wrogowie: " + Stats.getBodyCount().toString());
        JLabel nameLabel = new JLabel("Nazwa gracza: " + Stats.getName());
        JLabel movesLabel = new JLabel("Wykonane ruchy: " + Buttons.getMoveCounter());
        timer();
        JLabel timer;
        if (secondsDisplay <= 9 ) {
            timer = new JLabel("Czas gry: " + elapsedMinutes + ":0" + secondsDisplay);
        } else {
            timer = new JLabel("Czas gry: " + elapsedMinutes + ":" + secondsDisplay);
        }

        winLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
        bodyCount.setFont(new Font("Calibri", Font.PLAIN, 22));
        nameLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
        movesLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
        timer.setFont(new Font("Calibri", Font.PLAIN, 22));

        winPanel.add(winLabel);
        winPanel.add(nameLabel);
        winPanel.add(timer);
        winPanel.add(bodyCount);
        winPanel.add(movesLabel);

        endScreen.add(winPanel);

        MainFrame.dispose();

        endScreen.setLocationRelativeTo(null);
        endScreen.setVisible(true);

        Path path = Paths.get("src/main/java/saves/" + Stats.getName() + ".txt");

        String data;
        if (secondsDisplay <= 9) {
            data = "Wygrana\n" + "Nazwa gracza: " + Stats.getName() + "\n" + "Czas gry: " + elapsedMinutes + ":0" + secondsDisplay
                    + "\n" + "Pokonani wrogowie: " + Stats.getBodyCount().toString() + "\n" + "Wykonane ruchy: " + Buttons.getMoveCounter();
        } else {
            data = "Wygrana\n" + "Nazwa gracza: " + Stats.getName() + "\n" + "Czas gry: " + elapsedMinutes + ":" + secondsDisplay
                    + "\n" + "Pokonani wrogowie: " + Stats.getBodyCount().toString() + "\n" + "Wykonane ruchy: " + Buttons.getMoveCounter();
        }
        try {
            Files.writeString(path, data,
                    StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.print("Invalid Path");
        }
    }

    public void timer() {
        long elapsedTime = System.currentTimeMillis() - MainFrame.getStartTime();
        long elapsedSeconds = elapsedTime / 1000;
        secondsDisplay = elapsedSeconds % 60;
        elapsedMinutes = elapsedSeconds / 60;
    }
}
