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
        System.out.println(numEdges);
    }

    public void setEdges() {
        Edge e = null;
        boolean block;
        int weight;
        System.out.println(vertices.length);
        System.out.println(Arrays.toString(vertices));
        for (int i = 0; i < vertices.length; i++) {
            if(i==0){//top left corner
                block = findBlock(i,i+1);
                weight = findWeight(i,i+1);
//                System.out.println(i);//used when checking output
//                System.out.println(i+1);
//                System.out.println(block);
                e = new Edge(i,i+1, block, weight);
                edges.add(e);
                block = findBlock(i,i+bound);
                weight = findWeight(i,i+bound);
                e = new Edge(i,i+bound, block, weight);
                edges.add(e);
            }
            else if(i==bound-1){//top right corner
                block = findBlock(i,i-1);
                weight = findWeight(i,i-1);
                e = new Edge(i,i-1, block, weight);
                edges.add(e);
                block = findBlock(i,i+bound);
                weight = findWeight(i,i+bound);
                e = new Edge(i,i+bound, block, weight);
                edges.add(e);
            }
            else if(i==bound*(bound-1)){//bottom left corner
                block = findBlock(i,i-bound);
                weight = findWeight(i,i-bound);
                e = new Edge(i,i-bound, block, weight);
                edges.add(e);
                block = findBlock(i,i+1);
                weight = findWeight(i,i+1);
                e = new Edge(i,i+1, block, weight);
                edges.add(e);
            }
            else if(i==(bound*bound)-1){//bottom right corner
                block = findBlock(i,i-bound);
                weight = findWeight(i,i-bound);
                e = new Edge(i,i-bound, block, weight);
                edges.add(e);
                block = findBlock(i,i-1);
                weight = findWeight(i,i-1);
                e = new Edge(i,i-1, block, weight);
                edges.add(e);
            }
            else if(i>0 && i < bound-1){//top side
                block = findBlock(i,i-1);
                weight = findWeight(i,i-1);
                e = new Edge(i,i-1, block, weight);
                edges.add(e);
                block = findBlock(i,i+1);
                weight = findWeight(i,i+1);
                e = new Edge(i,i+1, block, weight);
                edges.add(e);
                block = findBlock(i,i+bound);
                weight = findWeight(i,i+bound);
                e = new Edge(i,i+bound, block, weight);
                edges.add(e);
            }
            else if(i>bound*(bound-1) && i < (bound*bound)-1){//bottom side
                block = findBlock(i,i-1);
                weight = findWeight(i,i-1);
                e = new Edge(i,i-1, block, weight);
                edges.add(e);
                block = findBlock(i,i+1);
                weight = findWeight(i,i+1);
                e = new Edge(i,i+1, block, weight);
                edges.add(e);
                block = findBlock(i,i-bound);
                weight = findWeight(i,i-bound);
                e = new Edge(i,i-bound, block, weight);
                edges.add(e);
            }
            else if(i != 0 && i != bound*(bound-1) && i%bound == 0){//left side
                block = findBlock(i,i+1);
                weight = findWeight(i,i+1);
                e = new Edge(i,i+1, block, weight);
                edges.add(e);
                block = findBlock(i,i+bound);
                weight = findWeight(i,i+bound);
                e = new Edge(i,i+bound, block, weight);
                edges.add(e);
                block = findBlock(i,i-bound);
                weight = findWeight(i,i-bound);
                e = new Edge(i,i-bound, block, weight);
                edges.add(e);
            }
            else if(i != bound-1 && i != (bound*bound)-1 && i%bound == bound-1){//right side
                block = findBlock(i,i-1);
                weight = findWeight(i,i-1);
                e = new Edge(i,i-1, block, weight);
                edges.add(e);
                block = findBlock(i,i+bound);
                weight = findWeight(i,i+bound);
                e = new Edge(i,i+bound, block, weight);
                edges.add(e);
                block = findBlock(i,i-bound);
                weight = findWeight(i,i-bound);
                e = new Edge(i,i-bound, block, weight);
                edges.add(e);
            }
            else{// all the organs
                block = findBlock(i,i-1);
                weight = findWeight(i,i-1);
                e = new Edge(i,i-1, block, weight);
                edges.add(e);
                block = findBlock(i,i+1);
                weight = findWeight(i,i+1);
                e = new Edge(i,i+1, block, weight);
                edges.add(e);
                block = findBlock(i,i+bound);
                weight = findWeight(i,i+bound);
                e = new Edge(i,i+bound, block, weight);
                edges.add(e);
                block = findBlock(i,i-bound);
                weight = findWeight(i,i-bound);
                e = new Edge(i,i-bound, block, weight);
                edges.add(e);
            }
        }
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
