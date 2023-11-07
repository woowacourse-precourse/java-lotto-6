package lotto.view;

import lotto.config.WinningPrize;

import java.text.NumberFormat;
import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String PRIZE_UNIT = "원";
    private static final String BRACKET_LEFT = "[";
    private static final String BRACKET_RIGHT = "]";
    private static final String DELIMITER = ", ";

    public static void printBuyingCount(int count) {
        String format = ViewMessage.OUTPUT_BUYING_FORMAT.message();
        System.out.printf(format, count);
        newLine();
    }

    public static void printEachLotto(List<Integer> numbers) {
        StringJoiner sj = new StringJoiner(DELIMITER);
        numbers.stream().map(Object::toString).forEach(sj::add);
        System.out.println(BRACKET_LEFT + sj + BRACKET_RIGHT);
    }

    public static void printResultTitle() {
        System.out.println(ViewMessage.OUTPUT_RESULT_TITLE_MSG.message());
    }

    public static void printEachResult(WinningPrize result, int count) {
        String format = ViewMessage.OUTPUT_RESULT_FORMAT.message();
        String message = result.message();

        NumberFormat formatter = NumberFormat.getInstance();
        String currency = formatter.format(result.prize()) + PRIZE_UNIT;

        System.out.printf(format, message, currency, count);
        newLine();
    }

    public static void printProfitResult(double profit) {
        String format = ViewMessage.OUTPUT_PROFIT_FORMAT.message();
        System.out.printf(format, profit);
        newLine();
    }

    public static void printErrorMessage(Exception error) {
        newLine();
        System.out.println(error.getMessage());
        newLine();
    }

    public static void newLine() {
        System.out.println();
    }
}
