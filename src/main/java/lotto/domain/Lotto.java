package lotto.domain;


import java.util.Collections;
import java.util.List;

import static lotto.configuration.ErrorMessage.*;
import static lotto.configuration.GameConfig.*;
import static lotto.util.LottoNumberGenerator.generateRandomLottoNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generateRandomLotto() {
        return new Lotto(generateRandomLottoNumber());
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        numbers.forEach(Lotto::validateRangeOfNumber);
    }

    private static void validateRangeOfNumber(int number) {
        if (hasInvalidRange(number)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    public static boolean hasInvalidRange(int number) {
        return number < LOTTO_NUMBER_LOWER_BOUND || number > LOTTO_NUMBER_UPPER_BOUND;
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(EXCESS_NUMBER_OF_LOTTOS);
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (containsDuplication(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATION);
        }
    }

    private static boolean containsDuplication(List<Integer> numbers) {
        long distinctNumberCount = numbers.stream()
                .distinct()
                .count();
        return distinctNumberCount != numbers.size();
    }

    public Rank calculateRank(List<Integer> winningNumbers, int bonusNumber) {
        int matchingNumberCount = calculateMatchingNumberCount(winningNumbers);
        int matchingBonusNumberCount = calculateMatchingBonusNumberCount(bonusNumber);

        return Rank.findByMatchingNumber(matchingNumberCount, matchingBonusNumberCount);
    }

    private int calculateMatchingBonusNumberCount(int bonusNumber) {
        return (int) numbers.stream()
                .filter(number -> number == bonusNumber)
                .count();
    }

    private int calculateMatchingNumberCount(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
