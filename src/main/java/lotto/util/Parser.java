package lotto.util;

import java.util.List;

public class Parser {
    public static int convertInt (String input) {
        return Integer.parseInt(input);
    }
    public static List<String> splitComma (String input) {
        return List.of(input.split(","));
    }

}
