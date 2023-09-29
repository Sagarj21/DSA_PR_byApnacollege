package Queue;
import java.util.*;
public class QueueByCollection {

	public static void main(String[] args) {
//		Queue<Integer> q=new LinkedList<>();
		Queue<Integer> q=new ArrayDeque<>();//Deque
		q.add(1);
		q.add(2);
		q.add(3);
		
		while(!q.isEmpty()) {
			System.out.println(q.peek());
			q.remove();
		}

	}

}
