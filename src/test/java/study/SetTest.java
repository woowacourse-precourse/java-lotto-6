package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    @DisplayName("크기 테스트")
    void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3"})
    @DisplayName("contains 포함하고 있는지 반환여부 확인")
    void contains_ShouldReturnTrueForIncludingElement(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("contains메소드 테스트2")
    void contains_ShouldReturnTrueOrFalseForElement(int number, boolean isTrue) {
        assertThat(numbers.contains(number)).isEqualTo(isTrue);
    }
}
