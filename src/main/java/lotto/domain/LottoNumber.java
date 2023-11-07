package lotto.domain;

public class LottoNumber {
public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber create(int number) {
        return new LottoNumber(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }

    public int getNumber() {
        return number;
    }
}
