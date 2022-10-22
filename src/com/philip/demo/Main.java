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


        player1.setHealth(100);
        player1.setLevel(1);
        player1.setStrength(15);
        player1.setIntelligence(25);
        player1.setAgility(50);

        System.out.println("\t\tWhats your name? ");
        player1.setPlayerName(sc.nextLine());

        Game:
        do {
            System.out.println("\tWelcome Sir " + player1.getPlayerName() + ", to the Dungeon!\n");

            System.out.println("\t\t1. Enter the Dungeon!\n");
            System.out.println("\t\t  9. Exit\n");

            System.out.println("\t\tMake your choice:  ");



            int playerMenu = getUserInputInt();
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
                        int playerMenu2 = getUserInputInt();
                        switch (playerMenu2) {
                            case 1:
                                fightMenu(player1);
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
                System.out.println("Wrong format of input. Try again!");
            }
        }while(runInput);



        return userInputInt;
    }





    public static void fightMenu(Player player1){
        Monster monster = getMonster();
        System.out.println("The monster is now close and you see it's a big " + monster.getMonsterName() + "! What do you do?");
        Fight:
        do {
            System.out.println("\n\t\t1. ATTACK!");
            System.out.println("\t\t2. Check player status.");
            System.out.println("\t\t3. FLEE! ");
            System.out.println("\n\t\tMake your choice:  ");
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
                    System.out.println("you fled the fight");
                    break Fight;
                default:
                    System.out.println("invalid number");
                    break;
            }
        }while(player1.getHealth()> 0 && monster.getHealth() > 0);


    }

    public static void fight1(Player player1, Monster monster){

            if (player1.getHealth() >= 1){
                monster.setHealth(monster.getHealth() - player1.calculateDamage(player1.getStrength(),player1.getLevel()));
                System.out.println(player1.getPlayerName() + " hits " + monster.getMonsterName() +" for " +player1.calculateDamage(player1.getStrength(), player1.getLevel())+ " damage."+ monster.getMonsterName() + "'s remaining hp is:  " + monster.getHealth() + " Hp");
            }
            if (monster.getHealth() < 0){
                monster.setHealth(0);
            }

            if (monster.getHealth() >= 1) {
                player1.setHealth(player1.getHealth() - monsterDamage(monster.getStrength(), monster.getBaseDamage()));
                System.out.println(monster.getMonsterName() +" hits Player for " + monsterDamage(monster.getStrength(),monster.getBaseDamage()) + "hp. " + player1.getPlayerName() +"'s remaining hp is: " + player1.getHealth() + "Hp");
            }

            if (player1.getHealth() <0){
                player1.setHealth(0);
            }



        if (player1.getHealth() <= 0){
            System.out.println("YOU ARE DEAD." + " RIP Sir "+player1.getPlayerName());
            System.exit(0);
        } else if (player1.getHealth()==0 && monster.getHealth()==0){
            System.out.println("You died but in the last second you brought the ugly beast with you");
        }else if (monster.getHealth() <= 0){
            System.out.println("The " + monster.getMonsterName() + " died." );
        }

//        if (player1.getHealth()<=0){
//            System.exit(0);
//        } else if (player1.getHealth()==monster.getHealth()) {
//            System.out.println("You died but in the last second you brought the ugly beast with you");
//        }
        System.out.println(player1.getPlayerName() + "'s remaining health is: "+ player1.getHealth());
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


//    public static void fight(Player player, Monster monster){
//
//
//        int playerHealth = player.health;
//        int playerStrength = player.;
//        int playerLevel = player.;
//        int playerIntelligence = player.intelligence;
//
//        int monsterHealth = monster.health;
//        int monsterStrength = monster.strength;
//        int monsterBaseDamage = monster.baseDamage;
//
//        int damage = player.calculateDamage(player., player.);
//        Scanner sc = new Scanner(System.in);
//
//        do {
//            monsterHealth = monsterHealth - player.calculateDamage(playerStrength,playerLevel);
//            if (monsterHealth <0){
//                monsterHealth = 0;
//            }
//            System.out.println(player.playerName + " hits " + monster. +" for " +player.calculateDamage(playerStrength,playerLevel)+ " damage."+ monster. + "'s remaining hp is:  " + monsterHealth + " Hp");
//
//            if (monsterHealth <=0) break;
//
//            playerHealth = playerHealth - monsterDamage(monsterStrength,monsterBaseDamage);
//
//            if (playerHealth <0){
//                playerHealth = 0;
//            }
//
//            System.out.println(monster. +" hits Player for " + monsterDamage(monsterStrength,monsterBaseDamage) + "hp. " + player.playerName +"'s remaining hp is: " + playerHealth + "Hp");
//
//        }while(playerHealth >= 0 && monsterHealth >= 0);
//
//        if (monsterHealth > playerHealth){
//            System.out.println("Monster win");
//        } else if (playerHealth==monsterHealth){
//            System.out.println("You died but in the last second you brought the ugly beast with you");
//        }else if (monsterHealth > playerHealth){
//            System.out.println("you died");
//            System.exit(0);
//        }
//
//        player.health = playerHealth;
//
//
//        if (playerHealth<=0){
//            System.exit(0);
//        } else if (playerHealth==monsterHealth) {
//            System.out.println("You died but in the last second you brought the ugly beast with you");
//        }
//        System.out.println(player.playerName + "'s remaining health is: "+ playerHealth);
//
//
//    }



    public static Monster getMonster(){
        Monster monster = new Monster();
        monster.setHealth(20);
        monster.setStrength(5);
        monster.setBaseDamage(2);
        monster.setMonsterName("Rat");

        Monster monster1 = new Monster();
        monster1.setHealth(30);
        monster1.setStrength(5);
        monster1.setBaseDamage(2);
        monster1.setMonsterName("Bug");

        Monster monster2 = new Monster();
        monster2.setHealth(20);
        monster2.setStrength(5);
        monster2.setBaseDamage(2);
        monster2.setMonsterName("Dragon");

        Monster monster3 = new Monster();
        monster3.setHealth(20);
        monster3.setStrength(5);
        monster3.setBaseDamage(5);
        monster3.setMonsterName("Mona sahlin");

        Monster monster4 = new Monster();
        monster4.setHealth(60);
        monster4.setStrength(5);
        monster4.setBaseDamage(2);
        monster4.setMonsterName("Lil bow wowser");

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
