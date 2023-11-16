package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoValue;

import java.util.Objects;

/**
 * 로또 번호 하나 값을 포장한 클래스
 */
public class LottoNumber {
    private int number;

    public LottoNumber() {
    }

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public LottoNumber(String number) {
        number = number.trim();
        validateNumber(number);

        int num = Integer.parseInt(number);
        validateRange(num);
        this.number = num;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumber(String number) {
        // 공백 입력하면 예외 처리
        if (number.isBlank() || number == null) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_VALUE.getMessage());
        }
        // 숫자 아닌 값 입력하면 예외 처리
        if (isNotNumber(number)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private void validateRange(int number) {
        // 로또 번호 숫자 범위 아닌 값 입력하면 예외 처리
        if (isNotInRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isNotNumber(String str) {
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }

    private boolean isNotInRange(int num) {
        if (num < LottoValue.NUMBER_MIN_VALUE.getValue()) {
            return true;
        }
        if (num > LottoValue.NUMBER_MAX_VALUE.getValue()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    // LottoNumber 객체 값 비교 위해 재정의
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber lottoNumber = (LottoNumber) o;
        return number == lottoNumber.number;
    }

    // 동일한 number 가지는 객체는 동일한 해시코드 값 가지게 됨
    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
