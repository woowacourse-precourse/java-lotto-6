package lotto;

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
        boolean isValid = true;

        if(!isInputSizeCorrect(numbers)) {
            System.out.println(ERROR_MESSAGE_INPUT_SIZE);
            isValid = false;
        }
        if(!isNumbersInRange(numbers)) {
            System.out.println(ERROR_MESSAGE_NUMBER_RANGE);
            isValid = false;
        }
        if(isNumbersDuplicated(numbers)) {
            System.out.println(ERROR_MESSAGE_WINNING_NUMBER_DUP);
            isValid = false;
        }
        return isValid;
    }

    public boolean verifyBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        boolean isValid = true;

        if(!isNumberInRange(bonusNumber)) {
            System.out.println(ERROR_MESSAGE_NUMBER_RANGE);
            isValid = false;
        }
        if(isBonusNumbersDuplicated(winningNumbers, bonusNumber)) {
            System.out.println(ERROR_MESSAGE_BONUS_NUMBER_DUP);
            isValid = false;
        }
        return isValid;
    }
}
