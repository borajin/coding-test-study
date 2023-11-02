class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] prime = Long.toString(n, k).split("0");

		for (String p : prime) {
			if (!p.equals("")) {
				if (isPrime(Long.parseLong(p)))
					answer++;
			}
		}
        
        return answer;
    }
    
    static boolean isPrime(long num) {
		if (num == 1)
			return false;

		if (num==2)
			return true;

		for (int i=2; i<=Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
