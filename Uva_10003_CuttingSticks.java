import java.util.Scanner;


class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int l = in.nextInt();
		while(l>0){
			int n = in.nextInt();
			int[] cuts = new int[n+2];
			int[][] cost = new int[n+2][n+2];
			for(int i=0; i<n+2; i++){
				for(int j=0; j<n+2; j++)
					cost[i][j] = -1;
			}
			for(int i=1; i<=n; i++)
				cuts[i] = in.nextInt();
			cuts[n+1] = l;
			System.out.println("The minimum cutting is "+cost(cost, cuts, 0, cuts.length-1)+".");
			l = in.nextInt();
		}
		in.close();
		
		
		
	}
	
	public static int cost(int[][] cost, int[] cuts, int a, int b){
		if(a+1 >= b)
			return 0;
		if(cost[a][b]!=-1)
			return cost[a][b];
		
		int min = Integer.MAX_VALUE;
		for(int i=a+1; i<=b-1; i++){
			int temp = cost(cost, cuts, a, i)+cost(cost, cuts, i, b);
			if(temp<min)
				min = temp;
		}
		min += cuts[b]-cuts[a];
		cost[a][b] = min;
		return min;
	}
	
	
}
