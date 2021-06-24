public class Interval {

    //open integer interval (do not include the start/end points)
    private int start;
    private int end;

    public Interval(int start, int end){
        if(start >= end)
            throw new IllegalArgumentException();
        this.start = start;
        this.end= end;
    }

    public int getStart(){
        return start;
    }

    public int getEnd(){
        return end;
    }

    public int length(){
        return end - start;
    }

    public boolean intersects(Interval other){
        return(end > other.start || other.end > start);
    }

    public String toString(){
        return "[" + start + ", " + end + "]";
    }

    public boolean equals(Object other){
        if(!(other instanceof Interval))
            return false;
        return (start == ((Interval) other).start && end == ((Interval) other).start);
    }
}
