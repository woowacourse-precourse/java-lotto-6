package lotto;

import java.util.function.IntFunction;
import java.util.stream.Stream;
import org.junit.platform.commons.util.StringUtils;

public class NumberParser {

    public static final String INPUT_BLANK_EXCEPTION = "입력 값이 공백입니다.";

    public static PurchaseAmount parsePurchaseAmount(final String inputValue) {
        validateEmpty(inputValue);
        return parse(inputValue, PurchaseAmount::from);
    }

    private static void validateEmpty(final String inputValue) {
        if (StringUtils.isBlank(inputValue)) {
            throw new IllegalArgumentException(INPUT_BLANK_EXCEPTION);
        }
    }

    private static <R> R parse(final String inputValue, IntFunction<R> changeNumber) {
        return Stream.of(inputValue)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(changeNumber::apply)
                .findFirst()
                .orElseThrow((IllegalArgumentException::new));
    }
}
