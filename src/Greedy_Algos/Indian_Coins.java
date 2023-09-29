package Greedy_Algos;

import java.util.*;
import java.util.Comparator;

/*
Indian Coins
We are given an infinite supply of denominations [1, 2, 5, 10, 20, 50, 100, 500, 20001.
Find min no. of coins/notes to make change for a value V.
V = 121
ans = 3 (100+20+1)
V = 590
ans = 4 (500+50+20+20)

*/

 
public class Indian_Coins {
	public static void main(String[] args) {
		Integer coins[]= {1,2,5,10,20,50,100,500,2000};
		
		Arrays.sort(coins,Comparator.reverseOrder());
		int counOftCoins=0;
		int amt=1059;
		ArrayList<Integer> ans=new ArrayList<>();
		
		for (int i = 0; i < coins.length; i++) {
			if(coins[i]<=amt) {
				while(coins[i]<=amt) {
					counOftCoins++;
					ans.add(coins[i]);
					amt-=coins[i];
				}
			}
		}
		System.out.println("Total no of coins used ="+counOftCoins);
		
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i)+" ");
		}
		System.out.println();
	}
}
