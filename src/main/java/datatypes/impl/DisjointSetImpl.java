package datatypes.impl;

import datatypes.DisjointSet;

public class DisjointSetImpl implements DisjointSet {
    private final int[] parents;
    private final int[] ranks;

    public DisjointSetImpl(int n) {
        parents = new int[n];
        ranks = new int[n];
        for (int i = 0; i < n; i++) {
            ranks[i] = 0;
            parents[i] = -1;
        }
    }

    @Override
    public int find(int point) {
        if (point < 0)
            throw new IllegalArgumentException("Point cannot be negative");
        if (parents[point] == -1)
            return point;
        return parents[point] = find(parents[point]);
    }

    @Override
    public void union(int point1, int point2) {
        int component1 = find(point1);
        int component2 = find(point2);

        if (component1 == component2)
            return;
        if (ranks[component1] > ranks[component2])
            parents[component2] = component1;
        else if (ranks[component1] < ranks[component2])
            parents[component1] = component2;
        else {
            parents[component1] = component2;
            ranks[component2] += 1;
        }
    }
}
