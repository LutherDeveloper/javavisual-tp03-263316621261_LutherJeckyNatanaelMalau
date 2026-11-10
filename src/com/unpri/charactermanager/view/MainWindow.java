
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

    public MainWindow(CharacterManager manager) {

        this.manager = manager;

        setTitle("Character Manager - Sprint #4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(12, 12));

        getContentPane().setBackground(AppTheme.BACKGROUND);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(
                new BoxLayout(headerPanel, BoxLayout.Y_AXIS)
        );
        headerPanel.setBackground(AppTheme.BACKGROUND);
        headerPanel.setBorder(AppTheme.WINDOW_PADDING);

        JLabel titleLabel = new JLabel("CHARACTER MANAGER");
        titleLabel.setFont(AppTheme.TITLE_FONT);
        titleLabel.setForeground(AppTheme.TEXT_PRIMARY);

        JLabel subtitleLabel = new JLabel(
                "Character collection and RPG statistics"
        );
        subtitleLabel.setFont(AppTheme.SUBTITLE_FONT);
        subtitleLabel.setForeground(AppTheme.TEXT_SECONDARY);

        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(5));
        headerPanel.add(subtitleLabel);

        add(headerPanel, BorderLayout.NORTH);

        characterListPanel = new JPanel();
        characterListPanel.setLayout(
                new BoxLayout(characterListPanel, BoxLayout.Y_AXIS)
        );
        characterListPanel.setBackground(AppTheme.BACKGROUND);
        characterListPanel.setBorder(AppTheme.WINDOW_PADDING);

        JScrollPane scrollPane = new JScrollPane(characterListPanel);
        scrollPane.setPreferredSize(new Dimension(650, 350));
        scrollPane.setBorder(AppTheme.SECTION_BORDER);
        scrollPane.getViewport().setBackground(AppTheme.BACKGROUND);

        add(scrollPane, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel(
                new FlowLayout(FlowLayout.LEFT)
        );
        footerPanel.setBackground(AppTheme.BACKGROUND);
        footerPanel.setBorder(AppTheme.WINDOW_PADDING);

        averageLevelLabel = new JLabel();
        averageLevelLabel.setFont(AppTheme.SUMMARY_FONT);
        averageLevelLabel.setForeground(AppTheme.ACCENT);

        JButton levelUpButton = new JButton(
                "Naikkan Level Lyra (+1)"
        );

        levelUpButton.setFont(AppTheme.BODY_FONT);
        levelUpButton.setToolTipText(
                "Menaikkan level, HP, dan Attack Lyra"
        );

        levelUpButton.addActionListener(event -> {
            Character lyra = manager.findByName("Lyra");

            if (lyra != null) {
                lyra.levelUp();
                refreshCharacterList();
            }
        });

        footerPanel.add(averageLevelLabel);
        footerPanel.add(levelUpButton);

        add(footerPanel, BorderLayout.SOUTH);

        refreshCharacterList();

        pack();
        setMinimumSize(new Dimension(650, 500));
        setLocationRelativeTo(null);
    }

    private void refreshCharacterList() {

        characterListPanel.removeAll();

        for (Character character : manager.getAllCharacters()) {

            JPanel card = new JPanel();
            card.setLayout(
                    new BoxLayout(card, BoxLayout.Y_AXIS)
            );

            card.setBackground(AppTheme.CARD_BACKGROUND);
            card.setOpaque(true);

            card.setBorder(
                    AppTheme.borderFor(character.getType())
            );

            card.setAlignmentX(Component.LEFT_ALIGNMENT);

            JLabel nameLabel = new JLabel(
                    character.getName() + " - " + character.getType()
            );

            nameLabel.setFont(AppTheme.BODY_FONT);
            nameLabel.setForeground(
                    AppTheme.colorFor(character.getType())
            );

            JLabel levelLabel = new JLabel(
                    "Level: " + character.getLevel()
            );

            if (character.getLevel()
                    >= AppTheme.GOLD_LEVEL_THRESHOLD) {

                levelLabel.setFont(AppTheme.LEVEL_GOLD_FONT);
                levelLabel.setForeground(AppTheme.GOLD);

                levelLabel.setToolTipText(
                        "Level tinggi: " + character.getLevel()
                );

            } else {

                levelLabel.setFont(AppTheme.LEVEL_FONT);
                levelLabel.setForeground(AppTheme.TEXT_PRIMARY);
            }

            JLabel statsLabel = new JLabel(
                    String.format(
                            "HP: %d | Attack: %d | Mana: %d",
                            character.getHitPoints(),
                            character.getAttack(),
                            character.getMana()
                    )
            );

            statsLabel.setFont(AppTheme.BODY_FONT);
            statsLabel.setForeground(AppTheme.TEXT_SECONDARY);

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
            card.add(Box.createVerticalStrut(5));
            card.add(levelLabel);
            card.add(Box.createVerticalStrut(5));
            card.add(statsLabel);

            if (character.getLevel() == 1) {
                card.setEnabled(false);
                nameLabel.setEnabled(false);
                levelLabel.setEnabled(false);
                statsLabel.setEnabled(false);
            }

            characterListPanel.add(card);
            characterListPanel.add(Box.createVerticalStrut(8));
        }

        averageLevelLabel.setText(
                String.format(
                        "Total: %d Characters | Average Level: %.2f",
                        manager.getTotalCharacters(),
                        manager.getAverageLevel()
                )
        );

        characterListPanel.revalidate();
        characterListPanel.repaint();
    }
}