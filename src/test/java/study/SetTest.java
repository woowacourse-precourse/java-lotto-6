package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트")
    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("Parameterized Tests 버전으로 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsParameterizedTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("contains() 메소드를 활용해 1, 2, 3 외의 값이 존재하는지를 확인하는 학습테스트")
    @Test
    void notContains() {
        assertThat(numbers.contains(true)).isFalse();
        assertThat(numbers.contains(4)).isFalse();
        assertThat(numbers.contains(5)).isFalse();
    }

    @DisplayName("Parameterized Tests 버전으로 contains() 메소드를 활용해 1, 2, 3 외의 값이 존재하는지를 확인하는 학습테스트")
    @ParameterizedTest
    @CsvSource(value = {"true:false", "4:false", "5:false"}, delimiter = ':')
    void notContainsParameterizedTest(String input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
