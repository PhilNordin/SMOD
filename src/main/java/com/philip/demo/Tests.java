package com.philip.demo;

import org.junit.Test;

import static com.philip.demo.Colors.*;
import static com.philip.demo.Colors.RESET;
import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void test(){
        String name = "anna";
        assertEquals("anna", name);

    }

    @Test
    public void testLevelUp(){
        Player player1 = new Player();
        Game.levelUp(player1,1);
        assertEquals(player1,10);
    }
    @Test
    public void testCanLose(){

    }
    @Test
    public void testCanDamage(){


    }

}
