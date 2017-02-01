
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long[][] dp = countWays();
		
		while(in.hasNextInt()){
			int n = in.nextInt();
			long ans = dp[4][n];
			
			if(ans==1)
				System.out.println("There is only 1 way to produce "+n+" cents change.");
			else
				System.out.println("There are "+ans+" ways to produce "+n+" cents change.");
		}
		
	}
	
	static long[][] countWays(){
		int[] coins = {1,5,10,25,50};
		long[][] dp = new long[5][30001];
		
		for(int j=0; j<=30000; j++)
			dp[0][j] = 1l;
		
		
		for(int i=1; i<5; i++){
			for(int j=0; j<=30000; j++){
				if(coins[i]>j){
					dp[i][j] = (long)dp[i-1][j];
				}
				else{
					dp[i][j] = (long)dp[i][j-coins[i]]+(long)dp[i-1][j];
				}
			}
		}
		
		return dp;
	}
}
