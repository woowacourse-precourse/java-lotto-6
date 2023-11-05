package lotto.controller;

import java.util.List;
import lotto.model.exception.InputViewException;
import lotto.model.Lotto;
import lotto.model.LottoProcess;
import lotto.model.WinningLotto;
import lotto.model.exception.LottoProcessException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;
    private final LottoProcess lottoProcess;

    public LottoController(OutputView outputView, InputView inputView, LottoProcess lottoProcess) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.lottoProcess = lottoProcess;
    }

    public void run() {
        int purchaseAmount = getValidPurchaseAmount();
        List<Lotto> purchaseLotto = getValidPurchaseLotto(String.valueOf(purchaseAmount));
        WinningLotto winningLotto = getValidWinningLotto();

        outputView.showPrizeResult(purchaseLotto, winningLotto, purchaseAmount);
    }

    private int getValidPurchaseAmount() {
//        boolean status = true;
        while (true) {
            try {
                String userPurchaseAmount = inputView.getPurchaseAmount();
                return LottoProcess.purchaseAmount(userPurchaseAmount);
//                status = false;
            } catch (LottoProcessException e) {
                System.out.println(e.getMessage());
            }
        }
//        return 0;
    }

    private List<Lotto> getValidPurchaseLotto(String userPurchaseAmount) {
        while (true) {
            try {
                int purchaseAmount = Integer.parseInt(userPurchaseAmount);
                List<Lotto> purchaseLotto = LottoProcess.purchaseLotto(String.valueOf(purchaseAmount));
                outputView.showPurchasedLottos(purchaseLotto);
                return purchaseLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLotto getValidWinningLotto() {
        while (true) {
            try {
                Lotto winningNumbers = inputView.getWinningNumbers();
                int bonusNumber = getValidBonusNumber(winningNumbers.getNumbers());
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = inputView.getBonusNumber(winningNumbers);
                InputViewException.checkBonusNumberDuplicationException(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
