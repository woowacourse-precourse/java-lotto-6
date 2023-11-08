package lotto.domain.model;

import lotto.constant.RankConstant;
import lotto.domain.validator.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Validator.validateDuplicateNumbers(numbers);

        for (int num : numbers) {
            Validator.validateNumberInRange(num);
        }

        this.numbers = Collections.unmodifiableList(sortNumbers(numbers));
    }

    private void validate(final List<Integer> numbers) { // validate validateCountOfNumbers
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("숫자의 개수가 6개를 넘지 않아야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        return sortedNumbers;
    }

    public void showNumbers() {
        System.out.println(this.numbers);
    }

    public String calculateRank(final WinningNumber winningNumber, final BonusNumber bonusNumber) {
        int countOfMatchingNumber = countMatchingNumbers(winningNumber);

        if (countOfMatchingNumber == 6) return RankConstant.FIRST;

        if (countOfMatchingNumber == 5) {
            if (isContainBonusNumber(bonusNumber)) return RankConstant.SECOND;

            return RankConstant.THIRD;
        }

        if (countOfMatchingNumber == 4) return RankConstant.FOURTH;

        if (countOfMatchingNumber == 3) return RankConstant.FIFTH;

        return RankConstant.NONE;
    }

    private int countMatchingNumbers(final WinningNumber winningNumber) {
        List<Integer> winningNumbers = winningNumber.getRegularWinningNumbers();
        int count = 0;

        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                ++count;
            }
        }

        return count;
    }

    private boolean isContainBonusNumber(final BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getBonusNumber());
    }
}