package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.ErrorMessages;

public class LottoAnswerValidator {
    public static List<Integer> checkIsValidLottoNumbers(String userInput) {
        //숫자인지 확인
        List<Integer> numbers;
        numbers = convertToNumber(userInput);
        checkIsCorrectNumber(numbers);
        checkLengthIsSix(numbers);
        return numbers;
    }

    private static List<Integer> convertToNumber(String userInput) {
        List<Integer> numbers = new ArrayList<>();
        try {
            String[] splitedUserInput = userInput.split(",");
            for (String unParsedNumber : splitedUserInput) {
                numbers.add(Integer.parseInt(unParsedNumber));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessages.CAN_NOT_CONVERT_TO_NUMBER.getMessage());
        }
        return numbers;
    }

    private static void checkLengthIsSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.NOT_SIX_NUMBERS.getMessage());
        }
    }

    private static void checkIsCorrectNumber(List<Integer> numbers) {
        for (int number : numbers) {
            checkIsOnSide(number);
        }
        //중복되는 값이 있는 지 확인
        Set<Integer> numbersWithDuplicatesRemove = new HashSet<>(numbers);
        if (numbers.size() != numbersWithDuplicatesRemove.size()) {
            throw new IllegalArgumentException(ErrorMessages.THERE_ARE_DUPLICATE_VALUES.getMessage());
        }
    }

    public static void checkIsOnSide(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessages.FALL_OUTSIDE_THE_RIGHT_RANGE.getMessage());
        }
    }
}
