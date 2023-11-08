package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
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
        numbers.addAll(List.of(1, 1, 2, 3));
    }

    @DisplayName("중복된 숫자는 하나만 포함시킨다")
    @Test
    void addAll_Test() {
        assertThat(numbers.size())
                .isEqualTo(3);
    }

    @DisplayName("입력한 숫자를 모두 포함한다")
    @ParameterizedTest(name = "{0}을 포함하고 있는지 확인한다")
    @ValueSource(ints = {1, 2, 3})
    void contains_Test1(int number) {
        assertThat(numbers.contains(number))
                .isTrue();
    }

    @DisplayName("입력한 숫자는 포함하고, 입력하지 숫자는 포함하지 않는다")
    @ParameterizedTest(name = "{0}을 입력했을 때 {1}를 반환한다")
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    void contains_test(int number, boolean bool) {
        assertThat(numbers.contains(number))
                .isEqualTo(bool);
    }
}
