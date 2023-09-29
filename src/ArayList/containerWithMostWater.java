package ArayList;
import java.util.ArrayList;
import java.util.Iterator;

public class containerWithMostWater {

	
	//2pointers approach	  
	public static int storeWater(ArrayList<Integer> height) {
	
		int maxwater=0;
		int left=0;
		int right=height.size()-1;
		while(left<right) {
			//calc water area
			int ht=Math.min(height.get(left), height.get(right));
			int width=right-left;
			int currwater=ht*width;
			maxwater=Math.max(maxwater, currwater);
			
			//update pointers
			if(height.get(left)<height.get(right)) {
				left++;
			}else {
				right--;
			}
			
		}
		
		return maxwater;
	}
	
	
	
	
	
//  bruite force
//	public static int storeWater(ArrayList<Integer> height) {
//		
//		int maxwater=0;
//		
//		for(int i=0;i<height.size();i++) {
//			for (int j = i+1; j < height.size(); j++) {
//				int ht= Math.min(height.get(i), height.get(j));
//				int width = j-i;
//				int currWater=ht*width;
//				maxwater=Math.max(maxwater, currWater);			}
//		}
//		
//		return maxwater;
//	}
	public static void main(String[] args) {
		ArrayList<Integer> height=new ArrayList<>();
		height.add(1);
		height.add(8);
		height.add(6);
		height.add(2);
		height.add(5);
		height.add(4);
		height.add(8);
		height.add(3);
		height.add(7);
		System.out.println(storeWater(height));
	}

}
