package lotto.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    public int checkPurchaseAmount(String input) {
        int amount = checkInteger(input);
        if (amount < 1) {
            throw new IllegalArgumentException();
        }
        return amount;
    }

    public List<Integer> checkLottoNumber(String input) {
        String[] splitNumbers = input.split(",");

        if (splitNumbers.length != Range.SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
        return getNumbers(splitNumbers);
    }

    public int checkBonusNumber(String input) {
        return checkBoundary(input);
    }

    public void validateLotto(List<Integer> numbers) {
        Set<Integer> duplicated = new HashSet<>();
        if (numbers.size() != Range.SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
        for (int number : numbers) {
            if (!duplicated.add(checkBoundary(number))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private List<Integer> getNumbers(String[] input) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : input) {
            numbers.add(checkBoundary(number));
        }
        numbers.sort(null);
        return numbers;
    }

    private int checkBoundary(int number) {
        if (number < Range.START.getValue() || number > Range.END.getValue()) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    private int checkBoundary(String input) {
        return checkBoundary(checkInteger(input));
    }

    private int checkInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
