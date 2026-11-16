
package com.unpri.charactermanager.model;

import java.util.ArrayList;
import java.util.List;

public class CharacterManager {

    private final List<Character> characters;

    public CharacterManager() {
        characters = new ArrayList<>();
    }

    public boolean addCharacter(Character character) {
        if (character == null) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            return false;
        }

        characters.add(character);
        return true;
    }

    public Character findByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName() != null &&
                character.getName().trim().equalsIgnoreCase(name.trim())) {
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

        characters.remove(character);
        return true;
    }

    public int getTotalCharacters() {
        return characters.size();
    }

    public List<Character> getAllCharacters() {
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

    public List<Character> findByType(CharacterType type) {
        List<Character> result = new ArrayList<>();

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

    public Character findStrongest() {
        if (characters.isEmpty()) {
            return null;
        }

        Character strongest = characters.get(0);

        for (Character character : characters) {
            if (character.getAttack() > strongest.getAttack()) {
                strongest = character;
            }
        }

        return strongest;
    }
}