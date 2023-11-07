package lotto.domain.number;

import lotto.ErrorMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoNumber {

    private static final Map<Integer, LottoNumber> numberCache = new HashMap<>();

    public static final int NIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final Integer lottoNumber;

    private LottoNumber(Integer lottoNumber) {
        this.validateNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
        numberCache.put(this.lottoNumber, this);
    }

    private void validateNumber(Integer number) {
        if (number > MAX_NUMBER || number < NIN_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_IN_RANGE.message());
        }
    }

    public static LottoNumber from(Integer number) {
        if (!numberCache.containsKey(number)) {
            new LottoNumber(number);
        }
        return numberCache.get(number);
    }

    public boolean isHit(List<Integer> numbers) {
        return numbers.contains(lottoNumber);
    }
}
