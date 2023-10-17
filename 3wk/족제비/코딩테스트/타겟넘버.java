class Solution {
    public int solution(int[] numbers, int target) {
        return getAnswer(numbers, target, 0, 0);
    }
    
    public int getAnswer(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        
        return getAnswer(numbers, target, depth + 1, sum + numbers[depth]) + getAnswer(numbers, target, depth + 1, sum - numbers[depth]);
  }
}
