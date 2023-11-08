package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Test
    @DisplayName("List<Number>가 특정 Number를 포함함을 검증한다.")
    void 내부_값이_같으면_contains가_true를_반환한다() {
        // given
        List<Number> numbers = List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3)
        );
        WinningNumbers winningNumbers = WinningNumbers.from(Lotto.from(numbers));

        // when
        boolean contains = winningNumbers.contains(Number.valueOf(2));

        // then
        assertThat(contains).isEqualTo(true);
    }

    @Test
    @DisplayName("List<Number>가 특정 Number의 포함하지 않음을 검증한다.")
    void 내부_값이_다르면_contains가_false를_반환한다() {
        // given
        List<Number> numbers = List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(6)
        );
        WinningNumbers winningNumbers = WinningNumbers.from(Lotto.from(numbers));

        // when
        boolean contains = winningNumbers.contains(Number.valueOf(3));

        // then
        assertThat(contains).isEqualTo(false);
    }
}
