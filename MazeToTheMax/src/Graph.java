import java.util.ArrayList;

public class Graph {
    private int bound;
    private int[] vertices;
    private int numEdges;
    ArrayList<Edges> edges;

    public Graph(int bound){
        this.bound = bound;
        vertices = setVertices();
        numEdges = setNumEdges();
        edges = setEdges();
    }

    public int setNumEdges(){
        numEdges = 0;
        if(bound >= 2){
            numEdges += 4 * 2;//for corners
            if(bound > 2){
                numEdges += 4 * 3 * (bound-2);//for sides
                for (int i = 0; i < bound-2; i++) {
                    numEdges += 4*4*(bound - 2);//for the organs
                }
            }
        }
        return numEdges;
    }

    public ArrayList<Edges> setEdges() {
        ;
    }

    public int[] setVertices(){
        int[] v = new int[bound*bound];
        for (int i = 0; i < bound; i++) {
            v[i] = i;
        }
        return v;
    }
}
