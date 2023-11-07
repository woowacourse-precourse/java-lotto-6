package lotto.domain;

import java.util.Objects;

import static lotto.util.Instruction.ERROR_WRONG_LOTTO_NUMBER_RANGE;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private final int lottoNumber;

    public LottoNumber(final int number) {
        isValidRange(number);
        this.lottoNumber = number;
    }

    public LottoNumber(final String number) {
        isValidInt(number);
        isValidRange(Integer.parseInt(number));
        this.lottoNumber = Integer.parseInt(number);
    }

    private void isValidRange(final int number) {
        if (!(number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(ERROR_WRONG_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void isValidInt(final String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_WRONG_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return lottoNumber - o.lottoNumber;
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
