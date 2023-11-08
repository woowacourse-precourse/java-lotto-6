package lotto;

import lotto.domain.LottoRank;
import lotto.domain.LottoRanks;
import lotto.view.InputView;
import lotto.domain.Lotto;
import lotto.domain.LottoDrawMachine;
import lotto.domain.PurchaseMachine;
import lotto.domain.WinningLotto;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameStarter {
    private final LottoRanks lottoRanks = LottoRanks.getInstance();
    int payment;

    public LottoGameStarter(int payment) {
        this.payment = payment;
    }

    void start() {
        List<Lotto> purchasedLottos = purchaseLotto();
        displayPurchasedLottos(purchasedLottos);
        WinningLotto winningLotto = getWinningLotto();
        int winningAmount = getWinningAmount(winningLotto, purchasedLottos);
        displayWinningResult();
        dispkayReturnsResult(evaluateLottoReturns(payment, winningAmount));
    }

    private void dispkayReturnsResult(String lottoReturns) {
        OutputView.printReturnsResult(lottoReturns);
    }

    private void displayWinningResult() {
        for (LottoRank rank : LottoRank.values()) {
            OutputView.printWinningLottoResult(rank, lottoRanks.getRankCount(rank));
        }
    }

    private void displayPurchasedLottos(List<Lotto> purchasedLottos) {
        for (Lotto lotto : purchasedLottos) {
            OutputView.printGeneratedLottoResult(lotto.getNumbers());
        }
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
        int countOfPurchasable = PurchaseMachine.getCountOfPurchasable(payment);
        OutputView.printPurchaseCountResult(countOfPurchasable);
        return PurchaseMachine.purchaseLottoForCount(countOfPurchasable);
    }

    private String evaluateLottoReturns(int payment, int winningAmount) {
        float returns = ((float) winningAmount / payment) * 100;
        return String.format("%.2f%%", returns);
    }

}
