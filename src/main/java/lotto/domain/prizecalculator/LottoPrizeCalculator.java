package lotto.domain.prizecalculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.congin.LottoWinningAmount;
import lotto.domain.Lotto;
import lotto.domain.repository.UserLottoRepository;

public class LottoPrizeCalculator {
    private final UserLottoRepository userLottoRepository;

    public LottoPrizeCalculator() {
        userLottoRepository = new UserLottoRepository();
    }

    public Map<LottoWinningAmount, Integer> setLottoPrizeCalculator(WinningNumbers winningNumbers) {
        return countWinningNumbers(winningNumbers);
    }

    //수익률 계산기
    public Map<LottoWinningAmount, Integer> countWinningNumbers(WinningNumbers winningNumbers) {
        List<Lotto> userLotto = userLottoRepository.getUserLotto();
        Map<LottoWinningAmount, Integer> countNumbers = new HashMap<>();
        for (Lotto lotto : userLotto) {
            Optional<LottoWinningAmount> winningAmount = LottoWinningAmount.getWinningAmount(
                    winningNumbers.getWinCount(lotto),
                    winningNumbers.isBonusCorrect(lotto)
            );
            winningAmount.ifPresent(amount -> countNumbers.merge(amount, 1, Integer::sum));
        }
        return countNumbers;
    }

}
