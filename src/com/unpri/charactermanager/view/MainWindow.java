package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainWindow extends JFrame {

    private final CharacterManager manager;

    private final JPanel characterListPanel;
    private final JLabel averageLevelLabel;
    private final JLabel statusLabel;
    private final JButton levelUpButton;

    public MainWindow(CharacterManager manager) {

        this.manager = manager;

        setTitle("Character Manager - Sprint #3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(
                new BoxLayout(headerPanel, BoxLayout.Y_AXIS)
        );

        headerPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 10, 20)
        );

        JLabel titleLabel = new JLabel("CHARACTER MANAGER");

        titleLabel.setFont(
                new java.awt.Font("Arial", java.awt.Font.BOLD, 24)
        );

        JLabel subtitleLabel = new JLabel(
                "Character Collection - Sprint 3"
        );

        subtitleLabel.setFont(
                new java.awt.Font("Arial", java.awt.Font.PLAIN, 13)
        );

        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(5));
        headerPanel.add(subtitleLabel);

        add(headerPanel, BorderLayout.NORTH);

        characterListPanel = new JPanel();

        characterListPanel.setLayout(
                new BoxLayout(characterListPanel, BoxLayout.Y_AXIS)
        );

        characterListPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        );

        JScrollPane scrollPane = new JScrollPane(characterListPanel);

        scrollPane.setPreferredSize(new Dimension(650, 350));

        add(scrollPane, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel(
                new FlowLayout(FlowLayout.LEFT, 15, 12)
        );

        averageLevelLabel = new JLabel();

        levelUpButton = new JButton(
                "Naikkan Level Lyra (+1)"
        );

        statusLabel = new JLabel("Ready");

        levelUpButton.addActionListener(event -> {
            Character lyra = manager.findByName("Lyra");

            if (lyra != null) {
                lyra.levelUp();
                refreshCharacterList();

                statusLabel.setText(
                        "Lyra berhasil naik ke level " + lyra.getLevel()
                );
            } else {
                statusLabel.setText("Character Lyra tidak ditemukan");
            }
        });

        footerPanel.add(averageLevelLabel);
        footerPanel.add(levelUpButton);
        footerPanel.add(statusLabel);

        add(footerPanel, BorderLayout.SOUTH);

        refreshCharacterList();

        pack();

        setMinimumSize(new Dimension(600, 450));
        setLocationRelativeTo(null);
    }

    private void refreshCharacterList() {

        characterListPanel.removeAll();

        for (Character character : manager.getAllCharacters()) {

            JPanel card = new JPanel();

            card.setLayout(
                    new BoxLayout(card, BoxLayout.Y_AXIS)
            );

            card.setBorder(
                    BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(
                                    java.awt.Color.LIGHT_GRAY
                            ),
                            BorderFactory.createEmptyBorder(
                                    12, 15, 12, 15
                            )
                    )
            );

            card.setAlignmentX(LEFT_ALIGNMENT);

            JLabel nameLabel = new JLabel(
                    character.getName() + " - " + character.getType()
            );

            nameLabel.setFont(
                    new java.awt.Font("Arial", java.awt.Font.BOLD, 16)
            );

            JLabel levelLabel = new JLabel(
                    "Level: " + character.getLevel()
            );

            JLabel statsLabel = new JLabel(
                    "HP: " + character.getHitPoints()
                    + " | Attack: " + character.getAttack()
            );

            card.add(nameLabel);
            card.add(Box.createVerticalStrut(5));
            card.add(levelLabel);
            card.add(Box.createVerticalStrut(5));
            card.add(statsLabel);

            card.setMaximumSize(
                    new Dimension(Integer.MAX_VALUE, 100)
            );

            characterListPanel.add(card);
            characterListPanel.add(Box.createVerticalStrut(10));
        }

        averageLevelLabel.setText(
                String.format(
                        "Average Level: %.2f",
                        manager.getAverageLevel()
                )
        );

        characterListPanel.revalidate();
        characterListPanel.repaint();
    }
}
