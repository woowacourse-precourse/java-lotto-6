package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Util {
    private static final int lottoAmount = 1000;

    public static int getLottoCount(int totalAmount) {
        return totalAmount / lottoAmount;
    }

    public static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
