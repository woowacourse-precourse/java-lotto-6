package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1); // 중복 값은 Set에 추가되지 않음
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("[요구사항1] Set의 크기를 확인")
    void setSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("[요구사항2] Set에 1, 2, 3이 포함되어 있는지 확인")
    void containsWithParameterized(int element) {
        assertThat(numbers.contains(element)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName("[요구사항3] Set에 주어진 값이 포함되어 있는지 여부를 확인")
    void containsTrueOrFalse(int element, boolean expected) {
        assertThat(numbers.contains(element)).isEqualTo(expected);
    }
}
