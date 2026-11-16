package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            CharacterManager manager = new CharacterManager();

            Character arthur = new Character(
                    "Arthur", CharacterType.WARRIOR, 5
            );
            arthur.setMana(0);

            Character darius = new Character(
                    "Darius", CharacterType.WARRIOR, 7
            );

            Character merlin = new Character(
                    "Merlin", CharacterType.MAGE, 8
            );
            merlin.setMana(120);

            Character morrigan = new Character(
                    "Morrigan", CharacterType.MAGE, 6
            );
            morrigan.setMana(150);

            Character robin = new Character(
                    "Robin", CharacterType.ARCHER, 1
            );
            robin.setMana(20);

            Character lyra = new Character(
                    "Lyra", CharacterType.ARCHER, 3
            );
            lyra.setMana(25);

            manager.addCharacter(arthur);
            manager.addCharacter(darius);
            manager.addCharacter(merlin);
            manager.addCharacter(morrigan);
            manager.addCharacter(robin);
            manager.addCharacter(lyra);

            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}