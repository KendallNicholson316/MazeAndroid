import java.util.Random;

public class Maze {
    private boolean[][] horizontal;
    private boolean[][] vertical;
    private Random r = new Random();
    private int bound;


    public Maze(int a){
        bound = a;
        generateMaze();
    }

    public void generateMaze(){
        horizontal = new boolean[bound][bound];
        for(int i = 0; i<bound; i++){
            for(int j =0; j<bound; j++){
                horizontal[i][j] =r.nextBoolean();

            }
        }
        horizontal[0][0] = true;
        horizontal[bound-1][bound-1]=true;

        vertical = new boolean[bound][bound];
        for(int i = 0; i<bound; i++){
            for(int j =0; j<bound; j++){
                vertical[i][j] =r.nextBoolean();
            }
        }
        vertical[0][0] = false;
        vertical[bound-1][bound-1]=false;
    }

    public void displayMaze(){
        for(int i = 0; i<bound; i++){
            for(int j =0; j<bound; j++){
                if(vertical[i][j]==true) {
                    System.out.print("|");
                }
                else if(horizontal[i][j]==false) {
                    System.out.print(" ");
                }
                if(horizontal[i][j]==true) {
                    System.out.print("_");
                }
                else if(horizontal[i][j]==false) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
