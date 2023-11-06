package lotto.view;

import lotto.domain.Game;
import lotto.domain.proxy.PrizeHandler;
import lotto.utils.RandomGenerator;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static String MESSAGE = "[ERROR]";
    private final InputView inputView;
    private final RandomGenerator randomGenerator;
    private final PrizeHandler prizeHandler;
    private Game game;

    public OutputView(InputView inputView, RandomGenerator randomGenerator, PrizeHandler prizeHandler, Game game) {
        this.inputView = inputView;
        this.randomGenerator = randomGenerator;
        this.prizeHandler = prizeHandler;
        this.game = game;
    }
    public void start() {
        while (MESSAGE.contains(ERROR_MESSAGE)) {
            runException();
        }
        inputView.close();
    }

    private void runException() {
        try {
            run();
            MESSAGE = "";
        } catch (IllegalArgumentException e) {
            handleException(e.getMessage());
        }
    }

    private void run() {
        if (game.isNotLotteryCreated()) {
            investedAmountAndPrintRandomLotto();
        }

        if (game.isNotWinningNumber()) {
            winningNumber();
        }

        if (game.isNotBonusNumber()) {
            bonusNumber();
        }

        if (game.isNotPaperCreated()) {
            game.createPaper();
        }

        game.calculate(prizeHandler);

        printWinningStatistics();
        printEarnRate(game.getInvestedAmount());
    }

    private void bonusNumber() {
        inputView.inputBonusNumber();
        game.createBonusNumber(inputView);
    }

    private void winningNumber() {
        inputView.inputWinningNumber();
        game.createWinningNumber(inputView);
    }

    private void investedAmountAndPrintRandomLotto() {
        inputView.investMoney();
        game.createLottery(inputView, randomGenerator);
        inputView.printLottoCount(game.getLottoCount());
        game.printLottery(inputView);
        inputView.printlnWithoutMessage();
    }


    private void printWinningStatistics() {
        inputView.printWinningStatistics();
        inputView.print(prizeHandler.printWinningStatistics());
    }

    private void printEarnRate(int amount) {
        double earnRate = prizeHandler.earnRate(amount);
        inputView.printEarnRate(earnRate);
    }

    private void handleException(String message) {
        inputView.println(message);
        MESSAGE = message;
    }
}
