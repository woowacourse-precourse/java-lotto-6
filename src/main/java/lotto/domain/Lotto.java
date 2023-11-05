package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.SystemOption.TARGET_NUMBERS_SIZE_VALUE;
import static lotto.message.ErrorMessage.DUPLICATE_ERROR_MESSAGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateUnique(numbers);
        this.numbers = numbers;
    }


    public static Lotto createLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != TARGET_NUMBERS_SIZE_VALUE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if (numbers.size() != getNumberOfDistinct(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE.toString());
        }
    }

    private int getNumberOfDistinct(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .collect(Collectors.toList())
                .size();
    }

    public void printNumbers() {
        System.out.println(this.numbers);
    }

    public Result compareWith(Target target) {
        int numberOfMatch = calculateNumberOfMatch(target);
        boolean isBonusPrize = isBonusPrize(target, numberOfMatch);
        return Result.createResult(numberOfMatch, isBonusPrize);
    }

    private int calculateNumberOfMatch(Target target) {
        return (int) target.getNumbers().stream()
                .filter(targetNumber -> this.numbers.contains(targetNumber))
                .count();
    }

    private boolean isBonusPrize(Target target, int numberOfMatch) {
        return numberOfMatch == TARGET_NUMBERS_SIZE_VALUE.getValue() - 1
                && this.numbers.contains(target.getBonusNumber());
    }

}
