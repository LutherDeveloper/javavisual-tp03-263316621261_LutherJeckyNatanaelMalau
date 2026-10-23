package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== CHARACTER MANAGER ===");
        System.out.println();

        Character warrior = new Character(
            "Arthur", CharacterType.WARRIOR
        );

        Character mage = new Character(
            "Merlin", CharacterType.MAGE, 3
        );

        Character archer = new Character(
            "Robin", CharacterType.ARCHER
        );

        System.out.println("--- Daftar Karakter ---");
        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(archer);

        System.out.println();
        System.out.println("--- Demo Level Up ---");

        System.out.println("Sebelum: " + warrior);
        warrior.levelUp();
        System.out.println("Sesudah: " + warrior);

        System.out.println();
        System.out.println("--- Mini-Challenge ---");

        Character necromancer = new Character(
            "Morrigan", CharacterType.MAGE, 5
        );

        necromancer.setMana(120);

        System.out.println(necromancer);
        System.out.println(
            "Mana: " + necromancer.getMana()
        );
        System.out.println(
            "Apakah karakter hidup? " + necromancer.isAlive()
        );

        System.out.println();
        System.out.println("--- Pengujian Validasi Mana ---");

        try {
            necromancer.setMana(-10);
        } catch (IllegalArgumentException e) {
            System.out.println(
                "Validasi berhasil: " + e.getMessage()
            );
        }
    }
}