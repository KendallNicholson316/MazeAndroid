/*
* This class creates a graph that serves as the maze, maze is just random, so to find
* a solvable maze the solvable boolean serves as a recursive method to do so  and to then
* display the maze the display function will format a string output
* */

import java.util.ArrayList;

public class Maze {
    private Graph maze;
    private int bound;
    private int current;
    private int end;

    public Maze(int bound){
        this.bound = bound;
        maze = new Graph(bound);
        current = 0;
        end = (bound*bound)-1;
    }

    //used for tracking solvable when testing
    public void spit(ArrayList<Edge> stuff){
        for (int i = 0; i < stuff.size(); i++) {
            System.out.println("start:" + stuff.get(i).getStart());
            System.out.println("end:" + stuff.get(i).getEnd());
            System.out.println("weight:" + stuff.get(i).getWeight());
            System.out.println("block:" + stuff.get(i).getBlock());
        }
    }

    //uses recursion to find if maze if solvable
    //outputs true if it can reach end
    //outputs false it end cannot be reached
    public boolean solvable() {
        int index;
        Graph duplicate = maze.getValidEdges();
        ArrayList<Edge> options = duplicate.getOptions(current);
        while (options.size() > 0) {
            //for testing
            //spit(options);
            index = maze.lightest(options);
            duplicate.getEdges().remove(options.get(index));

            if (options.get(index).getEnd() == end) {
                return true;
            }
            else {
                current = options.get(index).getEnd();
                options.remove(options.get(index));
                return solvable();
            }

        }
        //System.out.println("C'est impossible");
        return false;
    }

    //formats a maze display and prints
    public void displayMaze(){
        String display = "";
//        for(int b = 0; b<bound; b++) {
//            for (int p = 0; p < bound; p++) {
//                System.out.print(maze.getHorizontal().getBlocks()[b][p]);
//            }
//            System.out.println();
//        }
//        System.out.println();
//        for(int b = 0; b<bound; b++){
//            for (int p = 0; p < bound; p++) {
//                System.out.print(maze.getVertical().getBlocks()[b][p]);
//            }
//            System.out.println();
//        }

        for(int k =0; k<bound; k++){
            display += String.format("%1c"+"%1c",' ','_');
        }
        display += String.format("\n");
        for(int i = 0; i<bound; i++){
            for(int j =0; j<bound; j++){
                if(j==0){
                    display += String.format("|");
                }
                if(maze.getHorizontal().getBlocks()[i][j] && maze.getVertical().getBlocks()[i][j]) {
                    display += String.format("%1c"+"%1c",'_','|');
                }
                else if(maze.getHorizontal().getBlocks()[i][j] && !maze.getVertical().getBlocks()[i][j]) {
                    display += String.format("%1c"+"%1c",'_',' ');
               }
                else if(!maze.getHorizontal().getBlocks()[i][j] && maze.getVertical().getBlocks()[i][j]) {
                    display += String.format("%1c"+"%1c",' ','|');
                }
                else if(!maze.getHorizontal().getBlocks()[i][j] && !maze.getVertical().getBlocks()[i][j]) {
                    display += String.format("%1c"+"%1c",' ',' ');
                }
            }
            display += String.format("\n");
        }
        System.out.println(display);
    }
}
