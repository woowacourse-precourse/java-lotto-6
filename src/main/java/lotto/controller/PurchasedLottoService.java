package lotto.controller;

import static lotto.config.GameNumberConfig.LOTTO_PRICE;
import static lotto.view.constants.OutputMessage.PURCHASE_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;
import lotto.util.RandomNumbersGenerator;
import lotto.view.InputPurchasePriceView;
import lotto.view.OutputView;

public class PurchasedLottoService {

    public PurchasedLotto createPurchasedLotto() {
        int lottoCount = calculatePurchasedLottoCount(inputPurchasePrice());

        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = RandomNumbersGenerator.generateSortedRandomNumbers();
            lotto.add(new Lotto(numbers));
        }
        PurchasedLotto purchasedLotto = new PurchasedLotto(lotto);

        printPurchasedLotto(purchasedLotto);
        return purchasedLotto;
    }

    private int inputPurchasePrice() {
        do {
            try {
                return InputPurchasePriceView.inputPurchasePrice();
            } catch (IllegalArgumentException e) {
                OutputView.printNewLine();
                OutputView.printMessage(e.getMessage());
            }
        } while (true);
    }

    private int calculatePurchasedLottoCount(int purchasePrice) {
        int purchasedLottoCount = purchasePrice / LOTTO_PRICE.getNumber();
        printPurchasedLottoCount(purchasedLottoCount);

        return purchasedLottoCount;
    }

    private void printPurchasedLottoCount(int count) {
        String purchaseMessage = String.format(PURCHASE_MESSAGE.getMessage(), count);

        OutputView.printNewLine();
        OutputView.printMessage(purchaseMessage);
    }

    private void printPurchasedLotto(PurchasedLotto purchasedLotto) {
        purchasedLotto.getLotto()
                .forEach(lotto -> OutputView.printNumbers(lotto.getLotto()));
        OutputView.printNewLine();
    }

}
