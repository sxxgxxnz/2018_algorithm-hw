package multiply;

import java.util.Scanner;


public class multi {


	public int [][] m_multiply(int[][] A, int [][] B){
		int n=A.length;
		int [][] Result = new int[n][n];

		if(n==1)
			Result[0][0]=A[0][0]*B[0][0];	                   
		else {
			int [][] A11=new int[n/2][n/2];
			int [][] A12=new int[n/2][n/2];
			int [][] A21=new int[n/2][n/2];
			int [][] A22=new int[n/2][n/2];
			//A를 A11, A12, A21, A22로 나눌 배열 선언
			int [][] B11=new int[n/2][n/2];
			int [][] B12=new int[n/2][n/2];
			int [][] B21=new int[n/2][n/2];
			int [][] B22=new int[n/2][n/2];
			//B를  B11, B12, B21, B22로 나눌 배열 선언
			div(A,A11,0,0);
			div(A,A12,0,n/2);
			div(A,A21,n/2,0);
			div(A,A22,n/2,n/2);
			
			div(B,B11,0,0);
			div(B,B12,0,n/2);
			div(B,B21,n/2,0);
			div(B,B22,n/2,n/2);
			//행렬 A,B를 나눠줌
			int[][] M1=m_multiply(add(A11,A22),add(B11,B22));
			int[][] M2=m_multiply(add(A21,A22),B11);
			int[][] M3=m_multiply(A11,sub(B12,B22));
			int[][] M4=m_multiply(A22,sub(B21,B11));
			int[][] M5=m_multiply(add(A11,A12),B22);
			int[][] M6=m_multiply(sub(A21,A11),add(B11,B12));
			int[][] M7=m_multiply(sub(A12,A22),add(B21,B22));

			int[][]C11=add(sub(add(M1,M4),M5),M7);
			int[][] C12=add(M3,M5);
			int[][]C21=add(M2,M4);
			int[][]C22=add(sub(add(M1,M3),M2),M6);

			union(C11,Result,0,0);
			union(C12,Result,0,n/2);
			union(C21,Result,n/2,0);
			union(C22,Result,n/2,n/2);

		}
		return Result;
	}
	public int[][] sub(int[][]A,int[][]B){
		int n=A.length;
		int[][]C=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				C[i][j]=A[i][j]-B[i][j];
		return C;
	}
	public int[][] add(int[][] A,int[][]B){
		int n=A.length;
		int[][] C=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				C[i][j]=A[i][j]+B[i][j];
		return C;
	}

		public void div(int[][] H,int[][] C,int iB, int jB) {
			
			for(int i1=0,i2=iB;i1<C.length;i1++,i2++) {
				for(int j1=0,j2=jB;j1<C.length;j1++,j2++) {
					C[i1][j1]=H[i2][j2];

				}
			}

		}
		public void union(int[][] C,int[][] H,int iB,int jB) {

			for(int i1=0,i2=iB;i1<C.length;i1++,i2++) {
				for(int j1=0,j2=jB;j1<C.length;j1++,j2++) {
					H[i2][j2]=C[i1][j1];
				}
			}


		}
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		multi m=new multi();
		System.out.println("곱셈할 행렬의 차수를 입력하세요: ");
		int N= scan.nextInt();

		System.out.println("n차 행렬1 입력하세요: \n");
		int[][] A= new int [N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				A[i][j]=scan.nextInt();

		System.out.println("n차 행렬2 입력하세요: \n");
		int[][] B=new int [N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				B[i][j]=scan.nextInt();

		int[][] C=m.m_multiply(A, B);
		
		System.out.println("\n헹렬1과 행렬2의 곱셈 결과 : ");
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				System.out.println(C[i][j] +" ");
			System.out.println();
		}
	}
}

