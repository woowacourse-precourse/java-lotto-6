package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.RandomNumbers;
import lotto.view.OutputView;

public class LottoController {
    private static int amount;
    private static Lotto winningNumbers;
    InputController inputController = new InputController();

    public void startGame() {
        int quantity = getQuantity();
        OutputView.printNumberOfLottoPurchase(quantity);
        OutputView.printLottoList(purchaseLotto(quantity));
        setWinningNumbers();
    }

    private int getQuantity() {
        String quantity = inputController.getQuantityInput();
        amount = Integer.parseInt(quantity);
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

    private void setWinningNumbers() {
        winningNumbers = inputController.getWinningNumbersInput();
    }
}
