package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.List;

public class Util {
    private static final int LOTTO_PRICE = 1000;
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final int LOTTO_SIZE = 6;

    public static int getLottoCount(int totalAmount) {
        return totalAmount / LOTTO_PRICE;
    }

    public static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, LOTTO_SIZE);
    }

    public static String formatCurrency(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        return decimalFormat.format(amount);
    }
}
