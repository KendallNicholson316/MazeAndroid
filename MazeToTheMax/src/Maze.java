/*
* This class
* */
//TODO create solvable boolean that checks is the maze is solvable (YAY)

public class Maze {
    private Graph maze;
    private int bound;

    public Maze(int bound){
        this.bound = bound;
        maze = new Graph(bound);
        spit();
    }

    public void spit(){
        for (int i = 0; i < maze.getEdges().size(); i++) {
            System.out.println("start:" + maze.getEdges().get(i).getStart());
            System.out.println("end:" + maze.getEdges().get(i).getEnd());
            System.out.println("weight:" + maze.getEdges().get(i).getWeight());
        }
    }

//    public boolean solvable(){}

    public void displayMaze(){
        String display = "";
        for(int b = 0; b<bound; b++) {
            for (int p = 0; p < bound; p++) {
                System.out.print(maze.getHorizontal().getBlocks()[b][p]);
            }
            System.out.println();
        }
        System.out.println();
        for(int b = 0; b<bound; b++){
            for (int p = 0; p < bound; p++) {
                System.out.print(maze.getVertical().getBlocks()[b][p]);
            }
            System.out.println();
        }

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
