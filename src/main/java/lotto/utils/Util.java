package lotto.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static List<Integer> stringToIntegerList(String[] string) {
        return Arrays.stream(string)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static String readLine() {
        return Console.readLine();
    }
}
