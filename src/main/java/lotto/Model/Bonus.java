package lotto.Model;

import static lotto.Utils.toInt;

public class Bonus {
    int bonusNumber;

    public Bonus(String input) {
        validate(input);
        this.bonusNumber = toInt(input);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(String input) {
        int validInput = isNumber(input);
        isCorrectRange(validInput);

    }

    private int isNumber(String input) {
        try {
            return toInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45사이의 숫자로만 입력해야 합니다.");
        }
    }

    private void isCorrectRange(int validInput) {
        if (validInput < 1 || validInput > 45) {
            throw new IllegalArgumentException(("[ERROR] 보너스 번호는 1~45사이의 숫자여야 합니다."));
        }
    }
}
