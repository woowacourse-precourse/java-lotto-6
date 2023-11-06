package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {
    static Stream<Arguments> provideLottoNumbersAndRanks() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), Rank.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), Rank.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 8, 9), Rank.FOURTH),
                Arguments.of(List.of(1, 2, 3, 8, 9, 10), Rank.FIFTH)
        );
    }

    @DisplayName("보너스 번호와 당첨번호가 중복이 될 경우 에러 발생")
    @Test
    void duplicateByWinningNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;

        assertThatThrownBy(() -> new WinningNumbers(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 로또번호를 비교하여 등수를 계산한다. ")
    @ParameterizedTest
    @MethodSource("provideLottoNumbersAndRanks")
    void announceLottoRank(List<Integer> input, Rank rank) {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber, bonusNumber);

        Lotto lotto = new Lotto(input);
        Rank result = winningNumbers.announceRank(lotto);

        assertThat(result).isEqualTo(rank);
    }
}
