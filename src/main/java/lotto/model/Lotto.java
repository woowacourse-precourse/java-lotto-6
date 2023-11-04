package lotto.model;

import static lotto.util.Constant.FIVE;
import static lotto.util.Constant.FOUR;
import static lotto.util.Constant.LOTTO_NUMBER_COUNT;
import static lotto.util.Constant.SIX;
import static lotto.util.Constant.THREE;

import java.util.Collections;
import java.util.List;
import lotto.exception.ExistDuplicatedNumberException;
import lotto.exception.InvalidLottoNumberException;
import lotto.util.NumbersGenerator;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto createWith(final NumbersGenerator numbersGenerator) {
        List<Integer> generate = numbersGenerator.generate();
        validateSixNumbers(generate);
        validateDuplicateNumbers(generate);
        return new Lotto(generate);
    }

    private static void validateSixNumbers(final List<Integer> numbers) {
        if (!hasSixNumbers(numbers)) {
            throw new InvalidLottoNumberException(numbers);
        }
    }

    private static boolean hasSixNumbers(final List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_COUNT.getValue();
    }

    private static void validateDuplicateNumbers(final List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new ExistDuplicatedNumberException(numbers);
        }
    }

    private static boolean hasDuplicate(final List<Integer> numbers) {
        int distinctCount = (int) numbers.stream()
                .distinct()
                .count();
        return distinctCount != numbers.size();
    }

    public boolean isFirstPrizeWinner(final List<Integer> winningNumbers) {
        return countMatchingNumbers(winningNumbers) == SIX.getValue();
    }

    public boolean isSecondPrizeWinner(final List<Integer> winningNumbers, final int bonusNumber) {
        return countMatchingNumbers(winningNumbers) == FIVE.getValue() && numbers.contains(bonusNumber);
    }

    public boolean isThirdPrizeWinner(final List<Integer> winningNumbers) {
        return countMatchingNumbers(winningNumbers) == FIVE.getValue();
    }

    public boolean isFourthPrizeWinner(final List<Integer> winningNumbers) {
        return countMatchingNumbers(winningNumbers) == FOUR.getValue();
    }

    public boolean isFifthPrizeWinner(final List<Integer> winningNumbers) {
        return countMatchingNumbers(winningNumbers) == THREE.getValue();
    }

    private int countMatchingNumbers(final List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
