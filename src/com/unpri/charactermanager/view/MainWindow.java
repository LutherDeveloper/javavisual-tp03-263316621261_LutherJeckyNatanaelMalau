
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.CharacterManager;
import com.unpri.charactermanager.model.Character;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private final CharacterManager manager;
    private final JPanel characterListPanel;
    private final JLabel averageLevelLabel;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager - TP8 AP10");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 520);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(12, 12));

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBorder(
                BorderFactory.createEmptyBorder(16, 18, 8, 18)
        );

        JLabel titleLabel = new JLabel("CHARACTER MANAGER");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 23));

        JLabel subtitleLabel = new JLabel(
                "Daftar karakter dan statistik level"
        );

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.add(titleLabel);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(subtitleLabel);

        headerPanel.add(titlePanel, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        characterListPanel = new JPanel();
        characterListPanel.setLayout(
                new BoxLayout(characterListPanel, BoxLayout.Y_AXIS)
        );
        characterListPanel.setBorder(
                BorderFactory.createEmptyBorder(8, 18, 8, 18)
        );

        JScrollPane scrollPane = new JScrollPane(characterListPanel);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
                "Daftar Karakter"
        ));
        add(scrollPane, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BoxLayout(
                footerPanel, BoxLayout.Y_AXIS
        ));
        footerPanel.setBorder(
                BorderFactory.createEmptyBorder(8, 18, 16, 18)
        );

        averageLevelLabel = new JLabel();
        averageLevelLabel.setFont(
                new Font("SansSerif", Font.BOLD, 16)
        );

        JButton levelUpButton = new JButton("Naikkan Level Lyra (+1)");
        levelUpButton.addActionListener(event -> {
            Character lyra = manager.findByName("Lyra");

            if (lyra != null) {
                lyra.setLevel(lyra.getLevel() + 1);
                refreshCharacterList();
            }
        });

        footerPanel.add(averageLevelLabel);
        footerPanel.add(Box.createVerticalStrut(10));
        footerPanel.add(levelUpButton);

        add(footerPanel, BorderLayout.SOUTH);

        refreshCharacterList();
    }

    private void refreshCharacterList() {
        characterListPanel.removeAll();

        for (Character character : manager.getAllCharacters()) {
            String characterInfo = String.format(
                    "%s | Tipe: %s | Level: %d | HP: %d | Attack: %d",
                    character.getName(),
                    character.getType(),
                    character.getLevel(),
                    character.getHitPoints(),
                    character.getAttack()
            );

            JLabel characterLabel = new JLabel(characterInfo);
            characterLabel.setFont(
                    new Font("SansSerif", Font.PLAIN, 14)
            );
            characterLabel.setBorder(
                    BorderFactory.createEmptyBorder(10, 8, 10, 8)
            );
            characterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            characterListPanel.add(characterLabel);
            characterListPanel.add(Box.createVerticalStrut(4));
        }

        averageLevelLabel.setText(String.format(
                "Rata-rata Level: %.2f",
                manager.getAverageLevel()
        ));

        characterListPanel.revalidate();
        characterListPanel.repaint();
    }
}