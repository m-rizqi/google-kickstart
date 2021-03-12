package th2020.round.a;

import java.util.Scanner;

public class Plates {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            int cases = in.nextInt();
            for (int t = 1; t <= cases; t++) {
                int n = in.nextInt();
                int k = in.nextInt();
                int p = in.nextInt();
                int[][] ar = new int[n][k];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < k; j++) {
                        ar[i][j] = in.nextInt();
                    }
                }
                int s = maxBeauty(ar, n, k, p);
                System.out.println("Case #"+t+": "+s);
            }
        }
    }

    public static int maxBeauty(int[][] ar,int n, int k, int p){
        int[][] prefixSum = new int[n + 1][k + 1];
        int[][] lookup = new int[n + 1][p + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    prefixSum[i][j] = prefixSum[i][j - 1] + ar[i - 1][j - 1];
                }
            }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= p; j++) {
                lookup[i][j] = 0;
    
                for (int x = 0; x <= Math.min(j, k); x++) {
                    lookup[i][j] = Math.max(lookup[i][j], prefixSum[i][x] + lookup[i - 1][j - x]);
                }
            }
        }

     return lookup[n][p];
    }

}
