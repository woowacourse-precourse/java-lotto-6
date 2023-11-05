package lotto.model;

import java.util.Objects;

public class LottoNumber {
    public static final int MIN = 1;
    public static final int MAX = 45;
    public static final int SIZE = 6;
    private final Integer number;

    public LottoNumber(Integer number) {
        validRange(number);
        this.number = number;
    }

    private void validRange(Integer number){
        if(number < MIN || number > MAX){
            throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45까지 입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
