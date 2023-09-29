package array_pr;

import java.util.Iterator;

public class ArrayPr {


	//largest number in array
	public static int largestNo(int[] arr) {
		// TODO Auto-generated method stub
		int lg=Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>=lg) {
				lg=arr[i];
			}
		}
		return lg;
	}


	//binary search   O(log n )
	public static int binarySearch(int[] arr,int key) {
		int start=0,end=arr.length-1;

		while(start<=end) {
			int mid=(start+end)/2;
			if(arr[mid]==key) {
				return mid;
			}
			if(arr[mid]<key) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		return -1;
	}

	//reverse an array
	public static void reverseArray(int[] arr) {
		int first=0,last=arr.length-1;

		while(first<last) {
			int temp=arr[first];
			arr[first]=arr[last];
			arr[last]=temp;
			first++;
			last--;
		}
	}

	//possible pairs in an array
	public static void printPairs(int arr[]) {
		int tp=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				System.out.print("("+arr[i]+","+arr[j]+")");
				tp++;
			}
			System.out.println();
		}
		System.out.println("Total pairs "+tp); //or formula to calculate total pairs in an array is tp=n*(n-1)/2
		System.out.println("Total pairs "+arr.length*(arr.length-1)/2);
	}

	//print subArray O(n^3)
	public static void subArrays(int []arr) {
		int ts=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {

				for (int j2 = i; j2 <=j ; j2++) {
					System.out.print(arr[j2]+" ");//subarray printed
				}
				ts++;
				System.out.println();
			}
			System.out.println();
		} 
		System.out.println("Total subarrays :"+ts);
	}


	//print max sum of subarray of given array  O(n^3)
	public static void maxsubArraySum(int []arr) {
		int currSum=0,maxSum=Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				currSum=0;
				for (int j2 = i; j2 <=j ; j2++) {
					//subarray sum
					currSum+=arr[j2];
				}
				System.out.println(currSum);
				if(maxSum<currSum) {
					maxSum=currSum;
				}
			}
		} 
		System.out.println("Max Sum "+maxSum);
	}//this is brute force approach. The optimized approach is Prefix Array method	
	//prefix[end]-prefix[start-1]
	//To calculate prefix array: prefix[i-1]+arr[i]
	public static void maxSubArraySum1(int []arr) {  // O(n^2)
		int currSum=0;
		int maxSum=Integer.MIN_VALUE;
		int prefix[]=new int[arr.length];

		prefix[0]=arr[0];
		//calculate prefix
		for (int i = 1; i < prefix.length; i++) {
			prefix[i]=prefix[i-1]+arr[i];
		}

		for (int i = 0; i < arr.length; i++) {
			int start=i;
			for (int j = i; j < arr.length; j++) {
				int end=j;
				currSum= start==0 ? prefix[end] : prefix[end]-prefix[start-1];
				if(maxSum<currSum) {
					maxSum=currSum;
				}
			}
		} 
		System.out.println("Max Sum "+maxSum);
	}

	//VVVIMP
	//kadane's algorithm to find maximum sum of a sub array in more optimized way than the prefix array.
	public static void kadanes(int arr[]) {	//O(n)
		int ms=Integer.MIN_VALUE;	//maximum sum
		int cs=0;	//current sum

		for (int i = 0; i < arr.length; i++) {
			cs=cs+arr[i];
			if(cs<0) {
				cs=0;
			}
			ms=Math.max(cs,ms);
		}
		System.out.println("maximum subarray sum is "+ms);
	}



	//Trapping Rainwater	O(n)
	public static int trappedRainwater(int height[]) {
		//calculate left max boundry
		int leftMax[]=new int[height.length];
		leftMax[0]= height[0];
		for (int i = 1; i < height.length; i++) {
			leftMax[i]=Math.max(height[i], leftMax[i-1]);
		}
		//calculate rigth max boundry
		int rightMax[]=new int[height.length];
		rightMax[height.length-1]= height[height.length-1];
		for(int i=height.length-2;i>=0;i--) {
			rightMax[i]=Math.max(height[i], rightMax[i+1]);
		}
		int trappedWater=0;
		//loop
		for(int i=0;i<height.length;i++) {
			//waterlevel=min(leftmax boun,rightmax bound)
			int waterlevel=Math.min(leftMax[i],rightMax[i]);
			//trapped water=waterlevel-height[i]
			trappedWater+=waterlevel-height[i];
		}
		return trappedWater;	
	}


	//Buy and Sell stocks
	//You are given an array prices where prices[i] is the price of a given stock on the ith day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
	public static int buyAndSellStocks(int prices[]) {
		int buyPrice=Integer.MAX_VALUE;
		int maxProfit=0;
		for (int i = 0; i < prices.length; i++) {
			if(buyPrice < prices[i]) {//profit
				int profit=prices[i]-buyPrice;
				maxProfit=Math.max(maxProfit, profit);
			}else {
				buyPrice=prices[i];
			}
		}
		return maxProfit;
	}


	public static void main(String[] args) {


		//		int arr[]= {1,2,6,-1,3};
		//
		//		subArrays(arr);
		//		maxSubArraySum1(arr);
		//		kadanes(arr);
		//		
		//		int height[]= {4,2,0,6,3,2,5};
		//		System.out.println(trappedRainwater(height));

		int prices[]= {7,1,5,3,6,4};
		System.out.println(buyAndSellStocks(prices));

	}
}
