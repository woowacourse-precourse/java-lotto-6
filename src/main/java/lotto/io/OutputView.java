package lotto.io;

import lotto.constant.ProgressMessage;
import lotto.domain.EarningRate;
import lotto.domain.Lottos;
import lotto.domain.WinningResult;
import lotto.formatter.OutputFormatter;

public class OutputView {

    private final OutputFormatter outputFormatter;

    public OutputView(final OutputFormatter outputFormatter) {
        this.outputFormatter = outputFormatter;
    }

    public void printPurchaseAmountRequest() {
        System.out.println(ProgressMessage.PURCHASE_AMOUNT_REQUEST.toValue());
    }

    public void printLottos(final Lottos lottos) {
        System.out.println(
                String.format(
                        ProgressMessage.PUBLISHED_NUM_OF_LOTTO.toValue(), lottos.numOfElement()));
        System.out.println(outputFormatter.formatLottos(lottos));
    }

    public void printWinningNumbersRequest() {
        System.out.println(ProgressMessage.WINNING_NUMBERS_REQUEST.toValue());
    }

    public void printBonusNumberRequest() {
        System.out.println(ProgressMessage.BONUS_NUMBER_REQUEST.toValue());
    }

    public void printResult() {
        System.out.println(ProgressMessage.RESULT_STATISTICS.toValue());
    }

    public void printWinningResult(final WinningResult winningResult) {
        System.out.println(outputFormatter.formatWinningResult(winningResult));
    }

    public void printEarningRate(final EarningRate earningRate) {
        System.out.println(
                String.format(ProgressMessage.EARNING_RATE.toValue(), earningRate.toValue()));
    }

    public void printError(final IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
