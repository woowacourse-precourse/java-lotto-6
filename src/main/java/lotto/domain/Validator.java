package lotto.domain;

import java.util.HashSet;
import java.util.List;

public abstract class Validator {

    public static void validateDuplicatedLottoNumbers(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != 6)
            throw new IllegalArgumentException(Error.DUPLICATED_ERROR.getMessage());
    }

    public static void validateBuyCash(int cash) {
        if (cash % LottoFactory.LOTTO_PRICE != 0)
            throw new IllegalArgumentException(Error.CASH_ERROR.getMessage());
    }
}
