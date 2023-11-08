package lotto.service;

import java.util.List;
import lotto.domain.CorrectCount;
import lotto.util.LottoValues;

public class CorrectLottoCalculator {

    public CorrectLottoCalculator() {
    }

    public Long getCorrectLottoCount(int rankCount, List<CorrectCount> correctLottoCounts) {
        return correctLottoCounts.stream().filter(correctCount -> correctCount.getCorrectNumberCount() == rankCount).count();
    }

    public Long getCorrectSecondLottoCount(int rankCount, List<CorrectCount> correctLottoCounts) {
        return correctLottoCounts.stream().filter(correctCount ->
                (correctCount.getCorrectNumberCount() == rankCount) &&
                        (correctCount.getCorrectBonusNumberCount() == LottoValues.BONUS_NUMBER_COUNT)).count();
    }

    public Long getCorrectThirdLottoCount(int rankCount, List<CorrectCount> correctLottoCounts) {
        return correctLottoCounts.stream().filter(correctCount ->
                (correctCount.getCorrectNumberCount() == rankCount) &&
                        (correctCount.getCorrectBonusNumberCount() == 0)).count();
    }
}
