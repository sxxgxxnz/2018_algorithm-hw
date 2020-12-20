package trees;
 
import java.util.*;


public class Tree{

	static void tree(int n, float p[]) {
		
		float q;
		float A[][]=new float [n+2][n+1];   //�ּҰ� ���
		int R[][]=new int[n+2][n+1];      	//k���� ���� ���

		//diagonal=0�϶�
		for(int i=1; i<=n; i++) {
			A[i][i]=p[i]; R[i][i]=i;
		}

		//diagonal 1~n-1����
		for(int l=1; l<=n-1; l++) {   //l�� diagonal�̴�.
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

		System.out.println("\n�ּڰ�="+A[1][n]);
		//A���, R��� ���
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
		System.out.println("��� ������ �Է�:");
		int n=scanner.nextInt();
		float p[]= new float[n+1];   //��� Ȯ����
		float sum_p=0;				// Ȯ���� ����... ���߿� ������ 1�� �ѱ�°͵� ����ó�� �ؾ��Ѵ�.
		
		for(int i=1;i<n;i++) {
			System.out.println("p"+(i)+">>");
			p[i]=scanner.nextFloat();
			sum_p +=p[i];
		}
		
		p[n] = 1 - sum_p;	// ������ p[n]�� ���ݱ��� 1���� Ȯ���� ���� ���� ��Ÿ�������Ѵ�. 
		System.out.println("p"+n+">>\n"+p[n]);

		Tree.tree(n, p);

		scanner.close();
	}
	//--------------------------------------
}
