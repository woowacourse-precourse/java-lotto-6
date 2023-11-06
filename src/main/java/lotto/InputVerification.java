package lotto;

import java.util.List;

public class InputVerification {

    public boolean isMultipleOfThousand(int amount) {
        if (amount % 1000 == 0)
            return true;

        throw new IllegalArgumentException("[ERROR] 1000의 배수가 아닙니다.");
    }

    public boolean isNumberInRange(int number) {
        if (number > 0 && number < 46) {
            return true;
        }

        throw new IllegalArgumentException("[ERROR] 1~45 사이의 수가 아닙니다.");
    }

    public boolean isNumbersInRange(List<Integer> numbers) {
        boolean isValid = true;

        for (Integer number : numbers) {
            if (!isNumberInRange(number)) {
                return false;
            }
        }

        return isValid;
    }

    public boolean isNumberDuplicated(int existingNumber, int newNumber) {
        if(existingNumber == newNumber)
            return true;

        throw new IllegalArgumentException("[ERROR]" + newNumber + ": 중복되는 수입니다.");
    }
}
