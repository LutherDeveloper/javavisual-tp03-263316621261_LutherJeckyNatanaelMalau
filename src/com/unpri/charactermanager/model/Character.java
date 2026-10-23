package com.unpri.charactermanager.model;

import java.util.Locale;
import java.util.Objects;

public class Character {

    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attack;
    private int mana;

    private static int totalCharacterCreated = 0;

    public Character(String name, CharacterType type) {
        this(name, type, 1);
    }

    public Character(String name, CharacterType type, int level) {
        setName(name);
        setType(type);
        this.mana = 0;
        setLevel(level);
        totalCharacterCreated++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama karakter tidak boleh kosong."
            );
        }
        this.name = name.trim();
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        if (type == null) {
            throw new IllegalArgumentException(
                "Jenis karakter tidak boleh null."
            );
        }
        this.type = type;
        recalculateStats();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                "Level harus minimal 1."
            );
        }
        this.level = level;
        recalculateStats();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        if (hitPoints < 0) {
            throw new IllegalArgumentException(
                "Hit points tidak boleh negatif."
            );
        }
        this.hitPoints = hitPoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if (attack < 0) {
            throw new IllegalArgumentException(
                "Attack tidak boleh negatif."
            );
        }
        this.attack = attack;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif."
            );
        }
        this.mana = mana;
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    private void recalculateStats() {
        switch (type) {
            case WARRIOR:
                hitPoints = 150 + (level - 1) * 20;
                attack = 20 + (level - 1) * 5;
                break;
            case MAGE:
                hitPoints = 80 + (level - 1) * 10;
                attack = 35 + (level - 1) * 7;
                break;
            case ARCHER:
                hitPoints = 100 + (level - 1) * 15;
                attack = 25 + (level - 1) * 6;
                break;
            case ASSASSIN:
                hitPoints = 90 + (level - 1) * 12;
                attack = 30 + (level - 1) * 8;
                break;
            default:
                throw new IllegalStateException(
                    "Jenis karakter tidak dikenali."
                );
        }
    }

    public void levelUp() {
        setLevel(level + 1);
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;
        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(Locale.ROOT));
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", attack=" + attack +
                ", mana=" + mana +
                '}';
    }
}