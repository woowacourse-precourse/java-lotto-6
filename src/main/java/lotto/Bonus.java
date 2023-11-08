package lotto;

import static lotto.Constants.*;

import java.util.List;

public class Bonus extends InputNumber {
    private Integer number;
    private List<Integer> winningNumbers;

    public Bonus() {
        this.number = ZERO;
    }

    public Integer getNumber() {
        return number;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void save(String readLine) {
        Integer number = validate(readLine);
        this.number = number;
    }

    protected Integer validate(String readLine) {
        String noEmptyReadLine = removeEmpty(readLine);
        checkDigit(noEmptyReadLine);
        Integer bonusNumber = translateToValueType(noEmptyReadLine);
        isContained(bonusNumber);
        checkBoundary(bonusNumber);
        return bonusNumber;
    }

    protected void checkDigit(String readLine) {
        if(readLine.length() == ZERO) {
            throw new IllegalArgumentException(BONUS_SIZE_ERROR);
        }
    }

    private void isContained(Integer number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(BONUS_DUPLICATION_ERROR);
        }
    }
}
