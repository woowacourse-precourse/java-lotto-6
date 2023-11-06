package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private LottoGameView lottoGameView;

    public LottoGame() {
        this.lottoGameView = new LottoGameView();
    }

    public void start() {
        int amount = lottoGameView.inputPurchaseAmount();
        List<Lotto> lotteries = issueLottery(amount / 1000);
        WinningNumbers winningNumbers = lottoGameView.inputWinningNumbers();
        List<Prize> result = lotteries.stream().map(lotto -> lotto.check(winningNumbers)).toList();
        int resultSum = result.stream().mapToInt(Prize::getMoney).sum();
        lottoGameView.printResult(result);
        lottoGameView.printRateReturn(calculateReturn(resultSum, amount));
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

    public double calculateReturn(int prize, int purchase) {
        double rateReturn = (double) prize / purchase * 1000;
        double result = Math.round(rateReturn);
        return result / 10;
    }
}
