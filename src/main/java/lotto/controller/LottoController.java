package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.model.BonusNumber;
import lotto.model.Calculator;
import lotto.model.PurchaseAmount;
import lotto.model.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Lotto winnerLotto;
    private List<Lotto> userLottos;
    private Map<Rank, Integer> result;
    private Calculator calculator;
    private PurchaseAmount purchaseAmount;
    private BonusNumber bonusNumber;

    public LottoController() {
        this.userLottos = new ArrayList<>();
        this.result = new HashMap<>();
    }

    public void run() {
        initPurchaseAmount();
        generateUserLottos();
        initWinnerNumber();
        initBonusNumber();
        generateResult();
        displayResult();
    }

    private void initPurchaseAmount() {
        while (true) {
            try {
                int input = InputView.readPurchaseAmount();
                purchaseAmount = new PurchaseAmount(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void generateUserLottos() {
        int countIssued = 0;
        while (purchaseAmount.notFullyIssued(countIssued)) {
            userLottos.add(Lotto.generateUserLotto());
            countIssued++;
        }
        OutputView.displayUserLottos(userLottos);
    }

    private void initWinnerNumber() {
        while (true) {
            try {
                List<Integer> numbers = InputView.readLottoNumbers();
                winnerLotto = new Lotto(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void initBonusNumber() {
        while (true) {
            try {
                int input = InputView.readBonusNumber();
                bonusNumber = new BonusNumber(winnerLotto, input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void generateResult() {
        calculator = new Calculator(winnerLotto, userLottos, bonusNumber.getBonusNumber());
        result = calculator.getCalculateResult();
    }

    private void displayResult() {
        float rateOfReturn = calculator.calculateRateOfReturn(result);
        OutputView.displayResult(result, rateOfReturn);
    }

}
