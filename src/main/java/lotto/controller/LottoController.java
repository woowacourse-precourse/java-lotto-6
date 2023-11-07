package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.PlayLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    public Map<LottoResult, Integer> matchCounts = new EnumMap<>(LottoResult.class);
    InputView inputView = new InputView();
    public int purchaseAmount;
    public int lottoCount;
    public int bonusNumber;
    public List<Lotto> lottos;
    public List<Integer> answerNumber;

    public void startLotto() {
        requestPurchaseAmount();
        OutputView.printNextLine();

        showLottoCount();
        OutputView.printNextLine();

        requestAnswerNumber();
        OutputView.printNextLine();

        requestBonusNumber();
        OutputView.printNextLine();

        gradeLotto();

        findIncome();
    }

    public void requestPurchaseAmount() {
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                OutputView.printPurchaseAmountRequest();
                purchaseAmount = inputView.inputPurchaseAmount();
                lottoCount = purchaseAmount / InputView.MIN_PURCHASE_AMOUNT;
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void showLottoCount() {
        OutputView.printLottoCount(lottoCount);
        lottos = PlayLotto.makeLottos(lottoCount);
        OutputView.printLottos(lottos);
    }

    public void requestAnswerNumber() {
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                OutputView.printAnswerNumberRequest();
                answerNumber = inputView.inputAnswerNumber();
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void requestBonusNumber() {
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                OutputView.printBonusNumberRequest();
                bonusNumber = inputView.inputBonusNumber(answerNumber);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void gradeLotto() {
        OutputView.printLottoResult();
        matchCounts = PlayLotto.calculateLotto(lottos, answerNumber, bonusNumber);
        OutputView.printResults(matchCounts);
    }

    public void findIncome() {
        double lottoIncome = PlayLotto.calculateIncome(matchCounts, purchaseAmount);
        OutputView.printIncome(lottoIncome);
    }
}