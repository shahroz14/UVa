import java.util.Arrays;
import java.util.Scanner;


class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int j=0; j<t; j++){
			
			int n = in.nextInt();
			int[] coins = new int[n];
			
			if(n==0){
				System.out.println("0");
				continue;
			}
				
			
			int totVal = 0;
			
			for(int i=0; i<n; i++){
				coins[i] = in.nextInt();
				totVal += coins[i];
			}
			Arrays.sort(coins);
			int midVal = totVal/2;
			
			int[][] dp = new int[n][midVal+1];
			
			for(int i=0; i<=midVal; i++)
				dp[0][i] = Math.min(Math.abs(coins[0]-i), i);
			
			for(int i=1; i<n; i++){
				for(int k=0; k<=midVal; k++){
					if(k-coins[i]<=0)
						dp[i][k] = Math.min(Math.abs(k-coins[i]), dp[i-1][k]);
					else
						dp[i][k] = Math.min(dp[i-1][k-coins[i]], dp[i-1][k]);
				}
			}
			
			
			int diff = dp[n-1][midVal];
				
			System.out.println(totVal-(2*(midVal-diff)));
			
			
			
		}
	}
}
