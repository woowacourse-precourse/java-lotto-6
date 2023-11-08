package lotto.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sorting {

    public static List<Integer> getListNaturalOrder(List<Integer> list) {
        List<Integer> ordered = new ArrayList<>(list);
        ordered.sort(Comparator.naturalOrder());
        return ordered;
    }
}
