package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.platform.commons.util.StringUtils;

public class LottoParser {

    public static final String INPUT_BLANK_EXCEPTION = "입력 값이 공백입니다.";
    public static final String NUMBER_SEPARATOR = ",";
    public static final String NOT_INTEGER_EXCEPTION = "숫지와 구분자, '" + NUMBER_SEPARATOR + "' 만 입력할 수 있습니다.";

    public static Lotto parseLotto(final String inputValue) {
        validateEmpty(inputValue);
        return parse(inputValue, Lotto::of);
    }

    private static void validateEmpty(final String inputValue) {
        if (StringUtils.isBlank(inputValue)) {
            throw new IllegalArgumentException(INPUT_BLANK_EXCEPTION);
        }
    }

    private static <R> R parse(final String inputValue, Function<List<Integer>, R> changeLotto) {
        try {
            List<Integer> numbers = Arrays.stream(inputValue.split(NUMBER_SEPARATOR))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return changeLotto.apply(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_EXCEPTION);
        }
    }
}
