/*
*
* */

import java.util.*;

public class MazeToTheMax {

    private int bound;
    private int levelNum;
    private boolean pass = false;
    private Random r = new Random();
    private Maze level;
    private String move;
    private Scanner sc = new Scanner(System.in);


    public MazeToTheMax(){
        levelNum = 1;
        bound = 2;
        move = "";
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
        while(bound<10){
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

            while(!pass){
                System.out.println("use commands a(left), d(right), w(up), and s(down)");
                move = sc.next();
                switch (move){
                    case "a":
                        pass = level.play(-1);
                        break;
                    case "s":
                        pass = level.play(bound);
                        break;
                    case "d":
                        pass = level.play(1);
                        break;
                    case "w":
                        pass = level.play(-bound);
                        break;
                    default:
                        System.out.println("sorry that isn't an input option");
                        pass = false;
                        break;
                }
                level.displayMaze();
            }

            System.out.println("yeet boi");

            pass = false;
            levelNum++;
            bound++;
        }
    }



    static public void main(String args[]){
        MazeToTheMax mm = new MazeToTheMax();
        System.exit(0);
    }
}
