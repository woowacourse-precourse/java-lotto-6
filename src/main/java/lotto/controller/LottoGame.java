package lotto.controller;

import static lotto.config.GameNumberConfig.LOTTO_PRICE;
import static lotto.view.constants.OutputMessage.PURCHASE_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;
import lotto.util.RandomNumbersGenerator;
import lotto.view.OutputView;
import lotto.view.InputView;

public class LottoGame {

    public void run() {
        PurchasedLotto purchasedLotto = createPurchasedLotto();
        printPurchasedLotto(purchasedLotto);

    }

    private PurchasedLotto createPurchasedLotto() {
        int lottoCount = inputPurchasedLottoCount(InputView.inputPurchasePrice());

        List<Lotto> lotto = new ArrayList<>();
        for (int i=0; i<lottoCount; i++) {
            List<Integer> numbers = RandomNumbersGenerator.generateSortedRandomNumbers();
            lotto.add(new Lotto(numbers));
        }
        return new PurchasedLotto(lotto);
    }

    private int inputPurchasedLottoCount(int purchasePrice) {
        int purchasedLottoCount = purchasePrice / LOTTO_PRICE.getNumber();
        String purchaseMessage = String.format(PURCHASE_MESSAGE.getMessage(), purchasedLottoCount);
        OutputView.printMessage(purchaseMessage);

        return purchasedLottoCount;
    }
    private void printPurchasedLotto(PurchasedLotto purchasedLotto) {
        purchasedLotto.getLotto()
                .forEach(lotto -> OutputView.printNumbers(lotto.getLotto()));
    }

}
