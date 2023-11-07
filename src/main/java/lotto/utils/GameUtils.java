package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class GameUtils {
    public static List<Integer> parse(String target) {
        return Arrays.stream(target.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
