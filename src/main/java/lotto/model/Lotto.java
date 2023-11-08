package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.Constants;
import lotto.utils.ErrorMessage;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        validate(lotto);
        this.lotto = lotto;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
        if (numbers.stream().distinct().count() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getLotto() {
        return new ArrayList<>(lotto);
    }
}
