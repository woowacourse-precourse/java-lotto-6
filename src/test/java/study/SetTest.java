package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    public void test2_1(){
        Set<Integer> target = new HashSet<>();
        target.add(1);
        target.add(2);
        target.add(3);

        assertThat(target.contains(1)).isTrue();
        assertThat(target.contains(2)).isTrue();
        assertThat(target.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void test2_2(int checkNumber){
        Set<Integer> target = new HashSet<>();
        target.add(1);
        target.add(2);
        target.add(3);

        assertThat(target.contains(checkNumber)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3:true", "true,4,5:false"}, delimiter = ':')
    @DisplayName("','를 기준으로 분리가능한 데이터 기준")
    public void test3(String input, Integer expected){
        Set<Integer> actualValue = new HashSet<>();


    }

}
