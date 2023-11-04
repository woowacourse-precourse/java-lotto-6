package lotto.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.GameConstant;
import lotto.message.ValidateErrorMessage;

public class Validator {
    public int validate(int payment){
        if (payment % GameConstant.PAYMENT_UNIT != 0) {
            throw new IllegalArgumentException(ValidateErrorMessage.PAYMENT_ERROR.getMessage());
        }
        return payment;
    }
    public List<Integer> validate(List<Integer> numbers){
        validateSize(numbers);
        validateRange(numbers);
        validateSameNumber(numbers, GameConstant.NUMBER_SIZE);
        return numbers;
    }

    private static void validateSameNumber(List<Integer> numbers, int size) {
        Set<Integer> tempNumber = new HashSet<>(numbers);
        if (tempNumber.size() < size) {
            throw new IllegalArgumentException(ValidateErrorMessage.LOTTO_SAME_NUMBER_ERROR.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number < GameConstant.NUMBER_MIN || number > GameConstant.NUMBER_MAX)
                .findAny().ifPresent(number -> {
                    throw new IllegalArgumentException(ValidateErrorMessage.LOTTO_ERROR.getMessage());});
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != GameConstant.NUMBER_SIZE) {
            throw new IllegalArgumentException(ValidateErrorMessage.NUMBERS_SIZE_ERROR.getMessage());
        }
    }
    public int validate(int bonusNumber, List<Integer> numbers) {
        List<Integer> duplicateCheckBox = new ArrayList<>(numbers);
        duplicateCheckBox.add(bonusNumber);
        validateRange(duplicateCheckBox);
        validateSameNumber(duplicateCheckBox, GameConstant.TOTAL_NUMBER_SIZE);
        return bonusNumber;
    }
}
