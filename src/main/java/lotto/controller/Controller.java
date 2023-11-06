package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.service.Service;
import lotto.util.Utils;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.LottoConstants.MIN_UNIT;

public class Controller {

    private Buyer buyer;
    private final Service service = new Service();

    public void run() {
        BeforeLottoGame();
    }

    private void BeforeLottoGame() {
        buyer = new Buyer(getInputAmount());
        service.buyLotto(buyer);
        showBuyingResult();
    }

    private int getInputAmount() {
        InputMessage.MoneyInputMessage();
        String userInput = readLine();
        return Utils.stringToInteger(userInput);
    }

    private void showBuyingResult() {
        int count = buyer.getPurchaseAmount() / MIN_UNIT ;
        OutputMessage.totalLottoMessage(count);
        for (Lotto lotto : buyer.getPurchasedLotteries()) {
            OutputMessage.viewLottoNumbers(lotto.getLottoNumbers());
        }
    }

}
