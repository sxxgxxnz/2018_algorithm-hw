import java.util.*;

public class floyd {
	

	int D[][];
	int W[][];
	int P[][];

	
	floyd(int n) {
		int i, j;
		Scanner scanner = new Scanner(System.in);
		
		// ���� vertex�� ������ŭ �迭�� �����Ѵ�.
		D = new int[n][n]; // D�� �ִܰŸ��� �����ϴ� ����
		W = new int[n][n]; // W�� ����ġ����
		P = new int[n][n]; // P�� �̵��� ���İ��� ���� �˷��ֱ� ���� �ִ� ����
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++) {
				System.out.println("vertex" + (i+1) + " ���� vertex" + (j+1)  + "�� ���� ����� ����ġ�� �Է����ּ���: ");
				W[i][j] = scanner.nextInt();
				P[i][j] = 0;
			}
		D = W;
	}

	// getter
	public int[][] getD() {
		return D;
	}

	public int[][] getW() {
		return W;
	}

	public int[][] getP() {
		return P;
	}

	// �ִ� ����� ���̿� �� ��θ� ���� ���� ���İ��� ������ ���ϴ� �Լ�
	public void floyding(int n, int[][] W, int[][] D, int[][] P) {
		int i, j, k;
		for (k = 0; k < n; k++)
			for (i = 0; i < n; i++)
				for (j = 0; j < n; j++)
					if (D[i][k] + D[k][j] < D[i][j]) {
						
						D[i][j] = D[i][k] + D[k][j];
						P[i][j] = k;
						
					}
		
	}

	// i����j�� �������� ���İ��� ���
	public void path(int i, int j) {
		if (P[i][j] != 0) {
		
			path(i, P[i][j]);
			System.out.print((P[i][j]+1) + "node->");
			path(P[i][j], j);
		}
	}

	public static void main(String[] args) {
		int n; // ������ ������ �޴� ����
		int[][] temp; // D���� �Խ�����
		int from, to; // ������� ������ ����
		floyd ff;
		System.out.println("vertex ������ �Է��ϼ���");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		ff = new floyd(n);

		ff.floyding(n, ff.getW(), ff.getD(), ff.getP());

		temp = new int[n][n];
		temp= ff.getD();

		System.out.println("������� �������� �����ּ���");
		from = scanner.nextInt();
		to = scanner.nextInt();

		System.out.println("�ִ� ��� : " + temp[from-1][to-1]);

		System.out.print(from + "node->");
		ff.path(from-1 , to-1 );
		System.out.println(to + "node");

	}
}