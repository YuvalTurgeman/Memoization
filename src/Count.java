public class Count {

    public static int count(int [] weights, int n){
        return count(weights,n, weights.length -1);
    }

    private static int count(int [] weights, int n, int i){
        //if n is 0 then there is 1 solution (do not include any coin)
        if(n==0)
            return 1;
        //if n is less then 0 or there are no coins left, then no solution exists
        if(n<0 || i<0)
            return 0;
        //count is sum of solutions (1) excluding weights[i] (2) including weights[i]
        return count(weights, n, i-1) + count(weights,n - weights[i], i);

    }

    public static int countMemo(int []weights, int n){
        int [][] memo = new int [n+1][weights.length];
        for(int i=0;i<memo.length;i++)
            for(int j=0;j<memo[i].length;j++)
                memo[i][j] = -1;
        return countMemo(weights,n+1, weights.length-1, memo);
    }

    public static int countMemo(int []weights, int n, int i, int [][] memo){
        //if n is 0 then there is 1 solution (do not include any coin)
        if(n==0)
            return 1;
        //if n is less then 0 or there are no coins left, then no solution exists
        if(n<0 || i<0)
            return 0;

        //check if table contains the required  result
        if(memo[n][i] == -1){
            memo[n][i] = countMemo(weights,n-weights[i], i, memo) + countMemo(weights, n, i-1, memo);
        }
        return memo[n][i];
    }
}
