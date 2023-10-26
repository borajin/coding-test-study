import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        
        //가장 무거운 사람 <> 가장 가벼운 사람 끼리 태우기
        //가장 무거운 사람이 무게 초과하면 혼자 태워 보내기
        
        int lightIndex=0;
        for(int heavyIndex = people.length - 1; heavyIndex >= lightIndex; heavyIndex--) {
          if(people[heavyIndex] + people[lightIndex] <= limit) {
            lightIndex++;
            answer++;
          } else {
            answer++;
          }
        }
        
        return answer;
    }
}
