package baekjoon;


import java.util.Comparator;
import java.util.LinkedList;

class Edge {
    int[] node = new int[2];
    int distance;
    public Edge(int node1, int node2, int distance) {
        this.node[0] = node1;
        this.node[1] = node2;
        this.distance = distance;
    }

}

public class Kruskal {


    public static void main(String[] args) {
        int n = 7;
        int m = 11;
        LinkedList<Edge> list = new LinkedList<>();
        list.add(new Edge(1, 7, 12));
        list.add(new Edge(1, 4, 28));
        list.add(new Edge(1, 2, 67));
        list.add(new Edge(1, 5, 17));
        list.add(new Edge(2, 4, 24));
        list.add(new Edge(2, 5, 62));
        list.add(new Edge(3, 5, 20));
        list.add(new Edge(3, 6, 37));
        list.add(new Edge(4, 7, 13));
        list.add(new Edge(5, 6, 45));
        list.add(new Edge(5, 7, 73));

        list.sort(Comparator.comparingInt(o -> o.distance));

        int[] set = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = i;
        }

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!UnionFind.findParent(set, list.get(i).node[0] - 1, list.get(i).node[1] - 1)) {
                sum += list.get(i).distance;
                UnionFind.unionParent(set, list.get(i).node[0] - 1, list.get(i).node[1] - 1);
            }
        }

        System.out.println(sum);





    }
}

