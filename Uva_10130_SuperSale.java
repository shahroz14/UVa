import java.util.Scanner;


class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int k=0; k<t; k++){
			int n = in.nextInt();
			int[] p = new int[n];
			int[] w = new int[n];
			for(int i=0; i<n; i++){
				p[i] = in.nextInt();
				w[i] = in.nextInt();
			}
			int g = in.nextInt();
			//int[] mw = new int[g];
			int total = 0;
			int[][] dp = new int[n][31];
			
			for(int i=0; i<=30; i++){
				if(w[0]>i)
					dp[0][i] = 0;
				else
					dp[0][i] = p[0];
			}
			
			
			for(int i=1; i<n; i++){
				for(int j=0; j<=30; j++){
					if(w[i]>j)
						dp[i][j] = dp[i-1][j];
					else
						dp[i][j] = Math.max(dp[i-1][j], p[i]+dp[i-1][j-w[i]]);
				}
			}
			
			
			
			for(int a=0; a<g; a++){
				int mw = in.nextInt();
				total += dp[n-1][mw];
			}
			
			System.out.println(total);
		
		}
	}
}
