package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Util {
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
}
