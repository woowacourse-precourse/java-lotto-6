package lotto.study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Randoms.pickUniqueNumbersInRange()를 학습하기 위한 테스트이다.")
public class RandomsTest {

    @DisplayName("랜덤한 N개의 숫자를 생성할 수 있다.")
    @Test
    void generateRandomNumbersForN() {
        // given
        final int startInclusive = 1;
        final int endInclusive = 45;
        final int count = 6;

        // when
        List<Integer> result = Randoms
            .pickUniqueNumbersInRange(startInclusive, endInclusive, count);

        // then
        assertThat(result.size()).isEqualTo(count);
    }

    @DisplayName("생성된 N개의 숫자는 중복이 없다.")
    @Test
    void noDuplicateNumbersGeneratedForN() {
        // given
        final int startInclusive = 1;
        final int endInclusive = 45;
        final int count = 6;

        // when
        List<Integer> result = Randoms
            .pickUniqueNumbersInRange(startInclusive, endInclusive, count);

        // then
        assertThat(new HashSet(result).size()).isEqualTo(count);
    }

    @DisplayName("시작 범위가 종료 범위보다 크거나 같을 수 없다.")
    @ParameterizedTest(name = "[{index}] : startInclusive = {0}, endInclusive = {1}")
    @CsvSource(value = {"10, 1", "10, 10"})
    void startInclusiveCannotBeGreaterThanOrEqualToEndInclusive(final int startInclusive,
                                                                final int endInclusive) {
        // given
        final int count = 6;

        // when, then
        assertThatThrownBy(
            () -> Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count)
        ).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성 갯수는 0보다 작거나 입력 범위보다 클 수 없다.")
    @ParameterizedTest(name = "[{index}] : startInclusive = {0}, endInclusive = {1}, count = {2}")
    @CsvSource(value = {"1, 45, -1", "1, 45, 50"})
    void countCannotBeLessThanZeroOrGreaterThanInputInclusive(final int startInclusive,
                                                              final int endInclusive,
                                                              final int count) {
        // when, then
        assertThatThrownBy(
            () -> Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count)
        ).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
