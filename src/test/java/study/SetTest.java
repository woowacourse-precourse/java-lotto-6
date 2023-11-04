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

    @Test
    public void test2(){
        Set<Integer> target = new HashSet<>();
        target.add(1);
        target.add(2);
        target.add(3);

        assertThat(target.contains(1)).isTrue();
        assertThat(target.contains(2)).isTrue();
        assertThat(target.contains(3)).isTrue();
    }

}
