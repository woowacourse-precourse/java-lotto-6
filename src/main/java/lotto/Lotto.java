package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<Integer> numbers;
    private int bonusNumber;
    private Map<Integer, Boolean> winningNumbers = new HashMap<>();
    private int winningCount = 0;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void setWinningNumbersAndBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        setBonusNumber(bonusNumber);
        setWinningNumbers(winningNumbers);
    }

    private Lotto setBonusNumber(int number) {
        this.bonusNumber = number;
        return this;
    }

    private Lotto setWinningNumbers(List<Integer> winningNumbers) {
        winningNumbers.forEach(number -> this.winningNumbers.put(number, true));
        addWinningCountWithoutBonusNumberMatching();
        return this;
    }

    public int getWinningCount() {
        if (winningCount == 5 && getWinningCountWithBonusNumber()) {
            return winningCount - 1;
        }
        return winningCount;
    }

    // 5개 번호가 일치하되 보너스 번호가 일치하지 않는 경우
    public boolean getWinningCountWithBonusNumber() {
        if (winningCount == 5 && numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private void addWinningCountWithoutBonusNumberMatching() {
        numbers.forEach(number -> {
            if (this.winningNumbers.containsKey(number) || this.bonusNumber == number) {
                winningCount++;
            }
        });
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
