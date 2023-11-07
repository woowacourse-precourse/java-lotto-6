package lotto.domain.service;

import static lotto.domain.LottoEnum.LOTTO_COUNT;
import static lotto.domain.LottoEnum.LOTTO_END_NUMBER;
import static lotto.domain.LottoEnum.LOTTO_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.StaticsEnum;
import lotto.domain.model.AmountMoney;
import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.ResultTable;
import lotto.domain.model.WinningLotto;
import lotto.utils.Calculator;

public class LottoService {

    public List<Lotto> makeLottoList(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            pickLottoNumbers(lottoList);
        }
        return lottoList;
    }

    public void updateWinningStatistics(List<Lotto> lottoList, WinningLotto winningLotto,
                                        Map<StaticsEnum, ResultTable> statistics) {
        for (Lotto mylotto : lottoList) {
            long numberOfMatched = getNumberOfMatched(mylotto, winningLotto);
            boolean hasBonusBall = checkBonusBall(mylotto, winningLotto.getBonusNumber());

            incrementAppropriateStatistic(numberOfMatched, hasBonusBall, statistics);
        }
    }

    public double makeProfitRate(AmountMoney amountMoney, Map<StaticsEnum, ResultTable> statistics) {
        long totalPrice = Calculator.evaluateTotalPrice(statistics);
        double profitRate = Calculator.getProfitRate(totalPrice, amountMoney.getAmount());
        return profitRate;
    }

    private void pickLottoNumbers(List<Lotto> lottoList) {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                LOTTO_START_NUMBER.getValue(),
                LOTTO_END_NUMBER.getValue(),
                LOTTO_COUNT.getValue()));

        Lotto lotto = new Lotto(numbers);
        lottoList.add(lotto);
    }

    private void incrementAppropriateStatistic(long numberOfMatched, boolean hasBonusBall,
                                               Map<StaticsEnum, ResultTable> statistics) {
        if (numberOfMatched < StaticsEnum.MATCHED_MINIMUM.getCount()) {
            return;
        }
        StaticsEnum staticsEnum = StaticsEnum.getStaticsEnum(numberOfMatched, hasBonusBall);
        statistics.get(staticsEnum).incrementCount();
    }

    private long getNumberOfMatched(Lotto myLotto, Lotto winningLotto) {
        return winningLotto.getNumbers().stream()
                .filter(myLotto.getNumbers()::contains).count();
    }

    private boolean checkBonusBall(Lotto targetLotto, BonusNumber bonusNumber) {
        return targetLotto.getNumbers().stream()
                .anyMatch(number -> number == bonusNumber.getNumber());
    }
}
