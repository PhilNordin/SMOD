package com.philip.demo;

public class Monster implements ICombat {

    public int health;
    public int strength;

    public int baseDamage;
    public int experience;

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String monsterName;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    @Override
    public int fight(int health, int damage) {
        return 0;
    }

    @Override
    public int calculateDamage(int strength, int level) {
        return 0;
    }
}
