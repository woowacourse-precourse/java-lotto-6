package lotto.domains;

import java.util.List;
import lotto.io.Input;
import lotto.io.Output;

public class LottoGame {

    private int purchaseAmount;
    private int bonusNumber;
    private List<Integer> winningNumbers;
    private Purchase purchase;
    private WinningLotto winningLotto;

    private LottoResult lottoResult;

    public void play() {
        purchaseLottos();
        announceWinningLotto();
        result();
    }

    private void purchaseLottos() {
        purchaseAmount = Input.getPurchaseAmount();
        purchase = new Purchase(purchaseAmount);
        Output.showPurchasedLottos(purchase.getLottos());
    }

    private void announceWinningLotto() {
        winningNumbers = Input.getWinningLotto();
        bonusNumber = Input.getBonusNumber();
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    private void result() {
        lottoResult = new LottoResult(purchase, winningLotto);
        int[] result = LottoResult.analyze();
        Output.showWinningStatistics(result);
        Output.showRateOfReturn(result, purchaseAmount);
    }

}
