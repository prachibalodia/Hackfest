import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverClass
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   int range[];
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       range = new Solution().findSmallestRange(arr, n, k);
	       System.out.println(range[0] + " " + range[1]);
	   }
	}
}
// } Driver Code Ends


class Node
{
		int data;
		int row;
		int nextCol;
		Node(int data,int row,int nextCol)
		{
			this.data=data;
			this.row=row;
			this.nextCol=nextCol;
		}
}
class Solution
{
	static int[] findSmallestRange(int[][] arr,int n,int k){
	PriorityQueue<Node> pq=new PriorityQueue<Node>(new Comparator<Node>() {
		public int compare(Node n1,Node n2){
			return n1.data-n2.data;
			}
	});
	int max=0;
	int range=(int)1e9;
	for(int i=0;i<k;i++){
		pq.add(new Node(arr[i][0], i, 1));
		max=Math.max(max, arr[i][0]);
	}
    int res[] = new int[2];
	int start=-1;
	int end=-1;
	while(true){
		Node n1=pq.poll();
		int min=n1.data;
		if(range>max-min+1){
			range=max-min+1;
			start=min;
			end=max;
		}
		int nextRow=n1.row;
		int nextColumn=n1.nextCol;
		if(n1.nextCol<n){
			pq.add(new Node(arr[nextRow][nextColumn], nextRow, nextColumn+1));
			max=Math.max(max, arr[nextRow][nextColumn]);
		}
		else{
			break;
	}
 }
    int rangee[] = {start,end};
    return rangee;
	
 }
}
