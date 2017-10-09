import java.util.ArrayList;

public class Graph {
    private int bound;
    private int[] vertices;
    private int numEdges;
    private ArrayList<Edge> edges;

    public Graph(int bound){
        this.bound = bound;
        vertices = setVertices();
        numEdges = setNumEdges();
        setEdges();
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

    public void setEdges() {
        Edge e = null;
        for (int i = 0; i < vertices.length; i++) {
            if(i==0){//top left corner
                e = new Edge(i,i+1);
                edges.add(e);
                e = new Edge(i,i+bound);
                edges.add(e);
            }
            else if(i==bound-1){//top right corner
                e = new Edge(i,i-1);
                edges.add(e);
                e = new Edge(i,i+bound);
                edges.add(e);
            }
            else if(i==bound*(bound-1)){//bottom left corner
                e = new Edge(i,i-bound);
                edges.add(e);
                e = new Edge(i,i+1);
                edges.add(e);
            }
            else if(i==(bound*bound)-1){//bottom right corner
                e = new Edge(i,i-bound);
                edges.add(e);
                e = new Edge(i,i-1);
                edges.add(e);
            }
            else if(i>0 && i < bound-1){//top side
                e = new Edge(i,i-1);
                edges.add(e);
                e = new Edge(i,i+1);
                edges.add(e);
                e = new Edge(i,i+bound);
                edges.add(e);
            }
            else if(i>bound*(bound-1) && i < (bound*bound)-1){//bottom side
                e = new Edge(i,i-1);
                edges.add(e);
                e = new Edge(i,i+1);
                edges.add(e);
                e = new Edge(i,i-bound);
                edges.add(e);
            }
            else if(i != 0 && i != bound*(bound-1) && i%bound == 0){//left side
                e = new Edge(i,i+1);
                edges.add(e);
                e = new Edge(i,i+bound);
                edges.add(e);
                e = new Edge(i,i-bound);
                edges.add(e);
            }
            else if(i != bound-1 && i != (bound*bound)-1 && i%bound == bound-1){//right side
                e = new Edge(i,i-1);
                edges.add(e);
                e = new Edge(i,i+bound);
                edges.add(e);
                e = new Edge(i,i-bound);
                edges.add(e);
            }
            else{// all the organs
                e = new Edge(i,i-1);
                edges.add(e);
                e = new Edge(i,i+1);
                edges.add(e);
                e = new Edge(i,i+bound);
                edges.add(e);
                e = new Edge(i,i-bound);
                edges.add(e);
            }
        }


    }

    public int[] setVertices(){
        int[] v = new int[bound*bound];
        for (int i = 0; i < bound; i++) {
            v[i] = i;
        }
        return v;
    }
}
