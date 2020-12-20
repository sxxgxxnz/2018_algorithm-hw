package trees;
 
import java.util.*;


public class Tree{

	static void tree(int n, float p[]) {
		
		float q;
		float A[][]=new float [n+2][n+1];   //최소값 결과
		int R[][]=new int[n+2][n+1];      	//k값에 대한 행렬

		//diagonal=0일때
		for(int i=1; i<=n; i++) {
			A[i][i]=p[i]; R[i][i]=i;
		}

		//diagonal 1~n-1까지
		for(int l=1; l<=n-1; l++) {   //l은 diagonal이다.
			for(int i=1; i<=n-l; i++) {
				int j=i+l;
				A[i][j]=Float.MAX_VALUE;
				for(int k=i;k<=j;k++) {
					
					q=((k>i)?A[i][k-1]:0)+((k<j)?A[k+1][j]:0)+sum(p,i,j);

					if(q<A[i][j]) {
						A[i][j]=q;
						R[i][j]=k;
					}
				}

			}
		}

		System.out.println("\n최솟값="+A[1][n]);
		//A행렬, R행렬 출력
		System.out.println("\nA=");
		for(int i=1;i<=n+1;i++) {
			for(int j=0;j<=n;j++) {
				if(i<=j+1)
					System.out.print(A[i][j]+"\t");
				else
					System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("R=");

		for(int i = 1; i<=n+1;i++) {
			for(int j=0; j<=n; j++) {
				if(i<=j+1)
					System.out.print(R[i][j]+" ");
			}
			System.out.println();
			for(int k=1; k<=i; k++)
				System.out.print("  ");
		}

	}
	//--------------------------------------

	static float sum(float p[],int i,int j) {
		
		float result=0;

		for(int m=i;m<=j;m++) 
			result+=p[m];
		
		return result;
	}
	//--------------------------------------

	public static void main(String args[]) {

		Scanner scanner=new Scanner(System.in);
		System.out.println("노드 개수를 입력:");
		int n=scanner.nextInt();
		float p[]= new float[n+1];   //노드 확률값
		float sum_p=0;				// 확률의 총합... 나중에 총합이 1을 넘기는것도 예외처리 해야한다.
		
		for(int i=1;i<n;i++) {
			System.out.println("p"+(i)+">>");
			p[i]=scanner.nextFloat();
			sum_p +=p[i];
		}
		
		p[n] = 1 - sum_p;	// 마지막 p[n]은 지금까지 1에서 확률의 합을 빼서 나타나져야한다. 
		System.out.println("p"+n+">>\n"+p[n]);

		Tree.tree(n, p);

		scanner.close();
	}
	//--------------------------------------
}
