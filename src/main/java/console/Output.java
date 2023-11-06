package console;

import consts.ConsoleMessage;

import java.util.List;
import java.util.Objects;

public class Output {
    private Output() {
    }

    public static Output create() {
        return new Output();
    }

    public void askPurchaseAmount() {
        System.out.println(ConsoleMessage.ASK_PURCHASE_AMOUNT);
    }

    public void showPurchasedLotto(final int count, final List<Objects> lottoNumbers) {
        this.printNewLine();
        System.out.println(String.format(ConsoleMessage.PURCHASED_LOTTO_COUNT, count));

        // TODO : 로또 넘버 생성 로직 구현 후 작성
    }

    public void askWinningNumber() {
        this.printNewLine();
        System.out.println(ConsoleMessage.ASK_WINNING_NUMBER);
    }

    public void askBonusNumber() {
        this.printNewLine();
        System.out.println(ConsoleMessage.ASK_BONUS_NUMBER);
    }

    public void showWinningStatistics(final List<Objects> results, final double profitRate) {
        System.out.println(ConsoleMessage.WINNING_STATISTICS);
        // TODO : 결과 데이터 생성 로직 구현 후 작성
        System.out.println(String.format(ConsoleMessage.WINNING_STATISTICS_PROFIT_RATE, profitRate));
    }

    public void showErrorMessage(final String message) {
        System.out.println(String.format(ConsoleMessage.ERROR_MESSAGE, message));

    }

    private void printNewLine() {
        System.out.println();
    }
}
