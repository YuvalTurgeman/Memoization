import java.util.Arrays;
import java.util.Comparator;

public class MaxUse {

    public static int maxUse(Interval[] segments) {
        Comparator<Interval> endComparator = new EndIntervalComparator();

        //sort by end of interval
        Arrays.sort(segments, endComparator);

        //second parameter is index of las interval
        return maxUse(segments, segments.length-1);
    }

    private static int maxUse(Interval[] segments, int index){
        if(index < 0)
            return 0;
        int currentSegLen = segments[index].length();
        int prevIndex = firstNonIntersection (segments, index);
        int with = maxUse(segments, prevIndex) + currentSegLen;
        int without = maxUse(segments, index-1);
        return Math.max(with,without);
    }

    private static int firstNonIntersection(Interval[] segments, int i){
        Interval currentSeg = segments[i];
        i--;// skip the current segment
        while(i>=0 && currentSeg.intersects(segments[i]))
            i--;
        return i;
    }

    public static int maxUseMemo(Interval[] segments){
        //table[i] = maxUse of the first i+1 segments
        int[] memo = new int[segments.length];
        for(int i=0;i<memo.length;i++)
            memo[i] = -1;

        Comparator<Interval> endComparator = new EndIntervalComparator();
        //sort intervals by end point
        Arrays.sort(segments, endComparator);
        //find max usage for all the intervals in sorted array
        return maxUseMemo(memo, segments, segments.length-1);

    }

    private static int maxUseMemo(int[] memo, Interval[] segments,int index){
        if(index < 0)
            return 0;
        if(memo[index] == -1){
            int currentSegLen = segments[index].length();
            int prevIndex = firstNonIntersection (segments, index);
            int with = maxUse(segments, prevIndex) + currentSegLen;
            int without = maxUse(segments, index-1);
            memo[index] = Math.max(with,without);
        }
        return memo[index];
    }
}
