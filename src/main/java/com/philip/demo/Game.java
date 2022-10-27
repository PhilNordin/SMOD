package com.philip.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static com.philip.demo.Colors.*;
import static com.philip.demo.Colors.RESET;

public class Game {

    public static void myDungeonGame(){
        Scanner sc = new Scanner(System.in);
        Player player1 = new Player();
        Monster monster = getMonster();

        player1.setHealth(100);
        player1.setLevel(1);
        player1.setStrength(15);
        player1.setIntelligence(25);
        player1.setAgility(50);

        System.out.println(WHITE_BOLD_BRIGHT +"Whats your name? ");
        player1.setPlayerName(sc.nextLine());

        Game:
        do {
            System.out.println("Welcome Sir " + player1.getPlayerName() + ", to the Dungeon!\n");

            System.out.println("1. Enter the Dungeon!\n");
            System.out.println("  9. Exit\n");

            System.out.println("Make your choice:  ");



            int playerMenu = getUserInputInt();
            switch (playerMenu) {           //MAIN MENU
                case 1:
                    Scanner scan = new Scanner(System.in);
                    System.out.println("You enter the dungeon and within seconds a monster appear!");
                    System.out.println("What do you do?");

                    do {
                        System.out.println(WHITE_BOLD_BRIGHT +"\n1. Fight!");
                        System.out.println("2. Check player status.");

                        System.out.println("3. Return to main menu. ");

                        System.out.println("\nMake your choice:  ");
                        int playerMenu2 = getUserInputInt();

                        //BATTLE MENU
                        switch (playerMenu2) {
                            case 1:
                                fightMenu(player1);
                                break;
                            case 2:
                                getPlayerStats(player1);
                                break;
                            case 3:
                                System.out.println("Returning to main menu\n");
                                continue Game;

                            default:
                                System.out.println("Invalid number");

                        }
                    }while(true);
                case 9:
                    System.out.println("You exit the game.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid number");

            }
        }while(true);

    }

    public static int getUserInputInt(){
        Scanner sc = new Scanner(System.in);
        String userInput;
        int userInputInt = 0;
        boolean runInput = true;

        do {
            try{
                userInput = sc.nextLine();
                userInputInt = Integer.parseInt(userInput);
                runInput = false;
            }catch (Exception e){
                System.out.println(WHITE_BOLD_BRIGHT+"Wrong format of input. Try again!");
            }
        }while(runInput);
        return userInputInt;
    }

    public static void fightMenu(Player player1){
        Monster monster = getMonster();
        System.out.println(WHITE_BOLD_BRIGHT+"The monster is now close and you see it's a big " + monster.getMonsterName() + "! What do you do?");
        Fight:
        do {
            System.out.println(WHITE_BOLD_BRIGHT +"\n1. ATTACK!");
            System.out.println("2. Check player status.");
            System.out.println("3. FLEE! ");
            System.out.println("\nMake your choice:  ");
            Scanner sc = new Scanner(System.in);
            int choice = getUserInputInt();
            switch(choice){
                case 1:
                    fight1(player1, monster);
                    break;
                case 2:
                    System.out.println(player1.toString());
                    break;
                case 3:
                    Random rand = new Random();
                    if (player1.getAgility() > rand.nextInt(100)) {
                        System.out.println("You fled the fight");
                        break Fight;
                    } else {
                        System.out.println("You try to run but the beast wont let you! ");
                        break;
                    }
                default:
                    System.out.println("invalid input. Try again!\n");
                    break;
            }
        }while(player1.getHealth()> 0 && monster.getHealth() > 0);


    }


