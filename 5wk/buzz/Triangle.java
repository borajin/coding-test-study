/* 프로그래머스 정수삼각형
https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=java */
class Triangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(
                    j > 0 ? triangle[i - 1][j - 1] : 0, j < triangle[i].length - 1 ? triangle[i - 1][j] : 0);
                if (i == triangle[i].length - 1) answer = Math.max(answer, triangle[i][j]);
            }
        }
        return answer;
    }
}
