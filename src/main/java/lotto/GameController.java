package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.RandomNumberGenerator;
import lotto.domain.WinningNumber;
import lotto.view.BonusNumberInputView;
import lotto.view.LottoNumberOutputView;
import lotto.view.LottoPurchaseInputView;
import lotto.view.WinningNumbersInputView;
import lotto.view.WinningPrizeOutputView;
import lotto.view.WinningResultOutputView;

public class GameController {
    private static final int LOTTO_PRICE = 1000;

    public void init() {
        int purchaseAmount = LottoPurchaseInputView.getLottoPurchaseAmount();
        List<Lotto> lottos = getLottos(purchaseAmount);

        LottoNumberOutputView.printLottos(lottos);

        List<Integer> winningNumbers = WinningNumbersInputView.getWinningNumbers();

        int bonusNumber = BonusNumberInputView.getBonusNumber();

        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);
        WinningResultOutputView.printResult(lottos, winningNumber);
        WinningPrizeOutputView.printTotalPrize(lottos, winningNumber, purchaseAmount);
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
}
