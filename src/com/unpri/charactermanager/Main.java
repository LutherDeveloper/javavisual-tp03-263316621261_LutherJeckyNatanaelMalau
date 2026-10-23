package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CharacterManager manager = new CharacterManager();

        System.out.println("=== CHARACTER MANAGER TP5 ===");

        Character arthur = new Character("Arthur", CharacterType.WARRIOR);
        Character merlin = new Character("Merlin", CharacterType.MAGE, 3);
        Character robin = new Character("Robin", CharacterType.ARCHER, 2);

        System.out.println("\n--- CREATE ---");
        System.out.println("Arthur: " + manager.addCharacter(arthur));
        System.out.println("Merlin: " + manager.addCharacter(merlin));
        System.out.println("Robin: " + manager.addCharacter(robin));

        System.out.println("\n--- DUPLICATE TEST ---");
        Character duplicate = new Character("ARTHUR", CharacterType.MAGE);
        System.out.println("Arthur duplikat ditolak: "
                + !manager.addCharacter(duplicate));
        System.out.println("Total karakter: " + manager.getTotalCharacters());

        System.out.println("\n--- READ ---");
        System.out.println("Cari Merlin: " + manager.findByName("Merlin"));
        System.out.println("Semua karakter:");
        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        System.out.println("\n--- DEFENSIVE COPY TEST ---");
        ArrayList<Character> copy = manager.getAllCharacters();
        copy.clear();
        System.out.println("Isi salinan setelah clear(): " + copy.size());
        System.out.println("Total asli tetap: " + manager.getTotalCharacters());

        System.out.println("\n--- MINI-CHALLENGE ---");
        System.out.println("Rata-rata level: " + manager.getAverageLevel());
        System.out.println("Jumlah MAGE: "
                + manager.findByType(CharacterType.MAGE).size());

        Character strongest = manager.findStrongest();
        System.out.println("Karakter dengan attack tertinggi: " + strongest);

        System.out.println("\n--- REFERENCE EXPERIMENT ---");
        Character a = new Character("Test", CharacterType.WARRIOR);
        Character b = a;
        b.setLevel(8);
        System.out.println("a.getLevel(): " + a.getLevel());
        System.out.println("a == b: " + (a == b));

        System.out.println("\n--- REMOVE ---");
        System.out.println("Robin berhasil dihapus: "
                + manager.removeCharacter("Robin"));
        System.out.println("Total setelah remove: " + manager.getTotalCharacters());

        System.out.println("\n--- EMPTY LIST TEST ---");
        CharacterManager emptyManager = new CharacterManager();
        System.out.println("Rata-rata list kosong: "
                + emptyManager.getAverageLevel());

        System.out.println("\nTotal objek Character dibuat: "
                + Character.getTotalCharacterCreated());
    }
}
