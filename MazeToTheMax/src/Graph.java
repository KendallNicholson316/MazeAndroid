/*
*
* */

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private int bound;
    private int[] vertices;
    private int numEdges;
    private Blocks horizontal;
    private Blocks vertical;
    private ArrayList<Edge> edges = new ArrayList<Edge>();

    public Graph(int bound){
        this.bound = bound;
        vertices = setVertices();
        setNumEdges();
        horizontal = new Blocks(bound,'h');
        vertical = new Blocks(bound,'v');
        setEdges();
    }

    //returns the lightest edge in a given list
    public int lightest(ArrayList<Edge> options){
        Edge lightest = options.get(0);
        int index = 0;
        for (int i = 1; i < options.size(); i++) {
            if(lightest.getWeight() > options.get(i).getWeight()){
                lightest = options.get(i);
                index = i;
            }
        }
        return index;
    }

    //returns the edges that are usable by a given vertex
    public ArrayList<Edge> getOptions(ArrayList<Edge> full, int vertex){
        ArrayList<Edge> options = new ArrayList<Edge>();
        for (int i = 0; i < full.size(); i++) {
            if(full.get(i).getStart() == vertex && !full.get(i).getBlock()){
                options.add(full.get(i));
            }
        }
        return options;
    }

    //returns all nonblocked edges
    public ArrayList<Edge> getValidEdges(){
        ArrayList<Edge> valid = this.edges;
        Edge temp = null;
        for (int i = valid.size()-1; i > 0; i--) {
            temp = valid.get(i);
            if(temp.getBlock()){
                valid.remove(temp);
            }
        }
        return valid;
    }

    //returns all the edges
    public ArrayList<Edge> getEdges(){
        return edges;
    }

    //Accesses either horizontal or vertical booleans to determine if path is blocked
    //true is blocked
    //false if not blocked
    public boolean findBlock(int s, int e){
        int smaller;//for finding proper index in the boolean arrays
        if(s < e){
            smaller = s;
        }
        else{
            smaller = e;
        }
        if(Math.abs(s-e)==1){
            return vertical.getBlocks()[smaller/bound][smaller%bound];
        }
        else{
            return horizontal.getBlocks()[smaller/bound][smaller%bound];
        }
    }

    public int findWeight(int s, int e){
        int smaller;//for finding proper index in the boolean arrays
        if(s < e){
            smaller = s;
        }
        else{
            smaller = e;
        }
        return (bound - (smaller/bound))*(bound-(smaller%bound));
    }

    public void setNumEdges(){
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
        //System.out.println(numEdges);
    }

    public void setEdges() {
      //  System.out.println(vertices.length);
        //System.out.println(Arrays.toString(vertices));
        for (int i = 0; i < vertices.length; i++) {
            if(i==0){//top left corner
                addEdge(i, i + 1);
                addEdge(i, i + bound);
            }
            else if(i==bound-1){//top right corner
                addEdge(i, i - 1);
                addEdge(i, i + bound);
            }
            else if(i==bound*(bound-1)){//bottom left corner
                addEdge(i, i + 1);
                addEdge(i, i - bound);
            }
            else if(i==(bound*bound)-1){//bottom right corner
                addEdge(i, i - 1);
                addEdge(i, i - bound);
            }
            else if(i>0 && i < bound-1){//top side
                addEdge(i, i + 1);
                addEdge(i, i + bound);
                addEdge(i, i - 1);
            }
            else if(i>bound*(bound-1) && i < (bound*bound)-1){//bottom side
                addEdge(i, i + 1);
                addEdge(i, i - bound);
                addEdge(i, i - 1);
            }
            else if(i != 0 && i != bound*(bound-1) && i%bound == 0){//left side
                addEdge(i, i + 1);
                addEdge(i, i + bound);
                addEdge(i, i - bound);
            }
            else if(i != bound-1 && i != (bound*bound)-1 && i%bound == bound-1){//right side
                addEdge(i, i + bound);
                addEdge(i, i - bound);
                addEdge(i, i - 1);
            }
            else{// all the organs
                addEdge(i, i + 1);
                addEdge(i, i + bound);
                addEdge(i, i - 1);
                addEdge(i, i - bound);
            }
        }
    }

    public void addEdge(int start, int end){
        Edge e = null;
        boolean block;
        int weight;
        block = findBlock(start,end);
        weight = findWeight(start,end);
        e = new Edge(start, end, block, weight);
        edges.add(e);
    }

    //creates array of vertices/ints
    //these are also the more broad maze locations i.e. for 2x2 vertices = [0,1,2,3]
    // and translates to:
    // [0,1]
    // [2,3]
    public int[] setVertices(){
        int[] v = new int[bound*bound];
        for (int i = 0; i < bound*bound; i++) {
            v[i] = i;
        }
        return v;
    }

    public Blocks getHorizontal() {
        return horizontal;
    }

    public Blocks getVertical() {
        return vertical;
    }
}
