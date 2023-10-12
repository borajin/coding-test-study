package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class BfsDfs {
	static int[][] graph = {
		{1, 2, 3},
		{0},
		{0,4,5},
		{1,5},
		{3},
		{3,5}
	};

	public static void main(String[] args) {
		boolean visited[] = new boolean[6];
		System.out.print("bfs: ");
		bfs(0, visited);

		visited = new boolean[6];
		System.out.print("\ndfs: ");
		dfs(0, visited);
	}



	static void bfs(int i, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		//방문처리
		visited[i] = true;

		//큐가 빌 때까지
		while (!queue.isEmpty()) {
			//방문한 노드 큐에서 추출
			int n = queue.poll();

			System.out.print((char) ('A'+n) + " ");
			// 방문한 노드와 모든 인접 노드
			for(int j : graph[n]) {
				// 방문하지 않았으면 큐에 삽입 후, 방문 처리
				if (!visited[j]) {
					queue.add(j);
					visited[j] = true;
				}
			}

		}

	}

	static void dfs(int i, boolean[] visited) {
		//방문처리
		visited[i] = true;

		System.out.print((char) ('A' + i)+ " ");
		//System.out.println(alph[i]);
		//인접노드 찾기
		for (int j : graph[i]) {
			//인접 노드가 방문한 적이 없을 경우 dfs 다시 실행
			if (!visited[j])
				dfs(j, visited);
		}
	}

}
