package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.*;
import static lotto.Utils.calculateReturn;

public class LottoGame {

    private final LottoGameView lottoGameView;

    public LottoGame() {
        this.lottoGameView = new LottoGameView();
    }

    public void start() {
        Long purchaseAmount = lottoGameView.inputPurchaseAmount();
        List<Lotto> lotteries = issueLottery(purchaseAmount / LOTTERY_PRICE);
        lottoGameView.printLotteries(lotteries);
        WinningNumbers winningNumbers = new WinningNumbers();
        lottoGameView.inputWinningNumbers(winningNumbers);
        lottoGameView.inputBonusNumbers(winningNumbers);
        List<Prize> result = lotteries.stream().map(lotto -> lotto.check(winningNumbers)).toList();
        Long resultSum = result.stream().mapToLong(Prize::getMoney).sum();
        lottoGameView.printResult(result);
        lottoGameView.printRateReturn(calculateReturn(resultSum, purchaseAmount));
    }

    private List<Lotto> issueLottery(Long tickets) {
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
}
