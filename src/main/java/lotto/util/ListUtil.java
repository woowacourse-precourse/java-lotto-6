package lotto.util;

import java.util.Arrays;
import java.util.List;

public class ListUtil {

    private ListUtil() {
    }

    public static List<Integer> StringArrayToList(String[] split) {
        return Arrays.stream(split)
            .map(Integer::parseInt)
            .toList();
    }

}
