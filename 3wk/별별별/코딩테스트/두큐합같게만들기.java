import java.util.*;

/*
테스트 1 〉	통과 (0.22ms, 72.2MB)
테스트 2 〉	통과 (0.12ms, 78.2MB)
테스트 3 〉	통과 (0.26ms, 69.7MB)
테스트 4 〉	통과 (0.50ms, 67.4MB)
테스트 5 〉	통과 (3.07ms, 79.1MB)
테스트 6 〉	통과 (4.89ms, 74.6MB)
테스트 7 〉	통과 (5.01ms, 80.4MB)
테스트 8 〉	통과 (4.22ms, 74MB)
테스트 9 〉	통과 (21.49ms, 93.2MB)
테스트 10 〉	통과 (43.17ms, 100MB)
테스트 11 〉	실패 (시간 초과)
테스트 12 〉	실패 (시간 초과)
테스트 13 〉	통과 (846.73ms, 398MB)
테스트 14 〉	통과 (808.61ms, 407MB)
테스트 15 〉	실패 (시간 초과)
테스트 16 〉	통과 (5007.93ms, 405MB)
테스트 17 〉	통과 (1620.96ms, 407MB)
테스트 18 〉	실패 (시간 초과)
테스트 19 〉	실패 (시간 초과)
테스트 20 〉	실패 (시간 초과)
테스트 21 〉	실패 (시간 초과)
테스트 22 〉	실패 (시간 초과)
테스트 23 〉	실패 (시간 초과)
테스트 24 〉	실패 (시간 초과)
테스트 25 〉	실패 (시간 초과)
테스트 26 〉	실패 (시간 초과)
테스트 27 〉	실패 (시간 초과)
테스트 28 〉	실패 (시간 초과)
테스트 29 〉	통과 (6.10ms, 81.2MB)
테스트 30 〉	실패 (시간 초과)
 */

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> que1 = new LinkedList<>();
		Queue<Integer> que2 = new LinkedList<>();
        
        for (int q : queue1) {
			que1.add(q);
		}

		for (int q : queue2) {
			que2.add(q);
		}

		int sum1 = queueSum(que1);
		int sum2 = queueSum(que2);
        
        //int n = (Arrays.stream(que1).sum() + Arrays.stream(que2).sum()) / 2;
        
        if((sum1+sum2)%2 != 0)
            return answer = -1;

		while (sum1!=sum2) {
			if(sum1 < sum2) {
				if (que2.size() <= 1) {
					answer = -1;
					break;
				}

				int q2 = que2.poll();
				que1.add(q2);
				sum1 = queueSum(que1);
				sum2 = queueSum(que2);
				answer++;
			} else if(sum1 > sum2) {
				if (que1.size() <= 1) {
					answer = -1;
					break;
				}

				int q1 = que1.poll();
				que2.add(q1);
				sum1 = queueSum(que1);
				sum2 = queueSum(que2);
				answer++;
			}
		}
        
        return answer;
    }
    
    public static int queueSum(Queue<Integer> queue) {
		Queue<Integer> sumQue = new LinkedList<>();
		sumQue.addAll(queue);

		int sum = 0;;
		for (int i=0; i < queue.size(); i++) {
			sum += sumQue.poll();
		}

		return sum;
	}
}
