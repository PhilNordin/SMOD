package com.philip.demo;

import java.util.Random;

import static com.philip.demo.Colors.*;

public class Player implements ICombat {

    public int health;
    public int strength;
    public int agility;
    public int intelligence;
    public int level;
    public String playerName;

    public int experienceGained;
    public int getExperience;

    public int getExperienceGained() {
        return experienceGained;
    }

    public void setExperienceGained(int experienceGained) {
        this.experienceGained = experienceGained;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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
    public String toString() {
        return "Player Status:\n"+
                WHITE_BOLD_BRIGHT+"\nName: " + playerName +
                "\nLevel: " + level +
                RED_BOLD_BRIGHT + "\nHealth: " + health +
                GREEN_BOLD_BRIGHT +"\nStrength: " + strength +
                PURPLE_BOLD_BRIGHT +"\nAgility: " + agility +
                BLUE_BOLD_BRIGHT +"\nIntelligence: " + intelligence + RESET;
    }

    @Override
    public int calculateDamage(int strength,int level) {
        Random rand = new Random();
        if (rand.nextInt(10) > 8){
            System.out.println(YELLOW_BOLD_BRIGHT+"CRITICAL HIT!");
            return (((strength+level)/4)*10);
        }
        return (((strength+level)/4)+1);
    }

    public String getPlayerName(){

        return playerName;
    }
}
