package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.RandomNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static int amount;

    public void startGame() {
        int quantity = getQuantity();
        OutputView.printNumberOfLottoPurchase(quantity);
        OutputView.printLottoList(purchaseLotto(quantity));
    }

    private int getQuantity() {
        String quantity = getQuantityInput();
        amount = Integer.parseInt(quantity);
        return amount / 1000;
    }

    private String getQuantityInput() {
        return checkValidationQuantity(InputView.inputAmount());
    }

    private String checkValidationQuantity(String input) {
        try {
            PurchaseAmount purchaseAmount = new PurchaseAmount(input);
            return purchaseAmount.getAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return getQuantityInput();
        }
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
