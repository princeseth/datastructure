import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class RatMaze {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					a[i][j]=sc.nextInt();
			RatMaze g=new RatMaze();
			ArrayList<String> res=g.printPath(a,n);
			for(int i=0;i<res.size();i++)
				System.out.print(res.get(i)+" ");
			System.out.println();
		}
	}

	public static ArrayList<String> printPath(int[][] m, int n) {
		Set<String> set = new TreeSet<String>(); //Here, tree set is used to maintain the order.
		traverse(m, 0, 0, n, set, "");
		ArrayList<String> al = new ArrayList<String>(set);
		return al;
	}

	static void traverse(int m[][], int i, int j, int n, Set<String> set,
			String str) {
		if (i < 0 || j < 0 || i == n || j == n)
			return;
		if (i == n - 1 && j == n - 1) {
			set.add(str);
			return;
		}
		if (m[i][j] == 1) {
			m[i][j] = 5;
			traverse(m, i - 1, j, n, set, str + "U");
			traverse(m, i + 1, j, n, set, str + "D");
			traverse(m, i, j - 1, n, set, str + "L");
			traverse(m, i, j + 1, n, set, str + "R");
			m[i][j] = 1;
		}
	}
}

