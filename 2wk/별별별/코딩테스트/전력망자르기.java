import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        int[][] copyWires = new int[n][n];
        for (int[] wire : wires) {
            copyWires[wire[0]-1][wire[1]-1] = 1;
            copyWires[wire[1]-1][wire[0]-1] = 1;
        }
        
        for (int[] wire : wires) {
            int w1 = bfs(wire[0]-1, wire[1]-1, copyWires);
            int w2 = bfs(wire[1]-1, wire[0]-1, copyWires);
            
            answer = Math.min(Math.abs(w1-w2), answer);
        }
        
        return answer;
    }
    
    static int bfs(int node1, int node2, int[][] copyWires) {
        boolean[] visited = new boolean[copyWires.length];
        int count = 1;
        
        int n = copyWires.length - 1;
        
        Queue<Integer> queue = new LinkedList<>();
        visited[node1] = true;
        queue.add(node1);
        
        while(!queue.isEmpty()) {
            int v = queue.poll();
            
            for(int j=0; j<=n; j++) {
                if(j!=node2 && copyWires[v][j]==1 && !visited[j]) {
                    count++;
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
        
        return count;
        
    }
}
