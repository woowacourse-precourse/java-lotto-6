package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGameInputer {
    public static String input() {
        return Console.readLine();
    }

    public static Integer inputToInteger() {
        return Integer.parseInt(input());
    }

    public static List<Integer> convertCommaSeparatedValuesToList() {
        return Arrays.stream(input().split(","))
                .filter(value -> !value.isEmpty())
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
