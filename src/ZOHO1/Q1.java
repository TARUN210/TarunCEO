package ZOHO1;
import java.util.*;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 5;// 1 2 3 4 6 OP: 1 2 4 -1
		// 4 2 7 1 OP: 4 2 1 -1
		int[] arr = {3, 3, 2, 4, 5};
//		int[] arr = new int[n];
//		System.out.println("Enter array elements: ");
//		for(int i:arr) {
//			i=sc.nextInt();
//		}
		
		LinkedList<Integer> list = new LinkedList<>();
		List<Integer> ans = new LinkedList<>();
		
		ans.add(arr[0]);
		
		int prev = arr[0];
		
		
		
		for(int i=1;i<n;i++) {
			list.add(arr[i]);
		}
		int j=0;
		int size = list.size();
		int s1 = list.size();
		for(int i=0;i<s1-1;i++) {
			int temp = prev;
			j=0;
			while(j<size) {
				if(list.get(j)%prev==0 ) {
					prev=list.get(j);
					int idx = list.indexOf(list.get(j));
					ans.add(list.get(j));
					list.remove(idx);
					size--;
					break;
				}
				j++;
			}
			if(j==size) {
				ans.add(-1);
//				int idx = list.indexOf(list.get(0));
				prev = list.get(0);
				list.remove(0);
				size--;
			}
		}
		System.out.println(ans);
	}

}
