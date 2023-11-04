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


}
