package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WinningLotto {
    private final Lotto lotto;

    public WinningLotto(String winningLotto) {
        this.lotto = new Lotto(toIntList(winningLotto));
    }

    public Lotto getLotto() {
        return lotto;
    }

    private List<Integer> toIntList(String winningLotto) {
        validate(winningLotto);
        return Arrays.stream(winningLotto.split(LottoConstant.DELIMITER))
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
        return Pattern.matches(LottoConstant.REGEX_INPUT_FORMAT, winningLotto);
    }
}
