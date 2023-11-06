package lotto.validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.util.CharacterUnits.COMMA;
import static lotto.util.CharacterUnits.PATTERN;

public class InputValidator {

    private static final Pattern pattern = Pattern.compile(PATTERN.getUnit());

    public static void validateNumber(String input) {
        for (char token : input.toCharArray()) {
            isNumberToken(token);
        }
    }

    private static void isNumberToken(Character token) {
        if (!(Character.isDigit(token))) {
            throw new IllegalArgumentException("[ERROR] 입력값에 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    public static void validateBlank(String input) {
        if (input.isBlank() || input == null) {
            throw new IllegalStateException("[ERROR] 입력값을 입력하지 않았습니다.");
        }

    }

    public static void validateInputNumbersFormat(List<String> numbers) {
        validateSpecialSign(numbers);
        validateNumbers(numbers);
    }

    private static void validateNumbers(List<String> numbers) {
        for (String number : numbers) {
            validateNumber(number);
        }
    }

    private static void validateSpecialSign(List<String> numbers) {
        for (String number : numbers) {
            isSpecialSignToken(number);
        }
    }

    private static void isSpecialSignToken(String number) {
        if (pattern.matcher(number)
                .find()) {
            throw new IllegalArgumentException("[ERROR] 입력값에 구분자인,(쉼표) 이 외의 특수문자를 허용하지 않습니다.");
        }

    }

}
