package lotto.controller;

import java.util.List;
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
        while (true) {
            try {
                String userPurchaseAmount = inputView.getPurchaseAmount();
                return lottoProcess.purchaseAmount(userPurchaseAmount);
            } catch (LottoProcessException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> getValidPurchaseLotto(String userPurchaseAmount) {
        while (true) {
            try {
                int purchaseAmount = Integer.parseInt(userPurchaseAmount);
                List<Lotto> purchaseLotto = lottoProcess.purchaseLotto(String.valueOf(purchaseAmount));
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
                String bonusNumber = getValidBonusNumber(winningNumbers.getNumbers());
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String userBonusNumber = String.valueOf(inputView.getBonusNumber());
                new WinningLotto(new Lotto(winningNumbers), userBonusNumber);
                return userBonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
