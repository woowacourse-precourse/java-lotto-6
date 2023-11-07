package lotto.domain;

import static lotto.constants.LottoConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.constants.LottoConstant.MINIMUM_LOTTO_NUMBER;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) throws IllegalArgumentException {
        if (number < MINIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 번호는 " + MINIMUM_LOTTO_NUMBER + "보다 커야 합니다.");
        }
        if (number > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 번호는 " + MAXIMUM_LOTTO_NUMBER + "보다 작아야 합니다.");
        }
    }

    public Integer getNumber() {
        return number;
    }
}
