package lotto.domain.common;


import lotto.exception.Lotto.LottoNotSizeSixException;

import java.util.List;


public record Lotto(List<Integer> numbers) {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_SIZE = 6;


    public Lotto {
        validateLottoSize(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new LottoNotSizeSixException();
        }
    }


}