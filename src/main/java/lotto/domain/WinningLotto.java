package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.utils.InputValidator;

public class WinningLotto {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int LOTTO_SIZE = 6;

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto() {
        this.winningNumbers = null;
        this.bonusNumber = -1;
    }

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto createWinningNumbers(String winningNumbers) {
        InputValidator.validateEmpty(winningNumbers);
        InputValidator.validateNull(winningNumbers);
        List<Integer> numbers = parseNumbers(winningNumbers);
        validateSize(numbers);
        validateUnique(numbers);
        validateRange(numbers);
        return new Lotto(numbers);
    }

    public int createBonusNumber(String bonusNumber) {
        InputValidator.validateEmpty(bonusNumber);
        InputValidator.validateNull(bonusNumber);
        return parseNumber(bonusNumber);
    }

    public Lotto getWinningNumbers() {
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private List<Integer> parseNumbers(String numbers) {
        return Stream.of(numbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int parseNumber(String number) {
        int parsedNumber;
        try {
            parsedNumber = Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력 가능");
        }

        if (parsedNumber <= 0) {
            throw new IllegalArgumentException("양의 정수만 입력 가능");
        }

        return parsedNumber;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 6개만 입력 가능");
        }
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("각 숫자는 고유해야함");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateSingleRange(number);
        }
    }

    private void validateSingleRange(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(
                    "로또번호는" + MIN_VALUE + "과" + MAX_VALUE + "사이만 가능");
        }
    }

    public List<Integer> getCurrentWinningNumbers() {
        return winningNumbers.getCurrentNumbers();
    }
}
