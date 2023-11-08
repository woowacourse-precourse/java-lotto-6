package lotto;

import java.util.List;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {
    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        int purchaseAmount = inputView.inputPurchaseAmount();
        List<Lotto> lottos = resultView.showPurchasedLottos(purchaseAmount);
        Lotto winningLottoNumbers = inputView.inputWinningLottoNumbers();
        int bonusNumber = inputView.inputBonusNumber(winningLottoNumbers);
        resultView.showWinningResult(lottos, winningLottoNumbers, bonusNumber, purchaseAmount);
    }
}
