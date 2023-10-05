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

	//counting sort time complexity O(n+k) where k is range of elements
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

	//merge sort 	time com O(n logn) space com O(n)
	public static void mergeSort(int arr[],int si, int ei) {
		if(si>=ei) {//base case
			return;
		}
		int mid=si+(ei-si)/2;//mid find
		mergeSort(arr,si,mid);//left part
		mergeSort(arr,mid+1,ei);//right part
		merge(arr,si,mid,ei);
	}
	public static void merge(int arr[],int si,int mid,int ei) {
		//left(0,3)=4 right(4,6)=3  ->6-0+1
		int temp[]=new int[ei-si+1];
		int i=si;//iterator for left part
		int j=mid+1;//iterator for right part
		int k=0; //iterator for temp array
		while(i<=mid && j<=ei) {
			if(arr[i]<arr[j]) {
				temp[k]=arr[i];
				i++;
			}else {
				temp[k]=arr[j];
				j++;
			}
			k++;
		}
		// Copy the remaining elements from the left part (if any)
		while(i<=mid) {
			temp[k]=arr[i];
			i++;
			k++;
		}
		// Copy the remaining elements from the right part (if any)
		while(j<=ei) {
			temp[k]=arr[j];
			j++;
			k++;
		}

		// Copy temp back to the original arr starting at index si
		for (k = 0,i=si; k < temp.length; k++,i++) {
			arr[i]=temp[k];
		}
	}

	//Quick Sort time avg O(n logn) worst O(n^2) space O(1)
	public static void quickSort(int arr[],int si, int ei) {
		if(si>=ei) {//base condn
			return;
		}
		//last element
		int pIdx=partition(arr,si,ei);
		quickSort(arr,si,pIdx-1);//left
		quickSort(arr,pIdx+1,ei);//right
	}
	public static int partition(int arr[],int si, int ei) {
		int pivot=arr[ei];//last element
		int i=si-1;//to make place for elements smaller than pivot

		for(int j=si;j<ei;j++) {
			if(arr[j]<=pivot) {
				i++;
				//swap
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
		}
		//moving pivot to its right place and returning index of pivot
		i++;
		int temp=pivot;
		arr[ei]=arr[i];
		arr[i]=temp;
		return i;
	}



	//print array
	public static void printArr(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}


	public static void main(String[] args) {
		int arr[]= {4,1,2,3,2,5,7,3};
		//countingSort(arr);
		//mergeSort(arr,0,arr.length-1);
		quickSort(arr,0,arr.length-1);
		printArr(arr); 

	}

}

// import java.util.Arrays
// Arrays.sort(arr) O(n log n)<< O(n^n)
// Arrays.sort(arr,si,ei)
