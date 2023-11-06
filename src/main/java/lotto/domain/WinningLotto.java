package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WinningLotto {
    private static final String REGEX_INPUT_FORMAT = "^[0-9,]+$";
    private static final String DELIMITER = ",";

    private final Lotto lotto;

    public WinningLotto(String winningLotto) {
        this.lotto = new Lotto(toIntList(winningLotto));
    }

    public Lotto getLotto() {
        return lotto;
    }

    private List<Integer> toIntList(String winningLotto) {
        validate(winningLotto);
        return Arrays.stream(winningLotto.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private void validate(String winningLotto) {
        if (!containOnlyNumberAndComma(winningLotto)) {
            ErrorMessage.LOTTO_NUMBER_IS_NOT_NUMBER_OR_COMMA.throwIllegalArgumentException();
        }
    }

    private boolean containOnlyNumberAndComma(String winningLotto) {
        return Pattern.matches(REGEX_INPUT_FORMAT, winningLotto);
    }
}
