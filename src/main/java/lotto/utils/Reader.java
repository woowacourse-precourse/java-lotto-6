package lotto.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Reader {
    private Reader() {

    }

    public static String readLine() {
        return Console.readLine();
    }

    public static void close() {
        Console.close();
    }

    public static int readInteger() {
        String input = readLine().strip();
        return Integer.parseInt(input);
    }

    public static List<Integer> readIntegerList(String regex, int limit) {
        String input = readLine();

        List<Integer> numbers = Arrays.stream(input.split(regex, limit))
                .map(String::strip)
                .map(Integer::parseInt)
                .toList();

        return numbers;
    }
}
