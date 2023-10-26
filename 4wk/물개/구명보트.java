class Solution {
    public int solution(int[] people, int limit) {

        Arrays.sort(people);
        int answer = 0;

        int light = 0;
        int heavy = people.length - 1;

        while (light <= heavy) { // 배열 중앙 인덱스까지
            heavy--; // 가장 무거운 사람은 항상 태움

            if (people[light] + people[heavy] <= limit) {
                light++;
            }

            answer++;
        }

        return answer;
    }
}