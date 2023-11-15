import java.io.*;

public class Main {
  /*
		2차원 배열이 아닌 1차원 배열로 받는 이유
		한 열에는 최대 1개의 퀸만 놓을 수 있음
		index=열, 값=행 으로 생각하면 1차원 배열로 받을 수 있음
		ex) 4X4일 경우, [2,0,3,1] -> 1열에 3행, 2열에 1행, 3열에 4행, 4열에 2행에 queen을 배치한다는 의미
	 */
	static int[] queen;
	static int N;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		br.close();

		queen = new int[N];

		nQueen(0);
		System.out.println(count);
	}

	static void nQueen(int depth) {
    //행을 다 채우면 카운트를 1하고 리턴 시킴
		if (depth==N) {
			count++;
			return;
		}

		for (int i=0; i<N; i++) {
			queen[depth] = i;

			if (is_able(depth)) {
				nQueen(depth+1);
			}
		}
	}

	static boolean is_able(int col) {
    //배열의 Index가 열이기 때문에 열은 확인할 필요 없음
		for (int i=0; i<col; i++) {
      //행이 일치하는 경우
			if (queen[i]==queen[col])
				return false;
      //대각선상에 놓여있는 경우
			else if (Math.abs(col - i) == Math.abs(queen[col] - queen[i]))
				return false;
		}

		return true;
	}

}
