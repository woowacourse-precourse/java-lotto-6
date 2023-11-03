package lotto.view.output;

import lotto.domain.lotto.Lotto;

import java.util.List;

import static java.util.stream.Collectors.*;

public enum LottoNumberPresentation {
    DELIMITER(", "),
    PREFIX("["),
    SUFFIX("]");

    private String joinConstants;

    LottoNumberPresentation(String joinConstants) {
        this.joinConstants = joinConstants;
    }

    public static String getLottoNumbersAsString(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        return numbers.stream()
                .map(String::valueOf)
                .collect(joining(DELIMITER.joinConstants, PREFIX.joinConstants, SUFFIX.joinConstants));
    }
}
