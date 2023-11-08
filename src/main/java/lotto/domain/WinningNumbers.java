package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<String> numbers;
    private static final String CONSECUTIVE_COMMA_ERROR_MESSAGE = "[ERROR] 입력에 쉼표가 연속해서 있습니다.";
    private static final String SPECIAL_CHARACTER_ERROR_MESSAGE = "[ERROR] 쉼표를 제외한 특수문자는 사용할 수 없습니다.";
    private static final String SPACE_ERROR_MESSAGE = "[ERROR] 쉼표 앞뒤에 공백이 있습니다.";
    private static final String LEADING_TRAILING_COMMA_ERROR_MESSAGE = "[ERROR] 입력 맨 앞, 또는 맨 뒤에 쉼표가 있습니다.";
    private static final Pattern WINNING_NUMBERS_REGEX = Pattern.compile("^(\\s*\\d+\\s*,\\s*)*\\d+\\s*$");

    public WinningNumbers(List<String> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<String> numbers) {
        validateLotto(numbers);
        validateConsecutiveCommas(numbers);
        validateSpecialCharacters(numbers);
        validateSpaceAroundCommas(numbers);
        validateLeadingTrailingCommas(numbers);
    }

    protected void validateLotto(List<String> numbers) {
        List<Integer> integerList = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(integerList);
        lotto.validate(integerList);
    }

    protected void validateConsecutiveCommas(List<String> numbers) {
        String winningNumbersString = numbers.toString().replaceAll("\\s*,\\s*", ",");
        if (winningNumbersString.contains(",,") || winningNumbersString.startsWith(",") || winningNumbersString.endsWith(",")) {
            throw new IllegalArgumentException(CONSECUTIVE_COMMA_ERROR_MESSAGE);
        }
    }

    protected void validateSpecialCharacters(List<String> numbers) {
        String winningNumbersString = numbers.toString().replaceAll("\\s*,\\s*", ",");
        if (!WINNING_NUMBERS_REGEX.matcher(winningNumbersString).matches()) {
            throw new IllegalArgumentException(SPECIAL_CHARACTER_ERROR_MESSAGE);
        }
    }

    protected void validateSpaceAroundCommas(List<String> numbers) {
        String winningNumbersString = numbers.toString().replaceAll("\\s*,\\s*", ",");
        if (winningNumbersString.contains(" ,") || winningNumbersString.contains(", ") || winningNumbersString.startsWith(" ") || winningNumbersString.endsWith(" ")) {
            throw new IllegalArgumentException(SPACE_ERROR_MESSAGE);
        }
    }

    protected void validateLeadingTrailingCommas(List<String> numbers) {
        String winningNumbersString = numbers.toString().replaceAll("\\s*,\\s*", ",");
        if (winningNumbersString.startsWith(",") || winningNumbersString.endsWith(",")) {
            throw new IllegalArgumentException(LEADING_TRAILING_COMMA_ERROR_MESSAGE);
        }
    }

    public List<String> getNumbers() {
        return numbers;
    }
}
