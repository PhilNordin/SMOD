package com.philip.demo;

public class Monster implements ICombat {

    public int health;
    public int strength;

    public int baseDamage;

    public String monsterName;



    @Override
    public int fight(int health, int damage) {
        return 0;
    }

    @Override
    public int calculateDamage(int strength, int level) {
        return 0;
    }
}
