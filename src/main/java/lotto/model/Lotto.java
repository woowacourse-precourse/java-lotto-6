package lotto.model;

import java.util.List;

public class Lotto {
    private static final Integer LOTTO_SIZE = 6;
    private static final String LOTTO_SIZE_ERROR = "[ERROR] 로또 번호 갯수는 6개여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }
    }

}
