package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.util.Utils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class LottoController {

    private final LottoService lottoService;
    private static final Integer ONE_THOUSAND = 1000;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void startLotto() {
        long money = inputPurchaseAmount();
        HashMap<String, Long> scoreBored = produceStatisticsLottoScore(money);
        OutputView.outputViewStatistics(scoreBored);
        OutputView.outputViewTotalReturn(Utils.calculateReturn(getTotalReturn(scoreBored), money));
    }

    private Long inputPurchaseAmount() {
        InputView.inputViewPurchaseAmount();
        while (true) {
            try {
                Money money = new Money(getInputAmount());
                return money.getMoney();
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private List<List<Integer>> buyLotto(long money) {
        OutputView.outputViewPurchaseCount(money / ONE_THOUSAND);
        List<List<Integer>> myLotto = lottoService.generateRandomLottoNumbers(money / ONE_THOUSAND);
        for (int i = 0; i < money / ONE_THOUSAND; i++) {
            OutputView.lottoNumbersResult(Utils.convertListToFormattedString(myLotto.get(i)));
        }
        return myLotto;
    }

    private List<Integer> inputWinningLottoNumber() {
        InputView.inputViewWinningNumber();
        while (true) {
            try {
                Lotto lotto = new Lotto(getInputWinningNumber());
                return lotto.getLotto();
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private Integer inputBonusNumber() {
        InputView.inputViewBonusNumber();
        while (true) {
            try {
                BonusNumber bonusNumber = new BonusNumber(getInputBonusNumber());
                return bonusNumber.getBonusNumber();
            } catch (IllegalArgumentException e) {
            }
        }

    }

    private HashMap<String, Long> produceStatisticsLottoScore(Long money) {
        List<List<Integer>> myLotto = buyLotto(money);
        List<Integer> winningLotto = inputWinningLottoNumber();
        int bonusNumber = inputBonusNumber();
        return lottoService.getResultScoreBoard(myLotto, winningLotto, bonusNumber);
    }

    private Long getTotalReturn(HashMap<String, Long> scoreBoard) {
        long totalScore = 0L;
        for (long score : scoreBoard.values()) {
            totalScore += score;
        }

        return totalScore;
    }

    private long getInputAmount() {
        String userInput = InputView.input().trim();
        long money = Utils.stringToLong(userInput);
        return Utils.rangeInputMoney(money);
    }

    private List<Integer> getInputWinningNumber() {
        String userInput = InputView.input().trim();
        return Utils.convertToLottoIntegerList(userInput);
    }

    private Integer getInputBonusNumber() {
        String userInput = InputView.input().trim();
        return Utils.stringToInteger(userInput);
    }
}
