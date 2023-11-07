package lotto.domain.prizecalculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.congin.LottoWinningAmount;
import lotto.domain.Lotto;

public class LottoPrizeCalculator {
    private WinningNumbers winningNumbers;

    public void setLottoPrizeCalculator(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    //수익률 계산기
    public Map<LottoWinningAmount, Integer> countWinningNumbers(List<Lotto> lottos) {
        Map<LottoWinningAmount, Integer> countNumbers = new HashMap<>();
        for (Lotto lotto : lottos) {
            Optional<LottoWinningAmount> winningAmount = LottoWinningAmount.getWinningAmount(
                    winningNumbers.getWinCount(lotto),
                    winningNumbers.isBonusCorrect(lotto)
            );
            winningAmount.ifPresent(amount -> {
                countNumbers.merge(amount, 1, Integer::sum);
            });
        }
        return countNumbers;
    }

}
