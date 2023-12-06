package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }


    @Nested
    @DisplayName("Set.size 메서드 테스트")
    class sizeTest {

        @Test
        @DisplayName("Set.size()가 중복을 제거하는지 테스트한다")
        void Set_size로_Set_크기_확인하는_테스트() {
            Assertions.assertThat(numbers.size()).isEqualTo(3);
        }
    }

    @Nested
    @DisplayName("Set.contains 메서드 테스트")
    class ContainsTest {

        @ParameterizedTest
        @DisplayName("Set.contains()로 값이 존재하는지 테스트한다.")
        @ValueSource(ints = {
                1, 2, 3
        })
        void Set_contains로_값이_존재하는지_테스트(int input) {
            Assertions.assertThat(numbers.contains(input)).isTrue();
        }

        @ParameterizedTest
        @DisplayName("Set.contains 메서드 결과 값이 false인 경우에도 테스트한다.")
        @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
        void Set_contains로_값이_존재하지_않는경우도_테스트(Integer input, boolean expected) {
            boolean actualValue = numbers.contains(input);
            assertEquals(actualValue, expected);
        }
    }


}
