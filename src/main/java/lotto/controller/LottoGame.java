package lotto.controller;

import lotto.utils.ExceptionMessage;
import lotto.utils.LottoUtil;
import lotto.view.LottoView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    LottoView lottoView = new LottoView();
    LottoUtil lottoUtil = new LottoUtil();
    Money money;
    Lotto lotto;
    int bonusNumber;
    double revenue;
    final int WINNING_LOCATION = 0;
    final int BONUS_LOCATION = 1;
    final List<String> BONUS_NUMBER = List.of("3", "4", "5", "5+", "6");


    public void start() {
        printMessageAndInputMoney();
        List<List<Integer>> myLottos = getRandamLottos();
        printMessageAndInputWinningNumber();
        printMessageAndInputBonusNumber();
        Map<String, Integer> resultStatistics = getResultStatistics(myLottos);
        printStatistics(resultStatistics);
    }

    public void printMessageAndInputMoney() {
        lottoView.printBuyLottomMoneyMessage();
        money = new Money();
        lottoView.printLottoTicketCount(money.getCount());
    }

    public List<List<Integer>> getRandamLottos() {
        List<List<Integer>> lottos = lottoUtil.getLottos(money.getCount());
        lottoView.printLottoNumbers(lottos);
        return lottos;
    }

    public void printMessageAndInputWinningNumber() {
        lottoView.printWinningNumberMessage();
        String winningNumber = lottoUtil.getUserInput();
        lottoUtil.validateNumberCheck(winningNumber);
        List<Integer> winnerNumber = lottoUtil.convertNumbers(winningNumber);
        lottoUtil.checkDuplicateNumbers(winnerNumber);
        lotto = new Lotto(winnerNumber);
    }

    public void printMessageAndInputBonusNumber() {
        lottoView.printBonusNumberMessage();
        String bonusNum = lottoUtil.getUserInput();
        lotto.validate(bonusNum);
        bonusNumber = Integer.parseInt(bonusNum);
        duplicateBonusNumber(bonusNumber);
    }

    public void printStatistics(Map<String, Integer> resultStatistics) {
        lottoView.printStatisticsMessage();
        revenue = 0;
        BONUS_NUMBER.forEach(num -> {
            int sameCnt = resultStatistics.getOrDefault(num, 0);
            System.out.println(lottoUtil.getStatisticsMessage(num) + sameCnt);
            if(sameCnt > 0) {
                revenue += lottoUtil.getStatisticsValue(num) * sameCnt;
            }
        });
        System.out.println("총 수익률은 " + String.format("%.0f", revenue / money.getInputMoney()) + "%입니다.");
    }

    public Map<String, Integer> getResultStatistics(List<List<Integer>> myLottos) {
        Map<String, Integer> winningTotal = new HashMap<>();
        for(List<Integer> myLotto : myLottos) {
            List<Integer> winning = lottoUtil.calculateVariance(lotto.getNumbers(), myLotto, bonusNumber);
            if(winning.get(WINNING_LOCATION) == 5 && winning.get(BONUS_LOCATION) == 1) {
                String winningValue = winning.get(WINNING_LOCATION) + "+";
                winningTotal.put(winningValue, winningTotal.getOrDefault(winningValue, 0) + 1);
                continue;
            }
            if(winning.get(WINNING_LOCATION) >= 3) {
                String winningValue = winning.get(WINNING_LOCATION).toString();
                winningTotal.put(winningValue, winningTotal.getOrDefault(winningValue, 0) + 1);
            }
        }
        return winningTotal;
    }

    public void duplicateBonusNumber(int bonusNumber) {
        lotto.getNumbers().forEach(num -> {
            if(num == bonusNumber) {
                throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_DUPLICATE.getValue());
            }
        });
    }

}
