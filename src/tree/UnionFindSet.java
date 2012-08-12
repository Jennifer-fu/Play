package tree;

//http://acm.hdu.edu.cn/showproblem.php?pid=1232
//某省调查城镇交通状况，得到现有城镇道路统计表，表中列出了每条道路直接连通的城镇。
// 省政府“畅通工程”的目标是使全省任何两个城镇间都可以实现交通（但不一定有直接的道路相连，只要互相间接通过道路可达即可）。
// 问最少还需要建设多少条道路？

public class UnionFindSet {

    private int number;
    private int[] ancestor;
    private int[] rank;

    public UnionFindSet(int number) {
        this.number = number;
        this.ancestor = new int[number + 1];
        this.rank = new int[number + 1];
        init();
    }

    private void init() {
        for (int i = 1; i <= number; i++) {
            ancestor[i] = i;
            rank[i] = 0;
        }
    }

    private int find(int x) {
        if (ancestor[x] != x) {
            ancestor[x] = find(ancestor[x]);
        }
        return ancestor[x];
    }

    public void union(int x, int y) {
        int ancestorX = find(x);
        int ancestorY = find(y);
        if (rank[x] < rank[y])
            ancestor[ancestorX] = ancestorY;
        else if (rank[x] > rank[y])
            ancestor[ancestorY] = ancestorX;
        else {
            ancestor[ancestorX] = ancestorY;
            rank[y]++;
        }
    }

    public int findUnlinkedSet() {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (ancestor[i] == i) count++;
        }
        return count;
    }
}
