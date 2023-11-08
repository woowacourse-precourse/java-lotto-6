package lotto.view;

import lotto.message.ProcessMessage;
import lotto.message.ResultMessage;

import java.util.List;

public class OutputView {
    public void printInputMoneyToBuyLottoMessage() {
        System.out.println(ProcessMessage.INPUT_MONEY_TO_BUY_LOTTO);
    }

    public void printBoughtLottoCount(int numberOfLottoBought) {
        printNewLine();
        System.out.printf(ProcessMessage.LOTTO_COUNT.toString(), numberOfLottoBought);
    }

    public void printLottos(List<List<Integer>> lottoNumbers) {
        printNewLine();
        lottoNumbers.forEach(System.out::println);
    }

    public void printInputWinningNumbersMessage() {
        printNewLine();
        System.out.println(ProcessMessage.INPUT_WINNING_NUMBERS);
    }

    public void printInputBonusNumberMessage() {
        printNewLine();
        System.out.println(ProcessMessage.INPUT_BONUS_NUMBER);
    }

    public void printWinningResultMessage() {
        printNewLine();
        System.out.println(ResultMessage.WINNING_STATISTICS);
        System.out.println(ResultMessage.DIVIDED_LINE);
    }

    public void printWinningResult(List<String> winningResult) {
        winningResult.forEach(System.out::println);
    }

    public void printTotalYield(double totalYield) {
        System.out.printf(ResultMessage.TOTAL_YIELD.toString(), totalYield);
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printNewLine() {
        System.out.println();
    }
}
