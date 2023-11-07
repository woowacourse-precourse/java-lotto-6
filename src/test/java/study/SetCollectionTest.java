package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    @DisplayName("Set size는 유니크한 원소의 수를 반환한다.")
    void testSize() {
        // given

        // when
        int size = numbers.size();

        // then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest(name = "{0}을 조회한 결과는 true다.")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("추가된 숫자 조회 테스트")
    void testContainsTrue(int existElement) {
        // given

        // when
        boolean hasElement = numbers.contains(existElement);

        // then
        assertThat(hasElement).isTrue();
    }

    @ParameterizedTest(name = "{0}을 조회한 결과는 {1}다.")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiterString = ":")
    @DisplayName("숫자 조회 테스트")
    void testContains(int input, boolean expected) {
        // given

        // when
        boolean actual = numbers.contains(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
