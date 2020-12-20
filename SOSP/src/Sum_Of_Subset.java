public class Sum_Of_Subset {

	int n;
	int w[];
	int sum;
	int include[];
	int total;

	public void set(int n, int w[], int sum, int include[], int total) {

		this.n = n;
		this.w = w;
		this.sum = sum;
		this.include = include;
		this.total = total;
	}

	public void sum_of_subsets(int i, int weight, int total) {
		if (promising(i, weight, total)) {
			if (weight == sum) {
				for (int k = 1; k <= i; k++)
					System.out.print(" " + include[k]);
			} else {
				include[i + 1] = 1;
				sum_of_subsets(i + 1, weight + w[i + 1], total - w[i + 1]);
				include[i + 1] = 0;
				sum_of_subsets(i + 1, weight, total - w[i + 1]);
			}
		}

	}

	boolean promising(int i, int weight, int total) {

		return (weight + total >= sum) && (weight == sum || weight + w[i + 1]<=sum);
	}

	public static void main(String[] args) {
		int n = 4;
		//자작 입력데이터
		int total = 21;
		int w[] = new int[] { 0, 3, 5, 6, 7 };
		int include[] = new int[n + 1];

		Sum_Of_Subset ss = new Sum_Of_Subset();
		ss.set(n, w, 16, include, 21);
		ss.sum_of_subsets(0, 0, total);
	}
}