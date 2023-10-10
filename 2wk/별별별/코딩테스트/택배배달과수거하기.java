class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int d = 0;
        int del = 0;
        int pick = 0;
        
        for(int i = n-1; i>=0; i--) {

			del += deliveries[i];
			pick += pickups[i];
            
            while(del > 0 || pick > 0) {
				del -= cap;
				pick -= cap;
				answer += (i+1);
			}

		
		}
        
        answer *= 2;
        
        return answer;
    }
}
