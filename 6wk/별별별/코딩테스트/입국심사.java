import java.util.*;

//오버플로우 방지를 위해 long으로 받음
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long min = 0;
        //long으로 변수 선언해도 int * int가 int의 범위를 넘게 되면 때문에 오버플로우 발생할 수 있음 -> 모든 변수를 long으로 변환
        long max = (long) times[times.length-1] * (long) n;  //최대로 걸리는 시간은 가장 느린 사람에게 모든 사람이 심사받는 경우

        while (min < max) {
            long mid = (min + max) / 2;

            long count = 0;
            for (long t : times) {
                count += mid / t;  
            }

          if (count < n)
              min = mid + 1;
          else {
              answer = Math.min(max, mid);  //count는 같지만 max가 mid보다 작을 경우가 존재 최소값을 구하는 문제이기 때문에 min
              max = mid;
          }
        }
        
        return answer;
    }
}
