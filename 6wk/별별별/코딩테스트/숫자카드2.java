import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] cards = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i=0; i<cards.length; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);

		int m = Integer.parseInt(br.readLine());
		int[] nums = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		br.close();

		int[] counts = new int[m];

		for (int i=0; i<nums.length; i++) {
			int lLo = 0;
			int lHi = n;

			int uLo = 0;
			int uHi = n;
			int num = nums[i];
			while (lLo < lHi) {
				int mid = (lLo + lHi) / 2;

				if (cards[mid] < num)
					lLo = mid + 1;
				else
					lHi = mid;
			}

			while (uLo < uHi) {
				int mid = (uLo + uHi) / 2;

				if (cards[mid] <= num)
					uLo = mid + 1;
				else
					uHi = mid;
			}

			counts[i] = uHi - lHi;
		}

		for (int cnt : counts) {
			bw.write(String.valueOf(cnt) + " ");
		}
		bw.flush();
	}

}
