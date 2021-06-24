import java.util.Comparator;

public class EndIntervalComparator implements Comparator<Interval> {

    public int compare(Interval i1, Interval i2){
        return Integer.compare(i1.getEnd(),i2.getEnd());
    }
}
