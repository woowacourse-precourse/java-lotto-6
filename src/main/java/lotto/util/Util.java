package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    private static final String COMMA = ",";

    private Util() {
    }

    public static List<Integer> createRandomNumberList(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }

    public static List<Integer> sortListAscending(List<Integer> list) {
        List<Integer> ascending = new ArrayList<>(list);
        ascending.sort(Comparator.naturalOrder());
        return ascending;
    }

    public static List<Integer> splitInputNumbers(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int stringToInt(String input) {
        return Integer.parseInt(input);
    }
}
