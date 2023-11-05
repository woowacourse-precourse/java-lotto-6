package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinningNumber {

    private static final int WINNING_NUMBER_SIZE = 6;

    private final List<Number> winningNumbers;
    private final Number bonusNumber;

    WinningNumber(List<Number> winningNumbers, Number bonusNumber) {
        validate(winningNumbers, bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Number> winningNumbers, Number bonusNumber) {
        validateNotNull(winningNumbers, bonusNumber);
        validateSize(winningNumbers);
        validateDistinct(winningNumbers, bonusNumber);
    }

    private void validateNotNull(List<Number> winningNumbers, Number bonusNumber) {
        Objects.requireNonNull(winningNumbers);
        Objects.requireNonNull(bonusNumber);
    }

    private void validateSize(List<Number> winningNumbers) {
        if (isDifferentNumbersSize(winningNumbers.size())) {
            String exceptionMessage = "당첨 번호는 %d자리이어야 합니다".formatted(WINNING_NUMBER_SIZE);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private boolean isDifferentNumbersSize(int size) {
        return size != WINNING_NUMBER_SIZE;
    }

    private void validateDistinct(List<Number> winningNumbers, Number bonusNumber) {
        if (isOverlapped(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호, 보너스 번호는 서로 겹쳐서는 안됩니다");
        }
    }

    private boolean isOverlapped(List<Number> winningNumbers, Number bonusNumber) {
        List<Number> numbers = new ArrayList<>(winningNumbers);
        numbers.add(bonusNumber);

        return isOverlapped(numbers);
    }

    private boolean isOverlapped(List<Number> numbers) {
        int countOfDistinctNumber = (int) numbers.stream().distinct().count();

        return numbers.size() > countOfDistinctNumber;
    }

    public static WinningNumber of(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumber(Number.getList(winningNumbers), Number.from(bonusNumber));
    }

    public int countMatchingWinningNumber(List<Number> numbers) {
        return (int) winningNumbers.stream().filter(numbers::contains).count();
    }

    public boolean isMatchingBonusNumber(List<Number> numbers) {
        return numbers.contains(bonusNumber);
    }
}
