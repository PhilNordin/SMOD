package com.philip.demo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void testLevelUp(){
        Player player1 = new Player();
        player1.setLevel(1);
        Game.levelUp(player1,20);
        int afterLevelUp = player1.getLevel();
        assertEquals(afterLevelUp,2);
    }
    @Test
    public void testCanLose(){
        Player player1 = new Player();
        Monster monster = new Monster();
        player1.setHealth(1);
        player1.setHealth(player1.getHealth() - monster.calculateDamage(5,1));
        assertEquals(player1.getHealth(),1);
    }
    @Test
    public void testCanDamage(){
        Player player1 = new Player();
        int playerDmg = player1.calculateDamage(15, 1);
        assertEquals(playerDmg,5);
    }

}
