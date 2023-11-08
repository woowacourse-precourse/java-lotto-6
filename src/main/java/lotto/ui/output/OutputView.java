package lotto.ui.output;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.ui.constant.MessageConst.AMOUNT_NOTICE;
import static lotto.ui.constant.MessageConst.HYPHEN;
import static lotto.ui.constant.MessageConst.RETURN_NOTICE_PREFIX;
import static lotto.ui.constant.MessageConst.RETURN_NOTICE_SUFFIX;
import static lotto.ui.constant.MessageConst.UNIT;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printAmountNotice(int amount) {
        spaceOneLine();
        System.out.println(amount + AMOUNT_NOTICE);
    }

    public static void printLotto(List<Integer> numbers) {
        List<Integer> changeable = new ArrayList<>(numbers);
        Collections.sort(changeable);

        System.out.println(Arrays.toString(changeable.toArray()));
    }

    public static void printWinningDetail(String description, int count) {
        System.out.println(description + HYPHEN + count + UNIT);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        DecimalFormat formatter = new DecimalFormat("###,###.#");
        String format = formatter.format(rateOfReturn);
        System.out.println(RETURN_NOTICE_PREFIX + format + RETURN_NOTICE_SUFFIX);
    }

    public static void spaceOneLine() {
        System.out.println();
    }
}
