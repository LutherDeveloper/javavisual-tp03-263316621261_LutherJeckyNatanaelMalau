
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class AppTheme {

    private AppTheme() {
        
    }

    public static final Color BACKGROUND = new Color(24, 27, 38);
    public static final Color CARD_BACKGROUND = new Color(37, 42, 57);
    public static final Color TEXT_PRIMARY = new Color(240, 242, 248);
    public static final Color TEXT_SECONDARY = new Color(170, 178, 195);
    public static final Color GOLD = new Color(255, 193, 7);
    public static final Color ACCENT = new Color(90, 160, 255);

    public static final Color WARRIOR_COLOR = new Color(220, 75, 75);
    public static final Color MAGE_COLOR = new Color(160, 100, 230);
    public static final Color ARCHER_COLOR = new Color(65, 180, 120);
    public static final Color ASSASSIN_COLOR = new Color(75, 145, 220);

    public static final Font TITLE_FONT =
            new Font(Font.SANS_SERIF, Font.BOLD, 23);

    public static final Font SUBTITLE_FONT =
            new Font(Font.SANS_SERIF, Font.PLAIN, 13);

    public static final Font BODY_FONT =
            new Font(Font.SANS_SERIF, Font.PLAIN, 14);

    public static final Font LEVEL_FONT =
            BODY_FONT.deriveFont(Font.BOLD, 14f);

    public static final Font LEVEL_GOLD_FONT =
            BODY_FONT.deriveFont(Font.BOLD, 16f);

    public static final Font SUMMARY_FONT =
            BODY_FONT.deriveFont(Font.BOLD, 16f);

    public static final int GOLD_LEVEL_THRESHOLD = 5;

    public static final Border WINDOW_PADDING =
            BorderFactory.createEmptyBorder(16, 18, 16, 18);

    public static final Border CARD_BORDER =
            BorderFactory.createEmptyBorder(12, 12, 12, 12);

    public static final Border SECTION_BORDER =
            BorderFactory.createTitledBorder("Daftar Karakter");

    public static Color colorFor(CharacterType type) {
        if (type == null) {
            return TEXT_SECONDARY;
        }

        switch (type) {
            case WARRIOR:
                return WARRIOR_COLOR;

            case MAGE:
                return MAGE_COLOR;

            case ARCHER:
                return ARCHER_COLOR;

            case ASSASSIN:
                return ASSASSIN_COLOR;

            default:
                return TEXT_SECONDARY;
        }
    }

    public static Border borderFor(CharacterType type) {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(colorFor(type), 2),
                CARD_BORDER
        );
    }
}