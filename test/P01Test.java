import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class P01Test {

    private P01 p01;

    @Before
    public void setUp(){
        p01 = new P01();
    }

    @Test
    public void should_return_1_if_m_is_1_and_n_is_1(){
        List<List<Integer>> result = p01.calculate(1, 1);
        assertThat(result.size(),is(1));
        assertThat(result.get(0), is(makeList(new int[]{1})));
    }

    @Test
    public void should_return_1_if_n_is_2_m_is_1(){
        List<List<Integer>> result = p01.calculate(2, 1);
        assertThat(result.size(),is(1));
        assertThat(result.get(0),is(makeList(new int[]{1})));
    }

    @Test
    public void should_return_1_and_2_if_n_is_2_m_is_3(){
        List<List<Integer>> result = p01.calculate(2, 3);
        assertThat(result.size(),is(1));
        List<Integer> expected = makeList(new int[]{1, 2});
        assertThat(result.get(0), is(expected));
    }

    @Test
    public void should_return_result_if_n_is_10_m_is_16(){
        List<List<Integer>> result = p01.calculate(10, 16);
        assertThat(result.size(),is(22));
    }

    @Test
    public void should_return_empty_is_n_is_1_and_m_is_2(){
        List<List<Integer>> result = p01.calculate(1, 2);
        assertThat(result.size(),is(0));
    }


    private List<Integer> makeList(int[] numbers) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            result.add(numbers[i]);
        }
        return result;
    }
}
