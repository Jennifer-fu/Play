package tree;

public class UnionFindSet {

    private int number;
    private int[] ancestor;

    public UnionFindSet(int number) {
        this.number = number;
        this.ancestor = new int[number + 1];
        init();
    }

    private void init() {
        for (int i = 1; i <= number; i++) {
            ancestor[i] = i;
        }
    }

    private int find(int x) {
        while (x != ancestor[x])
            x = ancestor[x];
        return x;
    }

    public void union(int x, int y) {
        int ancestorX = find(x);
        int ancestorY = find(y);
        if (ancestorX != ancestorY)
            ancestor[ancestorX] = ancestorY;
    }

    public int findUnlinkedSet() {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (ancestor[i] == i) count++;
        }
        return count;
    }
}
