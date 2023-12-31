import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] wires) {
        // 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/86971
        
        // wires = 간선 정보. 1,3 or 3,1 두 경우는 없음
        // wires 를 전부 탐색하여, n번째 wire 가 끊겼을 때
        // n번째 간선의 양 노드 각각의 하위 노드 개수 차이 중
        // 가장 적은 값을 return

        /*
테스트 1 〉	통과 (5.33ms, 76.3MB)
테스트 2 〉	통과 (4.99ms, 73.4MB)
테스트 3 〉	통과 (5.42ms, 75.8MB)
테스트 4 〉	통과 (5.43ms, 78.6MB)
테스트 5 〉	통과 (4.53ms, 78MB)
테스트 6 〉	통과 (0.41ms, 74.9MB)
테스트 7 〉	통과 (0.30ms, 75.2MB)
테스트 8 〉	통과 (1.10ms, 74.2MB)
테스트 9 〉	통과 (1.43ms, 73.9MB)
테스트 10 〉	통과 (4.76ms, 79.7MB)
테스트 11 〉	통과 (6.16ms, 88.8MB)
테스트 12 〉	통과 (5.16ms, 81.9MB)
테스트 13 〉	통과 (4.57ms, 79.6MB)
        */
        
        List<LinkedList<Integer>> towerTree = makeTowerTree(n, wires);

        int answer = 999;
        for (int[] wire : wires) {
          int leftNode = wire[0]-1;
          int rightNode = wire[1]-1;
            
          towerTree.get(leftNode).remove(Integer.valueOf(rightNode));
          towerTree.get(rightNode).remove(Integer.valueOf(leftNode));

          int first = getConnectedTowerCountByBfs(towerTree, leftNode);
          int second = getConnectedTowerCountByBfs(towerTree, rightNode);

          answer = Math.min(answer, Math.abs(first - second));

          towerTree.get(leftNode).add(rightNode);
          towerTree.get(rightNode).add(leftNode);
        }
        
        return answer;
    }
    
    public int getConnectedTowerCountByBfs(List<LinkedList<Integer>> towerTree, Integer rootNode) {
        Queue<Integer> bfsQueue = new LinkedList<>();
        boolean[] visited = new boolean[towerTree.size()];
        int count = 0;

        //root node 추가
        bfsQueue.add(rootNode);
        visited[rootNode] = true;
        
        while (!bfsQueue.isEmpty()) {
          int nextNode = bfsQueue.poll();
          count++;

          for (Integer node : towerTree.get(nextNode)) {
            if (visited[node]) {
              continue;
            }

            bfsQueue.add(node);
            visited[node] = true;
          }
        }

        return count;
    }
    
    public List<LinkedList<Integer>> makeTowerTree(int totalNodeCount, int[][] wires) {
        List<LinkedList<Integer>> towerTree = new ArrayList<>();

        for (int i = 0; i < totalNodeCount; i++) {
          towerTree.add(new LinkedList<>());
        }

        for (int[] wire : wires) {
          int leftNode = wire[0]-1;
          int rightNode = wire[1]-1;
            
          towerTree.get(leftNode).add(rightNode);
          towerTree.get(rightNode).add(leftNode);
        }

        return towerTree;
    }
}
