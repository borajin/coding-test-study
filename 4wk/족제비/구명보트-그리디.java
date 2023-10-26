import java.util.Arrays;

public class 구명보트 {
  
  //https://school.programmers.co.kr/learn/courses/30/lessons/42885
  
  public static void main(String[] args) {
    int[] people = {70, 50, 80, 50};
    int limit = 100;

    //정원2명 : 가장 무거운 사람 - 가장 가벼운 사람 끼리 태우기
    //가장 무거운 사람이 무게 초과하면 혼자 태워 보내기

    int answer = 0;

    Arrays.sort(people);

    int lightIndex=0;
    for(int heavyIndex = people.length - 1; heavyIndex >= lightIndex; heavyIndex--) {
      if(people[heavyIndex] + people[lightIndex] <= limit) {
        lightIndex++;
        answer++;
      } else {
        answer++;
      }
    }

    System.out.println(answer);
  }
}
