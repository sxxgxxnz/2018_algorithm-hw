import java.io.*;
import java.util.Arrays;

public class Hamiltonian {
	boolean W[][];
	
	int n;
	int vindex[];

	void set(int n, boolean W[][], int vindex[]) {
		this.n = n;
		this.W = W;
		this.vindex = vindex;
	}

	void hamiltonian(int i, int vindex[], boolean W[][],int n) {
		int j;

		if (promising(i, vindex, W)) {
			if (i == n - 1) {
				
				for (j = 1; j <= n-1; j++) {
					System.out.print("  " + vindex[j]);
				}
				System.out.println(" ");
				
			} else {
				for (j = 2; j <= n; j++) {
					vindex[i + 1] = j;	//
					hamiltonian(i + 1, vindex, W,n);
				}
				
			}

		}
	}

	boolean promising(int i, int vindex[], boolean W[][]) {
		int j;
		boolean a;

		if (i == n - 1 && !W[vindex[n - 1]][vindex[0]]) {
			a = false;

		} else if (i > 0 && !W[vindex[i - 1]][vindex[i]]) {
			a = false;
		} else {
			a = true;
			j = 1;
			while (j < i && a) {
				if (vindex[i] == vindex[j]) {
					a = false;
					
				}
				j++;
			}

		}
		return a;
	}

	public static void main(String[] args) {
		int n = 5;
		int vindex[] = new int[n + 1];
		vindex[0] = 1;

		boolean W[][] = new boolean[][] { 
				{ false, false, false, false, false, false },
				{ false, false, true, false, true, false },
				{ false, true, false, true, true, false },
				{ false, false, true, false, true, true }, 
				{ false, true, true, true, false, true },
				{ false, false, false, true, true, false } };

		
		Hamiltonian hh = new Hamiltonian();
		hh.set(5, W, vindex);
		hh.hamiltonian(0, vindex, W,5);
	}
}
