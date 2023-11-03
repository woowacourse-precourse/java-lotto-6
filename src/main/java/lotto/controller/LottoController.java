package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.RandomNumbers;
import lotto.view.InputView;

public class LottoController {
    private static int amount;

    private int getQuantity() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.inputAmount());
        amount = Integer.parseInt(purchaseAmount.getAmount());
        return amount / 1000;
    }

    private List<Lotto> purchaseLotto(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        RandomNumbers randomNumbers = new RandomNumbers();

        for (int i = 0; i < quantity; i++) {
            List<Integer> lottoNumbers = randomNumbers.generateRandomNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}
