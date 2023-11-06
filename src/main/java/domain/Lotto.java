package domain;

import constant.ConstantNumber;
import constant.ExceptionMessage;
import util.LottoRandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this(new LottoRandomUtil().getWinningNumbers(ConstantNumber.WINNING_NUMBER_COUNT.get()));
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.INCORRECT_COUNT_OF_WINNING_NUMBERS.get());
        }
        int uniqueNumberSize = numbers.stream()
                .distinct()
                .toList()
                .size();
        if (uniqueNumberSize != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_WINNING_NUMBERS.get());
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int rank(WinningLotto winningLotto) {
        int matchingNumbersCount = calculateMatchingNumbersCount(winningLotto);
        return calculateRank(matchingNumbersCount, winningLotto.getBonusNumber());
    }

    private int calculateMatchingNumbersCount(WinningLotto winningLotto) {
        int count = 0;
        for (int i = 0; i < ConstantNumber.WINNING_NUMBER_COUNT.get(); i++) {
            if (winningLotto.contains(numbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int calculateRank(int matchingNumbersCount, int bonusNumber) {
        final int winningNumberCount = ConstantNumber.WINNING_NUMBER_COUNT.get();
        if (matchingNumbersCount == winningNumberCount) {
            return 1;
        }
        if (matchingNumbersCount == winningNumberCount - 1 && numbers.contains(bonusNumber)) {
            return 2;
        }
        if (matchingNumbersCount < 3) {
            return -1;
        }
        return 8 - matchingNumbersCount;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
