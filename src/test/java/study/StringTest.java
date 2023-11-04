package study;

import static  org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @Disabled
    public void test1_1(){
        String target = "1,2";
        String[] targets = target.split(",");

        assertThat(targets)
                .contains("1", "2");
    }

    @Test
    @Disabled
    public void test1_2(){
        String target = "1,";
        String[] targets = target.split(",");

        assertThat(targets)
                .containsExactly("1");
    }

    @Test
    public void test2(){
        String target = "(1,2)";
        target = target.substring(1, target.length()-1);

        assertThat(target)
                .contains("1,2");
    }

}
