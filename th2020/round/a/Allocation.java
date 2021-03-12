package th2020.round.a;
import java.util.Arrays;
import java.util.Scanner;

public class Allocation {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            int cases = in.nextInt();
            for (int t = 1; t <= cases; t++) {
                int n = in.nextInt();
                int k = in.nextInt();
                int[] ar = new int[n];
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    ar[i] = in.nextInt();
                    sum += ar[i];
                }
                int s =solution(ar, n, k, sum);
                System.out.println("Case #"+t+": "+s);
            }
        }
    }

    public static int solution(int[] ar, int n, int k,int sum){
        Arrays.sort(ar);
        int i = n-1;
        while(sum > k && i >=0){
            sum -= ar[i];
            i--;
            n--;
        }
        return n;
    }

}
