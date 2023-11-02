package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Parser {
    public static List<Integer> parseWinningNumber(String winningNum, String regex) {
        return new ArrayList<>(Arrays.asList(winningNum.split(regex)))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
