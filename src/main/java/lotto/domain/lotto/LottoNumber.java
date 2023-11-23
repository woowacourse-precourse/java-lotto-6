package lotto.domain.lotto;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number < 0 || number > 45) {
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
}
