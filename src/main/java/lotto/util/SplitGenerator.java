package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.constant.ValidatorMessage;
import lotto.model.Lotto;

public class SplitGenerator {
    private final static String delimiter = ",";

    private final Lotto lotto;

    public SplitGenerator(String lotto) {
        validate(lotto);

        this.lotto = new Lotto(split(lotto));
    }

    public void validate(String lotto) {
        validateIsNull(lotto);
        validateIsNonContainsComma(lotto);
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    private List<Integer> split(String lotto) {
        String[] splitLotto = lotto.split(delimiter);

        try {
            return Arrays.stream(splitLotto)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_LOTTO_NUMERIC);
        } catch (NullPointerException exception) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_IS_NULL);
        }
    }

    private void validateIsNonContainsComma(String lotto) {
        if (!lotto.contains(delimiter)) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_WIN_NUMBER_IS_NUMERIC);
        }
    }

    private void validateIsNull(String lotto) {
        if (lotto == null || lotto.isEmpty()) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_IS_NULL);
        }
    }
}
