package lotto.validator;

import java.util.List;

public class WinningNumberValidator {
    private static final String WINNING_NUMBER_PATTERN = "^(?:(?:[1-9]|[1-3][0-9]|4[0-5]),){5}(?:[1-9]|[1-3][0-9]|4[0-5])$";

    public static void validateFormat(String input) throws IllegalArgumentException {
        if (!input.matches(WINNING_NUMBER_PATTERN)) {
            throw new IllegalArgumentException("[ERRPR] 당첨 번호 포맷이 잘못되었습니다.");
        }
    }

    public static void validateDuplicate(List<String> input) throws IllegalArgumentException {
        List<String> disticedNumbers = input.stream()
                .distinct()
                .toList();

        if (disticedNumbers.size() != input.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 숫자는 서로 중복되면 안됩니다.");
        }
    }
}


