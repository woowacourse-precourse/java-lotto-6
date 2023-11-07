package lotto.controller;

import lotto.model.StatInfo;
import lotto.model.User;
import lotto.service.Calculator;
import lotto.view.OutputView;

import java.util.List;

public class GameController {
    static List<List<Integer>> lottoStorage;
    static List<Integer> userWinningNumbers;
    static int bonusNumber;
    static double rateOfReturn;

    static final String FIFTH = StatInfo.THREE_MATCHED.getMatchedResult();
    static final String FOURTH = StatInfo.FOUR_MATCHED.getMatchedResult();
    static final String THIRD = StatInfo.FIVE_MATCHED.getMatchedResult();
    static final String SECOND = StatInfo.FIVE_AND_BONUS_MATCHED.getMatchedResult();
    static final String FIRST = StatInfo.SIX_MATCHED.getMatchedResult();
    static final String SLASH = " - ";
    static final String COUNT_UNIT = "개";

    LottoController lottoController = new LottoController();
    UserController userController = new UserController();
    Calculator calculator = new Calculator();
    OutputView outputView = new OutputView();

    public void run() {
        lottoStorage = lottoController.getLottoStorage();
        lottoController.showLottos(lottoStorage);

        User user = userController.saveWinningNumbers();

        userWinningNumbers = user.getWinningNumbers();
        bonusNumber = user.getBonusNumber();
        showResult();
    }

    public List<Integer> getResult() {
        return calculator.saveResult(lottoStorage, userWinningNumbers, bonusNumber);
    }

    public void showResult() {
        outputView.setOutputWinningStatistics();
        outputView.setOutputDivisionSlash();
        showStatistics();
        showRateOfReturn(rateOfReturn);
    }

    public void showStatistics() {
        List<Integer> result = getResult();
        rateOfReturn = getRateOfReturn(lottoStorage.size(), result);
        System.out.println(FIFTH + SLASH + result.get(3) + COUNT_UNIT);
        System.out.println(FOURTH + SLASH + result.get(4) + COUNT_UNIT);
        System.out.println(THIRD + SLASH + result.get(5) + COUNT_UNIT);
        System.out.println(SECOND + SLASH + result.get(7) + COUNT_UNIT);
        System.out.println(FIRST + SLASH + result.get(6) + COUNT_UNIT);
    }

    public double getRateOfReturn(int numberOfLotto, List<Integer> result) {
        return calculator.calculateRateOfReturn(numberOfLotto, result);
    }

    public void showRateOfReturn(double rate) {
        outputView.setOutputRateOfReturn(rate);
    }
}
