import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LCSTest {
    @Test
    public void should_return_A_if_two_string_are_both_A(){
        LCS lcs = new LCS();
        String result = lcs.calculate("A","A");
        assertThat(result, is("A"));
    }

    @Test
    public void should_return_empty_given_A_and_B(){
        LCS lcs = new LCS();
        String result = lcs.calculate("A","B");
        assertThat(result, is(""));
    }
    
    @Test
    public void should_return_aede_given_acedfe_and_aede(){
        LCS lcs = new LCS();
        String result = lcs.calculate("acedsd", "acdd");
        assertThat(result,is("acdd"));
    }

    @Test
    public void should_return_empty_given_eedfd_and_zzxxxx(){
        LCS lcs = new LCS();
        String result = lcs.calculate("eedfd", "zzxxxx");
        assertThat(result,is(""));
    }

    @Test
    public void should_return_s_given_feefs_and_as(){
        LCS lcs = new LCS();
        String result = lcs.calculate("feefs", "as");
        assertThat(result,is("s"));
    }

    @Test
    public void should_return_CTAATA_given_GTTCCTAATA_and_CGATAATTGAGA(){
        LCS lcs = new LCS();
        String result = lcs.calculate("GTTCCTAATA", "CGATAATTGAGA");
        assertThat(result,is("CTAATA"));
    }

}
