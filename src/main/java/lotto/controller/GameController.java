package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.GameNumbers;
import lotto.domain.Lotto;
import lotto.service.Service;
import lotto.util.Util;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;

public class GameController {

    private Buyer buyer;
    private GameNumbers gameNumbers;


    public void run() {
        beforePlayGame();
        gameResult();
    }

    private void beforePlayGame() {
        buyer = Buyer.from(getInputPurchaseAmount());
        Service.buyLotteries(buyer);
        showPurchasedLotteries(buyer.getPurchasedLotto());
        gameNumbers = GameNumbers.of(getInputWinningNumbers(), getInputBonusNumbers());
    }

    private void gameResult() {
        Service.resultLotteries(buyer, gameNumbers);
        OutputMessage.showLottoResult(buyer.getResultRank());
    }

    private int getInputPurchaseAmount() {
        InputMessage.inputPurchaseAmount();
        return Util.stringToInt(Console.readLine());
    }

    private void showPurchasedLotteries(List<Lotto> lotteries) {
        OutputMessage.purchasedLotto(lotteries.size());
        lotteries.forEach(lotto -> OutputMessage.showLottoNumbers(lotto.getNumbers()));
    }

    private List<Integer> getInputWinningNumbers() {
        InputMessage.inputWinningNumbers();
        return Util.splitInputNumbers(Console.readLine());
    }

    private int getInputBonusNumbers() {
        InputMessage.inputBonusNumber();
        return Util.stringToInt(Console.readLine());
    }
}