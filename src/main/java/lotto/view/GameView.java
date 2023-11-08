package lotto.view;

import lotto.utils.OutputMessage;

public class GameView {

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

    public void printROI(final double roi) {
        print(String.format(OutputMessage.OUTPUT_ROI.getMessage(), roi));
    }

    private void print(final String message) {
        System.out.print(message);
    }
}
