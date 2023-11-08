package lotto.Domain;

import lotto.ExceptionChecker;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private Integer bonusNumber;
    private final ExceptionChecker exceptionChecker = ExceptionChecker.INSTANCE;


    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.valueOf(bonusNumber);
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        exceptionChecker.checkListNull(numbers);
        exceptionChecker.checkListLength6(numbers);
        exceptionChecker.checkListRange(numbers);
        exceptionChecker.checkListDuplicateNumbers(numbers);
    }

    private void validateBonusNumber(String bonusNumber) {
        exceptionChecker.checkNull(bonusNumber);
        exceptionChecker.checkNumber(bonusNumber);
        exceptionChecker.checkRange(bonusNumber);
        exceptionChecker.checkDuplicateNumber(numbers, Integer.valueOf(bonusNumber));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
