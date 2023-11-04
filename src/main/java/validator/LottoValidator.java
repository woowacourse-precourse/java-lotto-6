package validator;

import java.util.List;
import model.dto.AnswerLottoNumbers;

public class LottoValidator {

    private static final String ERROR_MSG = "[ERROR]";

    public void validatePurchase(final String inputPurchase) {
        validateDigit(inputPurchase);
        validateDivided(inputPurchase);
    }

    public void validateAnswerNumbers(final AnswerLottoNumbers answerNumbers) {
        List<String> numbers = answerNumbers.divideNumbers();
        numbers.forEach(this::validateDigit);

        List<Integer> convertedNumbers = numbers.stream()
            .map(Integer::parseInt)
            .toList();
        validateSize(convertedNumbers);
        validateDuplicate(convertedNumbers);
        convertedNumbers.forEach(this::validateRange);
    }

    public void validateBonusNumber(final List<Integer> numbers, final String inputBonusNumber) {
        validateDigit(inputBonusNumber);
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        validateContain(numbers, bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateContain(final List<Integer> numbers, final int inputBonusNumber) {
        boolean condition = !numbers.contains(inputBonusNumber);
        throwExceptionByCondition(condition, ERROR_MSG);
    }

    private void validateRange(final int number) {
        boolean condition = number <= 45 && number >= 1;
        throwExceptionByCondition(condition, ERROR_MSG);
    }

    private void validateDuplicate(final List<Integer> numbers) {
        long distinctSize = numbers.stream()
            .distinct()
            .count();
        boolean condition = (distinctSize == numbers.size());
        throwExceptionByCondition(condition, ERROR_MSG);
    }

    private void validateSize(final List<Integer> numbers) {
        boolean condition = numbers.size() == 6;
        throwExceptionByCondition(condition, ERROR_MSG);
    }

    private void validateDivided(final String inputPurchase) {
        int purchase = Integer.parseInt(inputPurchase);
        boolean condition = purchase % 1000 == 0;
        throwExceptionByCondition(condition, ERROR_MSG);
    }

    private void validateDigit(final String inputPurchase) {
        boolean condition = inputPurchase.chars()
            .allMatch(Character::isDigit);
        throwExceptionByCondition(condition, ERROR_MSG);
    }

    private void throwExceptionByCondition(final boolean condition, final String errorMessage) {
        if (!condition) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
