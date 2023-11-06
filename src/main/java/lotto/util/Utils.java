package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public final class Utils {

    public static List<Integer> randomUniqueNumbers(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }

    public static int stringToInteger(String string) {
        return Integer.parseInt(string);
    }


}
