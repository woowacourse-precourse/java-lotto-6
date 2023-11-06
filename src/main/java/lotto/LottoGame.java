package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.*;

public class LottoGame {

    private LottoGameView lottoGameView;

    public LottoGame() {
        this.lottoGameView = new LottoGameView();
    }

    public void start() {
        int purchaseAmount = lottoGameView.inputPurchaseAmount();
        int tickets = purchaseAmount / LOTTERY_PRICE;
        List<Lotto> lotteries = issueLottery(tickets);
        WinningNumbers winningNumbers = lottoGameView.inputWinningNumbers();
        List<Prize> result = lotteries.stream().map(lotto -> lotto.check(winningNumbers)).toList();
        int resultSum = result.stream().mapToInt(Prize::getMoney).sum();
        lottoGameView.printResult(result);
        lottoGameView.printRateReturn(calculateReturn(resultSum, purchaseAmount));
    }

    public List<Lotto> issueLottery(int tickets) {
        List<Lotto> lotteries = new ArrayList<>();

        lottoGameView.printLotteryAmount(tickets);
        for (int i = 0; i < tickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTERY_MIN_NUMBER, LOTTERY_MAX_NUMBER, LOTTERY_DIGIT_LENGTH);
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
