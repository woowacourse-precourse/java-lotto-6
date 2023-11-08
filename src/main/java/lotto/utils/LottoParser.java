package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.domain.exception.inputException.InputBlankException;
import lotto.domain.exception.inputException.InputNotIntegerException;
import lotto.domain.lottoTicket.Lotto;
import org.junit.platform.commons.util.StringUtils;

public class LottoParser {

    public static final String NUMBER_SEPARATOR = ",";

    public static Lotto parseLotto(final String inputValue) {
        validateEmpty(inputValue);
        return parse(inputValue, Lotto::of);
    }

    private static void validateEmpty(final String inputValue) {
        if (StringUtils.isBlank(inputValue)) {
            throw new InputBlankException();
        }
    }

    private static <R> R parse(final String inputValue, Function<List<Integer>, R> changeLotto) {
        try {
            List<Integer> numbers = Arrays.stream(inputValue.split(NUMBER_SEPARATOR, -1))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return changeLotto.apply(numbers);
        } catch (NumberFormatException e) {
            throw new InputNotIntegerException();
        }
    }
}
