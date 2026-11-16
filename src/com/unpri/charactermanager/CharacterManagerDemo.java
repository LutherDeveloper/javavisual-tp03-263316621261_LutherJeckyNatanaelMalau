
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import java.util.List;

public class CharacterManagerDemo {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        Character c1 = new Character("Arthur", CharacterType.WARRIOR, 3);
        Character c2 = new Character("Luna", CharacterType.MAGE, 5);
        Character c3 = new Character("Robin", CharacterType.ARCHER, 2);

        System.out.println("=== CHARACTER MANAGER SPRINT 2 ===");

        System.out.println("\n1. Add Character");
        System.out.println("Arthur: " + manager.addCharacter(c1));
        System.out.println("Luna: " + manager.addCharacter(c2));
        System.out.println("Robin: " + manager.addCharacter(c3));

        System.out.println("\n2. Duplicate Prevention");
        Character duplicate = new Character("arthur", CharacterType.MAGE);
        System.out.println("Duplicate Arthur: " + manager.addCharacter(duplicate));

        System.out.println("\n3. Find By Name");
        System.out.println("Search Luna: " + manager.findByName("Luna"));

        System.out.println("\n4. Total Characters");
        System.out.println("Total: " + manager.getTotalCharacters());

        System.out.println("\n5. Average Level");
        System.out.println("Average: " + manager.getAverageLevel());

        System.out.println("\n6. Find By Type");
        List<Character> mages = manager.findByType(CharacterType.MAGE);
        System.out.println("Total Mage: " + mages.size());

        System.out.println("\n7. Find Strongest");
        System.out.println("Strongest: " + manager.findStrongest());

        System.out.println("\n8. Defensive Copy");
        List<Character> copy = manager.getAllCharacters();
        copy.clear();
        System.out.println("Total after clearing copy: "
                + manager.getTotalCharacters());

        System.out.println("\n9. Remove Character");
        System.out.println("Remove Robin: " + manager.removeCharacter("Robin"));
        System.out.println("Total after removal: "
                + manager.getTotalCharacters());

        System.out.println("\n=== TEST SELESAI ===");
    }
}
