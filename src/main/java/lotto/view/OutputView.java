package lotto.view;

import lotto.domain.WinningGrade;
import lotto.message.ProcessMessage;

import java.util.List;
import java.util.Map;

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
        System.out.println(ProcessMessage.WINNING_STATISTICS);
        System.out.println(ProcessMessage.LINE);
    }

    public void printWinningResult(Map<WinningGrade, Integer> winningResult) {
        winningResult.entrySet().stream()
                .filter(result -> result.getKey() != WinningGrade.DEFAULT)
                .forEach(result -> System.out.println(result.getKey().toString() + result.getValue()));
    }

    public void printTotalYield(double totalYield) {
        System.out.printf(ProcessMessage.TOTAL_YIELD.toString(), totalYield);
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printNewLine() {
        System.out.println();
    }
}
