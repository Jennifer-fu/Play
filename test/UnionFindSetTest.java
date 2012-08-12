import org.junit.Test;
import tree.UnionFindSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UnionFindSetTest {
    @Test
    public void should_return_1_given_4_number_and_13_in_one_set_43_in_one_set() {
        UnionFindSet set = new UnionFindSet(4);
        set.union(1, 3);
        set.union(4, 3);
        int result = set.findUnlinkedSet();
        assertThat(result, is(2));
    }

    @Test
    public void should_return_0_given_3_number_and_12_in_one_set_13_in_one_set_23_in_one_set() {
        UnionFindSet set = new UnionFindSet(3);
        set.union(1, 2);
        set.union(1, 3);
        set.union(2, 3);
        int result = set.findUnlinkedSet();
        assertThat(result, is(1));
    }

    @Test
    public void should_return_2_given_5_number_and_12_in_one_set_35_in_one_set() {
        UnionFindSet set = new UnionFindSet(5);
        set.union(1, 2);
        set.union(3, 5);
        int result = set.findUnlinkedSet();
        assertThat(result, is(3));
    }

    @Test
    public void should_return_998_given_999_number_and_none_in_one_set() {
        UnionFindSet set = new UnionFindSet(999);
        int result = set.findUnlinkedSet();
        assertThat(result, is(999));
    }
}
