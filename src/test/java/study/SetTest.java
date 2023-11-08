package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    @DisplayName("Set의 size() 메소드를 통해 Set의 크기를 확인한다.")
    @Test
    void checkSetSizeUsingSizeMethod() {
        Set<Integer> testSet = new HashSet<>();
        testSet.add(1);
        testSet.add(2);
        testSet.add(3);
        testSet.add(4);
        testSet.add(2);
        assertThat(testSet.size()).isEqualTo(4);
    }

    @ParameterizedTest
    @DisplayName("Set의 contains() 메소드를 통해 1,2,3의 값이 존재하는지를 확인한다.")
    @ValueSource(ints = {1, 2, 3})
    void checkSetContainsItemsUsingContainsMethod(int item) {
        Set<Integer> testSet = new HashSet<>(List.of(1, 2, 3));
        assertThat(testSet.contains(item)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set의 contains() 메소드를 통해 1,2,3 값은 Set에 존재, 4,5 값은 Set에 존재하지 않음을 확인한다.")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void test(int input, boolean expected) {
        Set<Integer> testSet = new HashSet<>(List.of(1, 2, 3));
        assertThat(testSet.contains(input)).isEqualTo(expected);
    }
}