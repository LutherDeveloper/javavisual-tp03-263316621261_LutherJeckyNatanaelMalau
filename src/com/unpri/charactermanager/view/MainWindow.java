package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import java.awt.BorderLayout;
import java.awt.Color;
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

        setTitle("Character Manager - Sprint #4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(AppTheme.BACKGROUND);

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(
                new BoxLayout(headerPanel, BoxLayout.Y_AXIS)
        );
        headerPanel.setBackground(AppTheme.BACKGROUND);
        headerPanel.setOpaque(true);
        headerPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 10, 20)
        );

        JLabel titleLabel = new JLabel("CHARACTER MANAGER");
        titleLabel.setFont(AppTheme.TITLE_FONT);
        titleLabel.setForeground(AppTheme.TEXT_PRIMARY);

        JLabel subtitleLabel = new JLabel(
                "Character Collection - Sprint 4"
        );
        subtitleLabel.setFont(AppTheme.SUBTITLE_FONT);
        subtitleLabel.setForeground(AppTheme.TEXT_SECONDARY);

        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(5));
        headerPanel.add(subtitleLabel);

        add(headerPanel, BorderLayout.NORTH);

        // Character list
        characterListPanel = new JPanel();
        characterListPanel.setLayout(
                new BoxLayout(characterListPanel, BoxLayout.Y_AXIS)
        );
        characterListPanel.setBackground(AppTheme.BACKGROUND);
        characterListPanel.setOpaque(true);
        characterListPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        );

        JScrollPane scrollPane = new JScrollPane(characterListPanel);
        scrollPane.setPreferredSize(new Dimension(650, 350));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(AppTheme.BACKGROUND);

        add(scrollPane, BorderLayout.CENTER);

        // Footer
        JPanel footerPanel = new JPanel(
                new FlowLayout(FlowLayout.LEFT, 15, 12)
        );
        footerPanel.setBackground(AppTheme.CARD_BACKGROUND);
        footerPanel.setOpaque(true);

        averageLevelLabel = new JLabel();
        averageLevelLabel.setFont(AppTheme.BODY_FONT);
        averageLevelLabel.setForeground(AppTheme.TEXT_PRIMARY);

        levelUpButton = new JButton("Naikkan Level Lyra (+1)");
        levelUpButton.setFont(AppTheme.BODY_FONT);
        levelUpButton.setBackground(AppTheme.ACCENT);
        levelUpButton.setForeground(Color.WHITE);
        levelUpButton.setFocusPainted(false);

        statusLabel = new JLabel("Ready");
        statusLabel.setFont(AppTheme.SMALL_FONT);
        statusLabel.setForeground(AppTheme.TEXT_SECONDARY);

        levelUpButton.addActionListener(event -> {
            Character lyra = manager.findByName("Lyra");

            if (lyra != null) {
                lyra.levelUp();
                refreshCharacterList();

                statusLabel.setText(
                        "Lyra berhasil naik ke level " + lyra.getLevel()
                );
            } else {
                statusLabel.setText(
                        "Character Lyra tidak ditemukan"
                );
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

            boolean isDisabled = character.getLevel() == 1;

            // Character card
            JPanel card = new JPanel();
            card.setLayout(
                    new BoxLayout(card, BoxLayout.Y_AXIS)
            );

            card.setBackground(AppTheme.CARD_BACKGROUND);
            card.setOpaque(true);
            card.setAlignmentX(LEFT_ALIGNMENT);

            card.setBorder(AppTheme.getRoleBorder(
                    character.getType()
            ));

            // Tooltip information
            String tooltip = "<html>"
                    + "<b>Name:</b> " + character.getName() + "<br>"
                    + "<b>Type:</b> " + character.getType() + "<br>"
                    + "<b>Level:</b> " + character.getLevel() + "<br>"
                    + "<b>HP:</b> " + character.getHitPoints() + "<br>"
                    + "<b>Attack:</b> " + character.getAttack()
                    + "</html>";

            card.setToolTipText(tooltip);

            // Character name
            JLabel nameLabel = new JLabel(
                    character.getName() + " - " + character.getType()
            );
            nameLabel.setFont(AppTheme.SUBTITLE_FONT);

            // Role-specific color
            nameLabel.setForeground(
                    isDisabled
                            ? AppTheme.DISABLED
                            : AppTheme.getRoleColor(character.getType())
            );

            // Character level
            JLabel levelLabel = new JLabel(
                    "Level: " + character.getLevel()
            );

            levelLabel.setFont(
                    AppTheme.getLevelFont(character.getLevel())
            );

            levelLabel.setForeground(
                    isDisabled
                            ? AppTheme.DISABLED
                            : AppTheme.getLevelColor(character.getLevel())
            );

            // Character statistics
            JLabel statsLabel = new JLabel(
                    "HP: " + character.getHitPoints()
                    + " | Attack: " + character.getAttack()
            );

            statsLabel.setFont(AppTheme.BODY_FONT);
            statsLabel.setForeground(
                    isDisabled
                            ? AppTheme.DISABLED
                            : AppTheme.TEXT_SECONDARY
            );

            // Disable level 1 characters
            card.setEnabled(!isDisabled);
            nameLabel.setEnabled(!isDisabled);
            levelLabel.setEnabled(!isDisabled);
            statsLabel.setEnabled(!isDisabled);

            // Apply tooltip to components
            nameLabel.setToolTipText(tooltip);
            levelLabel.setToolTipText(tooltip);
            statsLabel.setToolTipText(tooltip);

            card.add(nameLabel);
            card.add(Box.createVerticalStrut(5));
            card.add(levelLabel);
            card.add(Box.createVerticalStrut(5));
            card.add(statsLabel);

            card.setMaximumSize(
                    new Dimension(Integer.MAX_VALUE, 110)
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