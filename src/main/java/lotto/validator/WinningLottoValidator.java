package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.util.NumberSplitter;

public class WinningLottoValidator implements Validator <String> {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final String WINNING_LOTTO_NUMERIC_REGEX =
            "^(?:45|[1-9]|[1-3][0-9]|4[0-4])(?:,(?:45|[1-9]|[1-3][0-9]|4[0-4])){5}$";
    private static final String WINNING_LOTTO_COMMA_REGEX = "^[^,]+(,[^,]+)*$";
    private static final Pattern NUMERIC_PATTERN = Pattern.compile(WINNING_LOTTO_NUMERIC_REGEX);
    private static final Pattern COMMA_PATTERN = Pattern.compile(WINNING_LOTTO_COMMA_REGEX);
    private static final String WINNING_LOTTO_NUMERIC_ERROR_MESSAGE =
            String.format("[ERROR] %d부터 %d까지의 자연수와 콤마만 입력할 수 있습니다.",
            LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX);
    private static final String WINNING_LOTTO_COMMA_ERROR_MESSAEGE =
            "[ERROR] 첫 번째 또는 마지막 문자의 콤마 또는 연속된 콤마는 입력할 수 없습니다.";
    private static final String WINNING_LOTTO_UNIQUE_ERROR_MESSAGE = "[ERROR] 중복된 번호는 입력할 수 없습니다.";

    @Override
    public String validate(String input) {
        comma(input);
        numericWithComma(input);
        unique(NumberSplitter.splitNumbers(input));
        return input;
    }

    private void numericWithComma(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(WINNING_LOTTO_NUMERIC_ERROR_MESSAGE);
        }
    }

    private void comma(String input) {
        if (!COMMA_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(WINNING_LOTTO_COMMA_ERROR_MESSAEGE);
        }
    }

    private void unique(List<String> splitNumbers) {
        Set<String> uniqueNumbers = new HashSet<>();

        for (String number : splitNumbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(WINNING_LOTTO_UNIQUE_ERROR_MESSAGE);
            }
        }
    }
}
