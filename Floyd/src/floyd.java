import java.util.*;

public class floyd {
	

	int D[][];
	int W[][];
	int P[][];

	
	floyd(int n) {
		int i, j;
		Scanner scanner = new Scanner(System.in);
		
		// 받은 vertex의 개수만큼 배열을 생성한다.
		D = new int[n][n]; // D는 최단거리를 저장하는 변수
		W = new int[n][n]; // W는 가중치변수
		P = new int[n][n]; // P는 이동간 거쳐가는 곳을 알려주기 위해 있는 변수
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++) {
				System.out.println("vertex" + (i+1) + " 에서 vertex" + (j+1)  + "로 가는 경로의 가중치를 입력해주세요: ");
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

	// 최단 경로의 길이와 그 경로를 가는 동안 거쳐가는 종점을 구하는 함수
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

	// i에서j로 가기위해 거쳐가는 노드
	public void path(int i, int j) {
		if (P[i][j] != 0) {
		
			path(i, P[i][j]);
			System.out.print((P[i][j]+1) + "node->");
			path(P[i][j], j);
		}
	}

	public static void main(String[] args) {
		int n; // 정점의 개수를 받는 변수
		int[][] temp; // D변수 입시저장
		int from, to; // 출발지와 도착지 설정
		floyd ff;
		System.out.println("vertex 개수를 입력하세요");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		ff = new floyd(n);

		ff.floyding(n, ff.getW(), ff.getD(), ff.getP());

		temp = new int[n][n];
		temp= ff.getD();

		System.out.println("출발점과 도착점을 적어주세요");
		from = scanner.nextInt();
		to = scanner.nextInt();

		System.out.println("최단 경로 : " + temp[from-1][to-1]);

		System.out.print(from + "node->");
		ff.path(from-1 , to-1 );
		System.out.println(to + "node");

	}
}