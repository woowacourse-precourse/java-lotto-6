package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CountTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 1_000})
    void Count_객체_생성(int input) {
        assertThat(new Count(input));
    }
    @ParameterizedTest
    @CsvSource(value = {"1,0", "10,9", "25,24", "100,99"})
    void 다음_count를_반환한다(int input, int expected) {
        assertThat(new Count(input).next().count())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 1_000})
    void 남아있는_count가_있을시_true를_반환한다(int input) {
        assertThat(new Count(input).hasMoreCount())
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0,-10, -100, -1_000})
    void 남아있는_count가_없을시_false를_반환한다(int input) {
        assertThat(new Count(input).hasMoreCount())
                .isFalse();
    }
}
