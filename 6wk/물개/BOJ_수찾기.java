import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] narr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            narr[i] = Integer.parseInt(st.nextToken());
        }

        // N 배열 오름차순으로 정렬
        Arrays.sort(narr);

        // M 입력 받기
        int m = Integer.parseInt(br.readLine());
        int[] marr = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            marr[i] = Integer.parseInt(st.nextToken());
        }

        // M개의 수 찾기
        for (int i = 0; i < m; i++) {
            int target = marr[i];
            int result = binarySearch(narr, target);
            bw.write(result + "\n");
        }

        br.close();
        bw.close();
    }


    //    배열의 중간 값 선택
//    중앙값 > 타겟데이터일 때 중앙값 기준 왼쪽 데이터 셋 선택
//    중앙값 < 타겟데이터일 때 중앙값 기준 오른쪽 데이터 셋 선택
//    과정 1~3을 반복하다 중앙값 == 타겟데이터일 때 탐색 종료
    public static int binarySearch(int[] narr, int target) {
        int left = 0;
        int right = narr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (narr[mid] == target) {
                return 1; // 찾았을 경우
            } else if (narr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0; // 못 찾았을 경우
    }

}
