package lotto.domain;

import static lotto.config.GameNumberConfig.LOTTO_NUMBER_COUNT;
import static lotto.config.GameNumberConfig.LOTTO_RANGE_MAX;
import static lotto.config.GameNumberConfig.LOTTO_RANGE_MIN;
import static lotto.exception.ErrorMessage.VALIDATE_DUPLICATE;
import static lotto.exception.ErrorMessage.VALIDATE_LOTTO_SIZE;
import static lotto.exception.ErrorMessage.VALIDATE_RANGE;

import java.util.List;
import lotto.config.GamePrizeConfig;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicate(numbers);
        checkRange(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(VALIDATE_LOTTO_SIZE.getMessage());
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        if (numbers.size() > distinctCount) {
            throw new IllegalArgumentException(VALIDATE_DUPLICATE.getMessage());
        }
    }

    private static void checkRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > LOTTO_RANGE_MAX.getValue() || number < LOTTO_RANGE_MIN.getValue()) {
                throw new IllegalArgumentException(VALIDATE_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    public boolean doesContain(int number) {
        return numbers.contains(number);
    }

    public int compareWinningNumber(Lotto winningLotto, BonusNumber bonusNumber) {
        int count = (int) (winningLotto.getLotto()
                .stream()
                .filter(this::doesContain)
                .count());
        boolean containBonus = doesContain(bonusNumber.getNumber());

        return comparePrizeConfig(count, containBonus);
    }

    private int comparePrizeConfig(int count, boolean containBonus) {
        int winningIndex = 0;
        for (GamePrizeConfig prize : GamePrizeConfig.values()) {
            if (prize.getCorrectCount() == count && prize.getCheckBonus() == containBonus) {
                return winningIndex;
            }
            winningIndex++;
        }
        return winningIndex;
    }
}
