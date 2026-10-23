package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private final ArrayList<Character> characters = new ArrayList<>();

    /**
     * Menambahkan karakter jika belum ada nama yang sama.
     *
     * @return true jika berhasil ditambahkan, false jika duplikat
     */
    public boolean addCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException(
                "Karakter tidak boleh null."
            );
        }

        if (findByName(character.getName()) != null) {
            return false;
        }

        characters.add(character);
        return true;
    }

    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(name.trim())) {
                return character;
            }
        }
        return null;
    }

    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        return characters.remove(character);
    }

    public int getTotalCharacters() {
        return characters.size();
    }

    /**
     * Mengembalikan salinan daftar, bukan daftar internal.
     */
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }

    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        if (type == null) {
            return result;
        }

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    /**
     * Mencari karakter dengan nilai attack tertinggi.
     * Jika daftar kosong, hasilnya null.
     */
    public Character findStrongest() {
        Character strongest = null;

        for (Character character : characters) {
            if (strongest == null ||
                    character.getAttack() > strongest.getAttack()) {
                strongest = character;
            }
        }

        return strongest;
    }
}
