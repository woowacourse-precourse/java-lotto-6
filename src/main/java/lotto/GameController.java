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
    public void init() {
        // 로또 구입 금액을 입력 받는다.
        int purchaseAmount = LottoPurchaseInputView.getLottoPurchaseAmount();
        // 당첨 번호를 입력 받는다.
        List<Integer> winningNumbers = WinningNumbersInputView.getWinningNumbers();
        // 보너스 번호를 입력 받는다.
        int bonusNumber = BonusNumberInputView.getBonusNumber();

        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);
        List<Lotto> lottos = getLottos(purchaseAmount);
        OutputView.printLottos(lottos);
    }

    private List<Lotto> getLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        while (purchaseAmount > 0) {
            lottos.add(new Lotto(randomNumberGenerator.generateRandomNumber()));
            purchaseAmount -= 1000;
        }
        return lottos;
    }
}
