package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.constant.BonusMatchType;
import lotto.constant.Winning;
import lotto.model.calculator.CheckWinning;
import lotto.model.calculator.WinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckTest {
    @DisplayName("당첨 번호와 발행 번호가 6개 모두 일치하면 1등으로 판단한다.")
    @Test
    void createFirstPrize() {
        WinningRank winningRank = new WinningRank();
        List<Integer> purchaseNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        BonusMatchType bonus = BonusMatchType.NOT_APPLICABLE;

        CheckWinning checkWinning = new CheckWinning(winningNumber, bonusNumber);
        int count = checkWinning.winningNumberCounter(purchaseNumber);
        bonus = checkWinning.bonusNumberCounter(purchaseNumber);
        winningRank.recorderWinningRank(count, bonus);

        assertThat(winningRank.getAllPrizeCount().get(Winning.FIRST)).isEqualTo(1);
    }

    @DisplayName("당첨 번호와 발행 번호가 5개 일치하고 보너스 번호가 일치하면 2등으로 판단한다.")
    @Test
    void createSecondPrize() {
        WinningRank winningRank = new WinningRank();
        List<Integer> purchaseNumber = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        BonusMatchType bonus = BonusMatchType.NOT_APPLICABLE;

        CheckWinning checkWinning = new CheckWinning(winningNumber, bonusNumber);
        int count = checkWinning.winningNumberCounter(purchaseNumber);
        bonus = checkWinning.bonusNumberCounter(purchaseNumber);
        winningRank.recorderWinningRank(count, bonus);

        assertThat(winningRank.getAllPrizeCount().get(Winning.SECOND)).isEqualTo(1);
    }

    @DisplayName("당첨 번호와 발행 번호가 5개 일치하고 보너스 번호가 불일치하면 3등으로 판단한다.")
    @Test
    void createThirdPrize() {
        WinningRank winningRank = new WinningRank();
        List<Integer> purchaseNumber = Arrays.asList(1, 2, 3, 4, 5, 8);
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        BonusMatchType bonus = BonusMatchType.NOT_APPLICABLE;

        CheckWinning checkWinning = new CheckWinning(winningNumber, bonusNumber);
        int count = checkWinning.winningNumberCounter(purchaseNumber);
        bonus = checkWinning.bonusNumberCounter(purchaseNumber);
        winningRank.recorderWinningRank(count, bonus);

        assertThat(winningRank.getAllPrizeCount().get(Winning.THIRD)).isEqualTo(1);
    }
}
