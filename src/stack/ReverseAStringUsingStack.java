package stack;

import java.util.Stack;

public class ReverseAStringUsingStack {

	public static String reverseStringbyStack(String str) {
		Stack<Character> s=new Stack<>();
		int idx=0;
		while(idx<str.length()){
			s.push(str.charAt(idx));
			idx++;
		}
		StringBuilder result=new StringBuilder("");
		while(!s.isEmpty()) {
			char curr=s.pop();
			result.append(curr);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		String str="hello world";
		System.out.println(reverseStringbyStack(str));
	}
}
