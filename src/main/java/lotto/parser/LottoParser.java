package lotto.parser;

import lotto.model.Lotto;
import lotto.validator.InputPriceValidator;

import java.util.Arrays;
import java.util.List;

import static lotto.validator.InputLottoValidator.validateLotto;

public class LottoParser {
    private static final String DELIMITER = ",";
    private LottoParser() {
    }
    public static Lotto parse(final String winningLotto) {
        validateLotto(winningLotto);
        return new Lotto(parseNumbers(winningLotto));
    }

    private static List<Integer> parseNumbers(String winningLotto) {
        return Arrays.stream(winningLotto.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
