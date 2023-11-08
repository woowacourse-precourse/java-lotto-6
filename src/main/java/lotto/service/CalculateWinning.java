package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoStatistic;
import lotto.domain.WinningLotto;

public class CalculateWinning {
    public static LottoStatistic generateStatistic(WinningLotto winning, List<Lotto> lottos) {
        List<LottoResult> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            results.add(calculateResult(winning, lotto));
        }

        return new LottoStatistic(results);
    }

    private static LottoResult calculateResult(WinningLotto lotto, Lotto myLotto) {
        int correctNum = countCorrectNumbers(lotto, myLotto);

        if (correctNum == 3) {
            return LottoResult.FIFTH;
        }
        if (correctNum == 4) {
            return LottoResult.FORTH;
        }
        if (correctNum == 5) {
            if (myLotto.getNumbers().contains(lotto.getBonusNumber())) {
                return LottoResult.SECOND;
            }
            return LottoResult.THIRD;
        }
        if (correctNum == 6) {
            return LottoResult.FIRST;
        }
        return LottoResult.FAIL;
    }

    private static int countCorrectNumbers(WinningLotto lotto, Lotto myLotto) {
        int correctNumber = 0;
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            if (myLotto.getNumbers().contains(lotto.getNumbers().get(i))) {
                correctNumber++;
            }
        }
        return correctNumber;
    }
}
