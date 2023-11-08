package lotto;

import java.util.List;

public class LottoBonusNumber {
    private int bonusNumber;

    public LottoBonusNumber(int bonusNumber, List<Integer> inputWinningNumbers) {
        validateBonusNumber(bonusNumber);
        checkBonusNumberDuplicate(bonusNumber, inputWinningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1이상 45이하의 숫자로 이루어져야 합니다.");
        }
    }

    private void checkBonusNumberDuplicate(int bonusNumber, List<Integer> inputWinningNumbers) {
        if (inputWinningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호와 중복 됩니다. 중복 되지 않는 번호를 입력해주세요.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
