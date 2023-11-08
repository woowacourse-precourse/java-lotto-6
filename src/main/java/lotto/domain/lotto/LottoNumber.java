package lotto.domain.lotto;

import java.util.Objects;

public class LottoNumber {

    private final Integer number;

    public LottoNumber(Integer number) {
        validateInRange(number);
        this.number = number;
    }

    public Integer getNumber(){
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
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private void validateInRange(Integer number) {
        if (notInRange(number)) {
            throw new IllegalArgumentException(String.format("%s~%s사이의 값만 입력해주세요.",LottoConstraint.MIN,LottoConstraint.MAX));
        }
    }

    private static boolean notInRange(Integer number) {
        return !LottoConstraint.inRange(number);
    }
}
