package ArayList;

import java.util.ArrayList;

public class FindAnyPairInRotatedArrayHasTagretSum {

	
	
	//bruteforce
//	public static boolean pairSum2(ArrayList<Integer> list, int target) {
//		
//		
//		for(int i=0;i<list.size();i++) {
//			for(int j=i+1;j<list.size();j++) {
//				if(list.get(i)+list.get(j)==target) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
	
	
	
	//2pointer apporach
	public static boolean pairSum2(ArrayList<Integer> list,int target) {
		int bp=-1;
		int n=list.size();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)>list.get(i+1)) {//breaking point
				bp=i;
				break;
			}
		}
		
		int lp=bp+1;//smallest index
		int rp=bp;//largest index
				
		while(lp!=rp) {
			//case1
			if(list.get(lp)+list.get(rp)==target) {
				return true;
			}
			//case2
			if(list.get(lp)+list.get(rp)< target) {
				lp=(lp+1)%n;
			}else {
				rp=(n+rp-1)%n;
			}
		}
		
		return false;
		
	}
		 
	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<>();
		list.add(11);
		list.add(15);
		list.add(6);
		list.add(8);
		list.add(9);
		list.add(10);
		
		int target=16;
		System.out.println(pairSum2(list,target));

	}
}
