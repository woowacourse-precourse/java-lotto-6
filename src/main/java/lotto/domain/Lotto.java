package lotto.domain;

import lotto.utils.Constants;
import lotto.utils.ErrorCode;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateUnique(numbers);
        validateNumber(numbers);
        this.numbers = numbers;
    }

    public int getMatchedNumber(Lotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    /**
     * 일치하는 로또 번호 갯수가 5일 때만 수행하는 메서드이기 때문에
     * 한가지 숫자, 즉 첫번째 숫자를 찾는다.
     */
    public int getUnmatchedNumber(Lotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        return numbers.stream()
                .filter(num -> !winningNumbers.contains(num))
                .findFirst()
                .get();
    }

    private List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_COUNT.getValues()) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_COUNT.getMessage());
        }
    }

    private void validateUnique(List<Integer> numbers) {
        int prev_length = numbers.size();
        int post_length = (int) numbers.stream()
                .distinct()
                .count();
        if (prev_length != post_length)
            throw new IllegalArgumentException(ErrorCode.IS_DUPLICATED.getMessage());
    }

    private void validateNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Constants.MIN_LOTTO_NUMBER.getValues() || number > Constants.MAX_LOTTO_NUMBER.getValues())
                throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBERS.getMessage());
        }
    }

    public void validateBonusNumber(int bonus) {
        if (numbers.contains(bonus))
            throw new IllegalArgumentException(ErrorCode.INVALID_BONUS.getMessage());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
