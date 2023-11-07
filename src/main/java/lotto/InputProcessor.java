package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputProcessor {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    public Integer toPaidAmount(String input) {
        input = input.trim();
        validateNotNull(input);
        return toNumber(input.trim());
    }

    public List<Integer> toWinningNumbers(String input) {
        input = input.trim();
        validateNotNull(input);
        return parseWith(input, ",");
    }

    public Integer toBonusNumber(String input) {
        input = input.trim();
        validateNotNull(input);
        return toNumber(input.trim());
    }

    private void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 입력한 게 null입니다.");
        }
    }

    private Integer toNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

    private List<Integer> parseWith(String input, String mark) {
        return Arrays.stream(input.split(mark))
                .map(String::trim)
                .map(this::toNumber)
                .toList();
    }

}