    public static void fight1(Player player1, Monster monster){

        if (player1.getHealth() >= 1){
            monster.setHealth(monster.getHealth() - player1.calculateDamage(player1.getStrength(),player1.getLevel()));
            System.out.println(WHITE_BOLD_BRIGHT+player1.getPlayerName() + " hits " + monster.getMonsterName() +" for " +player1.calculateDamage(player1.getStrength(), player1.getLevel())+ " damage. The "+ monster.getMonsterName() + "'s remaining "+RED_BOLD_BRIGHT+"health"+RESET+WHITE_BOLD_BRIGHT +" is:" + monster.getHealth() + " HP");
        }
        if (monster.getHealth() < 0){
            monster.setHealth(0);
        }

        if (monster.getHealth() >= 1) {
            player1.setHealth(player1.getHealth() - monsterDamage(monster.getStrength(), monster.getBaseDamage()));
            System.out.println(WHITE_BOLD_BRIGHT +monster.getMonsterName() +" hits " + player1.getPlayerName()+ " for " + monsterDamage(monster.getStrength(),monster.getBaseDamage()) + RED_BOLD_BRIGHT +" hp." +RESET+WHITE_BOLD_BRIGHT+ " Your remaining " +RED+"health" +RESET+ WHITE_BOLD_BRIGHT +" is: " + player1.getHealth() + " HP");
        }

        if (player1.getHealth() <0){
            player1.setHealth(0);
        }

        if (player1.getHealth() <= 0){
            System.out.println(WHITE_BOLD_BRIGHT +"YOU ARE DEAD." + " RIP Sir "+player1.getPlayerName());
            System.exit(0);
            myDungeonGame();
        } else if (player1.getHealth()==0 && monster.getHealth()==0){
            System.out.println(WHITE_BOLD_BRIGHT +"You died but in the last second you brought the ugly beast with you");
        }else if (monster.getHealth() <= 0){
            System.out.println(WHITE_BOLD_BRIGHT +"The " + monster.getMonsterName() + " died." );
            levelUp(player1, monster.experience);
        }
    }

    public static void getPlayerStats(Player player1) {
        System.out.println(WHITE_BOLD_BRIGHT +"\nPlayer status: ");
        System.out.println("Name : Sir" + player1.getPlayerName());
        System.out.println("Level: " + player1.getLevel()+RESET);
        System.out.println(RED_BOLD_BRIGHT +"\nHealth: " + player1.getHealth());
        System.out.println(GREEN_BOLD_BRIGHT + "Strength: " + player1.getStrength());
        System.out.println(BLUE_BOLD_BRIGHT +"Intelligence: " + player1.getIntelligence());
        System.out.println(PURPLE_BOLD_BRIGHT +"Agility: " + player1.getAgility()+RESET);
    }


    public static void levelUp(Player player, int experience) {
        int currentExp = player.getExperienceGained();
        player.setExperienceGained(currentExp + experience);

        if (player.getExperienceGained() > (player.getLevel() * 10)) {
            player.setLevel(player.getLevel() + 1);
            System.out.println(YELLOW_BOLD_BRIGHT +"Experience gained: " + experience + RESET);
            System.out.println(WHITE_BOLD_BRIGHT +"Level up! You are now level " + player.getLevel()+ RESET);
        } else {
            System.out.println(YELLOW_BOLD_BRIGHT +"Experience gained: " + experience + RESET);
        }
    }


    public static Monster getMonster(){
        Monster monster = new Monster();
        monster.setHealth(20);
        monster.setStrength(2);
        monster.setBaseDamage(2);
        monster.setExperience(5);
        monster.setMonsterName("Rat");

        Monster monster1 = new Monster();
        monster1.setHealth(30);
        monster1.setStrength(3);
        monster1.setBaseDamage(2);
        monster1.setExperience(8);

        monster1.setMonsterName("Bug");

        Monster monster2 = new Monster();
        monster2.setHealth(40);
        monster2.setStrength(4);
        monster2.setBaseDamage(3);
        monster2.setExperience(10);
        monster2.setMonsterName("Dragon");

        Monster monster3 = new Monster();
        monster3.setHealth(50);
        monster3.setStrength(10);
        monster3.setBaseDamage(5);
        monster3.setExperience(12);
        monster3.setMonsterName("Behemoth");

        Monster monster4 = new Monster();
        monster4.setHealth(60);
        monster4.setStrength(4);
        monster4.setBaseDamage(5);
        monster4.setExperience(15);
        monster4.setMonsterName("Demon");

        List<Monster> monsterArray = new ArrayList<>();
        monsterArray.add(monster);
        monsterArray.add(monster1);
        monsterArray.add(monster2);
        monsterArray.add(monster3);
        monsterArray.add(monster4);

        Random rand = new Random();


        return monsterArray.get(rand.nextInt(0,4));
    }



    public static int monsterDamage(int strength,int baseDamage){

        return baseDamage+(strength*2/4+1);   // IF crit return this and that - flera returns med if statement
    }

}
