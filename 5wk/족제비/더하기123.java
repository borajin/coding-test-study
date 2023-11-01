import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  //  https://www.acmicpc.net/problem/9095

  static int[] numbers = {1,2,3};

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int testcase = Integer.parseInt(bufferedReader.readLine());

    for (int i=0; i<testcase; i++) {
      int n = Integer.parseInt(bufferedReader.readLine());

      bufferedWriter.write(getCaseNum_bruteForce(n, 0) + "\n");
    }

    bufferedWriter.flush();

    bufferedReader.close();
    bufferedWriter.close();
  }

  public static int getCaseNum_bruteForce(int n, int sum) {
    if (sum == n) {
      return 1;
    }

    if (sum > n) {
      return 0;
    }

    int a = sum + numbers[0];
    int b = sum + numbers[1];
    int c = sum + numbers[2];

    return getCaseNum_bruteForce(n, a) + getCaseNum_bruteForce(n, b) + getCaseNum_bruteForce(n, c);
  }

  public static void getCaseNum_DP() {
    //구현하기
  }
}
