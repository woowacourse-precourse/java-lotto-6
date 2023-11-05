package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {
    private Set<Integer> winningNumbers;

    
    public int validateMoney(String string) {
        int money = validateisNumber(string);
        validateMoneyCorrectAmount(money);

        return money;
    }

    public void validateWinningNumber(String winning) {
        List<Integer> numbers = validateWinningisNumber(winning);
        validateWinningNumberLength(numbers);
        for (int number : numbers) {
            validateWinningNumberRange(number);
            winningNumbers = new HashSet<>();
            validateWinningNumberDuplicated(number);
        }

    }

    public void validateBonusNumber(String bonus) {
        int number = validateisNumber(bonus);
        validateWinningNumberRange(number);
        validateWinningNumberDuplicated(number);
    }


    private int validateisNumber(String string) {
        int money;
        try {
            money = Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return money;
    }

    private void validateMoneyCorrectAmount(int money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> validateWinningisNumber(String winning) {
        List<Integer> numbers;
        try {
            numbers = Arrays
                    .stream(winning.split(","))
                    .map(Integer::valueOf).
                    collect(Collectors.toList());
            return numbers;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningNumberLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningNumberRange(int number) {
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningNumberDuplicated(int number) {
        if (!winningNumbers.add(number)) {
            throw new IllegalArgumentException();
        }
    }

}
