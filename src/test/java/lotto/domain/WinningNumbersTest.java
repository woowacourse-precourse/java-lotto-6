package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constant.WinningGrade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("당첨 번호 도메인에")
class WinningNumbersTest {

    @DisplayName("당첨 번호 비교 요청시 당첨 정보를 반환하는가")
    @Test
    void compare() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final WinningNumbers winningNumbers = new WinningNumbers(numbers);

        // when
        final WinningDetails result =
                winningNumbers.compare(new Lottos(List.of(new Lotto(numbers))));

        // then
        assertThat(result.toWinningResult().numOfWinningGrade(WinningGrade.FIRST_GRADE)).isOne();
    }

    @DisplayName("보너스 번호를 갖고 있는지 확인 요청시")
    @Nested
    class Contains {

        @DisplayName("값을 가지고 있으면 true를 반환한다.")
        @Test
        void hasValue() {
            // given
            final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            final WinningNumbers winningNumbers = new WinningNumbers(numbers);

            // when
            final boolean result = winningNumbers.contains(new BonusNumber(numbers.get(0)));

            // then
            assertThat(result).isTrue();
        }

        @DisplayName("값을 가지지 않으면 false를 반환한다.")
        @Test
        void noSameValue() {
            // given
            final WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

            // when
            final boolean result = winningNumbers.contains(new BonusNumber(7));

            // then
            assertThat(result).isFalse();
        }
    }
}
