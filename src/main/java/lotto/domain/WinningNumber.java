package lotto.domain;

import lotto.Lotto;

import java.util.List;

import static lotto.constant.LottoConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoErrorMessage.LOTTO_NUMBER_ERROR_MESSAGE;

public class WinningNumber extends Lotto {
    private int bonusNumber;

    public WinningNumber(List<Integer> winningNumber) {
        super(winningNumber);
        validate(winningNumber);
    }

    private void validate(List<Integer> winningNumber) {
        for (int number : winningNumber) {
            validateLottoNumberRange(number);
        }
    }

    private void validate(int bonusNumber) {
        validateLottoNumberRange(bonusNumber);
    }

    private void validateLottoNumberRange(int lottoNumber) {
        if (lottoNumber < MINIMUM_LOTTO_NUMBER.getConstant() || lottoNumber > MAXIMUM_LOTTO_NUMBER.getConstant()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE.getErrorMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
