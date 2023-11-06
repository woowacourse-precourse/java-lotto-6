package lotto.domain;

public class LottoNumber {
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber create(int number) {
        return new LottoNumber(number);
    }

    public int getNumber() {
        return number;
    }
}
