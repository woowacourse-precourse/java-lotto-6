package lotto.domain;

import static lotto.global.constants.NumberType.MAX_LOTTO_NUMBER;
import static lotto.global.constants.NumberType.MIN_LOTTO_NUMBER;

import java.util.Objects;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

/**
 * 로또의 단일 번호를 저장하는 클래스
 */
public class Number {
    private int value;

    private Number(final int value) {
        Validator.validate(value);
        this.value = value;
    }

    /**
     * 로또의 단일 번호를 저장하는 객체를 생성하는 메서드
     *
     * @param value 로또의 단일 번호
     * @return Number 객체
     */
    public static Number valueOf(final int value) {
        return new Number(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number other = (Number) o;
        return value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int getValue() {
        return this.value;
    }

    private static class Validator {
        private static void validate(final int value) {
            validateInvalidRange(value);
        }

        private static void validateInvalidRange(final int value) {
            if (isInvalidRange(value)) {
                throw LottoException.from(ErrorMessage.INVALID_RANGE_ERROR);
            }
        }

        private static boolean isInvalidRange(final int value) {
            return value < MIN_LOTTO_NUMBER.getValue() || value > MAX_LOTTO_NUMBER.getValue();
        }
    }
}
