package datatypes;

public interface DisjointSet {
    int find(int point);
    void union(int point1, int point2);
}
