package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.*;

public class LottoGame {

    private final LottoGameView lottoGameView;

    public LottoGame() {
        this.lottoGameView = new LottoGameView();
    }

    public void start() {
        int purchaseAmount = lottoGameView.inputPurchaseAmount();
        int tickets = purchaseAmount / LOTTERY_PRICE;
        lottoGameView.printLotteryAmount(tickets);
        List<Lotto> lotteries = issueLottery(tickets);
        lottoGameView.printLotteries(lotteries);
        WinningNumbers winningNumbers = new WinningNumbers();
        lottoGameView.inputWinningNumbers(winningNumbers);
        lottoGameView.inputBonusNumbers(winningNumbers);
        List<Prize> result = lotteries.stream().map(lotto -> lotto.check(winningNumbers)).toList();
        Long resultSum = result.stream().mapToLong(Prize::getMoney).sum();
        lottoGameView.printResult(result);
        lottoGameView.printRateReturn(calculateReturn(resultSum, purchaseAmount));
    }

    public List<Lotto> issueLottery(int tickets) {
        List<Lotto> lotteries = new ArrayList<>();

        for (int i = 0; i < tickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LOTTERY_MIN_NUMBER,
                    LOTTERY_MAX_NUMBER,
                    LOTTERY_DIGIT_LENGTH
            );
            lotteries.add(new Lotto(numbers));
        }
        return lotteries;
    }

    public double calculateReturn(Long prize, int purchase) {
        double rateReturn = (double) prize / purchase * 1000;
        double result = Math.round(rateReturn);
        return result / 10;
    }
}
