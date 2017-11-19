/*
*
* */

import java.util.*;

public class MazeToTheMax {

    private int bound;
    private int levelNum;
    private boolean pass = true;
    private Random r = new Random();
    private Maze level;

    public MazeToTheMax(){
        levelNum = 1;
        bound = 2;
        levelUp();
    }

    public int getLevel(){
        return levelNum;
    }

/*
* implement a while loop to generate mazes until pass turns false
* pass = false if player cannot complete level
* can place limit on maze size by limiting bound in while() (while(pass && bound < 30))
* to help with the lag when finding solvable mazes of large bounds
* */
    public void levelUp(){//dictates maze bounds or level
        while(pass && bound<10){
            System.out.println("THIS IS LEVEL " + levelNum + "!!!");
            System.out.println("bound: " + bound);
            level = new Maze(bound);
            //level.displayMaze();
            boolean solvable = level.solvable();

            while(!solvable){
                level = new Maze(bound);
                //level.displayMaze();
                solvable = level.solvable();
            }
            level.displayMaze();
            levelNum++;
            bound++;
        }
    }



    static public void main(String args[]){
        MazeToTheMax mm = new MazeToTheMax();
        System.exit(0);
    }
}
