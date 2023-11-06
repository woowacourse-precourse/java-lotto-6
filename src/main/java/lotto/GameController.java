package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.RandomNumberGenerator;
import lotto.domain.WinningNumber;
import lotto.view.BonusNumberInputView;
import lotto.view.LottoPurchaseInputView;
import lotto.view.OutputView;
import lotto.view.WinningNumbersInputView;

public class GameController {
    private static final String PRIZE_STATISTICS = "당첨 통계";
    private static final int LOTTO_PRICE = 1000;
    private static final String SEPARATOR = "---";

    public void init() {
        // 로또 구입 금액을 입력 받는다.
        int purchaseAmount = LottoPurchaseInputView.getLottoPurchaseAmount();
        List<Lotto> lottos = getLottos(purchaseAmount);
        OutputView.printLottos(lottos);

        // 당첨 번호를 입력 받는다.
        List<Integer> winningNumbers = WinningNumbersInputView.getWinningNumbers();

        // 보너스 번호를 입력 받는다.
        int bonusNumber = BonusNumberInputView.getBonusNumber();

        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);
        printResult(lottos, winningNumber);
    }

    private List<Lotto> getLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        while (purchaseAmount > 0) {
            lottos.add(new Lotto(randomNumberGenerator.generateRandomNumber()));
            purchaseAmount -= LOTTO_PRICE;
        }
        return lottos;
    }

    private void printResult(List<Lotto> lottos, WinningNumber winningNumber) {
        System.out.println(PRIZE_STATISTICS);
        System.out.println(SEPARATOR);
    }
}
