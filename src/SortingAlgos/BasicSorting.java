package SortingAlgos;

import java.util.Iterator;

public class BasicSorting {

	//bubble sort //O(n^2)
	public static void bubbleSort(int arr[]) { //O(n^2)
		boolean swapped;
		for(int turn=0;turn<arr.length-1;turn++) {
			swapped=false;
			for (int j = 0; j < arr.length-1-turn; j++) {
				//swap
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapped = true;
				} 
			}
			// If no two elements were swapped in inner loop, the array is already sorted
            if (!swapped) {
                break;
            } 
		}
	}
	
	//selection sort  //O(n^2)
	public static void selectionSort(int arr[]) {
		for (int i = 0; i < arr.length-1; i++) {
			int minPos=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[minPos]>arr[j]) {
					minPos=j;
				}
			}
			//swap
			int temp=arr[minPos];
			arr[minPos]=arr[i];
			arr[i]=temp;
		}
	}
	
	
	//insertion sort ://O(n^2)    pick an element and place in the right pos in sorted array
	public static void insertionSort(int arr[]) {
		
		for (int i = 1; i < arr.length; i++) {
			int curr=arr[i];
			int prev=i-1;
			//finding correct position to insert
			while(prev>=0 && arr[prev]> curr) {
				arr[prev+1]=arr[prev];
				prev--;
			}
			//insertion
			arr[prev+1]=curr;
		}
	}
	
	//counting sort
	public static void  countingSort(int arr[]) {
		int largest=Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			largest=Math.max(largest, arr[i]);
		}
		
		int count[]=new int[largest+1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		
		//sorting
		int j=0;
		for (int i = 0; i < count.length; i++) {
			while(count[i]>0) {
				arr[j]=i;
				j++;
				count[i]--;
			}
		}
	}
	
	
	
	//print array
	public static void printArr(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		int arr[]= {5,4,1,2,3,2,4,5,7,3};
		countingSort(arr);
		printArr(arr); 

	}

}

// import java.util.Arrays
// Arrays.sort(arr) O(n log n)<< O(n^n)
// Arrays.sort(arr,si,ei)
