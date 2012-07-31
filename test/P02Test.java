import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class P02Test {

    private P02 p02;

    @Before
    public void setUp(){
        p02 = new P02();
    }

    @Test
    public void should_return_1_if_only_has_coins_with_1_and_money_is_1(){
        int min = p02.calculate(new int[]{1}, 1);
        assertThat(min,is(1));
    }

    @Test
    public void should_return_3_if_has_coins_1_5_10_and_money_is_11 (){
        int min = p02.calculate(new int[]{1, 5, 10}, 11);
        assertThat(min,is(2));
    }

    @Test
    public void should_return_3_if_has_coins_5_10_1_and_money_is_11 (){
        int min = p02.calculate(new int[]{ 5, 10, 1}, 11);
        assertThat(min,is(2));
    }

    @Test
    public void should_return_3_if_has_coins_1_2_5_21_25_and_money_is_63 (){
        int min = p02.calculate(new int[]{2, 5, 21, 25}, 63);
        assertThat(min,is(3));
    }

    @Test
    public void should_return_3_if_has_coins_25_21_5_2_1_and_money_is_63 (){
        int min = p02.calculate(new int[]{25, 21, 5, 2, 1}, 63);
        assertThat(min,is(3));
    }


    @Test
    public void should_return_max_value_if_has_coins_5_and_money_is_11 (){
        int min = p02.calculate(new int[]{5}, 11);
        assertThat(min,is(Integer.MAX_VALUE));
    }

}
