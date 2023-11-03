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
        LottoGame lottoGame = prepareLottoGame();
        WinningLotto winningLotto = prepareWinningLotto();
        WinningResult winningResult = playGame(lottoGame, winningLotto);
        endGame(winningResult, lottoGame);
    }

    private LottoGame prepareLottoGame() {
        messagePrinter.printBuyingPriceMessage();
        int buyingPrice = messageReceiver.receiveBuyingPrice();
        LottoGame lottoGame = LottoGame.createLottoGame(buyingPrice);
        messagePrinter.printBuyingAmountMessage(lottoGame);
        messagePrinter.printLottoNumbers(lottoGame);

        return lottoGame;
    }

    private WinningLotto prepareWinningLotto() {
        messagePrinter.printWinningNumbersMessage();
        WinningLotto winningLotto = messageReceiver.receiveWinningNumbers();
        messagePrinter.printBonusNumberMessage();
        int bonusNumber = messageReceiver.receiveBonusNumber();
        winningLotto.createBonusNumber(bonusNumber);

        return winningLotto;
    }

    private WinningResult playGame(final LottoGame lottoGame, final WinningLotto winningLotto) {
        return lottoGame.calculateWinning(winningLotto);
    }

    private void endGame(final WinningResult winningResult, final LottoGame lottoGame) {
        messagePrinter.printWinningStatisticsMessage();
        messagePrinter.printWinningStatisticsResult(winningResult);
        messagePrinter.printEarningsRate(winningResult, lottoGame);
    }
}
