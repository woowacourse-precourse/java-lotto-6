package lotto;

import java.util.ArrayList;

public class WinningNumbers {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private final Lotto mainNumbers;
    int bonusNumber;

    public WinningNumbers(Lotto mainNumbers, int bonusNumber) {
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    public void validateBonusNumber(){
        validateDuplicate();
        validateNumberRange();
    }

    private void validateNumberRange() {
        if (bonusNumber < LOTTO_START_NUMBER || bonusNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("1부터 45");
        }
    }

    private void validateDuplicate() {
        if(mainNumbers.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException("중복");
        }
    }
}
