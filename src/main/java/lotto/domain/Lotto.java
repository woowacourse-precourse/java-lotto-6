package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                                .sorted()
                                .collect(java.util.stream.Collectors.toList());
    }

    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(Error.INVALID_LOTTO_NUMBER_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(Error.DUPLICATE_LOTTO_NUMBER);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException(Error.INVALID_LOTTO_NUMBER_RANGE);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private int getMatchCount(Lotto lotto) {
        int matchCount = 0;
        for(int number : lotto.getNumbers()){
            if(this.numbers.contains(number)){
                matchCount++;
            }
        }

        return matchCount;
    }

    private boolean isMatchBonus(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    public Rank getRank(Lotto lotto, int bonusNumber) {
        int matchCount = getMatchCount(lotto);
        boolean isMatchBonus = isMatchBonus(bonusNumber);

        return Rank.valueOf(matchCount, isMatchBonus);
    }
}
