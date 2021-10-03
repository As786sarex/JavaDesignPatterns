package datatypes.impl;

import datatypes.DisjointSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisjointSetImplTest {

    private DisjointSet disjointSet;
    public static final int MATRIX_ROW_SIZE = 3;
    public static final int MATRIX_COL_SIZE = 3;
    public static final int[][] directions = {{1, 0}, {0, 1},{-1, 0}, {0, -1}};

    @BeforeEach
    void setUp() {
        this.disjointSet = new DisjointSetImpl(MATRIX_ROW_SIZE * MATRIX_COL_SIZE);
    }

    private int mapCellLocation(int x, int y) {
        return x * MATRIX_ROW_SIZE + y;
    }

    private void addCell(int x, int y) {
        int current = mapCellLocation(x, y);
        for (int[] dir : directions) {
            int xs = x + dir[0];
            int ys = y + dir[1];
            if (xs < 0 || xs >= MATRIX_ROW_SIZE || ys < 0 || ys >= MATRIX_ROW_SIZE)
                continue;
            int to = mapCellLocation(xs, ys);
            disjointSet.union(current, to);
        }
    }
    private boolean checkState() {
        return disjointSet.find(mapCellLocation(0, 0)) == disjointSet.find(mapCellLocation(MATRIX_ROW_SIZE - 1, MATRIX_COL_SIZE - 1));
    }

    @Test
    public void shouldGiveSameComponentAndExit() {
        addCell(1, 1);
        addCell(0, 1);
        boolean currentState = checkState();
        assertFalse(currentState);
        addCell(2,1);
        assertTrue(checkState());
    }
}