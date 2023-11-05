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
        if (numbers.size() != getCountOfDistinct(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE.toString());
        }
    }

    private int getCountOfDistinct(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .collect(Collectors.toList())
                .size();
    }

    public String getInfoOfNumbers() {
        return this.numbers.toString();
    }

    public Result compareWithTargetAndCreateResult(Target target) {
        int countOfMatch = calculateCountOfMatch(target);
        boolean isBonusPrize = isBonusWinning(target, countOfMatch);
        return Result.createResult(countOfMatch, isBonusPrize);
    }

    private int calculateCountOfMatch(Target target) {
        return (int) target.getNumbers().stream()
                .filter(targetNumber -> this.numbers.contains(targetNumber))
                .count();
    }

    private boolean isBonusWinning(Target target, int numberOfMatch) {
        return checkSecondWinning(numberOfMatch) && this.numbers.contains(target.getBonusNumber());
    }

    private boolean checkSecondWinning(int numberOfMatch) {
        return numberOfMatch == TARGET_NUMBERS_SIZE_VALUE.getValue() - 1;
    }

}
