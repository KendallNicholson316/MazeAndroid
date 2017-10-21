/*
*
* */

import java.util.*;

public class MazeToTheMax {

    private int bound;
    private int levelNum = 2;
    private boolean pass = true;
    private Random r = new Random();
    private Maze level;

    public MazeToTheMax(){
        levelUp();
    }

    public int getLevel(){
        return levelNum;
    }

/*
* will implement a while loop to generate mazes until pass turns false
* pass = false if player cannot complete level
* */
    public void levelUp(){//dictates maze bounds or level
        //while(pass){
            bound = (int)Math.pow(2,levelNum);
            System.out.println("bound: " + bound);
            level = new Maze(bound);
            level.displayMaze();

        //}
    }



    static public void main(String args[]){
        MazeToTheMax mm = new MazeToTheMax();
        System.exit(0);
    }
}
