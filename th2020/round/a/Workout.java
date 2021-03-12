package th2020.round.a;

import java.util.Scanner;

public class Workout {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            int cases = in.nextInt();
            for (int t = 1; t <= cases; t++) {
                int n = in.nextInt();
                int k = in.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = in.nextInt();
                }
                int s = difficulty(ar, n, k);
                System.out.println("Case #"+t+": "+s);
            }
        }
    }

    public static int difficulty(int[] ar,int n, int k){
        int maxDif = ar[n-1] - ar[0];
        int minDif = 1;
        while(minDif < maxDif){
            int midDif = (maxDif + minDif) /2;
            int tNeed = 0;
            for (int i = 1; i < n; i++) {
                int dif = ar[i] - ar[i-1];
                tNeed += (dif - 1)/midDif;
            }
            if(tNeed <= k){
                maxDif = midDif;
            }else{
                minDif = midDif+1;
            }
        }

        return minDif;
    }

}
