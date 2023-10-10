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
        
        List<LinkedList<Integer>> towerTree = makeTowerTree(n, wires);

        int answer = 999;
        for (int[] wire : wires) {
          towerTree.get(wire[0]-1).remove(Integer.valueOf(wire[1]-1));
          towerTree.get(wire[1]-1).remove(Integer.valueOf(wire[0]-1));

          int first = getConnectedTowerCountByBfs(towerTree, wire[0]-1);
          int second = getConnectedTowerCountByBfs(towerTree, wire[1]-1);

          answer = Math.min(answer, Math.abs(first - second));

          towerTree.get(wire[0]-1).add(wire[1]-1);
          towerTree.get(wire[1]-1).add(wire[0]-1);
        }
        
        return answer;
    }
    
    public int getConnectedTowerCountByBfs(List<LinkedList<Integer>> towerTree, Integer rootNode) {
        Queue<Integer> bfsQueue = new LinkedList<>();
        boolean[] visited = new boolean[towerTree.size()];
        int count = 0;

        //root node 추가
        bfsQueue.add(rootNode);

        while (!bfsQueue.isEmpty()) {
          int nextNode = bfsQueue.poll();
          visited[nextNode] = true;
          count++;

          for (Integer node : towerTree.get(nextNode)) {
            if (visited[node]) {
              continue;
            }

            bfsQueue.add(node);
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
          towerTree.get(wire[0] - 1).add(wire[1] - 1);
          towerTree.get(wire[1] - 1).add(wire[0] - 1);
        }

        return towerTree;
    }
}
