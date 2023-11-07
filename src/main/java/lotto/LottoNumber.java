package lotto;

import constants.ErrorMessage;
import constants.NumberType;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    static {
        IntStream.range(NumberType.MIN_LOTTO_NUMBER.getValue(), NumberType.MAX_LOTTO_NUMBER.getValue() + 1)
                .forEach(i -> lottoNumberCache.put(i, new LottoNumber(i)));
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateLottoNumberInRange(number);
        return lottoNumberCache.get(number);
    }

    public int getNumber() {
        return number;
    }

    private static void validateLottoNumberInRange(int number) {
        if (!checkLottoNumberInRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NOT_IN_RANGE_ERROR.getMessage());
        }
    }

    private static boolean checkLottoNumberInRange(int number) {
        return number >= NumberType.MIN_LOTTO_NUMBER.getValue() && number <= NumberType.MAX_LOTTO_NUMBER.getValue();
    }
}
