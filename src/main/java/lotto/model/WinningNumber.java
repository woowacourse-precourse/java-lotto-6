package lotto.model;

import java.util.List;

public class WinningNumber { // 당첨 번호 저장

    private static final String ERROR_INPUT_DUPLICATION_NUMBER="[ERROR]당첨 번호와 중복되지 않는 값을 입력해주세요.";
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        validateDuplicationNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicationNumber(int number) {
        if(this.winningNumbers.contains(number)){
            throw new IllegalArgumentException(ERROR_INPUT_DUPLICATION_NUMBER);
        }
    }


}
