package lotto.view;

import static lotto.util.Constant.COMMA;
import static lotto.util.Constant.REGEX_NOSPACE;
import static lotto.util.Constant.REGEX_SPACE;
import static lotto.util.Constant.REGEX_THOSAND_SEPARATOR;
import static lotto.util.Constant.REGEX_WINNING_NUMBERS_NUMERIC;
import static lotto.util.ErrorMessage.ERROR_WINNING_NUMBERS_NUMERIC;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static String readLine() {
        return Console.readLine();

    }

    public static List<String> split(String input) {
        return Arrays.stream(input.split(COMMA))
                .collect(Collectors.toList());
    }

    public static List<Integer> InputWinningNumbers(String input) {
        if (!REGEX_WINNING_NUMBERS_NUMERIC.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_NUMERIC);
        }

        return Arrays.stream(stringWithoutSpace(input).split(COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String stringWithoutSpace(String input) {
        return input.replaceAll(REGEX_SPACE, REGEX_NOSPACE);
    }

    public static String thosandSeparator(int prizeMoney) {
        return String.valueOf(prizeMoney).replaceAll(REGEX_THOSAND_SEPARATOR, COMMA);
    }
}
