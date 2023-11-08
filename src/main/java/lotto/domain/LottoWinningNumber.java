package lotto.domain;

import java.util.List;
import lotto.domain.util.Validation;

public class LottoWinningNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NUMBER_PER_LOTTO = 6;

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoWinningNumber() {
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        Validation.validateLottoNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumbers(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


    private void validateBonusNumbers(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 숫자는 1~45까지의 정수만 선택해야 합니다.");
        }

        if (this.winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 숫자는 중복될 수 없습니다.");
        }
    }


}
