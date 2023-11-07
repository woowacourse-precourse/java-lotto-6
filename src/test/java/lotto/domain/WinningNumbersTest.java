package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {

    @DisplayName("당첨 번호 생성시 잘못된 값을 입력받으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"일,이,삼,사,오,육", "1,2,3,4,5,a", "1,2,7,,3,4"})
    void throwsExceptionOnInvalidWinningNumbersInput(String inputNumbers) {
        assertThatThrownBy(() -> new WinningNumbers(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 생성시 예외 발생 메시지는 `로또 번호` 대신 `당첨 번호`가 포함되어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,46", "1,2,2,3,3,4"})
    void shouldContainsWinningNumberLiteralWhenException(String inputNumbers) {
        assertThatThrownBy(() -> new WinningNumbers(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("[ERROR]", "당첨 번호")
                .hasMessageNotContaining("로또 번호");
    }

    @DisplayName("보너스 번호 생성 시 당첨 번호와 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void throwsExceptionOnBonusNumberDuplicateWithWinningNumbers() {
        WinningNumbers winningNumbers = new WinningNumbers("1,3,5,7,9,11");
        BonusNumber bonusNumber = new BonusNumber("11");

        assertThatThrownBy(() -> winningNumbers.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 번호를 당첨 번호 그리고 보너스 번호와 비교하여 당첨 내역을 생성한다.")
    @Test
    void shouldGeneratePrizeResultsWhenLottoNumbersMatched() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        winningNumbers.setBonusNumber(new BonusNumber("7"));
        List<Lotto> lottoTickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                new Lotto(List.of(1, 2, 3, 8, 9, 10))
        );
        Map<LottoRank, Integer> expectedPrizeBreakdown = Map.of(
                LottoRank.FIRST_PRIZE, 1,
                LottoRank.SECOND_PRIZE, 1,
                LottoRank.THIRD_PRIZE, 1,
                LottoRank.FOURTH_PRIZE, 1,
                LottoRank.FIFTH_PRIZE, 1
        );

        //when
        LottoPrizeBreakdown result = winningNumbers.createLottoPrizeBreakdown(lottoTickets);

        //then
        expectedPrizeBreakdown.forEach((rank, winCount) -> {
            assertThat(result.getReport()).containsEntry(rank, winCount);
        });
    }

    @DisplayName("보너스 번호가 없는 상태에서 당첨내역을 생성하면 예외가 발생한다.")
    @Test
    void throwsExceptionWhenNotExistsBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoTickets = List.of(lotto);
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        assertThatThrownBy(() -> winningNumbers.createLottoPrizeBreakdown(lottoTickets))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR]");
    }
}