/*
* This class is used to store edge values
* start and end serve as endpoints
* weight serves to make paths/edges more of less desirable with smaller weights being more desirable
* block serves as the boolean determining whether or not an edge is a viable path
* */

public class Edge {
    private int start;
    private int end;
    private int weight;
    private boolean block;

    public Edge(int start, int end, boolean block, int weight){
        this.start = start;
        this.end = end;
        this.block = block;
        this.weight = weight;
    }

    public void setBlock(boolean block){ this.block = block;}


    public void setWeight(int weight){this.weight = weight; }
    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public boolean getBlock(){ return block;}


    public int getWeight(){ return weight;
    }
}
