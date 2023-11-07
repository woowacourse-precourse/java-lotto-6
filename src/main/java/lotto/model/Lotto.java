package lotto.model;

import static lotto.model.Rank.FIFTH;
import static lotto.model.Rank.FIRST;
import static lotto.model.Rank.FOURTH;
import static lotto.model.Rank.SECOND;
import static lotto.model.Rank.THIRD;
import static lotto.model.SystemConstant.MAX_LOTTO_NUMBER;
import static lotto.model.SystemConstant.MIN_LOTTO_NUMBER;
import static lotto.model.SystemConstant.NUM_OF_NUMBERS;
import static lotto.view.ErrorMessage.DUPLICATED_NUMBER;
import static lotto.view.ErrorMessage.NOT_EQUAL_NUM_OF_NUMBERS;
import static lotto.view.ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBERS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumOfNumbers(numbers);
        validateDuplicatedNumber(numbers);
        validateRangeOfNumbers(numbers);
    }

    private void validateNumOfNumbers(List<Integer> numbers) {
        if (numbers.size() != NUM_OF_NUMBERS) {
            throw new IllegalArgumentException(NOT_EQUAL_NUM_OF_NUMBERS.getMessage());
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> check = new HashSet<>();
        for (int number : numbers) {
            if (check.contains(number)) {
                throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
            }
            check.add(number);
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(OUT_OF_RANGE_LOTTO_NUMBERS.getMessage());
            }
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return new ArrayList<>(this.numbers);
    }

    public void validateBonusNumber(int number) {
        Set<Integer> winningNumbers = new HashSet<>(this.numbers);
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
        }
    }

    public void updateLottoRank(Lotto firstPrizeLotto, Map<Rank, Long> winningCountByRank, int bonusNum) {
        int match = getMatchingNumberCount(firstPrizeLotto);
        if (match >= NUM_OF_NUMBERS - 3) {
            winningCountByRank.put(checkRank(match, bonusNum),
                    winningCountByRank.get(checkRank(match, bonusNum)) + 1);
        }
    }

    public int getMatchingNumberCount(Lotto firstPrizeLotto) {
        Set<Integer> check = new HashSet<>(firstPrizeLotto.getNumbers());
        int match = 0;
        for (Integer number : this.numbers) {
            if (check.contains(number)) {
                match += 1;
            }
        }
        return match;
    }

    public Rank checkRank(int match, int bonusNumber) {
        if (match == NUM_OF_NUMBERS) {
            return FIRST;
        }
        if (match == NUM_OF_NUMBERS - 1) {
            return resultSecondAndThird(bonusNumber);
        }
        if (match == NUM_OF_NUMBERS - 2) {
            return FOURTH;
        }
        return FIFTH;
    }

    public Rank resultSecondAndThird(int bonusNumber) {
        if (compareBonus(bonusNumber)) {
            return SECOND;
        }
        return THIRD;
    }

    public boolean compareBonus(int bonusNumber) {
        Set<Integer> check = new HashSet<>(this.numbers);
        return check.contains(bonusNumber);
    }
}
