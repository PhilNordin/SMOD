package com.philip.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        myMenu();


    }

    public static void myMenu(){


        Scanner sc = new Scanner(System.in);
        Player player1 = new Player();
        Monster monster = getMonster();


        player1.health = 100;
        player1.level = 1;
        player1.strength = 15;
        player1.intelligence = 10;
        player1.agility = 50;

        System.out.println("\t\tWhats your name? ");
        player1.playerName = sc.nextLine();

        Game:
        do {
            System.out.println("\tWelcome Sir " + player1.getPlayerName() + ", to the Dungeon!\n");

            System.out.println("\t\t1. Enter the Dungeon!\n");
            System.out.println("\t\t  9. Exit\n");

            System.out.println("\t\tMake your choice:  ");



            int playerMenu = sc.nextInt();
            switch (playerMenu) {           //MAIN MENU
                case 1:
                    Scanner scan = new Scanner(System.in);
                    System.out.println("\t\tYou enter the dungeon and within seconds a monster appear!");
                    System.out.println("\t\tWhat do you do?");
                                            //BATTLE MENU
                    do {

                        System.out.println("\n\t\t1. Fight!");
                        System.out.println("\t\t2. Check player status.");

                        System.out.println("\t\t3. Return to main menu. ");

                        System.out.println("\n\t\tMake your choice:  ");
                        int playerMenu2 = scan.nextInt();
                        switch (playerMenu2) {
                            case 1:
                                fightMenu(player1, monster);
                                break;
                            case 2:
                                getPlayerStats(player1);
                                break;
                            case 3:
                                System.out.println("\t\tReturning to main menu\n");
                                continue Game;

                            default:
                                System.out.println("\t\tInvalid number");

                        }
                    }while(true);

                case 2:
                    System.out.println("hej1");
                    break;
                case 3:
                    System.out.println("hej2");
                    break;
                case 9:
                    System.out.println("\t\tYou exit the game.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\t\tInvalid number");

            }
        }while(true);

    }


    public static void fightMenu(Player player1, Monster monster){
        Fight:
        do {
            System.out.println("\n\t\t1. Fight!");
            System.out.println("\t\t2. Check player status.");
            System.out.println("\t\t3. FLEE! ");
            System.out.println("\n\t\tMake your choice:  ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    fight1(player1, monster);
                    break;
                case 2:
                    getPlayerStats(player1);
                    break;
                case 3:
                    System.out.println("yo fled the fight");
                    break Fight;


            }
        }while(player1.getHealth()>= 0 && monster.health >= 0);


    }

    public static void fight1(Player player, Monster monster){
        int playerHealth = player.health;
        int playerStrength = player.strength;
        int playerLevel = player.level;
        int playerIntelligence = player.intelligence;

        int monsterHealth = monster.health;
        int monsterStrength = monster.strength;
        int monsterBaseDamage = monster.baseDamage;

        int damage = player.calculateDamage(player.strength, player.level);
        Scanner sc = new Scanner(System.in);

            monsterHealth = monsterHealth - player.calculateDamage(playerStrength,playerLevel);
            if (monsterHealth <0){
                monsterHealth = 0;
            }
            System.out.println(player.playerName + " hits " + monster.monsterName +" for " +player.calculateDamage(playerStrength,playerLevel)+ " damage."+ monster.monsterName + "'s remaining hp is:  " + monsterHealth + " Hp");

            if (monsterHealth <=0){

            }

            playerHealth = playerHealth - monsterDamage(monsterStrength,monsterBaseDamage);

            if (playerHealth <0){
                playerHealth = 0;
            }

            System.out.println(monster.monsterName +" hits Player for " + monsterDamage(monsterStrength,monsterBaseDamage) + "hp. " + player.playerName +"'s remaining hp is: " + playerHealth + "Hp");


        if (monsterHealth > playerHealth){
            System.out.println("Monster win");
        } else if (playerHealth==monsterHealth){
            System.out.println("You died but in the last second you brought the ugly beast with you");
        }else if (monsterHealth > playerHealth){
            System.out.println("you died");
            System.exit(0);
        }

        player.health = playerHealth;


        if (playerHealth<=0){
            System.exit(0);
        } else if (playerHealth==monsterHealth) {
            System.out.println("You died but in the last second you brought the ugly beast with you");
        }
        System.out.println(player.playerName + "'s remaining health is: "+ playerHealth);



    }

    public static void getPlayerStats(Player player1){
        System.out.println("\n\t\tPlayer status: ");
        System.out.println("\t\tName : " + player1.getPlayerName());
        System.out.println("\t\tLevel: " + player1.getLevel());
        System.out.println("\t\tHealth: " + player1.getHealth());
        System.out.println("\t\tStrength: " + player1.getStrength());
        System.out.println("\t\tIntelligence: " + player1.getIntelligence());
        System.out.println("\t\tAgility: " + player1.getAgility());
    }


    public static void fight(Player player, Monster monster){


        int playerHealth = player.health;
        int playerStrength = player.strength;
        int playerLevel = player.level;
        int playerIntelligence = player.intelligence;

        int monsterHealth = monster.health;
        int monsterStrength = monster.strength;
        int monsterBaseDamage = monster.baseDamage;

        int damage = player.calculateDamage(player.strength, player.level);
        Scanner sc = new Scanner(System.in);

        do {
            monsterHealth = monsterHealth - player.calculateDamage(playerStrength,playerLevel);
            if (monsterHealth <0){
                monsterHealth = 0;
            }
            System.out.println(player.playerName + " hits " + monster.monsterName +" for " +player.calculateDamage(playerStrength,playerLevel)+ " damage."+ monster.monsterName + "'s remaining hp is:  " + monsterHealth + " Hp");

            if (monsterHealth <=0) break;

            playerHealth = playerHealth - monsterDamage(monsterStrength,monsterBaseDamage);

            if (playerHealth <0){
                playerHealth = 0;
            }

            System.out.println(monster.monsterName +" hits Player for " + monsterDamage(monsterStrength,monsterBaseDamage) + "hp. " + player.playerName +"'s remaining hp is: " + playerHealth + "Hp");

        }while(playerHealth >= 0 && monsterHealth >= 0);

        if (monsterHealth > playerHealth){
            System.out.println("Monster win");
        } else if (playerHealth==monsterHealth){
            System.out.println("You died but in the last second you brought the ugly beast with you");
        }else if (monsterHealth > playerHealth){
            System.out.println("you died");
            System.exit(0);
        }

        player.health = playerHealth;


        if (playerHealth<=0){
            System.exit(0);
        } else if (playerHealth==monsterHealth) {
            System.out.println("You died but in the last second you brought the ugly beast with you");
        }
        System.out.println(player.playerName + "'s remaining health is: "+ playerHealth);


    }



    public static Monster getMonster(){
        Monster monster = new Monster();
        monster.health = 20;
        monster.strength = 5;
        monster.baseDamage = 2;
        monster.monsterName = "Grävling";

        Monster monster1 = new Monster();
        monster1.health = 30;
        monster1.strength = 5;
        monster1.baseDamage = 2;
        monster1.monsterName = "Gremling";

        Monster monster2 = new Monster();
        monster2.health = 40;
        monster2.strength = 5;
        monster2.baseDamage = 2;
        monster2.monsterName = "Troll";

        Monster monster3 = new Monster();
        monster3.health = 50;
        monster3.strength = 5;
        monster3.baseDamage = 5;
        monster3.monsterName = "Mona Sahlin";

        Monster monster4 = new Monster();
        monster4.health = 60;
        monster4.strength = 5;
        monster4.baseDamage = 2;
        monster4.monsterName = "Lil bow wowser";

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
