class PointsPairs {
    public int distance;
    public int parentVertex;
    public PointsPairs(int pv, int d) {
        distance = d;
        parentVertex = pv;
    }
}
class Vertex {
    public char label;
    public boolean isIn;
    public Vertex(char label) {
        this.label = label;
        isIn = false;
    }
}
class Graph {
    private final int maxVert = 20;
    private final int INF = 10000000;
    private Vertex[] vertexList;
    private int[][] Matrix;
    private int nVerts;
    private int nTree;
    private PointsPairs[] sPairs;
    private int currVert;
    private int startToCurr;
    public Graph() {
        vertexList = new Vertex[maxVert];
        Matrix = new int[maxVert][maxVert];
        nVerts = 0;
        nTree = 0;
        for (int i = 0; i < maxVert; i++) {
            for (int j = 0; j < maxVert; j++) {
                Matrix[i][j] = INF;
            }
        }
        sPairs = new PointsPairs[maxVert];
    }
    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }
    public void addEdge(int start, int end, int weight) {
        Matrix[start][end] = weight;
    }
    public void path() {
        int startV = 0;
        vertexList[startV].isIn = false;
        nTree = 1;
        for (int i = 0; i < nVerts; i++) {
            int tmp = Matrix[startV][i];
            sPairs[i] = new PointsPairs(startV, tmp);
        }

        while (nTree < nVerts) {
            int indexMin = getMin();
            int minP = sPairs[indexMin].distance;

            if (minP == INF) {
                System.out.print("\nПостроение завершено"); break;
            }
            else {
                currVert = indexMin;
                startToCurr = sPairs[indexMin].distance;
            }
            vertexList[currVert].isIn = true;
            nTree++;
            MatrixSPath();
        }
        displayPath();

        nTree = 0;
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].isIn = false;
        }
    }
    public int getMin() {
        int MinPoint = INF;
        int minIndex = 0;
        for (int i = 0; i < nVerts; i++) {
            if (!vertexList[i].isIn && sPairs[i].distance < MinPoint) {
                MinPoint = sPairs[i].distance;
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void MatrixSPath() {
        int column = 0;
        while (column < nVerts) {
            if (vertexList[column].isIn) {
                column++;
                continue;
            }
            int currToCol = Matrix[currVert][column];
            int startToCol = startToCurr + currToCol;
            int sPathPairs = sPairs[column].distance;

            if (startToCol < sPathPairs) {
                sPairs[column].parentVertex = currVert;
                sPairs[column].distance = startToCol;
            }
            column++;
        }
    }
    public void displayPath() {
        for (int i = 0; i < nVerts; i++) {
            System.out.print("\n" + vertexList[i].label + "=");
            if (sPairs[i].distance == INF) {
                System.out.print("inf");
            }
            else {
                System.out.print(sPairs[i].distance);
            }
            char parent = vertexList[sPairs[i].parentVertex].label;
            System.out.print("(" + parent + ")");
        }
        System.out.print("\n");
    }
}
public class task3 {
    public static void main(String[] a) {

        Graph e = new Graph();

        e.addVertex('A');
        e.addVertex('B');
        e.addVertex('C');
        e.addVertex('D');
        e.addVertex('E');
        e.addVertex('F');
        e.addVertex('G');

        e.addEdge(0, 1, 10);
        e.addEdge(0, 2, 15);
        e.addEdge(1, 3, 7);
        e.addEdge(2, 3, 5);
        e.addEdge(3, 4, 22);
        e.addEdge(3, 5, 15);
        e.addEdge(4, 6, 3);
        e.addEdge(5, 6, 3);

        System.out.println("Кратчайшие маршруты:");
        e.path();

        Graph g = new Graph();

        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addVertex('G');
        g.addVertex('H');

        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 5);
        g.addEdge(1, 3, 15);
        g.addEdge(2, 4, 20);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 5, 18);
        g.addEdge(5, 6, 2);

        System.out.println("Кратчайшие маршруты:");
        g.path();

    }
}