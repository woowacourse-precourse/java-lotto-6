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
        return existingNumber == newNumber;
    }

    public boolean isNumbersDuplicated(List<Integer> numbers, int newNumber) {
        for(Integer number : numbers) {
            if (isNumberDuplicated(number, newNumber)) {
                throw new IllegalArgumentException("[ERROR] 중복된 수가 있습니다.");
            }
        }

        return false;
    }

    public boolean isInputSizeCorrect(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력 개수가 옳지 않습니다.");
        }
        return true;
    }

}
