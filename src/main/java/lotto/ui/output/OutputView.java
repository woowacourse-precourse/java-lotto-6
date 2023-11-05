package lotto.ui.output;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.ui.constant.MessageConst.AMOUNT_NOTICE;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printAmountNotice(long amount) {
        System.out.println(amount + AMOUNT_NOTICE);
    }

    public static void printLotto(List<Integer> numbers) {
        Collections.sort(numbers);
        System.out.println(Arrays.toString(numbers.toArray()));
    }

    //TODO 상수화?
    public static void printWinningDetail(String description, int count) {
        System.out.println(description + " - " + count + "개");
    }

    //TODO 상수화?
    public static void printRateOfReturn(double rateOfReturn) {
        String format = String.format("%.1f", rateOfReturn);
        System.out.println("총 수익률은 " + format + "%입니다.");
    }
}
