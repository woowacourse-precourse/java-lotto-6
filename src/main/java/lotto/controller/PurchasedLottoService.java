package lotto.controller;

import static lotto.config.GameNumberConfig.LOTTO_PRICE;
import static lotto.view.constants.OutputMessage.PURCHASE_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;
import lotto.util.RandomNumbersGenerator;
import lotto.view.InputPurchaseAmountView;
import lotto.view.OutputView;

public class PurchasedLottoService {

    public PurchasedLotto createPurchasedLotto(int inputPurchasePrice) {
        int lottoCount = calculatePurchasedLottoCount(inputPurchasePrice);

        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = RandomNumbersGenerator.generateSortedRandomNumbers();
            lotto.add(new Lotto(numbers));
        }
        PurchasedLotto purchasedLotto = new PurchasedLotto(lotto);

        printPurchasedLotto(purchasedLotto);
        return purchasedLotto;
    }

    public int inputPurchaseAmount() {
        do {
            try {
                return InputPurchaseAmountView.inputPurchaseAmount();
            } catch (IllegalArgumentException e) {
                OutputView.printNewLine();
                OutputView.printMessage(e.getMessage());
            }
        } while (true);
    }

    private int calculatePurchasedLottoCount(int purchaseAmount) {
        int purchasedLottoCount = purchaseAmount / LOTTO_PRICE.getValue();
        printPurchasedLottoCount(purchasedLottoCount);

        return purchasedLottoCount;
    }

    private void printPurchasedLottoCount(int count) {
        String purchaseMessage = String.format(PURCHASE_MESSAGE.getMessage(), count);

        OutputView.printNewLine();
        OutputView.printMessage(purchaseMessage);
    }

    private void printPurchasedLotto(PurchasedLotto purchasedLotto) {
        purchasedLotto.getLottos()
                .forEach(lotto -> OutputView.printNumbers(lotto.getLotto()));
        OutputView.printNewLine();
    }

}
