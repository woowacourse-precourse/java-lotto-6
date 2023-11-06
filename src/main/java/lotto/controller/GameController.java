package lotto.controller;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PrizeReception;
import lotto.domain.wrapper.BonusNumber;
import lotto.domain.wrapper.PurchaseAmount;
import lotto.service.ConsoleInputParser;
import lotto.service.PrizeChecker;
import lotto.service.VendingMachine;
import lotto.utils.PrintingMessage;
import lotto.utils.Prize;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    ConsoleInputParser consoleInputParser = new ConsoleInputParser();
    OutputView outputView = new OutputView();

    public void play() {
        PurchaseAmount purchaseAmount = getValidPurchaseAmount();
        VendingMachine vendingMachine = new VendingMachine(purchaseAmount);
        Lottos lottos = vendingMachine.getLottos();
        printLottos(lottos);
        Lotto winningLotto = getValidWinningLotto();
        BonusNumber bonusNumber = getValidBonusNumber(winningLotto);
        PrizeChecker prizeChecker = new PrizeChecker(winningLotto, bonusNumber);
        Map<Prize, Integer> lottosResult = lottos.getLottosResult(prizeChecker);
        PrizeReception prizeReception = new PrizeReception(lottosResult);
        printPrizeResults(prizeReception);
        printPrizeProfit(prizeReception, purchaseAmount);
    }

    private PurchaseAmount getValidPurchaseAmount() {
        boolean isCorrectInput = false;
        PurchaseAmount purchaseAmount = null;
        while (!isCorrectInput) {
            try {
                purchaseAmount = getPurchaseAmount();
                isCorrectInput = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printMessage(illegalArgumentException.getMessage());
            }
        }
        return purchaseAmount;
    }

    private PurchaseAmount getPurchaseAmount() {
        outputView.printMessage(PrintingMessage.GET_PURCHASE_AMOUNT_MESSAGE.get());
        String input = inputView.getInputFromConsole();
        return consoleInputParser.toPurchaseAmount(input);
    }

    private void printLottos(Lottos playerLottos) {
        outputView.printMessage(PrintingMessage.BUYING_MESSAGE.getWithFormat(playerLottos.getLottoCount()));
        outputView.printMessage(playerLottos.toString());
    }

    private Lotto getValidWinningLotto() {
        boolean isCorrectInput = false;
        Lotto winningLotto = null;
        while (!isCorrectInput) {
            try {
                winningLotto = getWinningLotto();
                isCorrectInput = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printMessage(illegalArgumentException.getMessage());
            }
        }
        return winningLotto;
    }

    private Lotto getWinningLotto() {
        outputView.printMessage(PrintingMessage.GET_WINNING_NUMBERS_MESSAGE.get());
        String input = inputView.getInputFromConsole();
        return consoleInputParser.toLotto(input);
    }

    private BonusNumber getValidBonusNumber(Lotto winningLotto) {
        boolean isCorrectInput = false;
        BonusNumber bonusNumber = null;
        while (!isCorrectInput) {
            try {
                bonusNumber = getBonusNumber(winningLotto);
                isCorrectInput = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printMessage(illegalArgumentException.getMessage());
            }
        }
        return bonusNumber;
    }

    private BonusNumber getBonusNumber(Lotto winningLotto) {
        outputView.printMessage(PrintingMessage.GET_BONUS_NUMBER_MESSAGE.get());
        String input = inputView.getInputFromConsole();
        return consoleInputParser.toBounsNumber(input, winningLotto);
    }

    private void printPrizeResults(PrizeReception prizeReception) {
        outputView.printMessage(PrintingMessage.PRIZE_MESSAGE_START_MESSAGE.get());
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NO_PRIZE) {
                continue;
            }
            outputView.printMessage(PrintingMessage.PRIZE_MESSAGE.getWithFormat(
                    prize.getSameCount(),
                    prize.getPrizeProfit(),
                    prizeReception.getPrizeCount(prize)
            ));
        }
    }

    private void printPrizeProfit(PrizeReception prizeReception, PurchaseAmount purchaseAmount) {
        outputView.printMessage(PrintingMessage.PROFIT_MESSAGE.getWithFormat(
                prizeReception.getProfitRate(purchaseAmount)
        ));
    }
}
