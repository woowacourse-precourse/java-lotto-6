package lotto.controller;

import lotto.utils.LottoUtil;
import lotto.view.LottoView;

import java.util.List;

public class LottoGame {
    LottoView lottoView = new LottoView();
    LottoUtil lottoUtil = new LottoUtil();
    Money money;
    Lotto lotto;

    public void start() {
        printMessageAndInputMoney();
        List<List<Integer>> myLottos = getRandamLottos();
        printMessageAndInputWinningNumber();
        printMessageAndInputBonusNumber();
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
        String bonusNumber = lottoUtil.getUserInput();
        lotto.validate(bonusNumber);
        lottoUtil.checkDuplicateNumbers(lotto.getNumbers());
    }

}
