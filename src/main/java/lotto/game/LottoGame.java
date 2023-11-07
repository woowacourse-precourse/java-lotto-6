package lotto.game;

import static lotto.Constants.LottoConstant.*;
import static lotto.Constants.MessageConstant.BUY_LOTTO;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.LottoNumber;
import lotto.AmountToBuyLotto;
import lotto.WinningNumber;
import lotto.WinningStatistic;
import lotto.YieldRate;
import lotto.random.RandomNumberGenerator;

public class LottoGame {


    private final List<Lotto> issuedLottos;
    private final RandomNumberGenerator randomNumberGenerator;

    public LottoGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
        issuedLottos = new ArrayList<>();
    }

    public void saleLotto(AmountToBuyLotto amountToBuyLotto) {
        int totalCount = amountToBuyLotto.dividedByLottoPrice();
        for (int current = INIT_COUNT; current < totalCount; current++) {
            issuedLottos.add(createLotto());
        }
    }

    private Lotto createLotto() {
        return new Lotto(randomNumberGenerator.generateRandomNumbers());
    }

    public String getIssuedLottosMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(BUY_LOTTO, issuedLottos.size()));
        for (Lotto issuedLotto : issuedLottos) {
            stringBuilder.append(issuedLotto.showNumbers());
        }
        return stringBuilder.toString();
    }

    public WinningStatistic createWinningStatistic(WinningNumber winningNumber,
        LottoNumber bonusNumber) {
        WinningStatistic winningStatistic = WinningStatistic.newInstance();
        compareWinningNumberWithLottos(winningNumber, bonusNumber, winningStatistic);
        return winningStatistic;
    }

    public YieldRate calculateYieldRate(AmountToBuyLotto amountToBuyLotto,
        WinningStatistic winningStatistic) {
        long totalAmount = winningStatistic.getTotalWinningAmount();
        return YieldRate.newInstance(amountToBuyLotto, totalAmount);
    }

    private void compareWinningNumberWithLottos(WinningNumber winningNumber,
        LottoNumber bonusNumber, WinningStatistic winningStatistic) {
        issuedLottos.stream()
            .map(lotto -> lotto.compareWinningNumber(winningNumber, bonusNumber))
            .forEach(winningStatistic::increaseCount);
    }
}
