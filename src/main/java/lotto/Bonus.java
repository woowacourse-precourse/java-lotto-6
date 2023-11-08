package lotto;

import static lotto.Constants.*;

import java.util.List;

public class Bonus extends InputNumber {
    private Integer number;

    public Bonus() {
        this.number = ZERO;
    }

    public Integer getNumber() {
        return number;
    }

    public void save(String readLine, List<Integer> winningNumbers) {
        Integer number = validate(readLine);
        isContained(number, winningNumbers);
        this.number = number;
    }

    private void isContained(Integer number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(BONUS_DUPLICATION_ERROR);
        }
    }

    protected Integer validate(String readLine) {
        String noEmptyReadLine = removeEmpty(readLine);
        checkDigit(noEmptyReadLine);
        Integer bonusNumber = translateToValueType(noEmptyReadLine);
        checkBoundary(bonusNumber);
        return bonusNumber;
    }

    protected void checkDigit(String readLine) {
        if(readLine.length() == ZERO) {
            throw new IllegalArgumentException(BONUS_SIZE_ERROR);
        }
    }
}
