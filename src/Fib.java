public class Fib {

    public static int fib(int n){
        int [] table = new int [n+1];
        for(int i = 0;i<n+1;i++){
            table[i] = -1;
        }
        return fib(table, n);
    }

    private static int fib(int[] table, int n){
        if(n==0 || n==1)
            return n;
        if(table[n] == -1) //if fib(i) is not computed
            table[n] = fib(table,n-1) + fib(table, n-2);

        return table[n];
    }
}
