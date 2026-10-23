package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        System.out.println("==================================");
        System.out.println(" CHARACTER MANAGER - TP5 AP6");
        System.out.println("==================================");

        System.out.println("\n--- A. Tambah Karakter ---");

        Character arthur = new Character(
                "Arthur", CharacterType.WARRIOR, 5, 150, 80, 0
        );

        Character merlin = new Character(
                "Merlin", CharacterType.MAGE, 8, 100, 95, 120
        );

        Character robin = new Character(
                "Robin", CharacterType.ARCHER, 4, 110, 70, 20
        );

        Character morrigan = new Character(
                "Morrigan", CharacterType.MAGE, 6, 90, 110, 150
        );

        System.out.println("Arthur: " + manager.addCharacter(arthur));
        System.out.println("Merlin: " + manager.addCharacter(merlin));
        System.out.println("Robin: " + manager.addCharacter(robin));
        System.out.println("Morrigan: " + manager.addCharacter(morrigan));

        System.out.println("\n--- Penolakan Duplikat ---");

        Character duplicate = new Character(
                "arthur", CharacterType.MAGE, 2, 50, 10, 30
        );

        System.out.println("Arthur duplikat: "
                + manager.addCharacter(duplicate));

        System.out.println("Total karakter: "
                + manager.getTotalCharacters());

        System.out.println("\n--- Daftar Karakter ---");

        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        System.out.println("\n--- Find By Name ---");

        System.out.println("Cari Merlin: " + manager.findByName("Merlin"));
        System.out.println("Cari Gandalf: " + manager.findByName("Gandalf"));

        System.out.println("\n--- Average Level ---");

        System.out.printf(
                "Rata-rata level: %.2f%n",
                manager.getAverageLevel()
        );

        CharacterManager emptyManager = new CharacterManager();

        System.out.println("Rata-rata list kosong: "
                + emptyManager.getAverageLevel());

        System.out.println("\n--- Find By Type: MAGE ---");

        ArrayList<Character> mages =
                manager.findByType(CharacterType.MAGE);

        for (Character mage : mages) {
            System.out.println(mage);
        }

        System.out.println("Jumlah MAGE: " + mages.size());

        System.out.println("\n--- Fitur Mandiri: Find Strongest ---");

        Character strongest = manager.findStrongest();

        if (strongest != null) {
            System.out.println("Karakter terkuat: "
                    + strongest.getName());
            System.out.println("Attack tertinggi: "
                    + strongest.getAttack());
        }

        System.out.println("\n--- Defensive Copy ---");

        ArrayList<Character> copy = manager.getAllCharacters();

        System.out.println("Total awal: " + manager.getTotalCharacters());

        copy.clear();

        System.out.println("Ukuran salinan setelah clear: " + copy.size());
        System.out.println("Total manager setelah clear: "
                + manager.getTotalCharacters());

        System.out.println("\n--- Eksperimen Reference ---");

        Character a = new Character(
                "ReferenceTest",
                CharacterType.WARRIOR,
                1, 100, 20, 0
        );

        Character b = a;
        b.setLevel(8);

        System.out.println("Level a setelah b.setLevel(8): "
                + a.getLevel());
        System.out.println("a == b: " + (a == b));

        Character c = new Character(
                a.getName(),
                a.getType(),
                a.getLevel(),
                a.getHitPoints(),
                a.getAttack(),
                a.getMana()
        );

        c.setLevel(10);

        System.out.println("a == c: " + (a == c));
        System.out.println("Level a setelah c.setLevel(10): "
                + a.getLevel());
        System.out.println("Level c: " + c.getLevel());

        System.out.println("\n--- Update dan Level Up ---");

        arthur.levelUp();
        System.out.println("Arthur setelah level up: " + arthur);

        System.out.println("\n--- Delete ---");

        System.out.println("Robin dihapus: "
                + manager.removeCharacter("Robin"));

        System.out.println("Robin dihapus lagi: "
                + manager.removeCharacter("Robin"));

        System.out.println("Total akhir: "
                + manager.getTotalCharacters());

        System.out.println("\n--- Static Counter ---");

        System.out.println("Total objek Character dibuat: "
                + Character.getTotalCharacterCreated());

        System.out.println("\n=== PROGRAM SELESAI ===");
    }
}