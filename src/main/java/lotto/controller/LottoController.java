package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.configuration.PrintMessage;
import lotto.service.LottoService;
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
        OutputView.outputViewTotalReturn(getTotalReturn(scoreBored),money);
    }

    private Long inputPurchaseAmount() {
        OutputView.inputViewPurchaseAmount();
        long myMoney = Long.parseLong(InputView.input());
        Money money = new Money(myMoney);
        return money.getMoney();
    }

    private List<List<Integer>> buyLotto(Long money) {
        PrintMessage.BUY_LOTTO_COUNT.printMessage(money / ONE_THOUSAND);
        List<List<Integer>> myLotto = lottoService.generateRandomLottoNumbers(money / ONE_THOUSAND);
        for (int i = 0; i < money / ONE_THOUSAND; i++) {
            OutputView.lottoNumbersResult(myLotto.get(i));
        }

        return myLotto;
    }

    private List<Integer> inputWinningLottoNumber() {
        OutputView.inputViewWinningNumber();
        Lotto lotto = new Lotto(lottoService.convertToLottoIntegerList(InputView.input()));
        return lotto.getLotto();
    }

    private Integer inputBonusNumber() {
        OutputView.inputViewBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(Integer.parseInt(InputView.input()));
        return bonusNumber.getBonusNumber();
    }

    private HashMap<String, Long> produceStatisticsLottoScore(Long money) {
        List<List<Integer>> myLotto = buyLotto(money);
        List<Integer> winningLotto = inputWinningLottoNumber();
        int bonusNumber = inputBonusNumber();
        return lottoService.getResultScoreBoard(myLotto, winningLotto, bonusNumber);
    }

    private Long getTotalReturn(HashMap<String, Long> scoreBoard) {
        long totalScore = 0L;
        for(long score : scoreBoard.values()) {
            totalScore += score;
        }

        return totalScore;
    }
}
