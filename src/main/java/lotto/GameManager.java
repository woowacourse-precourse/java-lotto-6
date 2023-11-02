package lotto;

import lotto.domain.LottoGame;
import lotto.view.MessagePrinter;
import lotto.view.MessageReceiver;

import static lotto.constant.NumberConstant.BUYING_PRICE_UNIT;

public class GameManager {

    private final MessagePrinter messagePrinter;
    private final MessageReceiver messageReceiver;

    public GameManager(final MessagePrinter messagePrinter, final MessageReceiver messageReceiver) {
        this.messagePrinter = messagePrinter;
        this.messageReceiver = messageReceiver;
    }

    public void startGame() {
        prepareGame();
    }

    private void prepareGame() {
        messagePrinter.printBuyingPriceMessage();
        int buyingPrice = messageReceiver.receiveBuyingPrice();
        int buyingAmount = buyingPrice / BUYING_PRICE_UNIT;
        messagePrinter.printBuyingAmountMessage(buyingAmount);
        LottoGame lottoGame = LottoGame.createLottoGame(buyingAmount);
        lottoGame.OrderByAsc();
        messagePrinter.printLottoNumbers(lottoGame);
    }
}
