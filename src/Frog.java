public class Frog {

    public static int frog(int n){
        return frogMemo(n,n);
    }

    public static int frogMemo(int row, int col){
        //frog has reached the top - right corner
        if(row==1 && col ==1)
            return 1;

        //frog got lost
        if(row<1 || col<1)
            return 0;

        //recursion step
        return frogMemo(row,col-1) + frogMemo(row,col-2)
                + frogMemo(row-1, col) + frogMemo(row-2, col);
    }

    public static int frogMemo(int n){
        //initialize memoization table
        int [][] memo = new int [n+1][n+1];
        for(int i=0;i<memo.length;i++)
            for(int j=0;j<memo[i].length;j++)
                memo[i][j] = -1;

        return frogMemo(n,n, memo);
    }

    public static int frogMemo(int row, int col, int [][] memo){
        //frog haws reached the top-right corner
        if(row == 1 && col == 1)
            return 1;
        //Frog got lost
        if(row < 1 || col < 1)
            return 0;

        //check if table contains the required result
        if(memo[row][col] == -1) {
            memo[row][col] = frogMemo(row, col - 1, memo) + frogMemo(row, col - 2, memo)
                    + frogMemo(row - 1, col, memo) + frogMemo(row - 2, col, memo);
            memo[col][row] = memo[row][col];
        }
        return memo[row][col];
    }


}
