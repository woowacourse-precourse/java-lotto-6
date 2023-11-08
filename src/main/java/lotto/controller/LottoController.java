package lotto.controller;

import lotto.constant.LottoConstant;
import lotto.constant.LottoCount;
import lotto.model.Lotto;
import lotto.model.RandomSixNumber;
import lotto.model.User;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final User user;
    private Lotto lotto;
    private OutputView outputView;
    private List<List<Integer>> randomSixNumbers;

    public LottoController() {
        this.inputView = new InputView();
        this.user = new User();
        this.lotto = null;
        this.outputView = new OutputView();
        this.randomSixNumbers = new ArrayList<>();
    }

    public void startGame() {
        LottoService lottoService = new LottoService();

        int purchaseAmount = getPurchaseAmount();

        generatePurchaseAmountRandomSixNumber(purchaseAmount);

        outputView.printRandomSixNumbers(randomSixNumbers);

        inputCorrectLottoNumber();

        int bonusNumber = getBonusNumber();

        HashMap<Integer, Integer> winningResult = lottoService.calculateWinningResult(randomSixNumbers, lotto, bonusNumber);
        outputView.printWinningStatistics(winningResult);

        double profitMargin = lottoService.calculateTotalProfitMargin(winningResult, purchaseAmount);
        outputView.printProfitMargin(profitMargin);
    }

    private int getBonusNumber() {
        int bonusNumber;
        while (true) {
            try {
                inputView.inputBonusNumberView();
                bonusNumber = user.inputBonusNumber(lotto.getNumbers());
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
        return bonusNumber;
    }

    private void inputCorrectLottoNumber() {
        while (true) {
            inputView.inputLottoNumbersView();
            try {
                List<Integer> correctNumber = user.inputLottoNumber();
                lotto = new Lotto(correctNumber);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private int getPurchaseAmount() {
        int purchaseAmount;
        while (true) {
            inputView.inputPurchaseAmountView();
            try {
                purchaseAmount = user.inputPurchaseAmount();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
        return purchaseAmount;
    }

    private void generatePurchaseAmountRandomSixNumber(int purchaseAmount) {
        int amount = purchaseAmount / LottoConstant.LOTTO_PURCHASE_UNIT;
        RandomSixNumber randomSixNumber = new RandomSixNumber();
        for (int round = 1; round <= amount; round++) {
            List<Integer> sixNumber = randomSixNumber.generate();
            randomSixNumbers.add(sixNumber);
        }
    }


}
