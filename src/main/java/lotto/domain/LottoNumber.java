package lotto.domain;

import lotto.enums.ErrorMessages;
import lotto.enums.LottoEnum;
import lotto.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    static {
        IntStream.range(LottoEnum.MIN_LOTTO_NUMBER.getValue(), LottoEnum.MAX_LOTTO_NUMBER.getValue() + 1)
                .forEach(i -> lottoNumberCache.put(i, new LottoNumber(i)));
    }
    private final int number;

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber valueOf(String stringNumber) {
        return LottoNumber.valueOf(StringUtil.stringToInt(stringNumber));
    }

    public static LottoNumber valueOf(int number) {
        return lottoNumberCache.get(number);
    }

    public int getNumber() {
        return this.number;
    }

    private void validate(int number) {
        if (number < LottoEnum.MIN_LOTTO_NUMBER.getValue()
                || number > LottoEnum.MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }
}
