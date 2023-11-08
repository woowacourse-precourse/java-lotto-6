package lotto.view;

import java.util.List;
import lotto.message.RunMessage;

public class OutputView {
    public void printAmountInputMessage() {
        System.out.print(RunMessage.INPUT_AMOUNT_MESSAGE.getMessage());
    }

    public void printBuyLottoMessage(int lottoCount) {
        System.out.printf(RunMessage.PRINT_LOTTO_COUNT.getMessage(), lottoCount);
    }

    public void printLottoNumber(List<Integer> numbers) {
        System.out.println(numbers.toString());
    }

    public void printWinningNumberInputMessage() {
        System.out.print(RunMessage.INPUT_WINNING_MESSAGE.getMessage());
    }

    public void printBonusNumberInputMessage() {
        System.out.print(RunMessage.INPUT_BONUS_MESSAGE.getMessage());
    }

    public void printWinningStatisticsMessage(int first, int second, int third, int fourth, int fifth, double yield) {
        System.out.print(RunMessage.PRINT_WINNING_STATISTIC_MESSAGE.getMessage());
        System.out.printf(RunMessage.PRINT_WINNING_FIFTH.getMessage(), fifth);
        System.out.printf(RunMessage.PRINT_WINNING_FOURTH.getMessage(), fourth);
        System.out.printf(RunMessage.PRINT_WINNING_THIRD.getMessage(), third);
        System.out.printf(RunMessage.PRINT_WINNING_SECOND.getMessage(), second);
        System.out.printf(RunMessage.PRINT_WINNING_FIRST.getMessage(), first);
        System.out.printf(RunMessage.PRINT_WINNING_STATISTIC.getMessage(), yield);
    }
}
