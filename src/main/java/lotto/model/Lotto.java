package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final String INVALID_LOTTO_SIZE = "[ERROR] 로또 번호 개수가 6개가 아닙니다.";
    private static final String INVALID_DUPLICATE = "[ERROR] 로또 번호에 중복이 있습니다.";
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        validate(lotto);
        this.lotto = lotto;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE);
        }
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_DUPLICATE);
        }
    }

    public List<Integer> getLotto() {
        return new ArrayList<>(lotto);
    }
}
