package lotto.domain.game;

import java.util.List;
import lotto.domain.lotto.PurchaseLottos;
import lotto.domain.lotto.PurchasePrice;
import lotto.domain.lotto.generator.AutoGenerator;
import lotto.domain.lottoResult.LottoResult;
import lotto.domain.lottoWinning.BonusNumber;
import lotto.domain.lottoWinning.LottoWinning;
import lotto.domain.lottoWinning.WinningNumbers;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        PurchasePrice purchasePrice = inputPurchasePrice();
        PurchaseLottos purchaseLottos = new PurchaseLottos(purchasePrice, new AutoGenerator());
        outputView.printPurchaseLottos(purchaseLottos);

        LottoWinning lottoWinning = getLottoWinning();
        LottoResult lottoResult = LottoResult.of(purchaseLottos, lottoWinning);

        outputView.printLottoResult(lottoResult);
        outputView.printRateOfReturn(lottoResult, purchasePrice);
    }

    private PurchasePrice inputPurchasePrice() {
        PurchasePrice purchasePrice = null;
        while (Validator.isNotValid(purchasePrice)) {
            int price = inputView.inputPrice();
            purchasePrice = PurchasePrice.from(price);
        }

        return purchasePrice;
    }

    private WinningNumbers inputWinningNumbers() {
        WinningNumbers winningNumbers = null;
        while (Validator.isNotValid(winningNumbers)) {
            List<Integer> inputWinningNumbers = inputView.inputWinningNumbers();
            winningNumbers = WinningNumbers.from(inputWinningNumbers);
        }

        return winningNumbers;
    }

    private BonusNumber inputBonusNumber(WinningNumbers winningNumbers) {
        BonusNumber bonusNumber = null;
        while (Validator.isNotValid(bonusNumber)) {
            int inputBonusNumber = inputView.inputBonusNumber();
            bonusNumber = BonusNumber.of(inputBonusNumber, winningNumbers);
        }

        return bonusNumber;
    }

    private LottoWinning getLottoWinning() {
        WinningNumbers winningNumbers = inputWinningNumbers();
        return new LottoWinning(winningNumbers, inputBonusNumber(winningNumbers));
    }
}