package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CharacterManager manager = new CharacterManager();

            manager.addCharacter(new Character(
                    "Arthur", CharacterType.WARRIOR, 5, 150, 80, 0
            ));

            manager.addCharacter(new Character(
                    "Merlin", CharacterType.MAGE, 8, 100, 95, 120
            ));

            manager.addCharacter(new Character(
                    "Robin", CharacterType.ARCHER, 4, 110, 70, 20
            ));

            manager.addCharacter(new Character(
                    "Morrigan", CharacterType.MAGE, 6, 90, 110, 150
            ));

            manager.addCharacter(new Character(
                    "Lyra", CharacterType.ARCHER, 3, 105, 65, 25
            ));

            manager.addCharacter(new Character(
                    "Darius", CharacterType.WARRIOR, 7, 180, 100, 0
            ));

            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}