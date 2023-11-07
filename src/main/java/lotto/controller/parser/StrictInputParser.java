package lotto.controller.parser;

import java.util.Arrays;
import java.util.List;
import lotto.controller.validator.InputValidator;

/**
 * 입력 변환을 담당하는 클래스.
 * <p>
 * 변환에 실패하면 예외를 던진다는 사실을 명시하기 위해 `Strict`을 앞에 붙여주었습니다.
 */
public final class StrictInputParser {

    private static final String COMMAS = ",";

    /**
     * 외부 생성 금지
     */
    private StrictInputParser() {
    }

    /**
     * `must`가 prefix로 붙은 메소드는 모두 검증이 이루어진다는 사실을 암시.
     * <p>
     * 변환에 실패할 경우 exception throwing이 발생합니다.
     *
     * @apiNote 변환 시, <h3 color="#bf0f4d">input은 반드시 숫자로 이루어진 문자열이여야 합니다.</h3>
     */
    public static long mustParseToLong(final String input) {
        InputValidator.validateNumericInput(input);
        return Long.parseLong(input);
    }

    /**
     * @apiNote 변환 시, <h3 color="#bf0f4d">input은 반드시 숫자로 이루어진 문자열이여야 합니다.</h3>
     */
    public static int mustParseToInt(final String input) {
        InputValidator.validateNumericInput(input);
        return Integer.parseInt(input);
    }

    /**
     * @apiNote 변환 시, <h3 color="#bf0f4d">input은 반드시 ,로 구분된, 숫자로 이루어진 문자열이여야 합니다.</h3>
     */
    public static List<Integer> mustParseFromCommasSeparatedInputToIntList(final String input) {
        InputValidator.validateCommasSeparatedInput(input);
        return Arrays.stream(input.split(COMMAS))
                .map(StrictInputParser::mustParseToInt)
                .toList();
    }

}
