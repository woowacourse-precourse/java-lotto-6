package study;

import static  org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class SetTest {

    @Test
    public void test1(){
        Set<String> target = new HashSet<>();
        target.add("item1");
        target.add("item2");

        assertThat(target)
                .hasSize(2);
    }



}
