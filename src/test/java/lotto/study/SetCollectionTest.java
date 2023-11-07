package lotto.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size()를 활용해 Set의 크기를 확인하는지")
    @Test
    void confirmSetSizeTest() {
        // given
        Integer expectedSetSize = 3;

        // when & then
        assertThat(numbers.size()).isEqualTo(expectedSetSize);
    }

    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는지")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest(Integer number) {
        // given & when & then
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는지")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsTrueOrFalseTest(Integer number, Boolean expectedResult) {
        // given
        Boolean result = numbers.contains(number);

        // when & then
        assertThat(result).isEqualTo(expectedResult);
    }
}
