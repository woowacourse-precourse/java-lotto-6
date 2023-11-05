package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    int number;

    public LottoNumber(int number) {
        validateNumber();
        this.number = number;
    }

    public static LottoNumber createLottoNumber(String number) {
        validateNumber();
        return new LottoNumber(Integer.parseInt(number));
    }

    private static void validateNumber() {
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber lottoNumber1)) {
            return false;
        }
        return getNumber() == lottoNumber1.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
