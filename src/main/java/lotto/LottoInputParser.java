package lotto;

import java.util.Arrays;
import java.util.List;

public class LottoInputParser {

    private static final String NUMBER_DELIMITER = ",";

    public List<Integer> parseIntegerList(String input) {
        validateNotEmpty(input);

        String[] splitInput = input.split(NUMBER_DELIMITER);
        if (splitInput.length == 0) {
            throw new IllegalArgumentException("빈 배열입니다. 입력값: " + input);
        }

        try {
            return Arrays.stream(splitInput)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 배열로 변환할 수 없습니다. 입력값: " + input);
        }
    }

    public int parseInt(String input) {
        validateNotEmpty(input);

        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없습니다. 입력값: " + input);
        }
    }

    private void validateNotEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }
}
