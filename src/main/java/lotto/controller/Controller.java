package lotto.controller;

import static lotto.view.InputView.requestAmout;

import lotto.domain.Amount;
import lotto.domain.PurchasedLottos;
import lotto.utils.RandomLottoNumbersGenerator;


public class Controller {
    public void run() {
        PurchasedLottos purchasedlottos = tryPurchaseLotto();
    }

    private PurchasedLottos tryPurchaseLotto() {
        try {
            Amount amount = new Amount(requestAmout());
            RandomLottoNumbersGenerator generator = new RandomLottoNumbersGenerator();
            PurchasedLottos purchasedLottos = PurchasedLottos.createPurchasedLottos(generator, amount)
        }
    }


}
