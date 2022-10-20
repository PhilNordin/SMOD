package com.philip.demo;

public class Player implements ICombat {

    public int health;
    public int strength;
    public int agility;
    public int intelligence;
    public int level;
    public String playerName;


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

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int fight(int health, int damage) {
        return health - damage;
    }

    @Override
    public int calculateDamage(int strength,int level) {
        return (((strength+level)/4)+1);
    }

    public String getPlayerName(){

        return playerName;
    }
}
