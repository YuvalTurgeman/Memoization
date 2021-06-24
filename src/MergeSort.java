public class MergeSort {

    public static int [] sort (int [] A){
        if(A == null)
            throw new IllegalArgumentException();
        //base case
        if(A.length<2)
            return A;

        //split
        int [] Al = splitLeft(A);
        int [] Ar = splitRight(A);

        //sort recursively
        Al = sort(Al);
        Ar = sort(Ar);

        //merge
        return merge(Al, Ar);
    }

    private static int [] splitLeft(int [] A ){
        int [] output = new int [A.length/2];
        for(int i=0;i< A.length/2;i++)
            output[i] = A[i];
        return output;
    }

    private static int [] splitRight(int [] A ){
        int [] output = new int [A.length - A.length/2];
        for(int i=A.length/2; i<A.length;i++)
            output[i- A.length/2] = A[i];
        return output;
    }

    private static int [] merge(int [] Al, int [] Ar){
        int ind = 0, i1 =0, i2 = 0;
        int lenL = Al.length, lenR = Ar.length;
        int [] output = new int[lenL + lenR];

        while(i1< lenL && i2 < lenR){
            if(Al[i1] < Ar[i2]){
                output[ind] = Al[i1];
                i1++;
            }
            else{
                output[ind] = Ar[i1];
                i2++;
            }
            ind++;
        }

        for(int i = i1; i<lenL; i++){
            output[ind] = Al[i];
            i++;
        }
        for(int i = i2; i<lenR; i++){
            output[ind] = Ar[i];
            i++;
        }

        return output;
    }
}
