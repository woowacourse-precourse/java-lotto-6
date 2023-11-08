package lotto.domain;

import java.util.HashMap;
import java.util.List;
import lotto.constant.NumberStrategy;
import lotto.constant.WinningAmount;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public WinningLotto getWinningLotto(WinningNumbers winningNumbers) {
        int generalNumberMatchCount = getGeneralNumberMatchCount(winningNumbers);
        boolean isBonusNumberMatch = isBonusNumberMatch(winningNumbers);

        return new WinningLotto(isBonusNumberMatch, generalNumberMatchCount);
    }

    private int getGeneralNumberMatchCount(WinningNumbers winningNumbers) {
        List<Integer> generalNumber = winningNumbers.getGeneralNumbers();

        return (int) numbers.stream().filter(generalNumber::contains).count();
    }

    private boolean isBonusNumberMatch(WinningNumbers winningNumbers) {
        return numbers.contains(winningNumbers.getBonusNumber());
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumberDuplicate(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NumberStrategy.LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NumberStrategy.LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Lotto[" + numbers + ']';
    }

}
