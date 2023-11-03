package lotto.domain.lotto;

import java.util.List;

import static java.util.stream.Collectors.*;

public enum SupportedLotto {
    DELIMITER(", "),
    PREFIX("["),
    SUFFIX("]");

    private String joinConstants;

    SupportedLotto(String joinConstants) {
        this.joinConstants = joinConstants;
    }

    public static String getLottoNumbersAsString(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        return numbers.stream()
                .map(String::valueOf)
                .collect(joining(DELIMITER.joinConstants, PREFIX.joinConstants, SUFFIX.joinConstants));
    }
}
