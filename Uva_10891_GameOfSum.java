
import java.util.HashMap;
import java.util.Scanner;


class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		
		while(in.hasNextInt()){
			int n = in.nextInt();
			if(n==0)
				break;
			long[] arr = new long[n];
			long[] sum = new long[n];
			HashMap<String, Long> dpMap = new HashMap<String, Long>();
		
			for(int i=0; i<n; i++)
				arr[i] = in.nextLong();
			
			sum[0] = arr[0];
			
			for(int i=1; i<n; i++)
				sum[i] = sum[i-1]+arr[i];
			System.out.println(best(dpMap, arr, sum, 0, n-1));
		}
		
	}
	
	static long best(HashMap<String, Long> dpMap, long[] arr, long[] sum, int a, int b){
		
		if(dpMap.containsKey(a+","+b))
			return dpMap.get(a+","+b);
		
		if(b<a)
			return 0;
		
		
		long max = Long.MIN_VALUE;
		
		
		
		for(int k=0; k<=b-a; k++){
			long temp = Math.max(sum(sum, a, a+k)-best(dpMap, arr, sum, a+k+1, b), sum(sum, b-k, b)-best(dpMap, arr, sum, a, b-k-1));
			if(temp>max)
				max = temp;
		}
		dpMap.put(a+","+b, max);
		
		return max;
		
	}
	
	static long sum(long[] sum, int from, int to){
		if(from==0)
			return sum[to];
		return sum[to]-sum[from-1];
	}
}
