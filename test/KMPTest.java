import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class KMPTest {
    @Test
    public void should_return_minus_1_if_only_contains_one_character(){
        KMP kmp = new KMP();
        int[] next = kmp.next("a");
        assertThat(next.length, is(1));
        assertThat(next[0],is(-1));
    }

    @Test
    public void should_return_minus_1_if_no_match_segment(){
        KMP kmp = new KMP();
        int[] next = kmp.next("ab");
        assertThat(next.length, is(2));
        assertThat(next[0],is(-1));
        assertThat(next[1],is(-1));
    }

    @Test
    public void should_return_0_if_has_one_match_segment(){
        KMP kmp = new KMP();
        int[] next = kmp.next("aa");
        assertThat(next.length, is(2));
        assertThat(next[0],is(-1));
        assertThat(next[1],is(0));
    }

    @Test
    public void should_return_minus_1_minus_1_minus_1_minus_1_01201234563_given_agctagcagctagctg(){
        KMP kmp = new KMP();
        int[] next = kmp.next("agctagcagctagctg");
        assertArrayEquals(new int[]{-1,-1,-1,-1,0,1,2,0,1,2,3,4,5,6,3,-1},next);
    }

    @Test
    public void should_return_minus_1_minus_1_01201234563_given_ababacb(){
        KMP kmp = new KMP();
        int[] next = kmp.next("ababacb");
        assertArrayEquals(new int[]{-1,-1,0,1,2,-1,-1},next);
    }

    @Test
    public void should_result_sub_string_index(){
        KMP kmp = new KMP();
        ArrayList<Integer> result = kmp.kmp("abababaababacb", "ababacb");
        assertThat(result.size(),is(1));
        assertThat(result.get(0),is(7));
    }

    @Test
    public void should_result_sub_string_index_1(){
        KMP kmp = new KMP();
        ArrayList<Integer> result = kmp.kmp("abcbcbcbc", "bcbc");
        assertThat(result.size(),is(3));
        assertThat(result.get(0),is(1));
        assertThat(result.get(1),is(3));
        assertThat(result.get(2),is(5));
    }
}
