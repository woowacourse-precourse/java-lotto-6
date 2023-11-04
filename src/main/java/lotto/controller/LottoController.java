package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.RandomNumbers;
import lotto.domain.WinningCriteria;
import lotto.view.OutputView;

public class LottoController {
    private static int amount;
    private static Lotto winningNumbers;
    private static int bonusNumber;
    List<Lotto> lottos = new ArrayList<>();
    InputController inputController = new InputController();

    public void startGame() {
        int quantity = getQuantity();
        OutputView.printNumberOfLottoPurchase(quantity);
        OutputView.printLottoList(purchaseLotto(quantity));
        setWinningNumbers();
        showWinningStatics();
    }

    private int getQuantity() {
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

        HashMap<WinningCriteria, Integer> result = lottoResult.getResult();
        OutputView.printStatics(result);
    }
}
