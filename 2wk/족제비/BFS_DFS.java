import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_DFS {

                                               // 0,  1,  2 , 3,  4,  5
  static String[] nodeStrings = new String[]{"A", "B", "C", "D", "E", "F"};

  public static void main(String[] args) {


    List<LinkedList<Integer>> graph = new ArrayList<>();
    graph.add(new LinkedList<>(Arrays.asList(1, 2, 3)));  //A - BCD
    graph.add(new LinkedList<>(List.of(0)));          //B - A
    graph.add(new LinkedList<>(Arrays.asList(0, 4, 5))); //C - AEF
    graph.add(new LinkedList<>(Arrays.asList(0, 5)));    //D - AF
    graph.add(new LinkedList<>(List.of(2)));         //E - C
    graph.add(new LinkedList<>(Arrays.asList(2, 3)));   //F - CD

    //dfs : A B C E F D
    boolean[] visited = new boolean[6];
    List<String> answer = new ArrayList<>(6);
    System.out.println(dfs(graph, 0, visited, answer));

    //bfs : A B C D E F
    System.out.println(bfs(graph));
  }

  public static List<String> bfs(List<LinkedList<Integer>> graph) {
    List<String> answer = new ArrayList<>(6);

    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[6];

    //시작 정점을 queue에 추가하고 방문 처리
    queue.add(0);
    visited[0] = true;

    while (!queue.isEmpty()) {
      Integer node = queue.poll();
      answer.add(nodeStrings[node]);

      for (Integer nextNode : graph.get(node)) {
        if (visited[nextNode]) {
          continue;
        }

        //큐에 방문하지 않은 인접 노드 추가하고 방문처리 (여기서 방문처리하지 않으면, A(시작노드)->D,C / D->F / C->F 의 케이스를 커버하지 못함)
        queue.add(nextNode);
        visited[nextNode] = true;
      }
    }

    return answer;
  }

  public static List<String> dfs(List<LinkedList<Integer>> graph, Integer node, boolean[] visited, List<String> answer) {
    answer.add(nodeStrings[node]);

    visited[node] = true;

    for (Integer nextNode : graph.get(node)) {
      if (visited[nextNode]) {
        continue;
      }

      dfs(graph, nextNode, visited, answer);
    }

    return answer;
  }
}
