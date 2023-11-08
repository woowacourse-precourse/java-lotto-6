package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinningNumber {

    private static final int WINNING_NUMBER_SIZE = 6;

    private final List<Number> winningNumbers;
    private final Number bonusNumber;

    public WinningNumber(List<Number> winningNumbers, Number bonusNumber) {
        validate(winningNumbers, bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static void validate(List<Number> winningNumbers, Number bonusNumber) {
        validateNotNull(winningNumbers);
        validateNotNull(bonusNumber);
        validateSize(winningNumbers);
        validateDistinct(winningNumbers, bonusNumber);
    }

    public static void validate(List<Number> winningNumbers) {
        validateNotNull(winningNumbers);
        validateSize(winningNumbers);
        validateDistinct(winningNumbers);
    }

    private static void validateNotNull(Object object) {
        Objects.requireNonNull(object);
    }

    private static void validateSize(List<Number> winningNumbers) {
        if (isDifferentNumbersSize(winningNumbers.size())) {
            String exceptionMessage = "당첨 번호는 %d자리이어야 합니다".formatted(WINNING_NUMBER_SIZE);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private static boolean isDifferentNumbersSize(int size) {
        return size != WINNING_NUMBER_SIZE;
    }

    private static void validateDistinct(List<Number> winningNumbers, Number bonusNumber) {
        List<Number> numbers = concat(winningNumbers, bonusNumber);

        if (isOverlapped(numbers)) {
            throw new IllegalArgumentException("당첨 번호, 보너스 번호는 서로 겹쳐서는 안됩니다");
        }
    }

    private static void validateDistinct(List<Number> winningNumbers) {
        if (isOverlapped(winningNumbers)) {
            throw new IllegalArgumentException("당첨 번호는 서로 겹쳐서는 안됩니다");
        }
    }

    private static List<Number> concat(List<Number> numbers, Number number) {
        List<Number> newNumbers = new ArrayList<>(numbers);
        newNumbers.add(number);

        return newNumbers;
    }

    private static boolean isOverlapped(List<Number> numbers) {
        int countOfDistinctNumber = (int) numbers.stream().distinct().count();

        return numbers.size() > countOfDistinctNumber;
    }

    public int countMatchingWinningNumber(List<Number> numbers) {
        return (int) winningNumbers.stream().filter(numbers::contains).count();
    }

    public boolean isMatchingBonusNumber(List<Number> numbers) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return "WinningNumber{winningNumbers=%s, bonusNumber=%s}".formatted(winningNumbers, bonusNumber);
    }
}
