package lotto.domain.winningLotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {

    @DisplayName("로또 번호와 당첨 번호 및 보너스 비교를 비교해서 당첨 등수를 반환한다.")
    @ParameterizedTest
    @MethodSource("parametersForDetermineRankTest")
    void determineRank_Success(Lotto lotto, Rank rank) {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // when, then
        Assertions.assertThat(winningLotto.determineRank(lotto)).isEqualTo(rank);
    }

    static Stream<Arguments> parametersForDetermineRankTest() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Rank.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), Rank.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 7, 10)), Rank.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 7, 9, 12)), Rank.FIFTH),
                Arguments.of(new Lotto(List.of(1, 2, 9, 10, 11, 12)), Rank.MISS)
        );
    }

    @DisplayName("당첨 번호의 개수가 6개보다 크면 예외가 발생한다.")
    @Test
    void createWinningNumbers_Fail_ByOverSize() {
        // when, then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_WINNING_NUMBERS_SIZE.getMessage()
                        .formatted(LottoConstants.LOTTO_NUMBERS_SIZE.getValue()));
    }

    @DisplayName("당첨 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createWinningNumbers_Fail_ByUnderSize() {
        // when, then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_WINNING_NUMBERS_SIZE.getMessage()
                        .formatted(LottoConstants.LOTTO_NUMBERS_SIZE.getValue()));
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbers_Fail_ByDuplicatedNumber() {
        // when, then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATED_WINNING_NUMBER.getMessage());
    }

    @DisplayName("당첨 번호 중에서 1보다 작은 번호가 존재하면 예외가 발생한다.")
    @Test
    void createWinningNumbers_Fail_ByNumberIsLessThanMinimum() {
        // when, then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.getMessage()
                        .formatted(
                                LottoConstants.MIN_LOTTO_NUMBER.getValue(),
                                LottoConstants.MAX_LOTTO_NUMBER.getValue()
                        )
                );
    }

    @DisplayName("당첨 번호 중에서 45보다 큰 번호가 존재하면 예외가 발생한다.")
    @Test
    void createWinningNumbers_Fail_ByNumberIsMoreThanMaximum() {
        // when, then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 66)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.getMessage()
                        .formatted(
                                LottoConstants.MIN_LOTTO_NUMBER.getValue(),
                                LottoConstants.MAX_LOTTO_NUMBER.getValue()
                        )
                );
    }
}
