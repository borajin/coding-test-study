public class 정수삼각형 {

  // https://school.programmers.co.kr/learn/courses/30/lessons/43105

  public static void main(String[] args) {
    int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

    //마지막 줄은 그 자체로 최대값이므로 제외 (length-2)
    for (int i=triangle.length-2; i>=0; i--) {
      for (int j=0; j<triangle[i].length; j++) {
        int left =  triangle[i+1][j];
        int right =  triangle[i+1][j+1];
        triangle[i][j] = Math.max(triangle[i][j] + left, triangle[i][j] + right);
      }
    }

    System.out.println(triangle[0][0]);
  }
}
