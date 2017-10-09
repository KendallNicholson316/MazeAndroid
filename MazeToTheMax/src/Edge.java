public class Edge {
    private int start;
    private int end;
    //add weight value

    public Edge(int s, int e){
        start = s;
        end = e;
    }


//    public void setWeight(int w){
//    }
    public void setStart(int s){
        start = s;
    }
    public void setEnd(int e){
        end = e;
    }
    public int getStart(){
        return start;
    }
    public int getEnd(){
        return end;
    }
}
