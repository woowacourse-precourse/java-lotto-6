package lotto.validator;

import java.util.regex.Pattern;
import lotto.controller.exception.NumericInputValidationException;
import lotto.exception.InvalidInputFormatException;

/**
 * 외부로부터 받는 사용자의 입력에 대한 검증기 역할
 */
public final class InputValidator {

    /**
     * 입력이 ,로 구분된 문자열인지 검증하는 정규 표현식
     */
    private static final String COMMAS_SEPARATED_REGEX = "^(\\d+,)+\\d+$";

    /**
     * 반드시 static 메소드만 사용하도록 객체 생성 제한
     */
    private InputValidator() {
    }

    /**
     * @apiNote 검증 시, <h3 color="#bf0f4d">input은 반드시 ,로 구분된, 숫자로 이루어진 문자열이여야 합니다.</h3>
     */
    public static void validateCommasSeparatedInput(final String input) {
        if (!Pattern.matches(COMMAS_SEPARATED_REGEX, input)) {
            throw new InvalidInputFormatException();
        }
    }

    /**
     * @apiNote 검증 시, <h3 color="#bf0f4d">input은 반드시 숫자로만 이루어진 문자열이여야 합니다.</h3>
     */
    public static void validateNumericInput(final String input) {
        final char[] chars = input.toCharArray();
        for (final char ch : chars) {
            if (!Character.isDigit(ch)) {
                throw new NumericInputValidationException();
            }
        }
    }

}
