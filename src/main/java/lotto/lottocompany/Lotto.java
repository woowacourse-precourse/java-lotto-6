package lotto.lottocompany;

import static lotto.lottocompany.Reward.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumber(numbers);
        validateLottoNumberRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Reward checkWinning(List<Integer> winningNumbers, int bonusNumber) {
        long matchingCount = numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        Reward decidedReward = getDecidedReward(matchingCount);

        if (decidedReward == SECOND) {
            return checkSecondReward(bonusNumber);
        }
        return decidedReward;
    }

    private Reward getDecidedReward(long matchingCount) {
        return Arrays.stream(values())
                .filter(reward -> reward.getWinCondition() == matchingCount)
                .findFirst()
                .orElse(NONE);
    }

    private Reward checkSecondReward(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return SECOND;
        }
        return THIRD;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR]: 로또는 6개의 숫자입니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR]: 로또는 6개의 숫자입니다.");
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR]: 로또는 번호는 1~45 사이의 숫자입니다.");
            }
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
