package lotto.domain;

import java.util.List;

public enum LottoNumbersRule {

    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_NUMBERS_SIZE(6);

    private final int value;

    LottoNumbersRule(final int value) {
        this.value = value;
    }

    public static boolean hasOutOfRangeNumber(final int number) {
        return number < MIN_NUMBER.value || number > MAX_NUMBER.value;
    }

    public static boolean isLottoNumbersSizeMismatched(final List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBERS_SIZE.value;
    }

    public int value() {
        return value;
    }

}
