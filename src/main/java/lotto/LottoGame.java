package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private LottoGameView lottoGameView;

    public LottoGame() {
        this.lottoGameView = new LottoGameView();
    }

    public void start() {
        int amount = lottoGameView.inputPurchaseAmount();
        List<Lotto> lotteries = issueLottery(amount);
        WinningNumbers winningNumbers = lottoGameView.inputWinningNumbers();
        List<Prize> result = lotteries.stream().map(lotto -> lotto.check(winningNumbers)).toList();
        int resultSum = result.stream().mapToInt(Prize::getMoney).sum();
        lottoGameView.printResult(result);
        double resultRate = (double) resultSum / amount;
        lottoGameView.printRateReturn(resultRate);
    }

    public List<Lotto> issueLottery(int amount) {
        List<Lotto> lotteries = new ArrayList<>();

        lottoGameView.printLotteryAmount(amount);
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lotteries.add(lotto);
        }
        lottoGameView.printLotteries(lotteries);

        return lotteries;
    }

    public double calculateReturn(int purchase, int prize) {
        double rateReturn = (double) prize / purchase;
        BigDecimal decimal = new BigDecimal(rateReturn);
        decimal = decimal.setScale(2, RoundingMode.HALF_UP); // 두 번째 자리에서 반올림
        return decimal.doubleValue() * 10;
    }
}
