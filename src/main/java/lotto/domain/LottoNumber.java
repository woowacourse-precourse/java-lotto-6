package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private static final String ERROR_LESS_THAN_MINIMUM_NUMBER = "로또 번호의 최솟값은 %d입니다.";
    private static final String ERROR_BIGGER_THAN_MAXIMUM_NUMBER = "로또 번호의 최댓값은 %d입니다.";

    private static final int MINIMUM_NUMBER_OF_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_NUMBER_OF_LOTTO_NUMBER = 45;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    private void validateLottoNumberRange(int lottoNumber) {
        validateBiggerThanMinimumNumberOfRange(lottoNumber);
        validateLessThanMaximumNumberOfRange(lottoNumber);
    }

    private void validateBiggerThanMinimumNumberOfRange(int number) {
        if (isLessThanMinimumNumber(number)) {
            throw new IllegalArgumentException(
                ERROR_MESSAGE_HEADER + String.format(ERROR_LESS_THAN_MINIMUM_NUMBER,
                    MINIMUM_NUMBER_OF_LOTTO_NUMBER));
        }
    }

    private void validateLessThanMaximumNumberOfRange(int number) {
        if (isBiggerThanMaximumNumber(number)) {
            throw new IllegalArgumentException(
                ERROR_MESSAGE_HEADER + String.format(ERROR_BIGGER_THAN_MAXIMUM_NUMBER,
                    MAXIMUM_NUMBER_OF_LOTTO_NUMBER));
        }
    }

    private boolean isLessThanMinimumNumber(int number) {
        return number < MINIMUM_NUMBER_OF_LOTTO_NUMBER;
    }

    private boolean isBiggerThanMaximumNumber(int number) {
        return number > MAXIMUM_NUMBER_OF_LOTTO_NUMBER;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        LottoNumber that = (LottoNumber) obj;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
