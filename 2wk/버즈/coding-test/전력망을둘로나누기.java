import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        LinkedList<LinkedList<Integer>> graph = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<Integer>());
        }
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        for (int[] wire : wires) {
            boolean[] visited = new boolean[n + 1];
            graph.get(wire[0]).remove(Integer.valueOf(wire[1]));
            graph.get(wire[1]).remove(Integer.valueOf(wire[0]));
            int net1 = bfs(graph, wire[0], visited);
            int net2 = bfs(graph, wire[1], visited);
            answer = Math.min(answer, Math.abs(net1 - net2));
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        
        return answer;
    }
    
    private int bfs(LinkedList<LinkedList<Integer>> graph, int start, boolean[] visited) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int cnt = 0;
        while (q.peek() != null) {
            int curr = q.poll();
            cnt++;
            for (int next : graph.get(curr)) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        return cnt;
    } 
    
//     public int solution(int n, int[][] wires) {
//         int answer = Integer.MAX_VALUE;
//         int[][] graph = new int[n + 1][n + 1];
//         for (int[] wire : wires) {
//             graph[wire[0]][wire[1]] = 1;
//             graph[wire[1]][wire[0]] = 1;
//         }
//         for (int[] wire : wires) {
//             boolean[] visited = new boolean[n + 1];
//             graph[wire[0]][wire[1]] = 0;
//             graph[wire[1]][wire[0]] = 0;
//             int net1 = bfs(graph, wire[0], visited);
//             int net2 = bfs(graph, wire[1], visited);
//             answer = Math.min(answer, Math.abs(net1 - net2));
//             graph[wire[0]][wire[1]] = 1;
//             graph[wire[1]][wire[0]] = 1;
//         }
        
        
//         return answer;
//     }
    
//     private int bfs(int[][] graph, int start, boolean[] visited) {
//         LinkedList<Integer> q = new LinkedList<>();
//         q.add(start);
//         visited[start] = true;
//         int cnt = 0;
//         while (q.peek() != null) {
//             int curr = q.poll();
//             cnt++;
//             for (int i = 0; i < graph.length; i++) {
//                 if (graph[curr][i] == 1 && !visited[i]) {
//                     q.add(i);
//                     visited[i] = true;
//                 }
//             }
//         }
//         return cnt;
//     } 
}

