package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.util.Constants;
import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class GameController {

    public void start() {
        int ticketCount = buyLotto(getAmount());
        Lottos lottos = new Lottos(ticketCount);
        printLottoNumbers(lottos);
        List<Integer> winningNumber = getLuckyNumber();
        int bonusNumber = getBonusNumber();
        Result result = new Result(lottos, winningNumber, bonusNumber);
        int totalPrize = result.gameResult();
        printGrossProfitRate(totalPrize, ticketCount);
    }

    private int buyLotto(int purchaseAmount) {
        int ticketCount = purchaseAmount / Constants.LOTTO_AMOUNT;
        printPurchaseAmount(ticketCount);

        return ticketCount;
    }
}
