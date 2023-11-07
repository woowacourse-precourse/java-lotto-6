package lotto.controller;

import lotto.utils.ExceptionMessage;
import lotto.utils.LottoUtil;
import lotto.view.LottoView;

import java.util.List;

public class LottoGame {
    LottoView lottoView = new LottoView();
    LottoUtil lottoUtil = new LottoUtil();
    Money money;
    Lotto lotto;
    int bonusNumber;

    public void start() {
        printMessageAndInputMoney();
        List<List<Integer>> myLottos = getRandamLottos();
        printMessageAndInputWinningNumber();
        printMessageAndInputBonusNumber();
        printStatistics();
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

    public void printStatistics() {
        lottoView.printStatisticsMessage();
    }

    public void duplicateBonusNumber(int bonusNumber) {
        lotto.getNumbers().forEach(num -> {
            if(num == bonusNumber) {
                throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_DUPLICATE.getValue());
            }
        });
    }

}
