package lotto.domain;

import java.util.List;

public class Bonus {

    private final int number;

    public Bonus(String inputNumber, List<Integer> winningNumbers) {
        int number = convertToInt(inputNumber);
        validateRange(number);
        validateDuplicate(number, winningNumbers);
        this.number = number;
    }

    private int convertToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 번호는 숫자여야 합니다.");
        }
    }

    private void validateDuplicate(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복 됩니다.");
        }
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 번호는 1이상 45이하 숫자여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
