package Greedy_Algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Job Sequencing Problem
Given an array of jobs where every job has a deadline and profit if the job is finished
before the deadline. It is also given that every job takes a single unit of time, so the
minimum possible deadline for any job is 1. Maximize the total profit if only one job can
be scheduled at a time.
Job A = 4, 20
Job B = 1, 10
Job C = 1, 40
Job D = 1, 30
ans = C, A
*/


public class Job_Sequencing_Problem {
	static class Job{
		int id;//0 1  2 3
		int deadLine;
		int profit;
	
		public Job( int id,int deadLine, int profit) {
			this.id = id;
			this.deadLine = deadLine;
			this.profit = profit;
			
		}
		
	}
	
	public static void main(String[] args) {
		int jobsInfo[][]= {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
		
		ArrayList<Job> jobs=new ArrayList<>();

		for (int i = 0; i < jobsInfo.length; i++) {
			jobs.add(new  Job(i,jobsInfo[i][0],jobsInfo[i][1]));
		}
		
		Collections.sort(jobs,(a,b)->b.profit-a.profit);//descending order of profit
		
		ArrayList<Integer> seq=new ArrayList<>();
		int time=0;
		
		for (int i = 0; i < jobs.size(); i++) {
			Job curr=jobs.get(i);
			if(curr.deadLine>time) {
				seq.add(curr.id);
				time++;
			}
		}
		
		System.out.println("max jobs= "+seq.size());
		for (int i = 0; i < seq.size(); i++) {
			System.out.print(seq.get(i));
		}
		System.out.println();
	}
}
