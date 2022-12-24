package ZOHO1;
import java.util.*;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("HWLLO");
		System.out.println("Enter a no.");
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		
		int r = 0;
		int c = n-1;
		
		int no = 1;
		
		for(int i=0;i<n;i++) {
			while(c>=i) {
				arr[r++][c--] = no++;
			}
			c = n-1;
			r = i+1;
		}
		
//		System.out.println(Arrays.deepToString(arr));
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==0) {
					System.out.print("\t");
				} else {
					System.out.print(arr[i][j]+"\t");
				}
			}System.out.println();
		}

	}

}
