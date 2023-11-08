package lotto.utils;

import lotto.constant.ConsoleMessage;
import lotto.constant.LottoNumberRange;
import lotto.model.Lotto;
import lotto.model.Capital;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringUtil {

    public static Capital stringToCapital(String input) {
        if (containsThousandSeparator(input)) {
            validateCommaAtPosition(input);
            input = removeComma(input);
        }

        int amount = 0;

        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ConsoleMessage.LOTTO_OUT_OF_RANGE_ERROR_MESSAGE);
        }

        return new Capital(amount);
    }

    protected static boolean containsThousandSeparator(String input) {
        return input.contains(",");
    }

    protected static void validateCommaAtPosition(String input) {
        String regex = "^[0-9]{1,3}(,[0-9]{3})*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(ConsoleMessage.INVALID_INPUT_FORMAT_ERROR_MESSAGE);
        }
    }

    protected static String removeComma(String input) {
        return input.replaceAll(",", "");
    }

    public static Lotto stringToLottery(String input) {
        List<Integer> numbers = splitWithStrip(input)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        return new Lotto(numbers);
    }

    protected static Stream<String> splitWithStrip(String input) {
        return Arrays.stream(input.split(","))
                .map(String::strip);
    }

    public static int stringToInt(String input) {
        try {
            int result = Integer.parseInt(input.strip());

            if (result < LottoNumberRange.MIN.getValue() || result > LottoNumberRange.MAX.getValue()) {
                throw new IllegalArgumentException(ConsoleMessage.LOTTO_OUT_OF_RANGE_ERROR_MESSAGE);
            }

            return result;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ConsoleMessage.LOTTO_OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

}
