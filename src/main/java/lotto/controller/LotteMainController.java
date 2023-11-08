package lotto.controller;

import lotto.LottoManager;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMainController {

    private final LottoManager lottoManager;

    public LottoMainController(LottoManager lottoManager) {
        this.lottoManager = lottoManager;
    }

    public void run() {
        PurchaseAmount purchaseAmount = repeatReadForInvalid(this::inputPurchaseAmount);
        List<Lotto> issuedLottos = lottoManager.CreateLotto(purchaseAmount);
        OutputView.printIssuedLottoDetails(issuedLottos);
    }

    private PurchaseAmount inputPurchaseAmount() {
        try {
            String input = InputView.inputPurchaseAmount();
            int amount = Integer.parseInt(input);
            return new PurchaseAmount(amount);
        } catch (NumberFormatException e) {
            OutputView.printErrorMessage(new IllegalArgumentException("구매 금액은 숫자여야 합니다."));
            return inputPurchaseAmount();
        }
    }

    private <T> T repeatReadForInvalid(Supplier<T> reader) {
        while (true) {
            try {
                return reader.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
