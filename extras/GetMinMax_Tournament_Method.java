// Arrays #2.

import java.io.*;

class Pair{
    int min;
    int max;
    Pair(){
        
    }
    Pair(int min, int max ){
        this.min = min;
        this.max = max;
    }
}
class GFG {
	public static void main (String[] args) {
		int[] arr = new int[]{-100,23,4,3,43,45,447,344,13,42,4,3,234,2,245,24 };
	    int n = arr.length;
	    Pair pair= getPair(arr,0,n-1);
	    System.out.println("Min -> "+ pair.min );
	    System.out.println("Max -> "+ pair.max );
	}
	
	public static Pair getPair(int[] arr, int low, int high){
	    if(high == low )
	        return new Pair(arr[high], arr[high]);
	    Pair p = new Pair();
	    if(high == low + 1){
	        p.min = Math.min(arr[high], arr[low]);
	        p.max = Math.max(arr[high], arr[low]);
	    }
	    int mid = (high + low)/2;
	    Pair mml = getPair(arr, low, mid);
	    Pair mmr = getPair(arr, mid+1, high);
	    
	    p.min = Math.min(mml.min, mmr.min);
	    p.max = Math.max(mmr.max, mml.max);
	    
	    return p;
	  
	}
}