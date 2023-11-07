package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final String INVALID_TYPE_ERROR_MESSAGE = "[ERROR] 로또 번호는 숫자여야 합니다.";
    private static final String INVALID_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1이상 45이하 여야 합니다.";
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final int lottoNumber;

    public LottoNumber(String lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = Integer.parseInt(lottoNumber);
    }

    private void validate(String lottoNumber) {
        if (isInvalidType(lottoNumber)) {
            throw new IllegalArgumentException(INVALID_TYPE_ERROR_MESSAGE);
        }
        if (isInvalidRange(lottoNumber)) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean isInvalidType(String target) {
        try {
            Integer.parseInt(target);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean isInvalidRange(String target) {
        int lottoNumber = Integer.parseInt(target);
        if (lottoNumber < MINIMUM_LOTTO_NUMBER || MAXIMUM_LOTTO_NUMBER < lottoNumber) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
