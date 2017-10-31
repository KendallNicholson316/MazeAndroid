/*
* This class is used for generating the random booleans in the horizontal[][] and vertical[][]
* thus their values determine if a path or edge is blocked off or usable
* */
import java.util.Random;

public class Blocks {
    private boolean[][] blocks;
    private Random r = new Random();
    private char type;
    private int bound;

    public Blocks(int bound, char type){
        blocks = new boolean[bound][bound];
        this.bound = bound;
        this.type = type;
        setBlocks();
    }

    public boolean[][] getBlocks() {
        return blocks;
    }

    public void setBlocks(){
        if(type == 'h') {
            //generates random horizontals for all except always true for bottom
            for (int i = 0; i < bound; i++) {
                for (int j = 0; j < bound; j++) {
                    if (i == bound - 1) {
                        blocks[i][j] = true;
                    } else {
                        blocks[i][j] = r.nextBoolean();
                    }

                }
            }
        }

        else if(type == 'v') {
            //generates random verticals except always true for end
            for (int i = 0; i < bound; i++) {
                for (int j = 0; j < bound; j++) {
                    if (j == bound - 1) {
                        blocks[i][j] = true;
                    } else {
                        blocks[i][j] = r.nextBoolean();
                    }
                }
            }
        }
    }
}
