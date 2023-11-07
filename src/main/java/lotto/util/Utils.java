package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Utils {

    public static List<Integer> randomUniqueNumbers(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }

    public static int stringToInteger(String string) {
        return Integer.parseInt(string);
    }

    public static List<Integer> stringToIntegerList(String[] strings) {
        return Arrays.stream(strings)
                .map(Integer::parseInt) // Convert strings to integers
                .collect(Collectors.toList());
    }


}
