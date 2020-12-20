import java.util.*;
import java.lang.*;

class Edge{
	int vertex1,vertex2;

	public Edge(int vertex1,int vertex2) {
		this.vertex1=vertex1;
		this.vertex2=vertex2;
	}
}

public class Dijkstra {

	static Edge [] F;

	public static void main(String[] args) {
		int n=5;

		int length[]=new int[n+1];
		int touch[]=new int[n+1];

		int vnear=0;
		
		F = new Edge[6];
		
		//예제 데이터
		/*int W[][]=new int[][]{
		{0,0,0,0,0,0}
		,{0,0,7,4,6,1}
		,{0,999,0,999,999,999}
		,{0,999,2,0,5,999}
		,{0,999,3,999,0,999}
		,{0,999,999,999,1,0}};
*/
		
		//임의의 데이터
		int W[][]=new int[][] {
			{0,0,0,0,0,0},
			{0,0,5,6,7,1},
			{0,999,0,3,999,999},
			{0,999,999,0,999,999},
			{0,999,999,1,0,999},
			{0,999,4,999,2,0}};
		
		for(int i=2;i<=n;i++) {
			touch[i]=1;
			length[i]=W[1][i];
		}


		int tmp=1;
		while(tmp != n) {			
			int min=1000;
			for(int j=2;j<=n;j++) {
				if(0 <= length[j] && length[j] <= min) {
					min=length[j];
					vnear=j;
				}
			}
			//add e to F
			
			Edge e = new Edge(0,0);

			e.vertex1 = touch[vnear];
			e.vertex2 = vnear;
			 
			F[tmp] = e;
		
			for(int j=2;j<=n;j++) 
				if(length[vnear]+W[vnear][j]<length[j]) {
					length[j]=length[vnear]+W[vnear][j];
					touch[j]=vnear;
				}
			length[vnear]=-1;
			

			//print
		
			System.out.println("(V"+F[tmp].vertex1+", V"+F[tmp].vertex2+")");
			tmp++;
			
		}//repeat n-1

	}
}

