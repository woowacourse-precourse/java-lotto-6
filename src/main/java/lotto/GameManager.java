package lotto;

import lotto.domain.LottoGame;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
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
        LottoGame lottoGame = getLottoGame();
        WinningLotto winningLotto = getWinningLotto();
        playGame(lottoGame, winningLotto);
    }

    private LottoGame getLottoGame() {
        messagePrinter.printBuyingPriceMessage();
        int buyingPrice = messageReceiver.receiveBuyingPrice();
        int buyingAmount = buyingPrice / BUYING_PRICE_UNIT;
        messagePrinter.printBuyingAmountMessage(buyingAmount);
        LottoGame lottoGame = LottoGame.createLottoGame(buyingAmount);
        messagePrinter.printLottoNumbers(lottoGame);
        return lottoGame;
    }

    private WinningLotto getWinningLotto() {
        messagePrinter.printWinningNumbersMessage();
        WinningLotto winningLotto = messageReceiver.receiveWinningNumbers();
        messagePrinter.printBonusNumberMessage();
        int bonusNumber = messageReceiver.receiveBonusNumber();
        winningLotto.createBonusNumber(bonusNumber);

        return winningLotto;
    }

    private void playGame(final LottoGame lottoGame, final WinningLotto winningLotto) {
        WinningResult winningResult = lottoGame.calculateWinning(winningLotto);
    }
}
