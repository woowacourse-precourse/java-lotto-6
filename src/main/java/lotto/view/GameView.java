package lotto.view;

import lotto.utils.OutputMessage;

public class GameView {
    private volatile static GameView INSTANCE;

    private GameView() {
    }

    public static GameView getInstance() {
        if (INSTANCE == null) {
            synchronized (GameView.class) {
                createInstance();
            }
        }

        return INSTANCE;
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameView();
        }
    }

    public void printInputBudgetMessage() {
        print(OutputMessage.INPUT_BUDGET.getMessage());
    }

    public void printLottosSize(final String lottosSize) {
        print(String.format(OutputMessage.OUTPUT_LOTTOS_SIZE.getMessage(), lottosSize));
    }

    public void printLottosNumbers(final String lottosNumbers) {
        StringBuilder sb = new StringBuilder(lottosNumbers);
        sb.append("\n\n");

        print(sb.toString());
    }

    public void printInputWinningNumbersMessage() {
        print(OutputMessage.INPUT_WINNING_NUMBERS.getMessage());
    }

    public void printInputBonusNumberMessage() {
        print(OutputMessage.INPUT_BONUS_NUMBER.getMessage());
    }

    public void printWinningStatistic(final String winningScores) {
        print(OutputMessage.OUTPUT_WINNING_STATISTIC.getMessage());
        print(winningScores);
    }

    public void printProfitRatio(final double roi) {
        print(String.format(OutputMessage.OUTPUT_ROI.getMessage(), roi));
    }

    private void print(final String message) {
        System.out.print(message);
    }
}
