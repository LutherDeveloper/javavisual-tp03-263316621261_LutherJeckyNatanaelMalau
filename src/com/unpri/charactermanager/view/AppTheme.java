package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class AppTheme {

    private AppTheme() {
    }

    public static final Color BACKGROUND = new Color(18, 24, 38);
    public static final Color CARD_BACKGROUND = new Color(30, 41, 59);
    public static final Color TEXT_PRIMARY = new Color(241, 245, 249);
    public static final Color TEXT_SECONDARY = new Color(148, 163, 184);

    public static final Color ACCENT = new Color(59, 130, 246);
    public static final Color GOLD = new Color(250, 204, 21);
    public static final Color DISABLED = new Color(100, 116, 139);

    public static final Color WARRIOR_COLOR = new Color(239, 68, 68);
    public static final Color MAGE_COLOR = new Color(168, 85, 247);
    public static final Color ARCHER_COLOR = new Color(34, 197, 94);
    public static final Color ASSASSIN_COLOR = new Color(249, 115, 22);

    public static final Font TITLE_FONT =
            new Font("Segoe UI", Font.BOLD, 24);

    public static final Font SUBTITLE_FONT =
            new Font("Segoe UI", Font.BOLD, 16);

    public static final Font BODY_FONT =
            new Font("Segoe UI", Font.PLAIN, 14);

    public static final Font SMALL_FONT =
            new Font("Segoe UI", Font.PLAIN, 12);

    public static final int HIGH_LEVEL_THRESHOLD = 5;

    public static Color getRoleColor(CharacterType type) {
        if (type == null) {
            return TEXT_SECONDARY;
        }

        switch (type.name()) {
            case "WARRIOR":
                return WARRIOR_COLOR;
            case "MAGE":
                return MAGE_COLOR;
            case "ARCHER":
                return ARCHER_COLOR;
            case "ASSASSIN":
                return ASSASSIN_COLOR;
            default:
                return TEXT_SECONDARY;
        }
    }

    public static Color getLevelColor(int level) {
        return level >= HIGH_LEVEL_THRESHOLD
                ? GOLD
                : TEXT_PRIMARY;
    }

    public static Font getLevelFont(int level) {
        return level >= HIGH_LEVEL_THRESHOLD
                ? new Font("Segoe UI", Font.BOLD, 14)
                : BODY_FONT;
    }

    public static Border getRoleBorder(CharacterType type) {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(getRoleColor(type), 2),
                BorderFactory.createEmptyBorder(12, 12, 12, 12)
        );
    }
}
