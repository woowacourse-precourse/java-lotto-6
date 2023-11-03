package lotto.domain;

import lotto.ErrorMessage;

import java.util.HashMap;
import java.util.Map;

public class Number {

    private static final Map<Integer, Number> numberCache = new HashMap<>();

    public static final int NIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final Integer number;

    private Number(Integer number) {
        this.validateNumber(number);
        this.number = number;
        numberCache.put(this.number, this);
    }

    private void validateNumber(Integer number) {
        if (number > MAX_NUMBER || number < NIN_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_IN_RANGE.message());
        }
    }

    public static Number from(Integer number) {
        if (!numberCache.containsKey(number)) {
            new Number(number);
        }
        return numberCache.get(number);
    }

    public boolean isHit(int number) {
        return this.number == number;
    }
}
