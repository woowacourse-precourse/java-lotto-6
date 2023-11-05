package lotto.parser;

import static lotto.domain.LottoCondition.LOTTO_PRICE;
import static lotto.domain.Symbols.DELIMITER;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private Parser() {
    }

    public static List<Integer> parseLotto(final String input) {
        return Arrays.stream(input.split(DELIMITER.getSymbol()))
                .map(Integer::parseInt)
                .toList();
    }

    public static int parseLottoCount(final String input) {
        return Integer.parseInt(input) / LOTTO_PRICE.getValue();
    }

    public static Integer parseBonusNumber(final String input) {
        return Integer.parseInt(input);
    }
}
