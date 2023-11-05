package lotto.parser;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final int LOTTO_PRICE = 1000;
    private static final String DELIMITER = ",";

    private Parser() {
    }

    public static List<Integer> parseLotto(final String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public static int parseLottoCount(final String input) {
        return Integer.parseInt(input) / LOTTO_PRICE;
    }

    public static Integer parseBonusNumber(final String input) {
        return Integer.parseInt(input);
    }
}
