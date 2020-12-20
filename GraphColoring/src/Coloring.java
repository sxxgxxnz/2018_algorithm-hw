import java.util.*;
import java.math.*;
import java.io.*;

public class Coloring{
	int n;
	int m;
	boolean W[][];
	int vcolor[];

	
	public void set(int n,boolean W[][],int vcolor[],int m) {
		this.n=n;
		this.W=W;
		this.vcolor=vcolor;
		this.m=m;
	}
	
	void m_coloring(int i,int vcolor[],boolean W[][],int n) {
		int color;
		if(promising(i,vcolor,W)) {
			if(i==n) {
				for(int j=1;j<=n;j++) {
					System.out.print(" "+vcolor[j]);
				}
				System.out.println(" ");
				
			}
			else {
				for(color=1;color<=m;color++) {
					vcolor[i+1]=color;
					m_coloring(i+1,vcolor,W,n);
				}
			}
	}
	}
	boolean promising(int i,int vcolor[],boolean W[][]) {
		int j;
		boolean a;
		a=true;
		j=1;
		while(j<i&&a) {
			if(W[i][j]&&vcolor[i]==vcolor[j]) {
				a= false;
			}
				j++;
		}
		return a;
	}
	
	public static void main(String[] args) {
		//예제데이터
		int n=4;
		int m=3;
		
		
		boolean W[][]=new boolean[][] {{false,false,false,false,false},{false,false,true,true,true}
		,{false,true,false,true,false}
		,{false,true,true,false,true}
		,{false,true,false,true,false}};
		
		
		//자작데이터
		/*
		int n=5;
		int m=3;
		boolean W[][]=new boolean[][] {
		{false,false,false,false,false,false}
		,{false,false,true,false,true,false}
		,{false,true,false,true,true,false}
		,{false,false,true,false,true,true}
		,{false,true,true,true,false,true}
		,{false,false,false,true,true,false}};
		*/
		int vcolor[]=new int[n+1];
		
		Coloring cc=new Coloring();
		cc.set(n, W, vcolor,m);
		cc.m_coloring(0,vcolor,W,n);
		
	}
}

