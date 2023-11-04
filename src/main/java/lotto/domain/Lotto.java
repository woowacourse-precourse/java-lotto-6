package lotto.domain;

import java.util.List;

import static lotto.constants.SystemOption.TARGET_NUMBERS_SIZE_VALUE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != TARGET_NUMBERS_SIZE_VALUE.getValue()) {
            throw new IllegalArgumentException();
        }
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
