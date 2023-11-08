package lotto;

import static lotto.Constants.*;

import java.util.List;

public class Bonus extends Input {
    private Integer number;

    public Bonus() {
        this.number = 0;
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
        Integer bonusNumber = translateToValueType(noEmptyReadLine);
        checkBoundary(bonusNumber);
        return bonusNumber;
    }

    protected String removeEmpty(String readLine) {
        return readLine.replaceAll("\\s", "");
    }

    protected Integer translateToValueType(String noEmptyReadLine) {
        Integer result;
        try {
            result = Integer.parseInt(noEmptyReadLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_TYPE_ERROR);
        }
        return result;
    }
}
