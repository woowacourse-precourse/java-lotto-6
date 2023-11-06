package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbersMaker {
    private WinningNumbersMaker() {
    }

    public static List<String> separateNumbers(String input) {
        String[] separatedInput = input.split(",");
        return Arrays.asList(separatedInput);
    }
}
