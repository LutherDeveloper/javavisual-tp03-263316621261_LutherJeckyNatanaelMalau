package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame {

    private final CharacterManager manager;

    private final JPanel characterGrid;
    private final JLabel statusLabel;
    private final JLabel versionLabel;

    public MainWindow(CharacterManager manager) {

        this.manager = manager;

        setTitle("Character Manager - Sprint #5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(12, 12));

        getContentPane().setBackground(AppTheme.BACKGROUND);

        // NORTH: Header and statistics
        JPanel northPanel = new JPanel();
        northPanel.setLayout(
                new BoxLayout(northPanel, BoxLayout.Y_AXIS)
        );
        northPanel.setBackground(AppTheme.BACKGROUND);
        northPanel.setBorder(AppTheme.WINDOW_PADDING);

        JPanel headerPanel = new JPanel(
                new BorderLayout()
        );
        headerPanel.setBackground(AppTheme.BACKGROUND);

        JLabel titleLabel = new JLabel("CHARACTER MANAGER");
        titleLabel.setFont(AppTheme.TITLE_FONT);
        titleLabel.setForeground(AppTheme.TEXT_PRIMARY);

        JLabel subtitleLabel = new JLabel(
                "Character Collection and RPG Statistics"
        );
        subtitleLabel.setFont(AppTheme.SUBTITLE_FONT);
        subtitleLabel.setForeground(AppTheme.TEXT_SECONDARY);

        JPanel titleContainer = new JPanel();
        titleContainer.setLayout(
                new BoxLayout(titleContainer, BoxLayout.Y_AXIS)
        );
        titleContainer.setBackground(AppTheme.BACKGROUND);

        titleContainer.add(titleLabel);
        titleContainer.add(Box.createVerticalStrut(5));
        titleContainer.add(subtitleLabel);

        headerPanel.add(titleContainer, BorderLayout.CENTER);

        northPanel.add(headerPanel);
        northPanel.add(Box.createVerticalStrut(12));

        // Additional panel: Statistics using GridLayout 2x2
        JPanel statisticsPanel = new JPanel(
                new GridLayout(2, 2, 8, 8)
        );
        statisticsPanel.setBackground(AppTheme.BACKGROUND);

        Character strongest = manager.findStrongest();

        String strongestName = strongest == null
                ? "-"
                : strongest.getName();

        addStatistic(
                statisticsPanel,
                "Total Characters",
                String.valueOf(manager.getTotalCharacters())
        );

        addStatistic(
                statisticsPanel,
                "Average Level",
                String.format("%.2f", manager.getAverageLevel())
        );

        addStatistic(
                statisticsPanel,
                "Strongest Character",
                strongestName
        );

        addStatistic(
                statisticsPanel,
                "Total Created",
                String.valueOf(Character.getTotalCharacterCreated())
        );

        northPanel.add(statisticsPanel);

        add(northPanel, BorderLayout.NORTH);

        // CENTER: Character list inside JScrollPane
        characterGrid = new JPanel(
                new GridLayout(0, 2, 10, 10)
        );

        characterGrid.setBackground(AppTheme.BACKGROUND);

        // Wrapper panel for the character grid
        JPanel characterContainer = new JPanel(
                new BorderLayout()
        );

        characterContainer.setBackground(AppTheme.BACKGROUND);
        characterContainer.add(
                characterGrid,
                BorderLayout.NORTH
        );

        JScrollPane scroll = new JScrollPane(
                characterContainer
        );

        scroll.setPreferredSize(
                new Dimension(620, 360)
        );

        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scroll.setBorder(AppTheme.SECTION_BORDER);

        scroll.getViewport().setBackground(
                AppTheme.BACKGROUND
        );

        add(scroll, BorderLayout.CENTER);

        // EAST: Dynamic role legend
        JPanel legendPanel = new JPanel();

        legendPanel.setLayout(
                new BoxLayout(legendPanel, BoxLayout.Y_AXIS)
        );

        legendPanel.setBackground(AppTheme.CARD_BACKGROUND);
        legendPanel.setBorder(AppTheme.WINDOW_PADDING);

        JLabel legendTitle = new JLabel("ROLE LEGEND");
        legendTitle.setFont(AppTheme.SUMMARY_FONT);
        legendTitle.setForeground(AppTheme.TEXT_PRIMARY);

        legendTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        legendPanel.add(legendTitle);
        legendPanel.add(Box.createVerticalStrut(18));

        for (CharacterType type : CharacterType.values()) {

            JLabel roleLabel = new JLabel(
                    "●  " + type.name()
            );

            roleLabel.setFont(AppTheme.BODY_FONT);
            roleLabel.setForeground(
                    AppTheme.colorFor(type)
            );

            roleLabel.setAlignmentX(
                    Component.LEFT_ALIGNMENT
            );

            legendPanel.add(roleLabel);
            legendPanel.add(Box.createVerticalStrut(12));
        }

        legendPanel.add(Box.createVerticalGlue());

        add(legendPanel, BorderLayout.EAST);

        // SOUTH: Status bar
        JPanel statusPanel = new JPanel(
                new BorderLayout()
        );

        statusPanel.setBackground(AppTheme.CARD_BACKGROUND);
        statusPanel.setBorder(AppTheme.CARD_PADDING);

        statusLabel = new JLabel(
                "Character Manager Ready"
        );

        statusLabel.setFont(AppTheme.SUBTITLE_FONT);
        statusLabel.setForeground(AppTheme.TEXT_SECONDARY);

        versionLabel = new JLabel("v0.5");

        versionLabel.setFont(AppTheme.LEVEL_FONT);
        versionLabel.setForeground(AppTheme.GOLD);

        statusPanel.add(
                statusLabel,
                BorderLayout.WEST
        );

        statusPanel.add(
                versionLabel,
                BorderLayout.EAST
        );

        add(statusPanel, BorderLayout.SOUTH);

        refreshCharacterList();

        // Fit components to window
        pack();

        setMinimumSize(
                new Dimension(600, 420)
        );

        setLocationRelativeTo(null);
    }

    // Statistics component
    private void addStatistic(
            JPanel panel,
            String title,
            String value) {

        JPanel statisticCard = new JPanel();

        statisticCard.setLayout(
                new BoxLayout(statisticCard, BoxLayout.Y_AXIS)
        );

        statisticCard.setBackground(
                AppTheme.CARD_BACKGROUND
        );

        statisticCard.setOpaque(true);
        statisticCard.setBorder(AppTheme.CARD_PADDING);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(AppTheme.SUBTITLE_FONT);
        titleLabel.setForeground(AppTheme.TEXT_SECONDARY);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(AppTheme.SUMMARY_FONT);
        valueLabel.setForeground(AppTheme.TEXT_PRIMARY);

        statisticCard.add(titleLabel);
        statisticCard.add(Box.createVerticalStrut(5));
        statisticCard.add(valueLabel);

        panel.add(statisticCard);
    }

    // Refresh character cards
    private void refreshCharacterList() {

        characterGrid.removeAll();

        for (Character character : manager.getAllCharacters()) {

            JPanel card = new JPanel();

            card.setLayout(
                    new BoxLayout(card, BoxLayout.Y_AXIS)
            );

            card.setBackground(
                    AppTheme.CARD_BACKGROUND
            );

            card.setOpaque(true);

            card.setBorder(
                    AppTheme.borderFor(character.getType())
            );

            card.setAlignmentX(Component.LEFT_ALIGNMENT);

            // Name and role
            JLabel nameLabel = new JLabel(
                    character.getName()
                    + " - "
                    + character.getType()
            );

            nameLabel.setFont(AppTheme.BODY_FONT);

            nameLabel.setForeground(
                    AppTheme.colorFor(character.getType())
            );

            // Level
            JLabel levelLabel = new JLabel(
                    "Level: " + character.getLevel()
            );

            if (character.getLevel()
                    >= AppTheme.GOLD_LEVEL_THRESHOLD) {

                levelLabel.setFont(AppTheme.LEVEL_GOLD_FONT);
                levelLabel.setForeground(AppTheme.GOLD);

            } else {

                levelLabel.setFont(AppTheme.LEVEL_FONT);
                levelLabel.setForeground(AppTheme.TEXT_PRIMARY);
            }

            // Statistics
            JLabel statsLabel = new JLabel(
                    String.format(
                            "HP: %d | ATK: %d | Mana: %d",
                            character.getHitPoints(),
                            character.getAttack(),
                            character.getMana()
                    )
            );

            statsLabel.setFont(AppTheme.BODY_FONT);
            statsLabel.setForeground(AppTheme.TEXT_SECONDARY);

            // Tooltip
            String tooltip = String.format(
                    "%s | Role: %s | HP: %d | Attack: %d | Mana: %d",
                    character.getName(),
                    character.getType(),
                    character.getHitPoints(),
                    character.getAttack(),
                    character.getMana()
            );

            card.setToolTipText(tooltip);
            nameLabel.setToolTipText(tooltip);
            levelLabel.setToolTipText(tooltip);
            statsLabel.setToolTipText(tooltip);

            card.add(nameLabel);
            card.add(Box.createVerticalStrut(6));
            card.add(levelLabel);
            card.add(Box.createVerticalStrut(6));
            card.add(statsLabel);

            // Level 1 disabled
            if (character.getLevel() == 1) {

                card.setEnabled(false);
                nameLabel.setEnabled(false);
                levelLabel.setEnabled(false);
                statsLabel.setEnabled(false);
            }

            characterGrid.add(card);
        }

        characterGrid.revalidate();
        characterGrid.repaint();

        statusLabel.setText(
                "Showing " + manager.getTotalCharacters()
                + " characters"
        );
    }
}