package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Calculator;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.RankResult;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Lotto winnerLotto;
    private List<Lotto> userLottos;
    private RankResult rankResult;
    private Calculator calculator;
    private PurchaseAmount purchaseAmount;
    private BonusNumber bonusNumber;

    public LottoController() {
        this.userLottos = new ArrayList<>();
        this.rankResult = new RankResult();
    }

    public void run() {
        initPurchaseAmount();
        generateUserLottos();
        initWinnerNumber();
        initBonusNumber();
        generateResult();
        displayStatistic();
        displayRateOfReturn();
    }

    private void initPurchaseAmount() {
        while (true) {
            try {
                OutputView.requestPurchaseAmount();
                int inputPurchaseAmount = Parser.parseInputToNumber(InputView.readLine());
                purchaseAmount = new PurchaseAmount(inputPurchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.displayExceptionMessage(e);
            }
        }
    }

    private void generateUserLottos() {
        int countIssued = 0;
        while (purchaseAmount.isNotFullyIssued(countIssued)) {
            userLottos.add(Lotto.generateUserLotto());
            countIssued++;
        }
        OutputView.displayUserLottos(userLottos);
    }

    private void initWinnerNumber() {
        while (true) {
            try {
                OutputView.requestWinnerNumber();
                List<Integer> numbers = Parser.parseInputToList(InputView.readLine());
                winnerLotto = new Lotto(numbers);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.displayExceptionMessage(e);
            }
        }
    }

    private void initBonusNumber() {
        while (true) {
            try {
                OutputView.requestBonusNumber();
                int inputBonusNumber = Parser.parseInputToNumber(InputView.readLine());
                bonusNumber = new BonusNumber(winnerLotto, inputBonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.displayExceptionMessage(e);
            }
        }
    }

    private void generateResult() {
        calculator = new Calculator(winnerLotto, userLottos, bonusNumber);
        rankResult.add(calculator.countRank());
    }

    private void displayStatistic() {
        OutputView.displayStatistic(rankResult);
    }

    private void displayRateOfReturn() {
        float rateOfReturn = calculator.calculateRateOfReturn(rankResult);
        OutputView.displayRateOfReturn(rateOfReturn);
    }

}
