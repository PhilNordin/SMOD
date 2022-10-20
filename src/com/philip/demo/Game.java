package com.philip.demo;

import java.util.Scanner;

public class Game {
        Scanner sc = new Scanner(System.in);

        public void myMenu(){

                int playerMenu = sc.nextInt();
                switch (playerMenu){
                        case 0:
                                System.out.println("0. Exit");
                                break;
                        case 1:
                                System.out.println("1. Start game");
                                break;
                        case 2:
                                System.out.println("2. Shop");
                                break;
                        case 3:
                                System.out.println("3. PLACEHOLDER1");
                        default:
                                System.out.println("Invalid number");
                                myMenu();
                }


        }

        public void menuHeader(){

                System.out.println("WELCOME TO THE DUNGEON MASTER 3000!");

                System.out.println("\n1. Start game");
                System.out.println("2. Shop");
                System.out.println(" ");
                System.out.println("0. Exit game");

                System.out.println("\nPlease make a choice..");

        }


}
