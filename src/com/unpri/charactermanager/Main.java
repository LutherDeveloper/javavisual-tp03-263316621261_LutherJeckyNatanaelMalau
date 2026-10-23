package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {
        Character arthur = new Character(
                "Arthur", CharacterType.WARRIOR, 1, 150, 20);

        Character merlin = new Character(
                "Merlin", CharacterType.MAGE, 3, 100, 49);

        Character robin = new Character(
                "Robin", CharacterType.ARCHER, 2, 120, 25);

        System.out.println("=== CHARACTER MANAGER ===");
        System.out.println("\n--- Daftar Karakter ---");

        System.out.println(arthur);
        System.out.println(merlin);
        System.out.println(robin);

        System.out.println("\n--- Demo Level Up ---");
        arthur.setLevel(2);
        System.out.println(arthur);

        System.out.println("\n--- Mini-Challenge ---");
        Character morrigan = new Character(
                "Morrigan", CharacterType.MAGE, 1, 100, 15);

        morrigan.setMana(120);

        System.out.println(morrigan);
        System.out.println("Morrigan is alive: "
                + morrigan.isAlive());
    }
}