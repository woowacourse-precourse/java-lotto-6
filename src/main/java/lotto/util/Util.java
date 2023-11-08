package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.List;

public class Util {
    public static final int LOTTO_PRICE = 1000;
    public static final int START_RANGE = 1;
    public static final int END_RANGE = 45;
    public static final int LOTTO_SIZE = 6;

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
