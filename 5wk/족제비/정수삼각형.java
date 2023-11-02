public class 정수삼각형 {

  // https://school.programmers.co.kr/learn/courses/30/lessons/43105

  public static void main(String[] args) {
    int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

    for (int i=triangle.length-2; i>=0; i--) {
      for (int j=0; j<triangle[i].length; j++) {
        triangle[i][j] = Math.max(triangle[i][j] + triangle[i+1][j], triangle[i][j] + triangle[i+1][j+1]);
      }
    }

    System.out.println(triangle[0][0]);
  }
}
