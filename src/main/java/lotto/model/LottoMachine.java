package lotto.model;

import java.util.List;

public class LottoMachine {

    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    private LottoMachine(List<Integer> winningNumbers, Integer bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoMachine draw(List<Integer> winningNumbers, Integer bonusNumber) {
        return new LottoMachine(winningNumbers, bonusNumber);
    }

    private void validate(List<Integer> winningNumbers, Integer bonusNumber) {
        if (hasInvalidSize(winningNumbers) || hasInvalidRange(winningNumbers, bonusNumber)
                || hasDuplicatedNumber(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasInvalidSize(List<Integer> winningNumbers) {
        return winningNumbers.size() != 6;
    }

    private boolean hasInvalidRange(List<Integer> winningNumbers, Integer bonusNumber) {
        return winningNumbers.stream()
                .anyMatch(this::isInvalidRange) || isInvalidRange(bonusNumber);
    }

    private boolean isInvalidRange(Integer number) {
        return number < 1 || number > 45;
    }

    private boolean hasDuplicatedNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        return hasDuplicatedNumber(winningNumbers) || winningNumbers.contains(bonusNumber);
    }

    private boolean hasDuplicatedNumber(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .distinct()
                .count() != 6;
    }
}
