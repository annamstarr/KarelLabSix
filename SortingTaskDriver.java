
/**
   @Author: A. Starr
      Date: 9/27/17
   Teacher: Appel
  */
import kareltherobot.*;
import java.awt.Color;

public class SortingTaskDriver implements Directions
{
    public static void main(String args[])  {
        //Do NOT modify the code below
        Robot stackBot = new Robot(1, 1,East, -1);
        stackBeepers(stackBot);
        stackBot.setVisible(false);
        stackBot.turnOff();
        
        
        //Your code goes here:
        Problem1 karel = new Problem1(1, 1, East, 0);  
        karel.sortBeepers();
        karel.turnOff();  
    } 
    
    public static void stackBeepers(Robot bot) {
        faceNorth(bot);
        
        for (int i = 1; i <=8; i ++) {
            stack(bot);
            returnToFloor(bot);
            faceEast(bot);
            bot.move();
            faceNorth(bot);
        }
    }
    
    public static void faceNorth(Robot bot) {
        while (!bot.facingNorth()) {
            bot.turnLeft();
        }
    }
    
    public static void faceEast(Robot bot) {
        while (!bot.facingEast()) {
            bot.turnLeft();
        }
    }
    
    public static void stack(Robot bot) {
        for (int j = 0; j < (int)(Math.random()*9+1); j++) {
            bot.putBeeper();
            bot.move();
        }
    }
    
    public static void returnToFloor(Robot bot) {
        while (!bot.facingSouth()) {
            bot.turnLeft();
        }
        while (bot.frontIsClear()) {
            bot.move();
        }
    }
    
    static {
        World.reset(); 
        //World.readWorld("worlds/fig6-31.kwld"); 
        //World.readWorld("worlds/sortsolution.kwld");
        World.setBeeperColor(Color.black);
        World.setStreetColor(Color.gray);
        World.setNeutroniumColor(Color.black);
        World.setDelay(5);  
        World.setVisible(true);
    }
}
