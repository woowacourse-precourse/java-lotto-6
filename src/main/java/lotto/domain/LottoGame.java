package lotto.domain;

import lotto.util.AutoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private InputView inputView;
    private OutputView outputView;
    private LottoResult lottoResult;
    private PurchaseLottos purchaseLottos;

    public LottoGame() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        PurchasePrice purchasePrice = inputPurchasePrice();
        purchaseLottos = new PurchaseLottos(purchasePrice, new AutoGenerator());

        outputView.printPurchaseLottos(purchaseLottos);

        WinningNumbers winningNumbers = inputWinningNumbers();
        BonusNumber bonusNumber = inputBonusNumber(winningNumbers);

        lottoResult = purchaseLottos.calculateLottoResult(winningNumbers, bonusNumber);

        outputView.printLottoResult(lottoResult);
        outputView.printRateOfReturn(lottoResult, purchasePrice);
    }

    private PurchasePrice inputPurchasePrice() {
        return inputView.inputPurchasePrice();
    }

    private WinningNumbers inputWinningNumbers() {
        return inputView.inputWinningNumbers();
    }

    private BonusNumber inputBonusNumber(WinningNumbers winningNumbers) {
        return inputView.inputBonusNumber(winningNumbers);
    }
}
