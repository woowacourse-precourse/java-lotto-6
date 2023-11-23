package lotto.domain.lotto.entity;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            //todo
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }

    public int getNumber() {
        return number;
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
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
