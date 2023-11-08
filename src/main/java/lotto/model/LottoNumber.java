package lotto.model;

public record LottoNumber(int number) {

    @Override
    public boolean equals(Object lottoNumber) {
        if (this == lottoNumber) {
            return true;
        }
        if (lottoNumber == null || getClass() != lottoNumber.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) lottoNumber;
        return number == that.number;
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
