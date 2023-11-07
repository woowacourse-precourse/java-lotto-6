package lotto.view;

import lotto.utils.OutputMessage;

//todo: input, output view 분리 고민
public class GameView {

    public void printInputBudgetMessage() {
        print(OutputMessage.INPUT_BUDGET.getMessage());
    }

    public void printLottosSize(int lottosSize) {
        print(String.format(OutputMessage.OUTPUT_LOTTOS_SIZE.getMessage(), lottosSize));
    }

    public void printLottosNumbers(String lottosNumbers) {
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

    public void printWinningStatistic(String winningScores){
        print(OutputMessage.OUTPUT_WINNING_STATISTIC.getMessage());
        print(winningScores);
    }

    private void print(String message) {
        System.out.print(message);
    }
}
