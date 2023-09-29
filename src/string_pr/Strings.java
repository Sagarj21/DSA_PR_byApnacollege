package string_pr;

import java.util.Iterator;

public class Strings {


	public static void printLetters(String name) {
		for (int i = 0; i < name.length(); i++) {
			System.out.println(name.charAt(i));
		}
	}

	//check if the string is palindrome or not  eg. racecar,noon,madam,1223221
	public static boolean isPalindrome(String str) {	//O(n)
		int f=0,l=str.length();
		for(int i=0;i<str.length()/2;i++) {
			if(str.charAt(i)!=(str.charAt(str.length()-1-i))) {
				//not a palindrome
				return false;
			}
		}
		return true;
	}


	//given a route containing 4 directions (E,W,N,S), find the shortest path to reach the destination.
	//"WNEENESENNN"
	public static float getShortestPath(String str) {	//O(n)
		int x=0,y=0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='E') {
				x++;
			}else if(str.charAt(i)=='W') {
				x--;
			}else if(str.charAt(i)=='N') {
				y++;
			}else {
				y--;
			}
		}
		return (float)Math.sqrt(x*x+y*y);//calculating shortest path by distance formula
	}


	public static String subString(String str,int si,int ei) {
		String substr="";
		for (int i = si; i < ei; i++) {
			substr+=str.charAt(i);
		}
		return substr;
	}


	//for a  given set of Strings, print the largest string , i.e. lexicographical string
	public static void largestStringBylexo(String str[]){	//O(x*n)
		String largest=str[0];
		for (int i = 1; i < str.length; i++) {
			if(largest.compareTo(str[i])<0) {
				largest=str[i];
			}
		}
		System.out.println(largest);
	} 

	//for a given string, convert each first letter of each word to uppercase.  eg. "hi i am sagar"==>"Hi I Am Sagar"
	public static String toUpperCase(String str) {
		StringBuilder sb=new StringBuilder("");

		Character ch=Character.toUpperCase(str.charAt(0));
		sb.append(ch);

		for (int i = 1; i < str.length(); i++) {
			if(str.charAt(i)==' ' && i<str.length()-1) {
				sb.append(str.charAt(i));
				i++;
				sb.append(Character.toUpperCase(str.charAt(i)));
			}else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}


	//string compression  eg. "aaabbcccdd" ==> "a3b2c3d2"
	public static String stringCompressor(String str) {	//O(n)
		StringBuilder sb=new StringBuilder("");

		for (int i = 0; i < str.length(); i++) {
			char ch=str.charAt(i);
			int count=1;
			while( i<str.length()-1 && ch==str.charAt(i+1)) {
				count++;
				i++;
			}
			sb.append(ch);
			if(count>1) {
				sb.append(count);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str="abc";
		System.out.println(stringCompressor(str));
		//String str="racecar";
		//String str= "hi i am sagar";
		//System.out.println(toUpperCase(str));
		//printLetters(name);
		//System.out.println(isPalindrome(str));
		//System.out.println("Shortest path "+getShortestPath(str));
		//System.out.println(subString(str,3,6));
		//		largestStringBylexo(str);
	}
}