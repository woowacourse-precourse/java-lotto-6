package lotto.view.input.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.LottoSymbol.LOTTO_SEPARATOR;

public class numberParser {
    public static int parseInteger(String userInput) {
        return Integer.parseInt(userInput);
    }

    public static List<Integer> separateIntegers(String userInput) {
        return Arrays.stream(userInput.split(LOTTO_SEPARATOR.getValue()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
