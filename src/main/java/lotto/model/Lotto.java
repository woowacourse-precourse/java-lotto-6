package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE_ERROR.getErrorMessage());
        }
    }

    // TODO: 추가 기능 구현
    public Result checkResult(final GameNumbers gameNumbers) {
        int matchWinningNumbers = caculateMatchWinningNumber(gameNumbers);
        boolean isMatchBonus = isMatchBonusNumber(gameNumbers);
        return Result.checkResult(matchWinningNumbers, isMatchBonus);
    }

    private boolean isMatchBonusNumber(GameNumbers gameNumbers) {
        return numbers.contains(gameNumbers.getBonusNumber().toInt());
    }

    private int caculateMatchWinningNumber(GameNumbers gameNumbers) {
        return (int) numbers.stream()
                .filter(gameNumbers::isContainWinningNumber)
                .count();
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE_ERROR.getErrorMessage());
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}