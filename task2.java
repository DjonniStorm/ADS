import java.util.Random;

//Depth First Search O(V^2)
public class task2 {
    private boolean[] visited;
    private int[][] graph;
    //v = vertex - текущая вершина графа
    public task2(int n) {
        graph = new int[n][n];
        visited = new boolean[graph.length];
        Random random = new Random();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (i == j) continue;
                graph[i][j] = random.nextInt(0, 2);
                graph[j][i] = graph[i][j];
            }
        }
        for (int v = 0; v < graph.length; v++) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
    public task2(int[][] arr) {
        graph = arr;
        visited = new boolean[graph.length];
        for (int v = 0; v < graph.length; v++) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
    private void dfs(int v) {
        visited[v] = true;
        for (int to = 0; to < graph.length; to++) {
            if (graph[v][to] != 0 && !visited[to]) {
                System.out.print(to + "  ");
                dfs(to);
            }
        }
    }
    public void printGraph() {
        System.out.print("\n");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.printf("%5d ", graph[i][j]);
            }
            System.out.print("\n");
        }
    }
}
