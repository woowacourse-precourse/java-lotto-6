package lotto;

import lotto.domain.InputView;
import lotto.domain.Lotto;
import lotto.domain.LottoDrawMachine;
import lotto.domain.PurchaseMachine;
import lotto.domain.WinningLotto;

import java.util.List;

public class LottoGameStarter {
    int payment;
    public LottoGameStarter(int payment) {
        this.payment = payment;
    }

    void start() {
        List<Lotto> purchasedLottos = purchaseLotto();
        WinningLotto winningLotto = getWinningLotto();
        int winningAmount = getWinningAmount(winningLotto, purchasedLottos);
        int lottoReturns = evaluateLottoReturns(winningAmount);
    }

    private WinningLotto getWinningLotto() {
        return new WinningLotto(
                new Lotto(InputView.inputWinningNumbers()),
                InputView.inputBonusNumber()
        );
    }

    private int getWinningAmount(WinningLotto winningLotto, List<Lotto> purchasedLottos) {
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(winningLotto);
        lottoDrawMachine.evaluateRanks(purchasedLottos);
        return lottoDrawMachine.getWinningAmount();
    }

    private List<Lotto> purchaseLotto() {
        int countOfPurchasable = PurchaseMachine.getCountOfPurchasable(InputView.inputPurchaseAmount());
        return PurchaseMachine.purchaseLottoForCount(countOfPurchasable);
    }

    private int evaluateLottoReturns(int winningAmount) {
        return (payment/winningAmount) * 100;
    }
}
