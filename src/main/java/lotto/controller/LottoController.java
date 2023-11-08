package lotto.controller;

import lotto.model.Lotto;
import lotto.model.RandomSixNumber;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
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
        int bonusNumber = 0;
        int purchaseAmount = 0;
        while (true) {
            inputView.inputPurchaseAmountView();
            try {
                purchaseAmount = user.inputPurchaseAmount();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
        generatePurchaseAmountRandomSixNumber(purchaseAmount);
        outputView.printRandomSixNumbers(randomSixNumbers);
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
        while (true) {
            try {
                inputView.inputBonusNumberView();
                bonusNumber = user.inputBonusNumber(lotto.getNumbers());
                break;
            }catch (IllegalArgumentException e){
                outputView.printErrorMessage(e);
            }
        }
    }

    private void generatePurchaseAmountRandomSixNumber(int purchaseAmount) {
        int amount = purchaseAmount / 1000;
        RandomSixNumber randomSixNumber = new RandomSixNumber();
        for (int round = 1; round <= amount; round++) {
            List<Integer> sixNumber = randomSixNumber.generate();
            randomSixNumbers.add(sixNumber);
        }
    }


}
