package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.RandomNumbers;
import lotto.view.OutputView;

public class LottoController {
    private int amount;
    private Lotto winningNumbers;
    private int bonusNumber;
    List<Lotto> lottos = new ArrayList<>();
    InputController inputController = new InputController();

    public void startGame() {
        showPurchaseLotto();
        setWinningNumbers();
        showWinningStatics();
    }

    private void showPurchaseLotto() {
        int quantity = calculateQuantity();
        OutputView.printNumberOfLottoPurchase(quantity);
        OutputView.printLottoList(purchaseLotto(quantity));
    }

    private int calculateQuantity() {
        String quantity = inputController.getQuantityInput();
        amount = Integer.parseInt(quantity);
        return amount / 1000;
    }

    private List<Lotto> purchaseLotto(int quantity) {
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
        bonusNumber = inputController.getBonusNumberInput(winningNumbers);
    }

    private void showWinningStatics() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateNumberOfWins(lottos, winningNumbers, bonusNumber);

        OutputView.printStatics(lottoResult.getResult());
        OutputView.printRateOfReturn(getRateOfReturn(lottoResult));
    }

    private double getRateOfReturn(LottoResult lottoResult) {
        return lottoResult.calculateRateOfReturn(amount);
    }
}
