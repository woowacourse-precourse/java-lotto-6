package validator;

import static consts.ErrorMessage.CANNOT_DIVIDE;
import static consts.ErrorMessage.DUPLICATED_NUMBER;
import static consts.ErrorMessage.INVALID_NUMBER_COUNT;
import static consts.ErrorMessage.INVALID_RANGE;
import static consts.ErrorMessage.NON_NUMERIC_VALUE;
import static consts.NumericConfig.END_INCLUSIVE;
import static consts.NumericConfig.LOTTO_COUNT;
import static consts.NumericConfig.LOTTO_PRICE;
import static consts.NumericConfig.START_INCLUSIVE;

import java.util.List;
import model.dto.AnswerLottoNumbers;

public class LottoValidator {

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

        validateLottoNumbers(convertedNumbers);
    }

    public void validateBonusNumber(final List<Integer> numbers, final String inputBonusNumber) {
        validateDigit(inputBonusNumber);
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        validateContain(numbers, bonusNumber);
        validateNumber(bonusNumber);
    }

    public void validateLottoNumbers(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        numbers.forEach(this::validateRange);
    }

    public void validateNumber(final int number) {
        validateRange(number);
    }

    private void validateContain(final List<Integer> numbers, final int inputBonusNumber) {
        boolean condition = !numbers.contains(inputBonusNumber);
        throwExceptionByCondition(condition, DUPLICATED_NUMBER.message());
    }

    private void validateRange(final int number) {
        boolean condition = number <= END_INCLUSIVE.number() && number >= START_INCLUSIVE.number();
        throwExceptionByCondition(condition, INVALID_RANGE.message());
    }

    private void validateDuplicate(final List<Integer> numbers) {
        long distinctSize = numbers.stream()
            .distinct()
            .count();
        boolean condition = (distinctSize == numbers.size());
        throwExceptionByCondition(condition, DUPLICATED_NUMBER.message());
    }

    private void validateSize(final List<Integer> numbers) {
        boolean condition = numbers.size() == LOTTO_COUNT.number();
        throwExceptionByCondition(condition, INVALID_NUMBER_COUNT.message());
    }

    private void validateDivided(final String inputPurchase) {
        int purchase = Integer.parseInt(inputPurchase);
        boolean condition = purchase % LOTTO_PRICE.number() == 0;
        throwExceptionByCondition(condition, CANNOT_DIVIDE.message());
    }

    private void validateDigit(final String inputPurchase) {
        boolean condition = inputPurchase.chars()
            .allMatch(Character::isDigit);
        throwExceptionByCondition(condition, NON_NUMERIC_VALUE.message());
    }

    private void throwExceptionByCondition(final boolean condition, final String errorMessage) {
        if (!condition) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
