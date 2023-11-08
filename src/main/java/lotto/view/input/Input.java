package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.view.input.error.InputError;
import lotto.view.input.error.InputIllegalArgumentException;

public class Input {
    private static final Pattern REMOVE_REGEX_PATTERN = Pattern.compile("\\s");
    private static final String DIVIDING_STANDARD = ",";

    public static int inputNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new InputIllegalArgumentException(InputError.MUST_BE_DIGIT);
        }
    }

    public static List<Integer> inputNumbers() {
        return divideByStandard(removeSpace(Console.readLine()));
    }

    private static String removeSpace(String value) {
        return REMOVE_REGEX_PATTERN.matcher(value).replaceAll("");
    }

    private static List<Integer> divideByStandard(String value) {
        String removedSpaceValue = removeSpace(value);

        return Arrays.stream(removedSpaceValue.split(DIVIDING_STANDARD))
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }
}
