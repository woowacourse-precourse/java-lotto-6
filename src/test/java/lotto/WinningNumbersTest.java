package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @DisplayName("보너스 번호가 당첨 번호 중 하나와 중복되면 예외를 던진다.")
    @Test
    void createWinningNumbersWithDuplicateBonusNumberShouldThrowException() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6; // 중복되는 보너스 번호

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호가 당첨 번호와 중복됩니다.");
    }

    @DisplayName("로또 티켓의 등수를 올바르게 결정한다.")
    @Test
    void determineRankReturnsCorrectRank() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winningNumbersObj = new WinningNumbers(winningNumbers, bonusNumber);

        Lotto firstPrizeLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoRank firstRank = winningNumbersObj.determineRank(firstPrizeLotto);
        assertThat(firstRank).isEqualTo(LottoRank.FIRST);

        Lotto secondPrizeLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoRank secondRank = winningNumbersObj.determineRank(secondPrizeLotto);
        assertThat(secondRank).isEqualTo(LottoRank.SECOND);

        Lotto thirdPrizeLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        LottoRank thirdRank = winningNumbersObj.determineRank(thirdPrizeLotto);
        assertThat(thirdRank).isEqualTo(LottoRank.THIRD);

        Lotto noPrizeLotto = new Lotto(List.of(10, 11, 12, 13, 14, 15));
        LottoRank noRank = winningNumbersObj.determineRank(noPrizeLotto);
        assertThat(noRank).isEqualTo(LottoRank.NONE);
    }
}
