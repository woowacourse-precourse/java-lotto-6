package lotto.verification;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputVerification {
    private static String ERROR_MESSAGE_INPUT_SIZE = "[ERROR] 입력 개수가 옳지 않습니다.";
    private static String ERROR_MESSAGE_NUMBER_RANGE = "[ERROR] 숫자범위가 옳지 않습니다.";
    private static String ERROR_MESSAGE_WINNING_NUMBER_DUP = "[ERROR] 당첨번호가 중복됩니다.";
    private static String ERROR_MESSAGE_BONUS_NUMBER_DUP = "[ERROR] 당첨번호와 보너스번호가 중복됩니다.";


    public boolean isMultipleOfThousand(int amount) {
        return amount % 1000 == 0;
    }

    public boolean isNumberInRange(int number) {
        return number >= 1 && number <= 45;
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

    public boolean isNumbersDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                return true;
            }
        }
        return false;
    }

    public boolean isBonusNumbersDuplicated(List<Integer> numbers, int newNumber) {
        for(Integer number : numbers) {
            if (isNumberDuplicated(number, newNumber)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInputSizeCorrect(List<Integer> numbers) {
        if (numbers.size() != 6) {
            return false;
        }
        return true;
    }

    public boolean verifyWinningNumbers(List<Integer> numbers) {
        try {
            if(!isInputSizeCorrect(numbers)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_SIZE);
            }

            if(!isNumbersInRange(numbers)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_RANGE);
            }

            if(isNumbersDuplicated(numbers)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_WINNING_NUMBER_DUP);
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean verifyBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        try {
            if(!isNumberInRange(bonusNumber)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_RANGE);
            }
            if(isBonusNumbersDuplicated(winningNumbers, bonusNumber)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_NUMBER_DUP);
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
