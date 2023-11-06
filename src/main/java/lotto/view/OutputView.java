package lotto.view;

import lotto.config.WinningPrize;

import java.text.NumberFormat;
import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    public static void printBuyingCount(int count) {
        String format = ViewMessage.OUTPUT_BUYING_FORMAT.message();
        System.out.printf(format, count);
        newLine();
    }

    public static void printEachLotto(List<Integer> numbers) {
        StringJoiner sj = new StringJoiner(", ");
        numbers.stream().map(Object::toString).forEach(sj::add);
        System.out.println("[" + sj + "]");
    }

    public static void printResultTitle() {
        System.out.println(ViewMessage.OUTPUT_RESULT_TITLE_MSG.message());
    }

    public static void printEachResult(WinningPrize result, int count) {
        String format = ViewMessage.OUTPUT_RESULT_FORMAT.message();
        String message = result.message();

        NumberFormat formatter = NumberFormat.getInstance();
        String currency = formatter.format(result.prize()) + "원";

        System.out.printf(format, message, currency, count);
        newLine();
    }

    public static void printProfitResult(float profit) {
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
