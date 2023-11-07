package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(String lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = Integer.parseInt(lottoNumber);
    }
    private void validate(String lottoNumber) {
        if (isInvalidType(lottoNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
        if (isInvalidRange(lottoNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하 입니다.");
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
        if (lottoNumber < 1 || 45 < lottoNumber) {
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
