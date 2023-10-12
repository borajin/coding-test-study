public class DFS {

    public static void main(String[] args) {
        // a:0
        // b:1
        // c:2
        // d:3
        // e:4
        // f:5

        // 노드 0과 노드 1 간에 간선(연결)이 존재함
        int n = 6;

        int[][] graph = new int[n][n];

        graph[0][1] = 1;
        graph[0][2] = 1;
        graph[0][3] = 1;
        graph[1][0] = 1;
        graph[2][0] = 1;
        graph[2][4] = 1;
        graph[2][5] = 1;
        graph[3][0] = 1;
        graph[3][5] = 1;
        graph[4][2] = 1;
        graph[5][2] = 1;
        graph[5][3] = 1;

        DFS(0, graph, new boolean[n], n);

    }

    static void DFS(int i, int[][] graph, 햣boolean[] visited, int n) {
        visited[i] = true;
        System.out.println((char) ('A' + i)  + " 방문");
        for(int next = 0; next < n; next++) {
            if(!visited[next] && graph[i][next] != 0) {
                DFS(next, graph, visited, n);
            }
        }
    }
}