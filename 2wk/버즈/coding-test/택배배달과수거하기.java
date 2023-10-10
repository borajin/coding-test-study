class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int sumDel = 0;
        int sumPick = 0;
       
        for (int i = n - 1; i >= 0; i--) {
            int cnt = 0;
            sumDel += deliveries[i];
            sumPick += pickups[i];
            
            while (sumDel > 0 || sumPick > 0) {
                sumDel -= cap;
                sumPick -= cap;
                cnt++;
            }
            answer += (i + 1) * 2 * cnt;
        }
        return answer;
    }
}

