package lotto.controller;

import lotto.utils.LottoUtil;
import lotto.view.LottoView;

import java.util.List;

public class LottoGame {
    LottoView lottoView = new LottoView();
    LottoUtil lottoUtil = new LottoUtil();
    Money money;

    public void start() {
        printMessageAndInputMoney();
        List<List<Integer>> lottos = getRandamLottos();
//        printMessageAndInputWinningNumber();
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

    public String printMessageAndInputWinningNumber() {
        lottoView.printWinningNumberMessage();
        String winningNumber = lottoUtil.getUserInput();
        return winningNumber;
    }

}
