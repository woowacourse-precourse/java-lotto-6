package study;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size 메소드를 활용하여 크기를 확인한다.")
    @Test
    void checkSizeOfSet() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set의 contains 메소드를 활용하여 값이 존재하는지를 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void checkContainedValueInSet(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set의 contains 메소드를 활용하여 존재하지 않는 값을 확인하면 false를 반환하는지를 확인한다.")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void checkNotContainedValueInSet(int input, boolean result) {
        assertEquals(numbers.contains(input), result);
    }
}
